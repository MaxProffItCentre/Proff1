package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
 
// - Users(name, login, pass, isCanAnswer, isCanManage, isDirector, isAdmin)
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "login")
	private String login;
	@Column(name = "pass")
	private String pass;
	@Column(name = "isCanAnswer")
	private boolean isCanAnswer;
	@Column(name = "isCanManage")
	private boolean isCanManage;
	@Column(name = "isCanDirector")
	private boolean isDirector;
	@Column(name = "isCanAdmin")
	private boolean isAdmin;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public static List <User> getUsers () {
//		List<User> users = new ArrayList<User>();
//		users.add(new User("Pupkin V.", "v.pupkin", "333", false, false, false, false));
//		users.add(new User("Bobrov A.", "a.bobrov", "333", false, false, false, false));
//		users.add(new User("Lermont V.", "v.lermont", "333", false, false, false, false));
//		return users;
//	}
	
	public User () {};
	
	public User (String name, String login, String pass) {
		
		this(name, login, pass, false, false, false, false);
	};
	
	public User(String name, String login, String pass, boolean isCanAnswer, boolean isCanManage, boolean isDirector,
			boolean isAdmin) {
		super();
		this.name = name;
		this.login = login;
		this.pass = pass;
		this.isCanAnswer = isCanAnswer;
		this.isCanManage = isCanManage;
		this.isDirector = isDirector;
		this.isAdmin = isAdmin;
	}
	
	public String toTableUsers() {
		StringBuilder sb = new StringBuilder();
		sb.append("<td>");
		sb.append(this.name);
		sb.append("</td>");
		sb.append("<td>");
		sb.append(this.login);
		sb.append("</td>");
		sb.append("<td>");
		sb.append(this.pass);
		sb.append("</td>");

		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isCanAnswer() {
		return isCanAnswer;
	}

	public void setCanAnswer(boolean isCanAnswer) {
		this.isCanAnswer = isCanAnswer;
	}

	public boolean isCanManage() {
		return isCanManage;
	}

	public void setCanManage(boolean isCanManage) {
		this.isCanManage = isCanManage;
	}

	public boolean isDirector() {
		return isDirector;
	}

	public void setDirector(boolean isDirector) {
		this.isDirector = isDirector;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		return result;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", login=" + login + ", pass=" + pass + ", isCanAnswer=" + isCanAnswer
				+ ", isCanManage=" + isCanManage + ", isDirector=" + isDirector + ", isAdmin=" + isAdmin + "]";
	}

	
	
}