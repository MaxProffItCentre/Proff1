package action04;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class System1 {
	private ArrayList<User> list = new ArrayList<User>();
	private final static String fileName = "file1.txt";

	public static void main(String[] args) {
		System1 system = new System1();
		System.out.println(system.list);
		system.usersToFile(system.getArrayFromList(), fileName);
		User[] users = system.usersFromFile(fileName);
		System.out.println(Arrays.toString(users));

	}

	public System1() {
		list.add(new User("user1", "pass1"));
		list.add(new User("user3", "pass3"));
		list.add(new User("user2", "pass2"));
		list.add(new User("user5", "pass5"));
		list.add(new User("user4", "pass4"));

	}

	public User[] getArrayFromList() {
		User[] users = list.toArray(new User[0]);
		return users;
	}

	public void usersToFile(User[] users, String fileName) {
		try (FileWriter fw = new FileWriter(fileName)) {

			list.forEach(new Consumer<User>() {

				@Override
				public void accept(User user) {
					try {
						fw.write(user.toFileStream());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public User[] usersFromFile(String fileName){
		List<User> users = new ArrayList<User>();
		try(
				FileReader fr = new FileReader(fileName);
			Scanner scan = new Scanner(fr);
			){
			while(scan.hasNextLine()){
				User user = User.fromFileStream(scan.nextLine());
				if(user!=null) users.add(user);
			}
		}catch(Exception e){
			
		}
		return users.toArray(new User[0]);
	}

}

class User {
	private String login;
	private String pass;
	private int id;
	private static int idAll = 0;

	public String toFileStream() {
		return login + ";" + pass + ";" + id + ";\n";
	}

	public static User fromFileStream(String str) {
		String[] arr = str.split(";");
		try {
			return new User(arr[0], arr[1], Integer.parseInt(arr[2]));
		} catch (Exception e) {
		}
		return null;
	}

	public User(String login, String pass, int id) {
		this.login = login;
		this.pass = pass;
		this.id = id;
		if (id < 0) this.id = idAll;
		idAll++;
	}

	public User(String login, String pass) {
		this(login, pass, -1);
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return id + "-" + login + "-" + pass;
	}

	@Override
	public int hashCode() {
		return login.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}


}
