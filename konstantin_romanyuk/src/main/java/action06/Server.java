package action06;

public class Server {
   static Server instance=null;
   
	private Server(){
		
	} // Private construktor;

public static Server RunServer(){
	if(instance==null) instance=new Server();
	else System.out.println("Already Exist");
	return instance;}

public static void main(String[] args) {
	RunServer();
	RunServer();
}}
