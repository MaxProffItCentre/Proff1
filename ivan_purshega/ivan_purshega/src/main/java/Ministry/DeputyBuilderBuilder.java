package Ministry;

public class DeputyBuilderBuilder {
	private String nameMinister;
	private int tarif;
	
	public DeputyBuilder newDeputyBuilder(IMinister ministr){
		return new DeputyBuilder(this,ministr);
	}
	
	public DeputyBuilderBuilder setTarif(int tarif){
		this.tarif=tarif;
		return this;
	}
	
	public DeputyBuilderBuilder setNameMinister(String name){
		nameMinister=name;
		return this;
	}
	
	public String getName(){
		return nameMinister;
	}
	
	public int getTarif(){
		return tarif;
	}
	
	
}
