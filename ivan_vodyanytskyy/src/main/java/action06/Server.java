package action06;
//Singleton

public class Server {
	private static Server server;
	public int test = 1;
	
	public Server(int test) {
		super();
		this.test = test;
	}

	private Server(){
		
	}
	
	private static Server getServer(){
		if (server == null){
			server = new Server();
		}
		return server;
		
	}
	public static void main(String[] args) {
		Server obj1 = Server.getServer();
		Server obj2 = Server.getServer();
		System.out.println(obj1 == obj2);
	}

}
