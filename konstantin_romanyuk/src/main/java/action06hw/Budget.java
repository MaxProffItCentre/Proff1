package action06hw;

public class Budget {
static Budget budget=new Budget();
static int summBudget;
private Budget(){summBudget=1500000;}
public static Budget setBudget(){return budget; }
public static int getSumBudget(){return summBudget; }
}
