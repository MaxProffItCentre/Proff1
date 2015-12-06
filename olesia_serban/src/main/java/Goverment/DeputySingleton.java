package Goverment;

public class DeputySingleton implements Deputy {
	private String name;
	private double tarif;
	private boolean isReg;
	private double summaGrab;
	private static DeputySingleton uniqueInstance;

	private DeputySingleton() {

	}

	public static DeputySingleton getInstance() {
		if (uniqueInstance == null) {
			synchronized (DeputySingleton.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new DeputySingleton();
				}
			}
		}
		return uniqueInstance;
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
