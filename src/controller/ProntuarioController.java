package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class ProntuarioController
 */
@WebServlet("/Prontuario.do")
public class ProntuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProntuarioModel prontuario;  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProntuarioController() {
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
		String acao = request.getParameter("acao");
		if (acao.equals("cadastrar")){
			cadastrarProntuario(request,response);
		}
	}
	
	protected void cadastrarProntuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        prontuario = new ProntuarioModel(usuario.getCn());
        
        String nome = request.getParameter("nome");
        String cpfCliente = request.getParameter("cpfCliente");
        String motivo = request.getParameter("motivo");
        String tratamento = request.getParameter("tratamento");
        Date dataAtendimento = new Date(new java.util.Date().getTime());
        Date dataRetorno = null;
		if ((request.getParameter("dataRetorno") != "") || (request.getParameter("dataRetorno") != null)) {
			try {
				dataRetorno = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataRetorno")).getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
        String matriculaProf = request.getParameter("matriculaProf");
        
        //validar Cliente (cpf)       
        ClienteController cliente = new ClienteController();
        
        //validar Animal (nome + cpfCliente)
        AnimalController animal = new AnimalController();
        
        //validar Professor (matricula + cargo)
        MedicoController medico = new MedicoController();
        
        if ((cliente.hasCliente(cpfCliente,sessao)) && (animal.hasAnimal(nome,cpfCliente,sessao)) && (medico.hasProfessor(matriculaProf,sessao))) {
        	int idAnimal = animal.getAnimalId(nome, cpfCliente, sessao);
        	String cpfAluno = usuario.getCPF();
        	String cpfProfessor = medico.getCPF(matriculaProf, sessao);
        	prontuario.criarProntuario(idAnimal, cpfAluno, cpfProfessor, motivo, tratamento, dataAtendimento, dataRetorno);
        	request.setAttribute("message", "Prontuário cadastrado com sucesso!");
            request.getRequestDispatcher("consultarPaciente.jsp").forward(request, response);
        }else if (!(cliente.hasCliente(cpfCliente,sessao))){
        	request.setAttribute("message", "Cliente inválido");
            request.getRequestDispatcher("consultarPaciente.jsp").forward(request, response);
        }else if (!(animal.hasAnimal(nome,cpfCliente,sessao))){
        	request.setAttribute("message", "Animal inválido");
            request.getRequestDispatcher("consultarPaciente.jsp").forward(request, response);
        }else if (!(medico.hasProfessor(matriculaProf,sessao))){
        	request.setAttribute("message", "Professor inválido");
            request.getRequestDispatcher("consultarPaciente.jsp").forward(request, response);
        }else {
        	request.setAttribute("message", "Erro!");
            request.getRequestDispatcher("consultarPaciente.jsp").forward(request, response);
        }
	}

}
