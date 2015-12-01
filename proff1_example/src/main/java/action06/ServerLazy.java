package action06;

public class ServerLazy {
	private static ServerLazy server = null;
	private ServerLazy(){		
	}
	public synchronized static ServerLazy getInstance(){
		if(server==null) server = new ServerLazy(); 
		return server;
	}
}
