package HomeTask;

public class DeputyPrototype implements Deputy{
	public String name;
	public static int number;
	public int tarif;
	public  boolean isReg;
	public  int summaGrub;
	public Minister minister;
	
	public DeputyPrototype(MinisterPrototype minister) throws InterruptedException {
		// TODO Auto-generated constructor stub
		this.minister = minister;
		number++;
		this.name = minister.name() + number;
		if (isReg != true) {
			Thread.sleep(10000);
			isReg = true;
			tarif = minister.getTarif()/2;
			summaGrub = tarif/2;
			Budget.setSummaBudget(Budget.getSummaBudget()-summaGrub);
	}
	}
	
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int grab() {
		// TODO Auto-generated method stub
		return summaGrub;
	}

}
