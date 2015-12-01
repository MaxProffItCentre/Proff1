package Calc;

public abstract class AbstractProcessor implements Processorable {
	private int result;
	private int temp;

	@Override
	public void printResult() {
		System.out.println("Result = " + result);
	}

	protected void setResult(int r) {
		result = r;
	}

	public int getResult() {
		return result;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	
}