package action06;

public class BuildeCar {
	private int number;
	private String color;
	
	private BuildeCar(int number, String color) {

	}
	private BuildeCar() {

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Car [number=" + number + ", color=" + color + "]";
	}
	public Builder newBuilder() {
		return new BuildeCar().new Builder();
	}

	public class Builder {
		
		private Builder() {
			// private constructor
		}

		public Builder setColor1(String color) {
			BuildeCar.this.color = color;

			return this;
		}

		public Builder setNumber(int number) {
			BuildeCar.this.number = number;

			return this;
		}

		public BuildeCar build() {
			return BuildeCar.this;
		}
		
		
	}

	public static void main(String[] args) {
		BuildeCar car = new BuildeCar().newBuilder().setColor1("red").setNumber(111123).build();
		System.out.println(car.toString());
		

	}

}
