package action06;

public class ServerMain {
	public static void main(String[] args) {
		Server obj1 = Server.getInstance();
		Server obj2 = Server.getInstance();
		System.out.println(obj1==obj2);
	}
	
}
