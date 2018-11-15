package controller;

import java.io.IOException;
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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		cliente = new ClienteModel(usuario.getCn());
        
        String nome = request.getParameter("nome");
        int cpf = Integer.parseInt(request.getParameter("cpf"));
        String endereco = request.getParameter("endereco");
        
        ClienteController cliente = new ClienteController();
        if (!cliente.hasCliente(cpf,sessao)) {        	
        	this.cliente.criarCliente(nome, cpf, endereco);
        	request.setAttribute("message", "Cliente castrado com sucesso!");
            request.getRequestDispatcher("cadastrarDono.jsp").forward(request, response);
        }else {
        	request.setAttribute("message", "Cliente já existe");
            request.getRequestDispatcher("cadastrarDono.jsp").forward(request, response);
        }
	}
	
	public boolean hasCliente(int cpf, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        cliente = new ClienteModel(usuario.getCn());
        if(cliente.lerCliente(cpf) != null) {
        	return true;
        }
        return false;
	}

}
