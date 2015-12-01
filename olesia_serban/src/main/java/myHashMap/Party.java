package myHashMap;

public class Party {
	private int number;
	private String contructor;

	public Party(int number, String contructor) {
		this.number = number;
		this.contructor = contructor;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("( ");
		
		sb.append(number).append(" - ").append(contructor);
		sb.append(")");
		return sb.toString();
	}
}
