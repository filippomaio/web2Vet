package controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class LoginView
 */
@WebServlet("/Login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginModel usuario;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        usuario = new LoginModel();
        usuario.conectar("localhost");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessao  = request.getSession();
	    sessao.removeAttribute("usuario");
	    response.sendRedirect("login.jsp");		    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
		//List<String> l = new ArrayList<String>();
		//l.add("A");
		//l.add("B");
		//l.add("C");
		//l.add("D");
		if (usuario.logar(cpf, senha)) {
			//request.setAttribute("lista", l);
			HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", this);
			request.setAttribute("usuario", this);
			
			//Carregar Listas
			ClienteController cliente = new ClienteController();
			cliente.carregarClientes(request);
			AnimalController animal = new AnimalController();
			animal.carregarAnimais(request);
			
			request.getRequestDispatcher("bem_vindo.jsp").forward(request,response);
        }else {
        	//revisar
        	request.setAttribute("message", "Login inválido");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

	}
	
	public Connection getCn() {
		return usuario.getCn();
	}
	
	public String getCPF() {
		return usuario.getCPF();
	}

}
