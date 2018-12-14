package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
		String acao = request.getParameter("acao");
		if(request.getParameter("idAnimal") != null) {
			int idAnimal = Integer.parseInt(request.getParameter("idAnimal"));
			if (acao.equals("visualizar")){
				visualizarProntuarioByAnimal(idAnimal,request,response);
			}
		}		
		if(request.getParameter("idProntuario") != null) {
			int idProntuario = Integer.parseInt(request.getParameter("idProntuario"));
			if (acao.equals("editar")){
				preencherProntuario(idProntuario,request,response);
			}else if (acao.equals("remover")){
				removerProntuario(idProntuario,request,response);
			}else if (acao.equals("gerar")) {
				gerarProntuario(idProntuario,request,response);
			}else if (acao.equals("aprovar")) {
				aprovarProntuario(idProntuario, request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao.equals("cadastrar")){
			cadastrarProntuario(request,response);
		}
		if (acao.equals("editar")){
			editarProntuario(request,response);
		}
	}
	
	protected void editarProntuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Prontuário não é editável		
	}
	
	protected void aprovarProntuario(int idProntuario, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		prontuario = new ProntuarioModel(usuario.getCn());
		if(prontuario.lerProntuario(idProntuario)!= null) {
			prontuario.aprovarProntuario(prontuario.getId());
			request.setAttribute("message", "Prontuario aprovado com sucesso!");
			usuario.carregarListas(request,response);			
			request.getRequestDispatcher("notificacoes.jsp").forward(request, response);
		}
	}
	
	protected void gerarProntuario(int idProntuario, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();		
		sessao.setAttribute("idProntuarioGerar", idProntuario);
		request.getRequestDispatcher("relatorio.jsp").forward(request, response);
	}
	
	protected void removerProntuario(int idProntuario, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		prontuario = new ProntuarioModel(usuario.getCn());
		
		if(prontuario.lerProntuario(idProntuario)!= null) {
			prontuario.deletarProntuario(prontuario.getId());
			request.setAttribute("message", "Prontuario removido com sucesso!");
			usuario.carregarListas(request,response);			
			request.getRequestDispatcher("bem_vindo.jsp").forward(request, response);
		}
	}
	
	protected void preencherProntuario(int idProntuario, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Prontuario não é editável
	}
	
	protected void visualizarProntuarioByAnimal(int idAnimal, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		sessao.setAttribute("idAnimalVisualizar", idAnimal);
		request.getRequestDispatcher("visualizarProntuarioDoPaciente.jsp").forward(request, response);
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
        	prontuario.criarProntuario(idAnimal, cpfAluno, cpfProfessor, motivo, tratamento, dataAtendimento, dataRetorno, 0);
        	usuario.carregarListas(request, response);
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
	
	public void carregarProntuarios(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		List<ProntuarioModel> prontuarios = new ArrayList<ProntuarioModel>();
		prontuario = new ProntuarioModel(usuario.getCn());
		prontuarios = prontuario.getProntuarios();
		ArrayList<String> idProntuarios = new ArrayList<>();
		ArrayList<String> idAnimaisProntuarios = new ArrayList<>();
		ArrayList<String> cpfAlunosProntuarios = new ArrayList<>();
		ArrayList<String> cpfProfessoresProntuarios = new ArrayList<>();
		ArrayList<String> motivos = new ArrayList<>();
		ArrayList<String> tratamentos = new ArrayList<>();
		ArrayList<String> dataAtendimentos = new ArrayList<>();
		ArrayList<String> dataRetornos = new ArrayList<>();
		ArrayList<String> aprovados = new ArrayList<>();
		for(int i=0;i<prontuarios.size();i++) {
			idProntuarios.add(Integer.toString(prontuarios.get(i).getId()));
			idAnimaisProntuarios.add(Integer.toString(prontuarios.get(i).getIdAnimal()));
			cpfAlunosProntuarios.add(prontuarios.get(i).getCpfAluno());
			cpfProfessoresProntuarios.add(prontuarios.get(i).getCpfProfessor());
			motivos.add(prontuarios.get(i).getMotivo());
			tratamentos.add(prontuarios.get(i).getTratamento());
			dataAtendimentos.add((prontuarios.get(i).getDataAtendimento()).toString());
			if (prontuarios.get(i).getDataRetorno() != null) {
				dataRetornos.add((prontuarios.get(i).getDataRetorno()).toString());
			}else {
				dataRetornos.add("");
			}
			aprovados.add(Integer.toString(prontuarios.get(i).getAprovado()));
		}
		sessao.setAttribute("idProntuarios", idProntuarios);
		sessao.setAttribute("idAnimaisProntuarios", idAnimaisProntuarios);
		sessao.setAttribute("cpfAlunosProntuarios", cpfAlunosProntuarios);
		sessao.setAttribute("cpfProfessoresProntuarios", cpfProfessoresProntuarios);
		sessao.setAttribute("motivos", motivos);
		sessao.setAttribute("tratamentos", tratamentos);
		sessao.setAttribute("dataAtendimentos", dataAtendimentos);
		sessao.setAttribute("dataRetornos", dataRetornos);
		sessao.setAttribute("aprovados", aprovados);
	}


}
