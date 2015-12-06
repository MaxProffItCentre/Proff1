package Goverment;

public class MinisterSingleton extends Minister {
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

}
