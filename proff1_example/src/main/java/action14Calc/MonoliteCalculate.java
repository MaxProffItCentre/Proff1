package action14Calc;

public class MonoliteCalculate {
	public static void main(String[] args) {
		MonoliteCalculate calc = new MonoliteCalculate();
		String[] arr = new String[]{"10","20"};
		calc.execute(arr);
	}

	private void showResult(String result) {
		System.out.println(result);
	}

	private long operate(long op1, long op2) {
		return op1 + op2;
	}

	private String getOpsName() {
		return " plus ";
	}

	public void execute(String [] args) {
		long op1 = Long.parseLong(args[0]);
		long op2 = Long.parseLong(args[1]);
		showResult("The result of " + op1 + getOpsName() + op2 + " is " + operate(op1, op2) + "!");
	}
}
