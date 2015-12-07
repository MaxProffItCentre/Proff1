package Goverment;

public class Budget {
	private static double money = 1500000;
	private static Budget uniqueInstance = new Budget();

	private Budget() {

	}

	public static Budget getInstance() {
		return uniqueInstance;
	}

	public static double getMoney() {
		return money;
	}

	public static void setMoney(double money) {
		Budget.money = money;
	}
}
