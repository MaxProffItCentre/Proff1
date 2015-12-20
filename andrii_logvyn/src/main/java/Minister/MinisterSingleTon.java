package Minister;

import java.util.ArrayList;

public class MinisterSingleTon implements IMinister{
	private MinisterSingleTon minister;
	private String name;
	private int tarif = 0;
	private int summaGrub = 0;
	private boolean isBudget = true;
	private ArrayList<Deputy> deputyList = new ArrayList<Deputy>();
	public  MinisterSingleTon(String name, Budget budget) {
		this.name = name;
		tarif = setTariff();
		isBudget = budget.setBudget(tarif);
	}
	
	public MinisterSingleTon newMinister(String name, Budget budget){
		if(minister == null){
			minister = new MinisterSingleTon(name, budget);
		}
		return minister;
	}
	
	private int setTariff(){
		
		return 1000 + (int)( Math.random()*(10000 - 1000));
	}
	
	@Override
	public void newAssistant() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void grab() {
		// TODO Auto-generated method stub
		
	}

}
