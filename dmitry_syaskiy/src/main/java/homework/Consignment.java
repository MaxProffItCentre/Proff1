package homework;

public class Consignment {
	private int number;
	private String contructor;
	public Consignment(){}
	public Consignment(int number, String contructor){
		this.number = number;
		this.contructor = contructor;
	}
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
	@Override
	public int hashCode(){
		return (contructor.hashCode() + number);
	}
	@Override
	public boolean equals(Object obj){
		if(obj == null) return false;
		if(obj.getClass() != Consignment.class) return false;
		Consignment other = (Consignment)obj;
		return this.hashCode() == other.hashCode();
	}
}
