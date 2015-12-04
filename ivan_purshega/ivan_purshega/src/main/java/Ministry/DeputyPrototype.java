package Ministry;

public class DeputyPrototype implements Assistants {
	
	private static DeputySingleTon dno;
	private String nameMinister;
	private int tarif;
	private int summaGrub;
	
	public DeputyPrototype(String string, int i, IMinister ministr) {
		 nameMinister=string;
		 tarif=i;
		 ministr.setGrub(tarif/2);
		 summaGrub=tarif/2;
		 Budget bablo=Budget.CreatBudget(0);
		 bablo.setBudget(bablo.getBudget()-tarif-ministr.getTarif());
		}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Grub() {
		// TODO Auto-generated method stub
		return 0;
	}

}



