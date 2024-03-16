package model;

import java.io.Serializable;

//Sempre fazer o import
public class ModelLogin implements Serializable {

//criamos o serial id universal para evitar erros 
	private static final long serialVersionUID = 2472796871797376756L;

	
//Aqui criamos os atribustos no back
	private String login;
	private String senha;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
