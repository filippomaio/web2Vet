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
 * Servlet implementation class MedicoController
 */
@WebServlet("/MedicoController")
public class MedicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MedicoModel medico;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicoController() {
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
	}
	
	protected void cadastrarMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO
	}
	
	public boolean hasMedico(String matricula, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        medico = new MedicoModel(usuario.getCn());
        if(medico.lerMedico(matricula) != null) {
        	return true;
        }
        return false;
	}
	
	//1 = Professor , 2 = Aluno
	public boolean hasProfessor(String matricula, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        medico = new MedicoModel(usuario.getCn());
        if(medico.lerMedico(matricula,1) != null) {
        	return true;
        }
        return false;
	}
	
	//1 = Professor , 2 = Aluno
	public boolean hasAluno(String matricula, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        medico = new MedicoModel(usuario.getCn());
        if(medico.lerMedico(matricula,2) != null) {
        	return true;
        }
        return false;
	}
	
	public String getCPF(String matricula, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        medico = new MedicoModel(usuario.getCn());
        medico = medico.lerMedico(matricula);
        return medico.getCPF();
	}
}
