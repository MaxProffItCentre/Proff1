package action06;

public class Server {
	private static Server uniqueInstance;

	private Server() {

	}
//проблема с многопоточностью
	public static Server getInstance() {
		if (uniqueInstance == null) {
			synchronized (Server.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Server();
				}
			}
		}
		return uniqueInstance;
	}
}
