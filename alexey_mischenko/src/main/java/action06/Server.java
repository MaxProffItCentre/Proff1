package action06;

public class Server {
	
	private static Server instance;
	
	private Server(){
		
	}

	public synchronized static Server getInctance() {
		if (instance==null) {
		instance = new Server();
		}
		return instance;
	}

	
	
	
	

}
