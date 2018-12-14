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
		if (usuario.logar(cpf, senha)) {
			HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", this);
            sessao.setAttribute("MeuCPF", usuario.getCPF());
            sessao.setAttribute("cargo", usuario.getCargo());
			request.setAttribute("usuario", this);
			
			carregarListas(request,response);
			
			request.getRequestDispatcher("bem_vindo.jsp").forward(request,response);
        }else {
        	request.setAttribute("message", "Login inválido");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

	}
	
	public void carregarListas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Carregar Listas
		ClienteController cliente = new ClienteController();
		cliente.carregarClientes(request);
		AnimalController animal = new AnimalController();
		animal.carregarAnimais(request);
		ProntuarioController prontuario = new ProntuarioController();
		prontuario.carregarProntuarios(request);
		MedicoController medico = new MedicoController();
		medico.carregarMedicos(request);
	}
	
	public Connection getCn() {
		return usuario.getCn();
	}
	
	public String getCPF() {
		return usuario.getCPF();
	}

}
