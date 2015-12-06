package Goverment;

import java.util.ArrayList;

public class MinisterBuilder implements Minister {
	private String name;
	private double tarif = 5000;
	private ArrayList<Deputy> listOfAsistents = new ArrayList<Deputy>();
	private double summaGrab;

	MinisterBuilder(BuilderMin builder) {
		this.name = builder.getName();
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
		dep.setTarif(tarif / 2);
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

class BuilderMin {
	private String name;

	public BuilderMin() {

	}

	public String getName() {

		return name;
	}

	public BuilderMin setName(String name) {
		this.name = name;
		return this;
	}

	public MinisterBuilder build() {
		return new MinisterBuilder(this);
	}

}
