package action05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
<<<<<<< HEAD
	Íàïèñàòü ìåòîä ïðèíèìàþùèé ëþáîé îáúåêò.
Ìåòîä âîçâðàùàåò âñå êëàññû â èåðàðõèþ êîòîðûõ âõîäèò äàííûé îáúåêò. 
=======
 	ÐÐ°Ð¿Ð¸ÑÐ°Ñ‚ÑŒ Ð¼ÐµÑ‚Ð¾Ð´ Ð¿Ñ€Ð¸Ð½Ð¸Ð¼Ð°ÑŽÑ‰Ð¸Ð¹ Ð»ÑŽÐ±Ð¾Ð¹ Ð¾Ð±ÑŠÐµÐºÑ‚.
ÐœÐµÑ‚Ð¾Ð´ Ð²Ð¾Ð·Ð²Ñ€Ð°Ñ‰Ð°ÐµÑ‚ Ð²ÑÐµ ÐºÐ»Ð°ÑÑÑ‹ Ð² Ð¸ÐµÑ€Ð°Ñ€Ñ…Ð¸ÑŽ ÐºÐ¾Ñ‚Ð¾Ñ€Ñ‹Ñ… Ð²Ñ…Ð¾Ð´Ð¸Ñ‚ Ð´Ð°Ð½Ð½Ñ‹Ð¹ Ð¾Ð±ÑŠÐµÐºÑ‚. 
>>>>>>> branch 'master' of https://github.com/MaxProffItCentre/Proff1.git
*/
public class ReflectionTask1Example {
	public static void main(String[] args) {
		Class[] classes = getAllClasses(new ArrayList());
		System.out.println(Arrays.toString(classes));
		
		
		
	}
	public static Class[] getAllClasses(Object obj){
		List<Class> classes = new ArrayList<Class>();
		classes.add(obj.getClass());
		for(int i = 0; i<classes.size();i++){
			Class superCl = classes.get(i).getSuperclass();
			if(superCl!=null)classes.add(superCl);
		}	
		return classes.toArray(new Class[0]);
	}
}
