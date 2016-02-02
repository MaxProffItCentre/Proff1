package actionSchool;

import java.util.ArrayList;


public class School {
	ArrayList <Klass> klases = new ArrayList();
	private String number;
	
	public School(){	
	}
	
	public School(String number){
		this.number=number;
	}

	public ArrayList<Klass> getKlases() {
		return klases;
	}

	public void setKlases(ArrayList<Klass> klases) {
		this.klases = klases;
	}
	
	
	
}
