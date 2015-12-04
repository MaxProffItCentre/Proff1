package Ministry;

import java.util.ArrayList;
import java.util.List;

public class MinisterBuilder implements IMinister{
	private String name;
	private int tarif;
	ArrayList<Assistants> assistentu=new ArrayList<Assistants>();
	private int summaGrab;
	
	public MinisterBuilder(MinisterBuilderBuilder minister){
		name=minister.getName();
		tarif=minister.getTarif();
	}
	

	@Override
	public Assistants newAssistant() {
		int type=(int)(1+3*Math.random());
		if (type==1)
		assistentu.add(DeputySingleTon.addDeputySingleTon(this.name+assistentu.size(),this.tarif/2,this));
		else if (type==2)assistentu.add(new DeputyBuilderBuilder().setNameMinister(this.name+assistentu.size()).setTarif(this.tarif/2).newDeputyBuilder(this));
		else assistentu.add(new DeputyPrototype(this.name+assistentu.size(),this.tarif/2,this));
		return assistentu.get(0) ;
	}

	@Override
	public int Grub() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setGrub(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Assistants> getAssistentu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTarif() {
		// TODO Auto-generated method stub
		return 0;
	}
}
