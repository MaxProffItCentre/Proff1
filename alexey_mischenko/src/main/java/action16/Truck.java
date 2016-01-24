package action16;

public class Truck {
	String number;
	
	public Truck(){
		
	}

	public Truck(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "Truck [number=" + number + "]";
	}
}
