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
 * Servlet implementation class AnimalController
 */
@WebServlet("/Animal.do")
public class AnimalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnimalModel animal;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao.equals("visualizar")){
			visualizarAnimais(request,response);
		}if(request.getParameter("idCliente") != null) {
			int idCliente = Integer.parseInt(request.getParameter("idCliente"));
			if (acao.equals("visualizarAnimalByDono")){
				visualizarAnimalByDono(idCliente,request,response);
			}
		}if(request.getParameter("idAnimal") != null) {
			int idAnimal = Integer.parseInt(request.getParameter("idAnimal"));
			if (acao.equals("editar")){
				preencherAnimal(idAnimal,request,response);
			}else if (acao.equals("remover")){
				removerAnimal(idAnimal,request,response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao.equals("cadastrar")){
			cadastrarAnimal(request,response);
		}
		if (acao.equals("editar")){
			editarAnimal(request,response);
		}
	}
	
	protected void editarAnimal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		animal = new AnimalModel(usuario.getCn());
        
		int idAnimal = Integer.parseInt(request.getParameter("idAnimal"));
        String nome = request.getParameter("nome");
        int idade = Integer.parseInt(request.getParameter("idade"));
        String tipo = request.getParameter("tipo");
        String cor = request.getParameter("cor");
        String cpfCliente = request.getParameter("cpfCliente");      	
        animal.atualizarAnimal(idAnimal, nome, idade, tipo, cor, cpfCliente);
        request.setAttribute("message", "Animal editado com sucesso!");
        usuario.carregarListas(request, response);
        request.getRequestDispatcher("gerenciarPaciente.jsp").forward(request, response);
	}
	
	protected void removerAnimal(int idAnimal, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		animal = new AnimalModel(usuario.getCn());
		
		if(animal.lerAnimal(idAnimal)!= null) {
			animal.deletarAnimal(animal.getId());
			request.setAttribute("message", "Animal removido com sucesso!");
			usuario.carregarListas(request,response);			
			request.getRequestDispatcher("GerenciarPaciente.jsp").forward(request, response);
		}
	}
	
	protected void preencherAnimal(int idAnimal, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		animal = new AnimalModel(usuario.getCn());
		
		if(animal.lerAnimal(idAnimal)!= null) {
			sessao.setAttribute("idAnimalEditar", animal.getId());
			sessao.setAttribute("nomeAnimalEditar", animal.getNome());
			sessao.setAttribute("idadeAnimalEditar", animal.getIdade());
			sessao.setAttribute("tipoAnimalEditar", animal.getTipo());
			sessao.setAttribute("corAnimalEditar", animal.getCor());
			sessao.setAttribute("cpfClienteAnimalEditar", animal.getCpfCliente());
            request.getRequestDispatcher("editarPaciente.jsp").forward(request, response);
		}
	}
	
	protected void visualizarAnimalByDono(int idCliente, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		sessao.setAttribute("idClienteVisualizar", idCliente);
		request.getRequestDispatcher("visualizarAnimalDoDono.jsp").forward(request, response);
	}

	
	protected void visualizarAnimais(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		ClienteController cliente = new ClienteController();
		String cpf = cliente.lerCliente(idCliente,request).getCpf();

		usuario.carregarListas(request, response);
		
		sessao.setAttribute("animalByCpfCliente", cpf);		
		request.getRequestDispatcher("visualizarPaciente.jsp").forward(request,response);
	}
	
	protected void cadastrarAnimal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        animal = new AnimalModel(usuario.getCn());
        
        String nome = request.getParameter("nome");
        int idade = Integer.parseInt(request.getParameter("idade"));
        String tipo = request.getParameter("tipo");
        String cor = request.getParameter("cor");
        String cpfCliente = request.getParameter("cpfCliente");
        
        ClienteController cliente = new ClienteController();
        if (cliente.hasCliente(cpfCliente,sessao)) {
        	animal.criarAnimal(nome, idade, tipo, cor, cpfCliente);
        	usuario.carregarListas(request, response);
        	request.setAttribute("message", "Animal cadastrado com sucesso!");
            request.getRequestDispatcher("cadastrarPaciente.jsp").forward(request, response);
        }else {
        	request.setAttribute("message", "Cliente inválido");
            request.getRequestDispatcher("cadastrarPaciente.jsp").forward(request, response);
        }
	}
	
	public boolean hasAnimal(String nome, String cpfCliente, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        animal = new AnimalModel(usuario.getCn());
        if(animal.lerAnimal(nome, cpfCliente) != null) {
        	return true;
        }
        return false;
	}
	
	public int getAnimalId(String nome, String cpfCliente, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        animal = new AnimalModel(usuario.getCn());
        animal = animal.lerAnimal(nome, cpfCliente);
        return animal.getId();
	}
	
	public void carregarAnimais(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		List<AnimalModel> animais = new ArrayList<AnimalModel>();
		animal = new AnimalModel(usuario.getCn());
		animais = animal.getAnimais();
		ArrayList<String> idAnimais = new ArrayList<>();
		ArrayList<String> nomeAnimais = new ArrayList<>();
		ArrayList<String> idadeAnimais = new ArrayList<>();
		ArrayList<String> tipoAnimais = new ArrayList<>();
		ArrayList<String> corAnimais = new ArrayList<>();
		ArrayList<String> cpfClientesAnimais = new ArrayList<>();
		for(int i=0;i<animais.size();i++) {
			idAnimais.add(Integer.toString(animais.get(i).getId()));
			nomeAnimais.add(animais.get(i).getNome());
			idadeAnimais.add(Integer.toString(animais.get(i).getIdade()));
			tipoAnimais.add(animais.get(i).getTipo());
			corAnimais.add(animais.get(i).getCor());
			cpfClientesAnimais.add(animais.get(i).getCpfCliente());
		}
		sessao.setAttribute("idAnimais", idAnimais);
		sessao.setAttribute("nomeAnimais", nomeAnimais);
		sessao.setAttribute("idadeAnimais", idadeAnimais);
		sessao.setAttribute("tipoAnimais", tipoAnimais);
		sessao.setAttribute("corAnimais", corAnimais);
		sessao.setAttribute("cpfClientesAnimais", cpfClientesAnimais);
	}
	
}
