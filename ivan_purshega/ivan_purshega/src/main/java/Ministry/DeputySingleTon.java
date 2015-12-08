package Ministry;

import java.util.ArrayList;
import java.util.List;

public class DeputySingleTon implements Assistants {
	private static DeputySingleTon dno;
	private String nameMinister;
	private int tarif;
	private int summaGrub;
	static boolean isReg=false;
	
	private DeputySingleTon(String string, int i, IMinister ministr) throws InterruptedException {
		if (isReg==false){
		 	isReg=true;
			System.out.println("Registration(Single) ......");
			Thread.sleep(10000);
			System.out.println("Registration compleat! Bablo spi...no!!!");
		}
		 nameMinister=string;
		 tarif=i;
		 ministr.setGrub(tarif/2);
		 summaGrub=tarif/2;
		 Budget bablo=Budget.CreatBudget(0);
		 bablo.setBudget(bablo.getBudget()-tarif-ministr.getTarif());
		}
		
	
	public static DeputySingleTon addDeputySingleTon(String string, int i, IMinister ministr) throws InterruptedException {
	 if (dno==null){
		  dno=new DeputySingleTon(string,i,ministr);
		  
	 } return dno;
	}
	
	public void setSummaGrab(){
		summaGrub+=tarif;
	}
	
	public int Grub(){
		return summaGrub;
	}

	

	@Override
	public String getName() {
		return nameMinister;
		
	}

}
