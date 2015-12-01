package action04;

public class MyCalc {

	private int a;
	private int b;
	private int result;
	private String action;

	private String exA = "";
	private String exB = "";
	boolean numberAcomplete;
	boolean numberBcomplete;
	boolean actionCompleate;

	public MyCalc() {
	}

	
	public void inChar(char c) {
		String stringForC = "" + c;
		if (!numberAcomplete && !numberBcomplete && !actionCompleate) {
			int forEx;

			if (Character.isDigit(c)) {
				forEx = Character.getNumericValue(c);
				exA += forEx;
				a = Integer.parseInt(exA);
			} else if (stringForC.equals("+") || stringForC.equals("-") || stringForC.equals("*")
					|| stringForC.equals("/")) {
				numberAcomplete = true;
				action = "" + c;
			}
		} else if (numberAcomplete && !numberBcomplete && !actionCompleate) {
			int forEx2;

			if (Character.isDigit(c)) {
				forEx2 = Character.getNumericValue(c);
				exB += forEx2;
				b = Integer.parseInt(exB);
			} else if (stringForC.equals("=")) {
				numberBcomplete = true;

				if (action.equals("+")) {
					result = a + b;
				} else if (action.equals("-")) {
					result = a - b;
				} else if (action.equals("*")) {
					result = a * b;
				} else if (action.equals("/")) {
					result = a / b;
				}
				actionCompleate = true;
			}
		}

	}

	public String printResult() {
		if (!numberAcomplete && !numberBcomplete) {
			return "" + a;
		} else if (numberAcomplete && !numberBcomplete) {
			return "" + b;
		} else if (actionCompleate) {
			return "" + result;
		} else {
			return "0";
		}

	}

	public static void main(String[] args) {
		MyCalc calc = new MyCalc();

		System.out.println("res: " + calc.printResult());
		calc.inChar('0');
		calc.inChar('8');
		System.out.println("res: " + calc.printResult());
		calc.inChar('+');
		calc.inChar('9');
		calc.inChar('8');
		System.out.println("res: " + calc.printResult());
		calc.inChar('=');
		System.out.println("res: " + calc.printResult());

	}

}
