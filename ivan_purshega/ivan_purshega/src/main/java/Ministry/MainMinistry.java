package Ministry;

public class MainMinistry {
	FactoryMinistry iMinister1 = new MinisterSingleTon();
	FactoryMinistry iMinister2 = new MinisterBuilder();
	FactoryMinistry iMinister3 = new MinisterPrototype();
}
