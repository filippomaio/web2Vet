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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        animal = new AnimalModel(usuario.getCn());
        
        String nome = request.getParameter("nome");
        int idade = Integer.parseInt(request.getParameter("idade"));
        String tipo = request.getParameter("tipo");
        String cor = request.getParameter("cor");
        int cpfCliente = Integer.parseInt(request.getParameter("cpfCliente"));
        
        ClienteController cliente = new ClienteController();
        if (cliente.hasCliente(cpfCliente,sessao)) {
        	animal.criarAnimal(nome, idade, tipo, cor, cpfCliente);
        	request.setAttribute("message", "Animal cadastrado com sucesso!");
            request.getRequestDispatcher("cadastrarPaciente.jsp").forward(request, response);
        }else {
        	request.setAttribute("message", "Cliente inválido");
            request.getRequestDispatcher("cadastrarPaciente.jsp").forward(request, response);
        }
	}
	
	public boolean hasAnimal(String nome, int cpfCliente, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        animal = new AnimalModel(usuario.getCn());
        if(animal.lerAnimal(nome, cpfCliente) != null) {
        	return true;
        }
        return false;
	}
	
	public int getAnimalId(String nome, int cpfCliente, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        animal = new AnimalModel(usuario.getCn());
        animal = animal.lerAnimal(nome, cpfCliente);
        return animal.getId();
	}
	

}
