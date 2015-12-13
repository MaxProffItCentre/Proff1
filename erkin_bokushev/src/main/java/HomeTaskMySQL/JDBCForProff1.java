package HomeTaskMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCForProff1 {
	private static String nameDriver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/proff1";
	private static String login = "root";
	private static String pass = "Root";
	
	public static void main(String[] args) {
		System.out.println(getRoles());
		System.out.println(getUsersOfRole("manager"));
		System.out.println(getOrders("user1"));

	}
	
	//Написать метод, который возвращает список всех ролей.
	public static ArrayList<Role> getRoles() {
		ArrayList<Role> roles = new ArrayList<Role>();
		
		try {
			Class.forName(nameDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String query = "SELECT roles.name FROM roles;";
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(url, login, pass);
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
			roles.add(new Role(rs.getString(1)));
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
		return roles;
	}
	
	//Написать метод, которому на вход дается строка с именем роли, метод должен вернуть список пользователей, это роли.
	public static ArrayList<User> getUsersOfRole (String role) {
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			Class.forName(nameDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String query = "SELECT distinct users.name FROM roles, users, roles_users where roles.id = roles_users.role_id and roles_users.user_id = users.id and roles.name like '"+ role +"';";
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(url, login, pass);
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
			users.add(new User(rs.getString(1)));
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
		return users;
	}
	
	/*Написать метод, которому на вход дается список строка с значением login-а, метод вовзращает список заказов, 
	 оформленных менеджером с указанным логином */
	public static ArrayList<Orders> getOrders (String login) {
		ArrayList<Orders> orders = new ArrayList<Orders>();
		
		try {
			Class.forName(nameDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String query = "SELECT orders.number FROM users, orders where orders.user_id = users.id and users.login like '"+ login + "';";
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(url, JDBCForProff1.login, pass);
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
			orders.add(new Orders(rs.getString(1)));
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
		return orders;	
	}
	
}
