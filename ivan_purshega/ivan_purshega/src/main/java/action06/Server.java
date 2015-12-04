package action06;

public class Server {
	 private static Server server;
	 public int test = 0;
	 private Server(int test){
	  this.test = test;
	 }
	 
	 private Server(){
	  
	 }
	 
	 public static Server getServer(int test){
	  if(server == null){
	   server = new Server(test);
	  }
	  return server;
	 }
	 
	 public static void main(String[] args) {
	  Server serv = Server.getServer(1);
	  Server serv1 = Server.getServer(2);
	  
	  System.out.println(serv.test + " - " + serv1.test);
	 }
	 
	}
