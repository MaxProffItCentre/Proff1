package Goverment;



public class MinisterBuilder extends Minister {
	

	MinisterBuilder(BuilderMin builder) {
		this.name = builder.getName();
	}

	
}

class BuilderMin {
	private String name;

	public BuilderMin() {

	}

	public String getName() {

		return name;
	}

	public BuilderMin setName(String name) {
		this.name = name;
		return this;
	}

	public MinisterBuilder build() {
		return new MinisterBuilder(this);
	}

}
