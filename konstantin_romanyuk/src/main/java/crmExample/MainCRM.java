package crmExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MainCRM {
	private static String nameDriver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/proff1";
	private static String login = "root";
	private static String pass = "root";
	private static ArrayList<Role> roles=new ArrayList<Role>();
	private static Role tmp;
	private static ArrayList<User> users=new ArrayList<User>();

	public static void main(String[] args) {
		/*getAllRoles();
		for(int i=0; i<roles.size(); i++)
		System.out.println(roles.get(i))*/
		/*getAllUsers("manager");
		for(int i=0; i<users.size(); i++)
			System.out.println(users.get(i))*/;
			ArrayList<Orders> ordersList1=getOrders("user2");
			for(int i=0; i<ordersList1.size(); i++)
				System.out.println(ordersList1.get(i));
		/*
		try {
			Class.forName(nameDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String query = "select * from users";
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(url, login, pass);
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				System.out.print(rs.getString(1) + ", ");
				System.out.print(rs.getString(2) + ", ");
				System.out.print(rs.getString(3) + ", ");
				System.out.print(rs.getString(4) + ", ");
				System.out.print(rs.getString(5) + ", ");
				System.out.println();
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
		}*/}
	
public static ArrayList <Role> getAllRoles(){
	try {
	Class.forName(nameDriver);
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}

String query = "select * from roles";
Connection connect = null;
try {
	connect = DriverManager.getConnection(url, login, pass);
	Statement statement = connect.createStatement();
	ResultSet rs = statement.executeQuery(query);
	while (rs.next()) {
		tmp=new Role (rs.getString(1),rs.getString(2));
		roles.add(tmp);
			}
} catch (SQLException e) {
	e.printStackTrace();
} finally {
	if (connect != null)
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}}
	
	
return roles;}

public static ArrayList <User> getAllUsers(String role){
	User tmp;
	try {
	Class.forName(nameDriver);
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}

String query = "select distinct * from users left join employees on users.employee_id=employees.id,roles_users,roles where roles_users.user_id=users.id and roles.id=roles_users.role_id and roles.name='"+role+"';";
		
Connection connect = null;
try {
	connect = DriverManager.getConnection(url, login, pass);
	/*PreparedStatement statement = connect.prepareStatement(query);
	statement.setString(1, role);
	ResultSet rs = statement.executeQuery(query);*/
	Statement statement = connect.createStatement();
	ResultSet rs = statement.executeQuery(query);
	while (rs.next()) {
		tmp=new User (rs.getString("users.name"),rs.getString("users.login"),rs.getString("users.pass"), new Employee(rs.getString("users.name"), rs.getDouble("employees.salary")));
		users.add(tmp);
			}
} catch (SQLException e) {
	e.printStackTrace();
} finally {
	if (connect != null)
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}}
	
	
return users;}

public static ArrayList <Orders> getOrders(String log){
	Orders tmp;
	ArrayList<Orders> ordersList=new ArrayList<Orders>();
	
	try {
	Class.forName(nameDriver);
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}

String query = "select distinct* from users left join employees on users.employee_id=employees.id, orders,contructors where orders.user_id=users.id and contructors.id=orders.contructor_id and users.login='"+log+"';";
		
Connection connect = null;
try {
	connect = DriverManager.getConnection(url, login, pass);
	/*PreparedStatement statement = connect.prepareStatement(query);
	statement.setString(1, role);
	ResultSet rs = statement.executeQuery(query);*/
	Statement statement = connect.createStatement();
	ResultSet rs = statement.executeQuery(query);
	while (rs.next()) {
		tmp=new Orders(rs.getString("orders.number"), new Contructor(rs.getString("contructors.name")),new User(rs.getString("users.name"),rs.getString("users.login"),rs.getString("users.pass"),new Employee(rs.getString("employees.name"),rs.getDouble("employees.salary"))),rs.getDouble("orders.summa"));
			ordersList.add(tmp);}
} catch (SQLException e) {
	e.printStackTrace();
} finally {
	if (connect != null)
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}}
	
	
return ordersList;}}
