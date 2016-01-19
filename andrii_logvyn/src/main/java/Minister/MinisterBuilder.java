package Minister;

import java.util.ArrayList;

public class MinisterBuilder implements IMinister {
	private String name;
	private int tarif = 0;
	private int summaGrub = 0;
	private ArrayList<Deputy> deputyList = new ArrayList<Deputy>();

	private MinisterBuilder() {

	}

	private int setTariff() {

		return 1000 + (int) (Math.random() * (10000 - 1000));
	}

	@Override
	public void newAssistant() {
		// TODO Auto-generated method stub

	}

	@Override
	public void grab() {
		// TODO Auto-generated method stub

	}

	public MinisterBuild newMinister() {
		return new MinisterBuilder().new MinisterBuild();
	}

	class MinisterBuild {

		public MinisterBuild setName(String name) {
			MinisterBuilder.this.name = name;
			return this;
		}
		
		public MinisterBuild setTarif(){
			MinisterBuilder.this.tarif = MinisterBuilder.this.setTariff();
			return this;
		}
		
		public MinisterBuilder buid(){
			return MinisterBuilder.this;
		}

	}

}
