package HomeTaskMySQL;

public class Orders {
	private String number;
	private Contructor contructor;
	private User user;
	@Override
	public String toString() {
		return number;
	}
	public Orders(String number) {
		super();
		this.number = number;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Contructor getContructor() {
		return contructor;
	}
	public void setContructor(Contructor contructor) {
		this.contructor = contructor;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getSumma() {
		return summa;
	}
	public void setSumma(int summa) {
		this.summa = summa;
	}
	private int summa;
	
}
