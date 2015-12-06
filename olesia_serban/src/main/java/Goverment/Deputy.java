package Goverment;

public abstract class Deputy {
	protected String name;
	protected double tarif;
	protected boolean isReg;
	protected double summaGrab;
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
	@Override
	public String toString() {
		
		return name;
	}
}
