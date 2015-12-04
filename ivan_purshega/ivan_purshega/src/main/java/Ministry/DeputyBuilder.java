package Ministry;

public class DeputyBuilder implements Assistants {
	
	private String nameMinister;
	private int tarif;
	private int summaGrub;
	
	public DeputyBuilder(DeputyBuilderBuilder builder, IMinister ministr) {
		 nameMinister=builder.getName();
		 tarif=builder.getTarif();
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
