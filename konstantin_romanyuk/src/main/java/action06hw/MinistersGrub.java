package action06hw;

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
			}
	
	
	public interface Minister{
		
		public Deputy newDeputy();
		
		
	}
    class MinisterSingleton implements Minister{
       private String name;
       private int tarif;
       private List<Deputy> list;
       private int summGrub;
		public MinisterSingleton(String name, int tarif){
			this.name=name;
			this.tarif=tarif;
		}
       public Deputy newDeputy() {
			
			return null;
		}
	
	public void grub() {
		summGrub=summGrub+tarif;		
	}}
    class MinisterBuilder implements Minister{
    	private String name;
        private int tarif;
        private List<Deputy> list;
        private int summGrub;
        public MinisterBuilder(String name, int tarif){
			this.name=name;
			this.tarif=tarif;
		}
		public Deputy newDeputy() {
			
			return null;
		}}
    class MinisterPrototype implements Minister{
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
		class DeputySingleton implements Deputy{
			private String Mname;
			private int tarif;
	        private boolean isReg=false;
	        private int summGrub;
	        private DeputySingleton(String name){}
		}
		class DeputyBuilder implements Deputy{
			private String name;
			private int tarif;
	        private boolean isReg=false;
	        private int summGrub;
		}
		class DeputyPrototype implements Deputy{
			private String name;
			private int tarif;
	        private boolean isReg=false;
	        private int summGrub;
		}
	
	
}