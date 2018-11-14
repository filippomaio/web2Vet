package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

/**
 * Servlet implementation class LoginView
 */
@WebServlet("/Login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginModel sessao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        sessao = new LoginModel();
        sessao.conectar("localhost");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
		//List<String> l = new ArrayList<String>();
		//l.add("A");
		//l.add("B");
		//l.add("C");
		//l.add("D");
		if (sessao.logar(cpf, senha)) {
			//request.setAttribute("lista", l);
			request.setAttribute("usuario", sessao);
			request.getRequestDispatcher("bem_vindo.jsp").forward(request,response);
        }else {
        	//revisar
        	response.sendRedirect("login.jsp?error=1");
        }
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
