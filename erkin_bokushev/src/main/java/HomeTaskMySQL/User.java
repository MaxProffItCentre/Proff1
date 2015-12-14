package HomeTaskMySQL;

public class User {
	private String name;
	@Override
	public String toString() {
		return name;
	}
	private String login;
	public User(String name) {
		super();
		this.name = name;
	}
	private String pass;
	private Employee employee;
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
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
