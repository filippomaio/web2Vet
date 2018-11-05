package model;

import java.sql.*;

public class MedicoModel {

	private Connection cn;
	
	private int id;
	private String nome;
	private int cpf;
	private String senha;
	private int matricula;
	private int cargo;
	
	public MedicoModel(Connection cn) {
        this.cn = cn;
    }
	
	public boolean criarMedico(String nome, int cpf, String senha, int matricula, int cargo) {
		String query = "INSERT INTO prontuariobd.medico(nome, cpf, senha, matricula, cargo) VALUES (?,?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setInt(2, cpf);
            ps.setString(3, senha);
            ps.setInt(4, matricula);
            ps.setInt(5, cargo);
            ps.executeUpdate();
            System.out.println("Cadastrado com sucesso");
        
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
		return false;
	}
	
	public MedicoModel lerMedico(int cpf) {
		String query = "SELECT * FROM prontuariobd.medico WHERE cpf = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, cpf);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.cpf = rs.getInt("cpf");
            this.senha = rs.getString("senha");
            this.matricula = rs.getInt("matricula");
            this.cargo = rs.getInt("cargo");
            
            System.out.println("Id: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("CPF: " + rs.getInt("cpf"));
            System.out.println("Senha: " + rs.getString("senha"));
            System.out.println("matricula: " + rs.getInt("matricula"));
            System.out.println("cargo: " + rs.getInt("cargo"));
            return this;
            
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
		return null;
	}
	
	public boolean atualizarMedico(int id, String nome, int cpf, String senha, int matricula, int cargo) {
		String query = "UPDATE prontuariobd.medico SET nome = ?, cpf = ?, senha = ?, matricula = ?, cargo = ? WHERE prontuariobd.medico.id = (?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setInt(2, cpf);
            ps.setString(3, senha);
            ps.setInt(4, matricula);
            ps.setInt(5, cargo);
            ps.setInt(6, id);
            ps.executeUpdate();
            System.out.println("Alterado com sucesso");
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
		return false;
	}
	
	public boolean deletarMedico(int cpf) {
		String query = "DELETE FROM prontuariobd.medico WHERE prontuariobd.medico.cpf = (?)";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, cpf);
            ps.executeUpdate();
            System.out.println("Deletado com sucesso");
            return true;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
		return false;
	}
	
}
