package action04hw;

public class Calc {
	private int result;
	private int temp;
	private char operation='0'; // 0+-*/
	public String printResult(){
		return result+"";
	}
	public void inChar(char p){
		if(p=='='){
			if(operation=='+') result = temp + result;// !! последовательность операндов
			if(operation=='-') result = temp - result;
			if(operation=='*') result = temp * result;
			if(operation=='/') result = temp / result;
			operation='0';
			temp=0;
		} else if('0'<=p && p<='9'){
			if(operation!='0' && temp==0){
				temp = result;
				result = 0;
			}
				result = result*10 + p-'0';
		} else {
			operation = p;
		}
	}
	public static void main(String[] args) {
		Calc calc = new Calc();
		String str = "00*225=";
		char[] buttons = str.toCharArray();
		for(char p: buttons){
			calc.inChar(p);
		}	
		System.out.println("Result: "+calc.printResult());
	}
}
