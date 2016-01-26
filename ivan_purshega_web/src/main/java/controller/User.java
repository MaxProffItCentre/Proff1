package controller;

public class User {
	private String name;
	private String login;
	private String pass;
	
	public User(String name, String login, String pass){
		this.name = name;
		this.login = login;
		this.pass = pass;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String toTableUser(){
		return "<tr><td>Name: " + name +"</td> " +
				"<td>Login: " + login + "</td> " +
				"<td>Password: " + pass  + "</td>" ;
	}
	
}
