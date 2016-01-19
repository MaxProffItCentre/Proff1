package ManagerJDBC;

public class User extends ConnectionIni{
	private String name;
	private String login;
	private String pass;
	private Employee employee;
	
	public User(String name, String login, String pass, Employee emp){
		this.name = name;
		this.login = login;
		this.pass = pass;
		this.employee = emp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginUser() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassUser() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
}
