package model;

import java.sql.*;
import java.util.ArrayList;

public class ProntuarioModel {

	private Connection cn;
	
	private int id;
	private int idAnimal;
	private String cpfAluno;
	private String cpfProfessor;
	private String motivo;
	private String tratamento;
	private Date dataAtendimento;
	private Date dataRetorno;
	private int aprovado;
		
	
	public ProntuarioModel(Connection cn) {
        this.cn = cn;
    }
	
	public boolean criarProntuario(int idAnimal, String cpfAluno, String cpfProfessor, String motivo, String tratamento, Date dataAtendimento, Date dataRetorno, int aprovado) {
		String query = "INSERT INTO prontuariobd.prontuario(idAnimal, cpfAluno, cpfProfessor, motivo, tratamento, dataAtendimento, dataRetorno, aprovado) VALUES (?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idAnimal);
            ps.setString(2, cpfAluno);
            ps.setString(3, cpfProfessor);
            ps.setString(4, motivo);
            ps.setString(5, tratamento);
            ps.setDate(6, dataAtendimento);
            ps.setDate(7, dataRetorno);
            ps.setInt(8, aprovado);
            ps.executeUpdate();
            System.out.println("Cadastrado com sucesso");
        
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
		return false;
	}
	
	public ProntuarioModel lerProntuario(int idAnimal, Date dataAtendimento) {
		String query = "SELECT * FROM prontuariobd.prontuario WHERE idAnimal = (?) and dataAtendimento = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idAnimal);
            ps.setDate(2, dataAtendimento);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            this.id = rs.getInt("id");
            this.idAnimal = rs.getInt("idAnimal");
            this.cpfAluno = rs.getString("cpfAluno");
            this.cpfProfessor = rs.getString("cpfProfessor");
            this.motivo = rs.getString("motivo");
            this.tratamento = rs.getString("tratamento");
            this.dataAtendimento = rs.getDate("dataAtendimento");
            this.dataRetorno = rs.getDate("dataRetorno");
            this.aprovado = rs.getInt("aprovado");

            return this;
            
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
		return null;
	}
	
	public ProntuarioModel lerProntuario(int idProntuario) {
		String query = "SELECT * FROM prontuariobd.prontuario WHERE id = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idProntuario);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            this.id = rs.getInt("id");
            this.idAnimal = rs.getInt("idAnimal");
            this.cpfAluno = rs.getString("cpfAluno");
            this.cpfProfessor = rs.getString("cpfProfessor");
            this.motivo = rs.getString("motivo");
            this.tratamento = rs.getString("tratamento");
            this.dataAtendimento = rs.getDate("dataAtendimento");
            this.dataRetorno = rs.getDate("dataRetorno");
            this.aprovado = rs.getInt("aprovado");

            return this;
            
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
		return null;
	}
	
	public boolean atualizarProntuario(int id, int idAnimal, String cpfAluno, String cpfProfessor, String motivo, String tratamento, Date dataAtendimento, Date dataRetorno) {
		String query = "UPDATE prontuariobd.prontuario SET idAnimal = ?, cpfAluno = ?, cpfProfessor = ?, motivo = ?, tratamento = ?, dataAtendimento = ?, dataRetorno = ? WHERE prontuariobd.prontuario.id = (?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idAnimal);
            ps.setString(2, cpfAluno);
            ps.setString(3, cpfProfessor);
            ps.setString(4, motivo);
            ps.setString(5, tratamento);
            ps.setDate(6, dataAtendimento);
            ps.setDate(7, dataRetorno);
            ps.setInt(8, id);
            ps.executeUpdate();
            System.out.println("Alterado com sucesso");
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
		return false;
	}
	
	public boolean aprovarProntuario(int id) {
		String query = "UPDATE prontuariobd.prontuario SET aprovado = ? WHERE prontuariobd.prontuario.id = (?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, 1);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Alterado com sucesso");
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
		return false;
	}
	
	public boolean deletarProntuario(int id) {
		String query = "DELETE FROM prontuariobd.prontuario WHERE prontuariobd.prontuario.id = (?)";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Deletado com sucesso");
            return true;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
		return false;
	}
	
	public ArrayList<ProntuarioModel> getProntuarios(){
        String query = "SELECT * FROM prontuariobd.prontuario";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<ProntuarioModel> prontuarios = new ArrayList<ProntuarioModel>();
            while(rs.next()){
            	ProntuarioModel prontuario = new ProntuarioModel(cn);
                prontuario.id = rs.getInt("id");
                prontuario.idAnimal = rs.getInt("idAnimal");
                prontuario.cpfAluno = rs.getString("cpfAluno");
                prontuario.cpfProfessor = rs.getString("cpfProfessor");
                prontuario.motivo = rs.getString("motivo");
                prontuario.tratamento = rs.getString("tratamento");
                prontuario.dataAtendimento = rs.getDate("dataAtendimento");
                prontuario.dataRetorno = rs.getDate("dataRetorno");
                prontuario.aprovado = rs.getInt("aprovado");
                prontuarios.add(prontuario);
            }
            return prontuarios;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        return null;
    }

	public int getId() {
		return id;
	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public String getCpfAluno() {
		return cpfAluno;
	}

	public String getCpfProfessor() {
		return cpfProfessor;
	}

	public String getMotivo() {
		return motivo;
	}

	public String getTratamento() {
		return tratamento;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public Date getDataRetorno() {
		return dataRetorno;
	}

	public int getAprovado() {
		return aprovado;
	}
	
}
