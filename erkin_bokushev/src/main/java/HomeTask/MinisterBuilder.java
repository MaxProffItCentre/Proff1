package HomeTask;

import java.util.ArrayList;

import HomeTask.DeputyBuilder.BuilderDeputyBuilder;

public class MinisterBuilder implements Minister {
	private String name;
	private int tarif;
	private int summaGrub;
	private ArrayList<DeputyBuilder> assistantsBuil = new ArrayList<DeputyBuilder>();
	
	@Override
	public Deputy newAssistant() throws InterruptedException {
		// TODO Auto-generated method stub
		DeputyBuilder dep = new BuilderDeputyBuilder().setMinister(this).setName(this.name).setTarif(this.tarif).build();
		assistantsBuil.add(dep);
		summaGrub +=dep.summaGrub/2;
		Budget.setSummaBudget(Budget.getSummaBudget()-summaGrub);
		return dep;
	}

	@Override
	public int grab() {
		// TODO Auto-generated method stub
		if (assistantsBuil.size() == 0) summaGrub = tarif;
		if (assistantsBuil.size() != 0) {
			summaGrub = tarif;
			for (DeputyBuilder dep: assistantsBuil) {
				summaGrub += dep.summaGrub/2;
			}
		}
		return summaGrub;
	}
	//===============Конструктор========================================
	public MinisterBuilder (BuilderMinisterBuilder builder) {
		this.setName(builder.getName());
		this.setTarif(builder.getTarif());
		summaGrub = tarif;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getTarif() {
		return tarif;
	}
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}

	public int getSummaGrub() {
		return summaGrub;
	}

	public void setSummaGrub(int summaGrub) {
		this.summaGrub = summaGrub;
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

	//	===============BuilderMinisterBuilder========================================
	public static class BuilderMinisterBuilder implements Minister{
		private String name;
		private int tarif;
		private int summaGrub;
		
		public BuilderMinisterBuilder () {}

		public String getName() {
			return name;
		}

		public BuilderMinisterBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public int getTarif() {
			return tarif;
		}

		public BuilderMinisterBuilder setTarif(int tarif) {
			if (tarif == 0) this.tarif = 1000;
			if (tarif != 0) this.tarif = tarif;
			return this;
		}

		public int getSummaGrub() {
			return summaGrub;
		}

		public BuilderMinisterBuilder setSummaGrub(int summaGrub) {
			this.summaGrub = summaGrub;
			return this;
		}
		
		public MinisterBuilder build () {
			return new MinisterBuilder (this);
		}

		@Override
		public Deputy newAssistant() throws InterruptedException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int grab() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String name() {
			// TODO Auto-generated method stub
			return name;
		}
	}
//	=========================================================================================


}
