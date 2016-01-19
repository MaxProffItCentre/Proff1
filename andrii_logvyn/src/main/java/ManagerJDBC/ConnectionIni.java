package ManagerJDBC;

public abstract class ConnectionIni {
	private static final String nameDriver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/proff1";
	private static final  String login = "root";
	private static final String pass = "root";
	
	public static String getNamedriver() {
		return nameDriver;
	}
	public static String getUrl() {
		return url;
	}
	public static String getLogin() {
		return login;
	}
	public static String getPass() {
		return pass;
	}
}
