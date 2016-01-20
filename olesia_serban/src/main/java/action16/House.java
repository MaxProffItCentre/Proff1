package action16;

public class House {
	private Lift lift;
	private String number;

	public House() {
	}

	public House(String number) {

		this.number = number;
	}

	public House(String number, Lift lift) {
		this(number);
		this.lift = lift;
	}

	public Lift getLift() {
		return lift;
	}

	public void setLift(Lift lift) {
		this.lift = lift;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "House [number=" + number + ", " + lift + "]";
	}

	public static House getInstanceOf() {
		return new House();
	}
}
