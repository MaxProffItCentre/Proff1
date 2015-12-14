package MySQL;

public class User {
	private String name;
	private String login;
	private String pass;
	private Employee employee;
	
	public User(String name, String login, String pass, Employee employee) {
		super();
		this.name = name;
		this.login = login;
		this.pass = pass;
		this.employee = employee;
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
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
