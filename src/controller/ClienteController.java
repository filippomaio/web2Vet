package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet("/Cliente.do")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteModel cliente;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		if (acao.equals("editar")){
			preencherCliente(idCliente,request,response);
		}else if (acao.equals("remover")){
			removerCliente(idCliente,request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao.equals("cadastrar")){
			cadastrarCliente(request,response);
		}
		if (acao.equals("editar")){
			editarCliente(request,response);
		}
	}
	
	protected void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		cliente = new ClienteModel(usuario.getCn());
        
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereco");
        
        if (hasCliente(cpf,sessao)) {        	
        	cliente.atualizarCliente(idCliente, nome, cpf, endereco);
        	request.setAttribute("message", "Cliente editado com sucesso!");
        	usuario.carregarListas(request, response);
            request.getRequestDispatcher("gerenciarDono.jsp").forward(request, response);
        }else {
        	request.setAttribute("message", "Erro ao editar Cliente");
            request.getRequestDispatcher("gerenciarDono.jsp").forward(request, response);
        }
	}
	
	protected void removerCliente(int idCliente, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		cliente = new ClienteModel(usuario.getCn());
		
		if(cliente.lerCliente(idCliente)!= null) {
			cliente.deletarCliente(cliente.getCpf());
			request.setAttribute("message", "Cliente removido com sucesso!");
			usuario.carregarListas(request,response);			
			request.getRequestDispatcher("GerenciarDono.jsp").forward(request, response);
		}
	}
	
	protected void preencherCliente(int idCliente, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		cliente = new ClienteModel(usuario.getCn());
		
		if(cliente.lerCliente(idCliente)!= null) {
			sessao.setAttribute("idClienteEditar", cliente.getId());
			sessao.setAttribute("nomeClienteEditar", cliente.getNome());
			sessao.setAttribute("cpfClienteEditar", cliente.getCpf());
			sessao.setAttribute("enderecoClienteEditar", cliente.getEndereco());
            request.getRequestDispatcher("editarDono.jsp").forward(request, response);
		}
	}
	
	protected void cadastrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		cliente = new ClienteModel(usuario.getCn());
        
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereco");
        
        if (!hasCliente(cpf,sessao)) {        	
        	cliente.criarCliente(nome, cpf, endereco);
        	usuario.carregarListas(request, response);
        	request.setAttribute("message", "Cliente castrado com sucesso!");
            request.getRequestDispatcher("cadastrarDono.jsp").forward(request, response);
        }else {
        	request.setAttribute("message", "Cliente já existe");
            request.getRequestDispatcher("cadastrarDono.jsp").forward(request, response);
        }
	}
	
	public boolean hasCliente(String cpf, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        cliente = new ClienteModel(usuario.getCn());
        if(cliente.lerCliente(cpf) != null) {
        	return true;
        }
        return false;
	}

	public ClienteModel lerCliente(int id,HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		cliente = new ClienteModel(usuario.getCn());
		return cliente.lerCliente(id);
	}
	
	public void carregarClientes(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		List<ClienteModel> clientes = new ArrayList<ClienteModel>();
		cliente = new ClienteModel(usuario.getCn());
		clientes = cliente.getClientes();
		ArrayList<String> idClientes = new ArrayList<>();
		ArrayList<String> cpfClientes = new ArrayList<>();
		ArrayList<String> nomeClientes = new ArrayList<>();
		for(int i=0;i<clientes.size();i++) {
			idClientes.add(Integer.toString(clientes.get(i).getId()));
			cpfClientes.add(clientes.get(i).getCpf());
			nomeClientes.add(clientes.get(i).getNome());
		}
		sessao.setAttribute("idClientes", idClientes);
		sessao.setAttribute("cpfClientes", cpfClientes);
		sessao.setAttribute("nomeClientes", nomeClientes);
	}
	
}
