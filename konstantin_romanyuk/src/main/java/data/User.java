package data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import dao.EmployeesDaoImpl;

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
 
 //@Column(name = "employee_id", insertable=false, updatable=false)
 private Long employee_id;
@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER) 
@JoinTable(name="roles_users", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
private Role role;
// @OneToOne  // (mappedBy = "user", cascade = CascadeType.ALL)
 //@JoinColumn(name="employee_id")
//@JoinTable(name = "users", joinColumns=@JoinColumn(name="employee_id"), inverseJoinColumns=@JoinColumn(name="id"))
// private Employee employee;

 public User(Long id, String name,String login, String pass, Employee employee) {
  this.id = id;
  this.name = name;
  this.pass = pass;
  this.login=login;
  //this.employee = employee;
 }
 public User(String name,String login, String pass) {
	 
	  this.name = name;
	  this.pass = pass;
	  this.login=login;
	  //this.employee = employee;
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

 /*public Long getEmployeeId() {
  return employee.getId();
 }
 public Employee getEmployee() {
	  return employee;
	 }
 public Employee getEmployee(long id) {
	 EmployeesDaoImpl EmployeesImpl = new EmployeesDaoImpl();
	  List<Employee> employees = EmployeesImpl.findAll();
	  return employees.get((int) id);
	 }
 public void setEmployee(Employee employee) {
  this.employee = employee;
 }*/

 @Override
 public String toString() {
  return "User [id=" + id + ", name=" + name + ", login=" + login + ", pass=" + pass + /*", employee=" + employee*/
     "]";
 }

public Long getEmployee_id() {
	return employee_id;
}

public void setEmployee_id(Long employee_id) {
	this.employee_id = employee_id;
}

}