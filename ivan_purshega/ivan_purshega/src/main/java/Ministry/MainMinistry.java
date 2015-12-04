package Ministry;


import java.util.ArrayList;
import java.util.List;

import action06.BuilderCar;
import action06.Car;

public class MainMinistry {
	public static void main(String[] args) {
		Budget budget=Budget.CreatBudget(1000000);
		
	
	IMinister iMinister1 = MinisterSingleTon.addMinistr("Azarov", 5000);
	IMinister iMinister2 = new MinisterBuilderBuilder().setName("Yanukovich").setTarif(6000).newMinisterBuilder();
	
//	Ministry iMinister3 = new MinisterPrototype();
	ArrayList <Assistants> list = new ArrayList <Assistants>();
	list.add(iMinister1.newAssistant());
	
	while(budget.getBudget()>0){
		list.add(iMinister1.newAssistant());
		System.out.println(iMinister1.Grub());
		System.out.println(budget.getBudget());
	}
	
	
	
//	System.out.println(iMinister1.Grub());
//	System.out.println(list.get(0).Grub());
//	list.add(iMinister1.newAssistant());
//	System.out.println(iMinister1.Grub());
//	System.out.println(list.get(1).Grub());
//	list.add(iMinister1.newAssistant());
//	System.out.println(iMinister1.Grub());
//	System.out.println(list.get(2).Grub());
//	for(int i=0; i<iMinister1.getAssistentu().size();i++){
//		System.out.println(iMinister1.getAssistentu().get(i).getClass().getName());
//	}
    
	
	}
}