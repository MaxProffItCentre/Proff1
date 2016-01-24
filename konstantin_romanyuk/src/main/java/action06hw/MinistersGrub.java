package action06hw;

import java.util.ArrayList;
import java.util.List;

/*Задача про министров.
Ministers and Assistants.
Есть несколько объектов министров, которые создают заместитетей-помошников.
У министров есть атрибуты: name, tarif(от 1000 до 10000), список помошников, summaGrub.  
У помощников есть атрибуты: nameMinister+number, tarif(половина от депутата), isReg , summaGrub.
Помощник половину честно заработанного отдает своему боссу.
Министры: Одиночка, Строитель, Прототип. 
IMinister{
 newAssistant();(если регистрируется новый помощник, то это занимает 10 секунд на регистрацию)
 grab();
}
Министр работает так: newAssistant(), grab(),newAssistant()... - не одновременно.

Есть класс Budget с полем budget. Объект этого класса должен быть в единственном экземпляре.
В этом классе единственное поле summaBudget=1,5 млн грн.
Помощники и министры
MinisterSingleTon, MinisterBuilder, MinisterPrototype
DeputySingleTon, DeputyBuilder, DeputyPrototype
Определить кто сколько заработал из Министров.
public class MinistersGrub {

}*/
public class MinistersGrub{
		
	
	public static void main(String[] args) {
		Budget.setBudget();
		System.out.println(Budget.getSumBudget());
		GrubMinSingle gr1=new GrubMinSingle();
		Thread th1=new Thread(gr1);
		GrubMinBuilder gr2=new GrubMinBuilder();
		Thread th2=new Thread(gr2);
		th1.setPriority(9);
		th2.setPriority(1);
		
		th1.start();
		th2.start();
			}
	
	public static class GrubMinSingle implements Runnable{

		public void run() {
			MinisterSingleton min1=new MinisterSingleton("Single",1000);	
			Budget.setBudget();
			
			while (Budget.summBudget>0){
				DeputySingleton deputy=min1.newDeputy();
				deputy.register();
				min1.grub();
				Budget.summBudget=Budget.summBudget-min1.tarif-deputy.tarif;
			}System.out.println(min1.summGrub);
		}
		
	}
	public interface Minister{
		
		public Deputy newDeputy();
		
		
	}
    static class MinisterSingleton implements Minister{
       private String name;
       private int tarif;
       private DeputySingleton deputy=null;
       private int num=0;
       private int summGrub;
      
		public MinisterSingleton(String name, int tarif){
			this.name=name;
			this.tarif=tarif;
		}
       public DeputySingleton newDeputy() {
			if (deputy==null) {num++; deputy=new DeputySingleton(this.name,this.tarif/2, this.num);}
			return deputy;
		}
	
	public void grub() {
		int payment = tarif+deputy.tarif/2;
		summGrub=summGrub+payment;	
		
	}}
   static class DeputySingleton implements Deputy{
			private String mName;
			private int tarif;
	      	private boolean isReg=false;
	        private int summGrub;
	        private int number;
	        public DeputySingleton(String mName, int tarif, int number){
	        	this.mName=mName;
	        	this.tarif=tarif;
	        	this.number=number;
	        }
	        public int getTarif(){
	        	return tarif;
	        }
		public boolean register(){
			if(isReg=false)
				try {
					this.wait(100); isReg=true;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return true;}
		}
  static  class MinisterBuilder implements Minister{
    	private String name;
        private int tarif;
        private ArrayList<DeputyBuilder> list=new ArrayList<DeputyBuilder>();
        private int summGrub;
        private int num=0;
        
        public MinisterBuilder(String name, int tarif){
			this.name=name;
			this.tarif=tarif;
		}
		public DeputyBuilder newDeputy() {
			num++; 
			DeputyBuilder deputy=new DeputyBuilder(this);
			list.add(deputy);
			return deputy;
			}
		public void grub() {int deputyTarif=0;
			for (DeputyBuilder db:list) 
			deputyTarif=deputyTarif+db.tarif;
			int payment = tarif+deputyTarif/2;
			summGrub=summGrub+payment;	
			
		}	
  }

	static class DeputyBuilder implements Deputy{
		private String mName;
		private int tarif;
        private boolean isReg=false;
        private int summGrub;
        private int number;
        
        public DeputyBuilder(MinisterBuilder minister){
        	this.mName=minister.name;
        	this.tarif=minister.tarif/2;
        	this.number=minister.num;
	}
        public boolean register(){
		if(isReg=false)
			try {
				this.wait(100); isReg=true;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	return true;}}
	
    public static class GrubMinBuilder implements Runnable{

		public void run() {
			MinisterBuilder min2=new MinisterBuilder("Builder",10000);	
			Budget.setBudget();
			while (Budget.summBudget>0){
				
				DeputyBuilder deputy=min2.newDeputy();
				deputy.register();
				min2.grub();
				int deputyTarif=0;
				for (DeputyBuilder db:min2.list) 
				deputyTarif=deputyTarif+db.tarif;
				Budget.summBudget=Budget.summBudget-min2.tarif-deputyTarif;
			}
			System.out.println(min2.summGrub);
		}
		
	}
   static class MinisterPrototype implements Minister{
    	private String name;
        private int tarif;
        private List<Deputy> list;
        private int summGrub;
        public MinisterPrototype(String name, int tarif){
			this.name=name;
			this.tarif=tarif;
		}
		public Deputy newDeputy() {
			
			return null;
		}}
    
	public interface Deputy{
		}
		
		
		class DeputyPrototype implements Deputy{
			private String name;
			private int tarif;
	        private boolean isReg=false;
	        private int summGrub;
		}
	
}
