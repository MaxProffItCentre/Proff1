package data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="users")
public class User {
 @Id
 @GeneratedValue(generator = "increment1")
 @GenericGenerator(name = "increment1", strategy = "increment")
 @Column(name="id")
 private int id;
 
 @Column(name="name")
 private String name;
 
 @Column(name="login")
 private String login;
 
 @Column(name="pass")
 private String pass;
 
 @Column(name="isCanAnswer")
 private int isCanAnswer;
 
 @Column(name="isCanManage")
 private int isCanManage;
 
 @Column(name="isDirector")
 private int isDirector;
 
 @Column(name="isAdmin")
 private int isAdmin;
 
 @OneToMany (mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
 private Set<Message> messages = new HashSet<Message>();
 
 
 
 public User(){
	 
 }
 
 public User(String name){
	 this.name=name;;
 }

 public Set<Message> getMessages() {
	return messages;
}



public void setMessages(Set<Message> messages) {
	this.messages = messages;
}

public User(String name, String login, String pass, int isCanAnswer, int isCanManage, int isDirector,
		int isAdmin) {

	
	this.name = name;
	this.login = login;
	this.pass = pass;
	this.isCanAnswer = isCanAnswer;
	this.isCanManage = isCanManage;
	this.isDirector = isDirector;
	this.isAdmin = isAdmin;
}

public User(int id, String name, String login, String pass, int isCanAnswer, int isCanManage, int isDirector,
		int isAdmin) {

	this.id = id;
	this.name = name;
	this.login = login;
	this.pass = pass;
	this.isCanAnswer = isCanAnswer;
	this.isCanManage = isCanManage;
	this.isDirector = isDirector;
	this.isAdmin = isAdmin;
}



public User(String name, String login, String pass) {

	this.name = name;
	this.login = login;
	this.pass = pass;
}
 
 
 

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", login=" + login + ", pass=" + pass + ", isCanAnswer=" + isCanAnswer
			+ ", isCanManage=" + isCanManage + ", isDirector=" + isDirector + ", isAdmin=" + isAdmin + "]";

}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
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

public int getIsCanAnswer() {
	return isCanAnswer;
}

public void setIsCanAnswer(int isCanAnswer) {
	this.isCanAnswer = isCanAnswer;
}

public int getIsCanManage() {
	return isCanManage;
}

public void setIsCanManage(int isCanManage) {
	this.isCanManage = isCanManage;
}

public int getIsDirector() {
	return isDirector;
}

public void setIsDirector(int isDirector) {
	this.isDirector = isDirector;
}

public int getIsAdmin() {
	return isAdmin;
}

public void setIsAdmin(int isAdmin) {
	this.isAdmin = isAdmin;
}

}