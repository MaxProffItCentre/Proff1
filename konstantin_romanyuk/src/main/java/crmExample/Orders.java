package crmExample;

public class Orders {
	private String number;
	private Contructor contructor;
	private User user;
	private Double summa;
	
	

	public Orders(String number, Contructor contructor, User user, Double summa) {
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

	public Double getSumma() {
		return summa;
	}

	public void setSumma(Double summa) {
		this.summa = summa;
	}

	@Override
	public String toString() {
		return "Orders [number=" + number + ", contructor=" + contructor + ", user=" + user + ", summa=" + summa + "]";
	}
	
	
}
