package Minister;

public class testDeputy {

	public static void main(String[] args) {
		//Deputy dep1 = new DeputyBuilder().newBuilder().setName("test1").setRegister(true).build();
		//dep1.setSummaGrab(10);
		//System.out.println(dep1.getName());
		/*DeputyPrototype proto = new DeputyPrototype("proto");
		DeputyPrototype clone = null;
		try {
			clone = proto.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(proto.getName() + " - " + clone.getName());*/
		
		int tar = 1000 + (int)( Math.random()*(10000 - 1000));
		System.out.println(tar);
	}

}
