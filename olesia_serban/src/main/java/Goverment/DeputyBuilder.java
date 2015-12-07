package Goverment;

public class DeputyBuilder extends Deputy {

	public DeputyBuilder(BuilderDep builder) {

	}

}

class BuilderDep {
	public BuilderDep() {
	}

	public DeputyBuilder build() {
		return new DeputyBuilder(this);
	}
}
