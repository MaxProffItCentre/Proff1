package Ministry;

import java.util.ArrayList;
import java.util.List;

public class DeputySingleTon implements Assistants {
	private static DeputySingleTon dno;
	private String nameMinister;
	private int tarif;
	private int summaGrub;
	
	private DeputySingleTon(String string, int i, IMinister ministr) {
		 nameMinister=string;
		 tarif=i;
		 ministr.setGrub(tarif/2);
		 summaGrub=tarif/2;
		 Budget bablo=Budget.CreatBudget(0);
		 bablo.setBudget(bablo.getBudget()-tarif-ministr.getTarif());
		}
		
	
	public static DeputySingleTon addDeputySingleTon(String string, int i, IMinister ministr) {
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
