package model;

import java.sql.*;

public class AnimalModel {

	private Connection cn;
	
	private int id;
	private String nome;
	private int idade;
	private String tipo;
	private String cor;
	private int cpfCliente;
	
	public AnimalModel(Connection cn) {
        this.cn = cn;
    }
	
	public boolean criarAnimal(String nome, int idade, String tipo, String cor, int cpfCliente) {
		String query = "INSERT INTO prontuariobd.animal(nome, idade, tipo, cor, cpfCliente) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setInt(2, idade);
            ps.setString(3, tipo);
            ps.setString(4, cor);
            ps.setInt(5, cpfCliente);
            ps.executeUpdate();
            System.out.println("Cadastrado com sucesso");
        
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
		return false;
	}
	
	public AnimalModel lerAnimal(int id) {
		String query = "SELECT * FROM prontuariobd.animal WHERE id = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.idade = rs.getInt("idade");
            this.tipo = rs.getString("tipo");
            this.cor = rs.getString("cor");
            this.cpfCliente = rs.getInt("cpfCliente");
            
            System.out.println("Id: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Idade: " + rs.getInt("idade"));
            System.out.println("Tipo: " + rs.getString("tipo"));
            System.out.println("Cor: " + rs.getString("cor"));
            System.out.println("cpfCliente: " + rs.getInt("cpfCliente"));
            return this;
            
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
		return null;
	}
	
	public AnimalModel lerAnimal(String nome, int cpfCliente) {
		String query = "SELECT * FROM prontuariobd.animal WHERE nome = (?) and cpfCliente = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setInt(2, cpfCliente);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.idade = rs.getInt("idade");
            this.tipo = rs.getString("tipo");
            this.cor = rs.getString("cor");
            this.cpfCliente = rs.getInt("cpfCliente");
            
            System.out.println("Id: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Idade: " + rs.getInt("idade"));
            System.out.println("Tipo: " + rs.getString("tipo"));
            System.out.println("Cor: " + rs.getString("cor"));
            System.out.println("cpfCliente: " + rs.getInt("cpfCliente"));
            return this;
            
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
		return null;
	}
	
	public boolean atualizarAnimal(int id, String nome, int idade, String tipo, String cor, int cpfCliente) {
		String query = "UPDATE prontuariobd.animal SET nome = ?, idade = ?, tipo = ?, cor = ?, cpfCliente = ? WHERE prontuariobd.animal.id = (?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setInt(2, idade);
            ps.setString(3, tipo);
            ps.setString(4, cor);
            ps.setInt(5, cpfCliente);
            ps.setInt(6, id);
            ps.executeUpdate();
            System.out.println("Alterado com sucesso");
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
		return false;
	}
	
	public boolean deletarAnimal(int id) {
		String query = "DELETE FROM prontuariobd.animal WHERE prontuariobd.animal.id = (?)";
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
	
	public int getId() {
		return this.id;
	}
	
}
