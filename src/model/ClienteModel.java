package model;

import java.sql.*;

public class ClienteModel {

	private Connection cn;
	
	private int id;
	private String nome;
	private int cpf;
	private String endereco;
	
	public ClienteModel(Connection cn) {
        this.cn = cn;
    }
	
	public boolean criarCliente(String nome, int cpf, String endereco) {
		String query = "INSERT INTO prontuariobd.cliente(nome, cpf, endereco) VALUES (?,?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setInt(2, cpf);
            ps.setString(3, endereco);
            ps.executeUpdate();
            System.out.println("Cadastrado com sucesso");
        
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
		return false;
	}
	
	public ClienteModel lerCliente(int cpf) {
		String query = "SELECT * FROM prontuariobd.cliente WHERE cpf = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, cpf);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.cpf = rs.getInt("cpf");
            this.endereco = rs.getString("endereco");
            
            System.out.println("Id: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("CPF: " + rs.getInt("cpf"));
            System.out.println("Endereço: " + rs.getString("endereco"));
            return this;
            
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
		return null;
	}
	
	public boolean atualizarCliente(int id, String nome, int cpf, String endereco) {
		String query = "UPDATE prontuariobd.cliente SET nome = ?, cpf = ?, endereco = ? WHERE prontuariobd.cliente.id = (?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setInt(2, cpf);
            ps.setString(3, endereco);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Alterado com sucesso");
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
		return false;
	}
	
	public boolean deletarCliente(int cpf) {
		String query = "DELETE FROM prontuariobd.cliente WHERE prontuariobd.cliente.cpf = (?)";
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
