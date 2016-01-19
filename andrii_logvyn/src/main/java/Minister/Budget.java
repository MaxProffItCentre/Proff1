package Minister;

public class Budget {
	private int budgetSum = 1500000;
	private static Budget budget;
	
	public static Budget newBudget(){
		if(budget == null){
			budget = new Budget();
		}
		return budget;
	}
	
	public int getBudget(){
		return budgetSum;
	}
	
	public boolean setBudget(int tarif){
		if(budgetSum - tarif > 0){
			budgetSum = budgetSum - tarif;
			return true;
		}else{
			return false;
		}
	}
}
