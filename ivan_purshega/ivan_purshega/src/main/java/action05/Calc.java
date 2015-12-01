package action05;

public class Calc {
	AbstractProc proc;
	
	
	
	public Calc(AbstractProc gg){
		proc=gg;
	}
	
	public void inSymv(char c){
		proc.inputChar(c);
		proc.printResult();
	}
	

}
