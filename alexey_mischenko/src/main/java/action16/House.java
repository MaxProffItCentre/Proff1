package action16;

public class House {
	Lift lift;
	String number;
	
	
	public Lift getLift() {
		return lift;
	}

	public void setLift(Lift lift) {
		this.lift = lift;
	}

	@Override
	public String toString() {
		return "House [lift=" + lift + ", number=" + number + "]";
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public House() {

	}
	
	public House(String number) {
		this.number = number;
	}
	
	House getInstance(){
		return new House();
	}
}
