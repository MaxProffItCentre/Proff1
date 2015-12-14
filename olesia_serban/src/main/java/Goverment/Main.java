package Goverment;

public class Main {
	public static void main(String[] args) {
		Minister min = MinisterSingleton.getInstance("One of A kind Minister");

		for (int i = 1; i <= 10; i++) {
			min.newAssistant(DeputySingleton.getInstance(), "00Unique");
			min.grab();
		}
		System.out.println(min);
		System.out.println(min.showMoney() + " : " + Budget.getMoney());
		
		Minister min2 = new BuilderMin().setName("Minister Builder").build();
		for (int i = 1; i <= 10; i++) {
			min2.newAssistant(new BuilderDep().build(), "00" + i);
			min2.grab();
		}
		System.out.println(min2);
		System.out.println(min2.showMoney() + " : " + Budget.getMoney());

	}
}
