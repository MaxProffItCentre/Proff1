package Ministry;

import java.util.ArrayList;

public class MinisterSingleTon implements IMinister{
	private static MinisterSingleTon ministr; 
	private String name;
	private int tarif;
	ArrayList<Assistants> assistentu=new ArrayList<Assistants>();
	private int summaGrab;
	
	public ArrayList<Assistants> getAssistentu() {
		return assistentu;
	}

	public void setAssistentu(ArrayList<Assistants> assistentu) {
		this.assistentu = assistentu;
	}

	private MinisterSingleTon(String name, int tarif){
		this.name=name;
		this.tarif=tarif;
		
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
	
	public static MinisterSingleTon addMinistr(String name, int tarif){
		if(ministr==null){
			ministr=new MinisterSingleTon(name, tarif);
		} return ministr;
	}
	
	@Override
	public int Grub(){
		return summaGrab;
	}
	
	public String getName(){
		return name;
	}

	@Override
	public void setGrub(int k) {
		
		summaGrab+=k+tarif;
		
	}

	@Override
	public int getTarif() {
		
		return tarif;
	}

	
	
	
}