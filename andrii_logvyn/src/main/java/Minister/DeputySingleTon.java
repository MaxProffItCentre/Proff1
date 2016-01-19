package Minister;

public class DeputySingleTon extends Deputy{
	private static DeputySingleTon deputy;
	public DeputySingleTon(String name){
		super();
		super.setName(name);
	}
	public static DeputySingleTon newDeputySingle(String name){
		if(deputy == null){
			deputy = new DeputySingleTon(name);
		}
		return deputy;
	}
	
	
}
