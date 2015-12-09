package crmExample;

import java.sql.Connection;
import java.sql.DriverManager;
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
	

	public static void main(String[] args) {
		getAllRoles();
		for(int i=0; i<roles.size(); i++)
		System.out.println(roles.get(i));
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
}
