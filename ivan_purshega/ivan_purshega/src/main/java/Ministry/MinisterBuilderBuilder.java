package Ministry;

import action06.BuilderCar;
import action06.Car;

public class MinisterBuilderBuilder {
	private String name;
	private int tarif;
	
	public MinisterBuilder newMinisterBuilder() throws InterruptedException{
		return new MinisterBuilder(this);
	}
	
	public int getTarif(){
		return tarif;
	}
	
	public String getName(){
		return name;
	}
	
	public MinisterBuilderBuilder setName(String name){
		this.name=name;
		return this;
	}
	
	public MinisterBuilderBuilder setTarif(int tarif){
		this.tarif=tarif;
		return this;
	}
}
