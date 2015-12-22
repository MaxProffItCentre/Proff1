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
 private String pass;
 
 @Column(name = "employee_id")
 private String employee_id;
 



 @OneToOne (mappedBy = "user", cascade = CascadeType.ALL)
 @JoinColumn(name="employee_id")   
 private Employee employee;

 public User(Long id, String name, String pass,String employee_id, Employee employee) {
  this.id = id;
  this.name = name;
  this.pass = pass;
  this.employee = employee;
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

 public void setId(Long id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getPass() {
  return pass;
 }

 public void setPass(String pass) {
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