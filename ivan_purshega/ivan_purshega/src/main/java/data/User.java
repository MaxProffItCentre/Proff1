package data;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

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
 private int pass;
 
 @Column(name = "employee_id")
 private int employee_id;
 

 @OneToOne (fetch=FetchType.EAGER, cascade = CascadeType.ALL)
// @JoinColumn(name="employee_id")   
 @PrimaryKeyJoinColumn
 private Employee employee;
 


 public User(String name, String login, int pass,int employee_id, Employee employee) {
  
  this.name = name;
  this.pass = pass;
  this.employee = employee;
  this.employee_id=employee_id;
 }
 
 public User(String name, String login,int pass,int employee_id) {
	
	  this.name = name;
	  this.login=login;
	  this.pass = pass;
	  this.employee_id=employee_id;
	 }

 public User() {
 }

 public String getLogin() {
  return login;
 }

 public void setLogin(String login) {
  this.login = login;
 }

 public Long getId() {
  return id;
 }

 public int getEmployee_id() {
	return employee_id;
}

public void setEmployee_id(int employee_id) {
	this.employee_id = employee_id;
}

public void setId(Long id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public int getPass() {
  return pass;
 }

 public void setPass(int pass) {
  this.pass = pass;
 }

 public Employee getEmployee() {
  return employee;
 }

 public void setEmployee(Employee employee) {
  this.employee = employee;
 }

 @Override
 public String toString() {
	 if (employee==null) return "User [id=" + id + ", name=" + name + ", login=" + login + ", pass=" + pass + ", employee" 
    + "]";
	 else
  return "User [id=" + id + ", name=" + name + ", login=" + login + ", pass=" + pass + ", employee=" + employee
    + "]";
 }

}