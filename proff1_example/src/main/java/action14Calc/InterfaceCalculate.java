package action14Calc;

public class InterfaceCalculate {
	private Operation ops = new OpAdd();
	private ResultWriter wtr = new ConsoleWriter();

	public static void main(String[] args) {
		InterfaceCalculate calc = new InterfaceCalculate();
		calc.execute(args);
	}

	public void execute(String [] args) {
		long op1 = Long.parseLong(args[0]);
		long op2 = Long.parseLong(args[1]);
		wtr.showResult("The result of " + op1 + ops.getOpsName() + op2 + " is " + ops.operate(op1, op2) + "!");
	}
}
interface Operation {
	long operate(long op1, long op2);
	String getOpsName();
}
interface ResultWriter{
	public void showResult(String str);
}


class OpAdd implements Operation {
	public String getOpsName() {
	return " plus ";
	}

	public long operate(long op1, long op2) {
		return op1 + op2;
	}
}
class OpMultiply implements Operation {
	public String getOpsName() {
		return " multiply ";
	}

	public long operate(long op1, long op2) {
		return op1 * op2;
	}
}
class ConsoleWriter implements ResultWriter{

	@Override
	public void showResult(String str) {
		System.out.println(str);		
	}
	
}