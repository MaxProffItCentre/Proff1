package Calc;

public class Calc {
	private AbstractProcessor proc;

	public Calc(AbstractProcessor pr) {
		proc = pr;
	}

	public void inSymv(char c) {
		proc.inputChar(c);
		proc.printResult();
	}
}
