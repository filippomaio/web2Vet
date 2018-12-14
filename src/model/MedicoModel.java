package model;

import java.sql.*;
import java.util.ArrayList;

public class MedicoModel {

	private Connection cn;
	
	private int id;
	private String nome;
	private String cpf;
	private String senha;
	private String matricula;
	private int cargo;
	
	public MedicoModel(Connection cn) {
        this.cn = cn;
    }
	
	public boolean criarMedico(String nome, String cpf, String senha, String matricula, int cargo) {
		String query = "INSERT INTO prontuariobd.medico(nome, cpf, senha, matricula, cargo) VALUES (?,?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setString(2, cpf);
            ps.setString(3, senha);
            ps.setString(4, matricula);
            ps.setInt(5, cargo);
            ps.executeUpdate();
            System.out.println("Cadastrado com sucesso");
        
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
		return false;
	}
	
	public MedicoModel lerMedico(String matricula) {
		String query = "SELECT * FROM prontuariobd.medico WHERE matricula = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, matricula);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.cpf = rs.getString("cpf");
            this.senha = rs.getString("senha");
            this.matricula = rs.getString("matricula");
            this.cargo = rs.getInt("cargo");
            
            System.out.println("Id: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("CPF: " + rs.getString("cpf"));
            System.out.println("Senha: " + rs.getString("senha"));
            System.out.println("matricula: " + rs.getString("matricula"));
            System.out.println("cargo: " + rs.getInt("cargo"));
            return this;
            
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
		return null;
	}
	
	public MedicoModel lerMedico(String matricula, int cargo) {
		String query = "SELECT * FROM prontuariobd.medico WHERE matricula = (?) and cargo = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, matricula);
            ps.setInt(2, cargo);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.cpf = rs.getString("cpf");
            this.senha = rs.getString("senha");
            this.matricula = rs.getString("matricula");
            this.cargo = rs.getInt("cargo");
            
            System.out.println("Id: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("CPF: " + rs.getInt("cpf"));
            System.out.println("Senha: " + rs.getString("senha"));
            System.out.println("matricula: " + rs.getString("matricula"));
            System.out.println("cargo: " + rs.getInt("cargo"));
            return this;
            
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
		return null;
	}
	
	public boolean atualizarMedico(int id, String nome, String cpf, String senha, String matricula, int cargo) {
		String query = "UPDATE prontuariobd.medico SET nome = ?, cpf = ?, senha = ?, matricula = ?, cargo = ? WHERE prontuariobd.medico.id = (?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setString(2, cpf);
            ps.setString(3, senha);
            ps.setString(4, matricula);
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
	
	public String getCPF() {
		return this.cpf;
	}
	
	public ArrayList<MedicoModel> getMedicos(){
        String query = "SELECT * FROM prontuariobd.medico";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<MedicoModel> medicos = new ArrayList<MedicoModel>();
            while(rs.next()){
            	MedicoModel medico = new MedicoModel(cn);
                medico.id = rs.getInt("id");
                medico.nome = rs.getString("nome");
                medico.cpf = rs.getString("cpf");
                medico.senha = rs.getString("senha");
                medico.matricula = rs.getString("matricula");
                medico.cargo = rs.getInt("cargo");
                medicos.add(medico);
            }
            return medicos;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        return null;
    }

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getSenha() {
		return senha;
	}

	public String getMatricula() {
		return matricula;
	}

	public int getCargo() {
		return cargo;
	}
	
}
