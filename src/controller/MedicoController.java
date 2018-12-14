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
	
	public void carregarMedicos(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		List<MedicoModel> medicos = new ArrayList<MedicoModel>();
		medico = new MedicoModel(usuario.getCn());
		medicos = medico.getMedicos();
		ArrayList<String> idMedicos = new ArrayList<>();
		ArrayList<String> nomeMedicos = new ArrayList<>();
		ArrayList<String> cpfMedicos = new ArrayList<>();
		ArrayList<String> senhaMedicos = new ArrayList<>();
		ArrayList<String> matriculaMedicos = new ArrayList<>();
		ArrayList<String> cargoMedicos = new ArrayList<>();
		for(int i=0;i<medicos.size();i++) {
			idMedicos.add(Integer.toString(medicos.get(i).getId()));
			nomeMedicos.add(medicos.get(i).getNome());
			cpfMedicos.add(medicos.get(i).getCpf());
			senhaMedicos.add(medicos.get(i).getSenha());
			matriculaMedicos.add(medicos.get(i).getMatricula());
			cargoMedicos.add(Integer.toString(medicos.get(i).getCargo()));
		}
		sessao.setAttribute("idMedicos", idMedicos);
		sessao.setAttribute("nomeMedicos", nomeMedicos);
		sessao.setAttribute("cpfMedicos", cpfMedicos);
		sessao.setAttribute("senhaMedicos", senhaMedicos);
		sessao.setAttribute("matriculaMedicos", matriculaMedicos);
		sessao.setAttribute("cargoMedicos", cargoMedicos);
	}
}
