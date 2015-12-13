package action06;

public class ServerLasy {

	private static ServerLasy server;

	private ServerLasy() {
	}

	private static ServerLasy getServer() {
		if (server == null) {
			server = new ServerLasy();
		}
		return server;
	}
}
