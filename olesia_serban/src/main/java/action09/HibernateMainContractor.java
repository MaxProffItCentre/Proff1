package action09;

import dao.ContractorDao;
import dao.ContractorDaoImpl;
//import data.Contractor;
import util.HibernateUtil;

public class HibernateMainContractor {
	public static void main(String[] args) {
		ContractorDao dao = new ContractorDaoImpl();
		//Contractor cont = new Contractor("Contaractor Is Here");
		//dao.create(cont);
		//Contractor cont=dao.read(4L);
		//cont.setName("Contractor My new Name");
		//dao.update(cont);
		//dao.delete(cont);
		
		System.out.println("**********************");
		System.out.println(dao.findAll());
		System.out.println("******************");
		System.out.println(dao.findContractorsByBeginString("Ф"));
		HibernateUtil.getSessionFactory().close();
		
	}
}
