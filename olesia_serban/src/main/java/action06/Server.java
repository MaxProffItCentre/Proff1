package action06;

public class Server {
	private static Server instance = new Server();
	private Server(){
		
	}
	public static Server getInstance() {
	      
	      return instance;
	   }
}
