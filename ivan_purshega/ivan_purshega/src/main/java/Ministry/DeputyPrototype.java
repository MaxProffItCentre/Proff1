package Ministry;

public class DeputyPrototype implements Assistants {
	
	
	private String nameMinister;
	private int tarif;
	private int summaGrub;
	boolean isReg=false;
	
	public DeputyPrototype(String string, int i, IMinister ministr) throws InterruptedException {
		 if (isReg==false){
			 	isReg=true;
				System.out.println("Registration(Prototype) ......");
				Thread.sleep(10000);
				System.out.println("Registration compleat! Bablo spi...no!!!");
			}
		 nameMinister=string;
		 tarif=i;
		 ministr.setGrub(tarif/2);
		 summaGrub=tarif/2;
		 Budget bablo=Budget.CreatBudget(0);
		 bablo.setBudget(bablo.getBudget()-tarif-ministr.getTarif());
		}

	@Override
	public String getName() {
		return nameMinister;
	}

	@Override
	public int Grub() {
		return summaGrub;
	}
}