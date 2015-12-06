package Goverment;

import java.util.ArrayList;

public class MinisterSingleton implements Minister {
	
	private String name;
	private double tarif = 5000;
	private ArrayList<Deputy> listOfAsistents = new ArrayList<Deputy>();
	private double summaGrab;
	private static MinisterSingleton uniqueInstance;

	private MinisterSingleton(String name) {
		this.name = name;
	}

	public static MinisterSingleton getInstance(String name) {
		if (uniqueInstance == null) {
			uniqueInstance = new MinisterSingleton(name);
		}
		return uniqueInstance;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Deputy> getListOfAsistents() {
		return listOfAsistents;
	}

	public void newAssistant(Deputy dep, String numberOfAsist) {

		dep.setName(name + " " + numberOfAsist);
		listOfAsistents.add(dep);
		dep.registrate(true);
		dep.setTarif(tarif/2);
	}

	public void grab() {
		summaGrab += tarif;
		Budget.setMoney(Budget.getMoney() - tarif);

	}

	public double showMoney() {

		return summaGrab;
	}

	

	public double getTarif() {
		return tarif;
	}

}
