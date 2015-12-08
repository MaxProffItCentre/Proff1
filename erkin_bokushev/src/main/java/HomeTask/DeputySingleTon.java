package HomeTask;

public class DeputySingleTon extends Thread implements Deputy {
	public String name;
	public static int number;
	public int tarif;
	public  boolean isReg;
	public  int summaGrub;
	public Minister minister;
	
	public DeputySingleTon (MinisterSingleTon minister) throws InterruptedException {
		number++;
		name = minister.name() + number;
		if (isReg != true) {
			Thread.sleep(10000);
			isReg = true;
			tarif = minister.getTarif()/2;
			summaGrub = tarif/2;
			Budget.setSummaBudget(Budget.getSummaBudget()-summaGrub);
		}
		
	}

	@Override
	public int grab() {
		// TODO Auto-generated method stub
		return summaGrub;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}


}
