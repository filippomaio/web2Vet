package model;

import java.sql.*;
import java.util.ArrayList;

public class AnimalModel {

	private Connection cn;
	
	private int id;
	private String nome;
	private int idade;
	private String tipo;
	private String cor;
	private String cpfCliente;
	
	public AnimalModel(Connection cn) {
        this.cn = cn;
    }
	
	public boolean criarAnimal(String nome, int idade, String tipo, String cor, String cpfCliente) {
		String query = "INSERT INTO prontuariobd.animal(nome, idade, tipo, cor, cpfCliente) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setInt(2, idade);
            ps.setString(3, tipo);
            ps.setString(4, cor);
            ps.setString(5, cpfCliente);
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
            this.cpfCliente = rs.getString("cpfCliente");
            
            System.out.println("Id: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Idade: " + rs.getInt("idade"));
            System.out.println("Tipo: " + rs.getString("tipo"));
            System.out.println("Cor: " + rs.getString("cor"));
            System.out.println("cpfCliente: " + rs.getString("cpfCliente"));
            return this;
            
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
		return null;
	}
	
	public AnimalModel lerAnimal(String nome, String cpfCliente) {
		String query = "SELECT * FROM prontuariobd.animal WHERE nome = (?) and cpfCliente = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setString(2, cpfCliente);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.idade = rs.getInt("idade");
            this.tipo = rs.getString("tipo");
            this.cor = rs.getString("cor");
            this.cpfCliente = rs.getString("cpfCliente");
            
            System.out.println("Id: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Idade: " + rs.getInt("idade"));
            System.out.println("Tipo: " + rs.getString("tipo"));
            System.out.println("Cor: " + rs.getString("cor"));
            System.out.println("cpfCliente: " + rs.getString("cpfCliente"));
            return this;
            
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
		return null;
	}
	
	public boolean atualizarAnimal(int id, String nome, int idade, String tipo, String cor, String cpfCliente) {
		String query = "UPDATE prontuariobd.animal SET nome = ?, idade = ?, tipo = ?, cor = ?, cpfCliente = ? WHERE prontuariobd.animal.id = (?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setInt(2, idade);
            ps.setString(3, tipo);
            ps.setString(4, cor);
            ps.setString(5, cpfCliente);
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
	
	public String getNome() {
		return this.nome;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public String getCor() {
		return this.cor;
	}
	
	public String getCpfCliente() {
		return this.cpfCliente;
	}
	
	
	public ArrayList<AnimalModel> getAnimais(){
        String query = "SELECT * FROM prontuariobd.animal";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<AnimalModel> animais = new ArrayList<AnimalModel>();
            while(rs.next()){
            	AnimalModel animal = new AnimalModel(cn);
                animal.id = rs.getInt("id");
                animal.nome = rs.getString("nome");
                animal.idade = rs.getInt("idade");
                animal.tipo = rs.getString("tipo");
                animal.cor = rs.getString("cor");
                animal.cpfCliente = rs.getString("cpfCliente");
                animais.add(animal);
            }
            return animais;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        return null;
    }
}
