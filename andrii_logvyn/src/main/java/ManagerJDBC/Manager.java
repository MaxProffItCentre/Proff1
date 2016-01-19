package ManagerJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Manager extends ConnectionIni {

	private static ArrayList<Orders> orders;
	private static ArrayList<Role> roles;
	private static ArrayList<User> users;

	public static void main(String[] args) {
		
		roles = getAllRoles();
		for (Role role : roles) {
			System.out.println(role.getName() + " - " + role.getComment());
		}
		System.out.println();
		
		users = returnUsersByRoles("manager");
		for (User usr : users) {
			System.out.println(usr.getName() + " - " + usr.getEmployee());
		}
		System.out.println();
		
		orders = getOrdersByLogin("user2");
		for (Orders order : orders) {
			System.out.println(order.getNumber() + " - " + order.getUser());
		}
	}

	public static ArrayList<Role> getAllRoles() {
		ArrayList<Role> role = new ArrayList<Role>();
		Connection connect = null;
		try {
			Class.forName(getNamedriver());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String query = "select * from roles";
			connect = DriverManager.getConnection(getUrl(), getLogin(), getPass());
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result != null) {
				while (result.next()) {
					// String s = (result.getObject("comment") ==
					// null)?"":result.getString("comment");
					role.add(new Role(result.getInt("id"), result.getString("name"),
							(result.getObject("comment") == null) ? "" : result.getString("comment")));
				}
			} else {
				System.out.println("Table roles is empty!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connect != null) {
				try {
					connect.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return role;
	}

	public static ArrayList<User> returnUsersByRoles(String role) {

		ArrayList<User> users = new ArrayList<User>();
		Employee tmp = null;

		if (role != null && role != "") {

			String query = "select users.name, users.login, users.pass, users.employee_id from roles_users, users, roles "
					+ "where roles_users.user_id = users.id and roles_users.role_id = roles.id and" + " roles.name = '"
					+ role + "'";
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(getUrl(), getLogin(), getPass());
				Statement state = conn.createStatement();
				ResultSet result = state.executeQuery(query);

				if (result != null) {
					while (result.next()) {
						if (result.getInt("employee_id") != 0) {
							Statement state_e = conn.createStatement();
							ResultSet result_e = state_e
									.executeQuery("select * from employees where id = " + result.getInt("employee_id"));

							if (result_e != null) {
								result_e.next();
								tmp = new Employee(result_e.getString("name"), result_e.getInt("salary"));
							}
							// users.add(new User(result.getString("name"),
							// result.getString("login"),
							// result.getString("pass"),tmp));
						}
						users.add(new User(result.getString("name"), result.getString("login"),
								result.getString("pass"), tmp));
					}
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else {
			return null;
		}
		return users;

	}

	public static ArrayList<Orders> getOrdersByLogin(String login){
		
		ArrayList<Orders> order = new ArrayList<Orders>();
		Connection conn = null;
		String query = "select users.name as uname, orders.number as onumber, orders.summa as osumma, contructors.name as cname"
				+ " from  users, orders, contructors where users.id = orders.user_id and "
				+ "contructors.id = orders.contructor_id and users.login ='" + login + "'";
		
		if(login != null && login != ""){
			 try {
				conn = DriverManager.getConnection(getUrl(), getLogin(), getPass());
				Statement state = conn.createStatement();
				ResultSet rs = state.executeQuery(query);
				if(rs != null){
					while(rs.next()){
						order.add(new Orders(rs.getString("onumber"), rs.getString("cname"), rs.getString("uname"), rs.getInt("osumma")));
					}
				}else{
					return null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(conn != null){
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			
		}else{
			return null;
		}
		
		
		return order;
		
	}

}

/*
 * Создать класс User с полями: name, login, pass, Employee employee Создать
 * класс Employee с полями: name, salary. Создать класс Role с полями: name,
 * comment. Создать класс Orders полями: number, contructor, user, summa.
 * Создать класс Contructor с полем: name.
 * 
 * Задача20. Написать метод, который возвращает список всех ролей.
 * 
 * 
 * Задача21. Написать метод, которому на вход дается строка с именем роли, метод
 * должен вернуть список пользователей, это роли.
 * 
 * Задача22. Написать метод, которому на вход дается список строка с значением
 * login-а, метод вовзращает список заказов, оформленных менеджером с указанным
 * логином.
 */
