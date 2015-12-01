package action05;

public class Proc extends AbstractProc {
	
	
	@Override
	 public void inputChar(char c) {
	  if(c!='+' && c!='-' && c!='/' && c!='*' && c!='=' && c!='C'){

		  String str=Integer.toString(getResult())+c;
		  Integer intik=new Integer(str);   
	  setResult(intik);

		  	
		  
	  } else if (c=='='){
		  if(getOperation()=='+'){
		  setResult(getTemp()+getResult());}
		  else if(getOperation()=='-'){
			  setResult(getTemp()-getResult());}
		  else if(getOperation()=='/'){
			  setResult(getTemp()/getResult());}
		  else if(getOperation()=='*'){
			  setResult(getTemp()*getResult());}
		  
	  } else if(c=='+' || c=='-' || c=='/' || c=='*') { 
		 
		  setOperation(c);
		  setTemp(getResult());
		  setResult(0);
	  }
	 
	
	}	 
	
	
}