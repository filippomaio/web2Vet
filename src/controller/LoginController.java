package controller;

import model.*;
import view.*;

import java.sql.*;

public class LoginController {
	private String login;
    private String senha;
    private LoginModel sessao;
    
    private LoginView loginView;
    
    public LoginController(LoginView loginView){
        sessao = new LoginModel();
        this.conectar();
        //loginView = new LoginView();
      
    }
    
    public Connection getCn(){
        return sessao.getCn();
    }
    
    public boolean conectar(){
        return sessao.conectar("localhost");
    }
    
    public boolean autenticar(String cpf, String senha){
        if(sessao.logar(cpf, senha)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean logoff(){
        return sessao.desconectar();
        
    }
}
