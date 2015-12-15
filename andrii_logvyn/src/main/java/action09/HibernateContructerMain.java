package action09;

import java.util.List;

import com.sun.javafx.scene.control.ControlAcceleratorSupport;

import dao.ContructorDaoImpl;
import data.Contructor;
import util.HibernateUtil;

public class HibernateContructerMain {

	public static void main(String[] args) {
		ContructorDaoImpl contructorDao = new ContructorDaoImpl();
		Contructor[] contrarr = {
				new Contructor("ООО Пупкино"),
				new Contructor("LTD Pego"),
				new Contructor("LTD Navy")
		};
		
		/*for(Contructor contr: contrarr){
			contructorDao.create(contr);
		}*/
		
		List<Contructor> contructors = contructorDao.findAll();
		contructors.forEach(contr->System.out.println(contr.getName()));
		contructors.get(0).setName("TTTTTT");
		contructorDao.updateSQL(contructors.get(0));
		/*contructorDao.update(contructors.get(0));
		contructorDao.delete(contructors.get(0));*/
		/*List<Contructor> listCon = contructorDao.findContructorByBeginString("L");
		listCon.forEach(contr->System.out.println(contr.getName()));*/
		HibernateUtil.getSessionFactory().close();
	}
	
}
