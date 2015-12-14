package action06;
//Singleton - создать класс Server и обеспечить наличие только одного экземпляра. 

public class Server {
	private Server () {};
	
	private static Server server = new Server();
	
	public static Server getServer () {
		return server;
	}
	
}
