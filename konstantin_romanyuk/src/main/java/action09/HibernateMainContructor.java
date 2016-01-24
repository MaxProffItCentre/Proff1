package action09;

import java.util.List;

import dao.ContructorDaoImpl;
import dao.ProductDaoImpl;
import data.Contructor;
import data.Product;
import util.HibernateUtil;

public class HibernateMainContructor {
	public static void main(String[] args) {
	ContructorDaoImpl ContructorImpl = new ContructorDaoImpl();
	/*Contructor[] arr = new Contructor[]{
			new Contructor("First"),
			new Contructor("Second"),
			new Contructor("Third"),			
			};
	for(Contructor contructor:arr){
		ContructorImpl.create(contructor);
	}*/
	
	//List<Contructor> contructors = ContructorImpl.findContructorsByBeginStringHQL("Fi");
	List<Contructor> contructors=ContructorImpl.findAll();
	contructors.forEach(contructor->System.out.println(contructor.getName()+"  "+ contructor.getOrders().toString()));
	/*Contructor contructor=(Contructor) ContructorImpl.read((long) 5);
	ContructorImpl.delete(contructor);
	List<Contructor> contructors = ContructorImpl.findAll();
	contructors.forEach(contructor1->System.out.println(contructor1.getName()));*/
	HibernateUtil.getSessionFactory().close();
}

}
