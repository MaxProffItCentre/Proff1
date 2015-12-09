package crmExample;

public class Orders {
	private String number;
	private Contructor contructor;
	private User user;
	private Double summa;
	
	public Orders(){}

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
	
	
}
