package Minister;

public class Minister {

}

/*
	Задача4. Задача про министров.
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
	 */