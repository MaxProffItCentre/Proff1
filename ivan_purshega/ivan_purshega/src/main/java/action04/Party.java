package action04;

public class Party {
	private int number;
	private String contructor;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getContructor() {
		return contructor;
	}
	public void setContructor(String contructor) {
		this.contructor = contructor;
	}
	public Party(int number, String contructor) {
		super();
		this.number = number;
		this.contructor = contructor;
	}
}
