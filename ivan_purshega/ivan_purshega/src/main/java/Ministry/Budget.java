package Ministry;

public class Budget {
		private static Budget bablo;
		int budget;
		
		private Budget(int cash){
			budget=cash;
		}
		
		public static Budget CreatBudget(int cash){
			if(bablo==null){
				bablo=new Budget(cash);
			} return bablo;
		}

		public int getBudget() {
			return budget;
		}

		public void setBudget(int budget) {
			this.budget = budget;
		}
	}
