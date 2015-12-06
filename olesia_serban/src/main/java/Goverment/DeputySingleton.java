package Goverment;

public class DeputySingleton extends Deputy {

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

}
