package Ministry;


import java.util.ArrayList;
import java.util.List;

import action06.BuilderCar;
import action06.Car;

public class MainMinistry {
	public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
		Budget budget=Budget.CreatBudget(1000000);
		
	
	IMinister iMinister1 = MinisterSingleTon.addMinistr("Azarov", (int)(5000+10000*Math.random()));
	IMinister iMinister2 = new MinisterBuilderBuilder().setName("Yanukovich").setTarif((int)(5000+10000*Math.random())).newMinisterBuilder();
	MinisterPrototype iMinister3= (MinisterPrototype) iMinister2.clone();
	iMinister3.setName("Poroshenko");
	iMinister3.setTarif((int)(5000+10000*Math.random()));
	ArrayList <Assistants> list = new ArrayList <Assistants>();
	
	while(budget.getBudget()>0){
		int numberOfMinister=(int)(1+3*Math.random());
		if (numberOfMinister==1)list.add(iMinister1.newAssistant());
		else if (numberOfMinister==2)list.add(iMinister2.newAssistant());
		else list.add(iMinister3.newAssistant());
//		System.out.println("Buget =" + budget.getBudget());
	}
	System.out.println(((MinisterSingleTon) iMinister1).getName()+" Spi...il!! "+iMinister1.Grub());
	System.out.println(((MinisterBuilder) iMinister2).getName()+" Spi...il!! "+iMinister2.Grub());
	System.out.println(((MinisterPrototype) iMinister3).getName()+" Spi...il!! "+iMinister3.Grub());
	
	
	}
}