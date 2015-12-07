package HomeTask;

import java.util.ArrayList;

public class MinisterSingleTon implements Minister{
	private String name;
	private int tarif;
	private int summaGrub;
	private ArrayList<DeputySingleTon> assistantsSingl = new ArrayList<DeputySingleTon>();
	private static MinisterSingleTon primeMinister = new MinisterSingleTon();
	
	private MinisterSingleTon() {
		this.setName("primeMinister");
		tarif = (int)(Math.random()*10000);
		if (tarif == 0) tarif = 1000;
		summaGrub = tarif;
	}
	
	public static MinisterSingleTon getPrimeMinister () {
		return primeMinister;
	}
	
	@Override
	public Deputy newAssistant() throws InterruptedException {
		// TODO Auto-generated method stub
		DeputySingleTon dep = new DeputySingleTon(this);
		assistantsSingl.add(dep);
		summaGrub +=dep.summaGrub/2;
		Budget.setSummaBudget(Budget.getSummaBudget()-summaGrub);
		return dep;
	}
	@Override
	public int grab() {
		// TODO Auto-generated method stub
		if (assistantsSingl.size() == 0) summaGrub = tarif;
		if (assistantsSingl.size() != 0) {
			summaGrub = tarif;
			for (DeputySingleTon dep: assistantsSingl) {
				summaGrub += dep.tarif/2;
			}
		}
		return summaGrub;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSummaGrub() {
		return summaGrub;
	}
	public void setSummaGrub(int summaGrub) {
		this.summaGrub = summaGrub;
	}
	public int getTarif() {
		return tarif;
	}

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}
}
