package Minister;

public class DeputyPrototype extends Deputy implements Cloneable {
	public DeputyPrototype(){
		
	}
	public DeputyPrototype(String name){
		super();
		super.setName(name);
	}
	
	@Override
	public DeputyPrototype clone() throws CloneNotSupportedException {
		return (DeputyPrototype) super.clone();
	}

}
