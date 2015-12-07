package action06;

public class BuilderCar {
	private int number;
	private String color;
	//private Builder build;
	/*private BuilderCar(int number, String color){
		
	}*/
	
	private BuilderCar() {
		//build = new BuilderCar().new Builder();
	}

	public int getNumber() {
		return number;
	}
	
	public String getColor() {
		return color;
	}
	
	
	@Override
	public String toString(){
		return this.number +" = "+ this.color;
	}
	
	public Builder newBuild(){
		return new BuilderCar().new Builder();
	}
	
	public class Builder{
		
		private Builder(){
			
		}
		
		
		
		public Builder setNumber(int number){
			BuilderCar.this.number = number;
			return this;
		}
		
		public Builder setColor(String color){
			BuilderCar.this.color = color;
			return this;
		}
		
		public BuilderCar build(){
			return BuilderCar.this;
		}
		
		
	}
	
	public static void main(String[] args) {
		BuilderCar car = new BuilderCar().newBuild().setNumber(1111).setColor("red").build();
		System.out.println(car.toString());
	}
}


