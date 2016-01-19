package action16;

public class House {
	Lift lift;
	String number;
	
	public static House getInstance(){
		return new House();
		
	}
	
	public House(String number){
		this.number=number;
	}
	
	public House(Lift lift, String number) {
		super();
		this.lift = lift;
		this.number = number;
	}
	@Override
	public String toString() {
		return "House [lift=" + lift + ", number=" + number + "]";
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
	
	public House(){
		
	}
	
}


