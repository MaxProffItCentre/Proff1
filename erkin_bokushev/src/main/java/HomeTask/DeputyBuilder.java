package HomeTask;

public class DeputyBuilder implements Deputy{
	public String name;
	public static int number;
	public int tarif;
	public  boolean isReg;
	public  int summaGrub;
	public Minister minister;

	public DeputyBuilder (BuilderDeputyBuilder builder) throws InterruptedException {
		this.name = builder.getName();
		this.tarif = builder.getTarif();
		this.minister = builder.getMinister();
		if (isReg != true) {
			Thread.sleep(10000);
			summaGrub = tarif/2;
			Budget.setSummaBudget(Budget.getSummaBudget()-summaGrub);
			isReg = true;
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
	
//	============BuilderDeputyBuilder============================================
	public static class BuilderDeputyBuilder implements Deputy{
		public String name;
		public static int number;
		public int tarif;
		public MinisterBuilder minister;
		
		public BuilderDeputyBuilder () {}
		
		public MinisterBuilder getMinister() {
			return minister;
		}
		public BuilderDeputyBuilder setMinister(MinisterBuilder minister) {
			this.minister = minister;
			return this;
		}
		public String getName() {
			return name;
		}
		public BuilderDeputyBuilder setName(String name) {
			number++;
			this.name = name + number;
			return this;
		}
		public int getTarif() {
			return tarif;
		}
		public BuilderDeputyBuilder setTarif(int tarif) {
			this.tarif = tarif/2;
			return this;
		}
		public DeputyBuilder build () throws InterruptedException {
			return new DeputyBuilder(this);
		}

		@Override
		public int grab() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String name() {
			// TODO Auto-generated method stub
			return null;
		}
	}
//	============================================================================================

	

	
}
