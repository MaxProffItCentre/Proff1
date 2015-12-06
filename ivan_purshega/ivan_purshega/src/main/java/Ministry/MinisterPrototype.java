package Ministry;

import java.util.ArrayList;

public class MinisterPrototype implements IMinister{
	
	private String name;
	private int tarif;
	ArrayList<Assistants> assistentu=new ArrayList<Assistants>();
	private int summaGrab;
	
	public void setAssistants(){
		assistentu=null;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setTarif(int tarif){
		this.tarif=tarif;
	}

	@Override
	public Assistants newAssistant() throws InterruptedException {
		int type=(int)(1+3*Math.random());
		if (type==1)
		assistentu.add(DeputySingleTon.addDeputySingleTon(this.name+assistentu.size(),this.tarif/2,this));
		else if (type==2)assistentu.add(new DeputyBuilderBuilder().setNameMinister(this.name+assistentu.size()).setTarif(this.tarif/2).newDeputyBuilder(this));
		else assistentu.add(new DeputyPrototype(this.name+assistentu.size(),this.tarif/2,this));
		return assistentu.get(0) ;
	}

	@Override
	public int Grub() {	
		return summaGrab;
	}

	@Override
	public void setGrub(int k) {
		summaGrab+=k+tarif;
	}

	@Override
	public ArrayList<Assistants> getAssistentu() {
		return assistentu;
	}

	@Override
	public int getTarif() {
		return tarif;
	}

	@Override
	public MinisterPrototype clone() {
		return null;
	}

	public String getName() {
		
		return name;
	}

}
