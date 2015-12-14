package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MainSQL {
	private static String nameDriver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/proff1";
	private static String login = "root";
	private static String pass = "root";
	private ArrayList<User> users=new ArrayList<>();
	private ArrayList<Role> roles=new ArrayList<>();
	private ArrayList<Roles_User> roles_users=new ArrayList<>();
	private ArrayList<Employee> employees =new ArrayList<>();
	private ArrayList<Orders> orders=new ArrayList<>();
	
	public MainSQL() {
		// TODO Auto-generated constructor stub
	}
	
	private ArrayList<Contructors> contructors=new ArrayList<>();

	public static void main(String[] args) {
		showRoles();
		
	}
	
	public static void showRoles(){
		try {
			Class.forName(nameDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String query = "select * from roles";
		String query2 = "select * from users";
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(url, login, pass);
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(query);
			ResultSet rs2 = statement.executeQuery(query2);
			while (rs2.next()) {
//				System.out.println(rs.getString(2));
				System.out.println(rs2.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connect != null)
				try {
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
		
}
