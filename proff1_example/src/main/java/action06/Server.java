package action06;

public class Server {
	private static Server server = new Server();
	private Server(){		
	}
	public static Server getInstance(){
		return server;
	}
}
