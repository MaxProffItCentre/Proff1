package Goverment;

import java.util.ArrayList;

public abstract class Minister {
	protected String name;
	protected double tarif = 5000;
	protected ArrayList<Deputy> listOfAsistents = new ArrayList<Deputy>();
	protected double summaGrab;
	
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
