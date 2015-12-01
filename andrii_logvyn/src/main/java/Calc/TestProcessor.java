package Calc;

public class TestProcessor extends AbstractProcessor {
	private String oper = "";
	private int tmpRes = 0;

	@Override
	public void inputChar(char c) {
		String inpChar = String.valueOf(c);
		if (inpChar.equals("C")) {
			setResult(0);
			oper = "";
			tmpRes = 0;
			setTemp(0);
		} else {
			if (!inpChar.equals("+") && !inpChar.equals("*")
					&& !inpChar.equals("-") && !inpChar.equals("=") && !inpChar.equals("/")) {
				if (oper.equals("")) {
					setResult(Integer.parseInt(String.valueOf(getResult())
							+ inpChar));
				} else {
					setTemp(Integer.parseInt(String.valueOf(getTemp())
							+ inpChar));
				}

			} else if (inpChar.equals("+") || inpChar.equals("-")
					|| inpChar.equals("*") || inpChar.equals("/")) {
				oper = inpChar;
			} else if (inpChar.equals("=")) {
				// tmpRes = getResult();
				Processing(oper);
				oper = inpChar;
			}
		}
	}

	private void Processing(String oper) {
		switch (oper) {
		case "+":
			setResult(getResult() + getTemp());
			break;
		case "-":
			setResult(getResult() - getTemp());
			break;
		case "*":
			setResult(getResult() * getTemp());
			break;
		case "/":
			setResult(getResult() / getTemp());
			break;
		}
	}

}
