package HomeTask;

import java.util.ArrayList;

public class MinisterPrototype implements Minister, Cloneable{
	private String name;
	private int tarif;
	private int summaGrub;
	private ArrayList<DeputyPrototype> assistantsProt = new ArrayList<DeputyPrototype>();
	
	public MinisterPrototype copy() throws CloneNotSupportedException {
		return (MinisterPrototype)super.clone();
	}
	

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Deputy newAssistant() throws InterruptedException {
		// TODO Auto-generated method stub
		DeputyPrototype dep  = new DeputyPrototype(this);
		assistantsProt.add(dep);
		summaGrub +=dep.summaGrub/2;
		Budget.setSummaBudget(Budget.getSummaBudget()-summaGrub);
		return dep;
	}

	@Override
	public int grab() {
		// TODO Auto-generated method stub
		return summaGrub;
	}
	
	public int getTarif() {
		return tarif;
	}
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
