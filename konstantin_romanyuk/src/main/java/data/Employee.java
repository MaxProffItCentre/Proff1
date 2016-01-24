package data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="employees")
public class Employee {
 @Id
 @GeneratedValue(generator = "increment")
 @GenericGenerator(name = "increment", strategy = "increment")
 @Column(name="id")
 private Long id;
 
 @Column(name="name")
 private String name;

 @Column(name="salary")
 private Long salary;
 
    //@OneToOne(mappedBy="employee")
  //@JoinColumn(name = "id")
    //@PrimaryKeyJoinColumn
  // private User user;


 /*public User getUser() {
  return user;
 }

 public void setUser(User user) {
  this.user = user;
 }*/

 public Employee(Long id, String name, Long salary, User user) {
  this.id = id;
  this.name = name;
  this.salary = salary;
 // this.user = user;
 }
 public Employee(String name) {
	super();
	  this.name = name;
	
	 }
 public Employee(String name,Long salary) {
	super();
	  this.name = name;
	  this.salary=salary;
	
	 }
 public Employee() {
  super();
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

 public Long getSalary() {
  return salary;
 }

 public void setSalary(Long salary) {
  this.salary = salary;
 }

 @Override
 public String toString() {
  String userName = "null";
  //if(user==null) userName = user.getName();
  return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", user=" + userName + "]";
 }
 
}