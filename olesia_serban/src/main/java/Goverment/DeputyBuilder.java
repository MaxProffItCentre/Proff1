package Goverment;

public class DeputyBuilder implements Deputy {
	private String name;
	private double tarif;
	private boolean isReg;
	private double summaGrab;

	DeputyBuilder(BuilderDep builder) {

	}

	public void setName(String name) {
		this.name = name;

	}

	public void registrate(boolean reg) {
		isReg = reg;

	}

	public String getName() {
		return name;
	}

	public boolean isReg() {
		return isReg;
	}

	public double getSummaGrab() {
		return summaGrab;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;

	}

	public void grab() {
		if (isReg) {
			summaGrab += tarif;
			Budget.setMoney(Budget.getMoney() - tarif);
		} else {
			return;
		}

	}
}

class BuilderDep {
	public BuilderDep() {
	}

	public DeputyBuilder build() {
		return new DeputyBuilder(this);
	}
}
