package MySQL;

public class Orders {
	private String number;
	private String contructor;
	private String user;
	private String summa;
	public Orders(String number, String contructor, String user, String summa) {
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
	public String getSumma() {
		return summa;
	}
	public void setSumma(String summa) {
		this.summa = summa;
	}
	
	
}
