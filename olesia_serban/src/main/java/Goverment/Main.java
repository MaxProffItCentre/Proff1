package Goverment;

public class Main {
	public static void main(String[] args) {
		Minister min = MinisterSingleton.getInstance("One of A kind Minister");
		
		
		for (int i = 1; i <= 10; i++) {
			min.newAssistant(DeputySingleton.getInstance(), "00"+i);
			min.grab();
		}
		System.out.println(min);
		System.out.println(min.showMoney()+" : "+ Budget.getMoney());
	
	}
}
