package model;

import java.sql.*;

public class ProntuarioModel {

	private Connection cn;
	
	private int id;
	private int idAnimal;
	private int idAluno;
	private int idProfessor;
	private String motivo;
	private String tratamento;
	private Date dataAtendimento;
	private Date dataRetorno;
	
	public ProntuarioModel(Connection cn) {
        this.cn = cn;
    }
	
	public boolean criarProntuario(int idAnimal, int idAluno, int idProfessor, String motivo, String tratamento, Date dataAtendimento, Date dataRetorno) {
		String query = "INSERT INTO prontuariobd.prontuario(idAnimal, idAluno, idProfessor, motivo, tratamento, dataAtendimento, dataRetorno) VALUES (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idAnimal);
            ps.setInt(2, idAluno);
            ps.setInt(3, idProfessor);
            ps.setString(4, motivo);
            ps.setString(5, tratamento);
            ps.setDate(6, dataAtendimento);
            ps.setDate(7, dataRetorno);
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
            ps.setDate(1, dataAtendimento);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            this.id = rs.getInt("id");
            this.idAnimal = rs.getInt("idAnimal");
            this.idAluno = rs.getInt("idAluno");
            this.idProfessor = rs.getInt("idProfessor");
            this.motivo = rs.getString("motivo");
            this.tratamento = rs.getString("tratamento");
            this.dataAtendimento = rs.getDate("dataAtendimento");
            this.dataRetorno = rs.getDate("dataRetorno");
            
            System.out.println("Id: " + rs.getInt("id"));
            System.out.println("IdAnimal: " + rs.getInt("idAnimal"));
            System.out.println("IdAluno: " + rs.getInt("idAluno"));
            System.out.println("IdProfessor: " + rs.getInt("idProfessor"));
            System.out.println("Motivo: " + rs.getString("motivo"));
            System.out.println("Tratamento: " + rs.getString("tratamento"));
            System.out.println("DataAtendimento: " + rs.getDate("dataAtendimento"));
            System.out.println("DataRetorno: " + rs.getDate("dataRetorno"));
            return this;
            
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
		return null;
	}
	
	public boolean atualizarProntuario(int id, int idAnimal, int idAluno, int idProfessor, String motivo, String tratamento, Date dataAtendimento, Date dataRetorno) {
		String query = "UPDATE prontuariobd.prontuario SET idAnimal = ?, idAluno = ?, idProfessor = ?, motivo = ?, tratamento = ?, dataAtendimento = ?, dataRetorno = ? WHERE prontuariobd.prontuario.id = (?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idAnimal);
            ps.setInt(2, idAluno);
            ps.setInt(3, idProfessor);
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
	
}
