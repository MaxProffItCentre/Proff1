package ManagerJDBC;

public class Orders {
	private String number;
	private String contructor;
	private String user;
	private int summa;
	
	public Orders(String number, String contructor, String user, int summa) {
		super();
		this.number = number;
		this.contructor = contructor;
		this.user = user;
		this.summa = summa;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getContructor() {
		return contructor;
	}

	public void setContructor(String contructor) {
		this.contructor = contructor;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getSumma() {
		return summa;
	}

	public void setSumma(int summa) {
		this.summa = summa;
	}
	
	
}
