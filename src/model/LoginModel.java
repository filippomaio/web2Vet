package model;

import java.sql.*;

public class LoginModel {
	
	private String hostname;
    private Connection cn;
    private Statement stmt;
    private String query;
    private ResultSet rs;
    private PreparedStatement ps;
    
    private int id;
    private String nome;
    private int cpf;
    private String senha;
    private int matricula;
    private int cargo;
    
	
	public boolean conectar(String hostname) {
		System.out.println("conectado...");
		try{
	           Class.forName("com.mysql.jdbc.Driver");
	           this.hostname = hostname;
	           String address = "jdbc:mysql://"+this.hostname+":3306";
	          
	           this.cn = DriverManager.getConnection(address, "root", "");
	           System.out.println(cn);

	           this.stmt = this.cn.createStatement();
	           
	           System.out.println("Conectou no banco");
	           
	           return true;
	           
	        }catch(ClassNotFoundException | SQLException e){
		        System.out.println(cn);
	            System.out.println("Erro: "+ e);
	        }
	        return false;
	}
	
	public boolean desconectar(){
        try {
            getCn().close();
            ps.close();
            rs.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao desconectar");
        }        
        return false;
    }
    
    
    public boolean logar(String cpf, String senha){
    
        query = "SELECT * FROM prontuariobd.medico WHERE cpf=? and senha=?";
        
        try {
            ps = cn.prepareStatement(query);
            ps.setString(1, cpf);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            rs.next();
            
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.cpf = rs.getInt("cpf");
            this.senha = rs.getString("senha");
            this.matricula = rs.getInt("matricula");
            this.cargo = rs.getInt("cargo");
            
            System.out.println("Usuário: " + this.nome);
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return false;
    }    

    /**
     * @return the cn
     */
    public Connection getCn() {
        return cn;
    }
    
}
