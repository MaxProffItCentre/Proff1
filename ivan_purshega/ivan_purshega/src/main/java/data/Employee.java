package data;


	import javax.persistence.Column;
	import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	 @GeneratedValue(generator = "increment1")
	 @GenericGenerator(name = "increment1", strategy = "increment")
	 @Column(name="id")
	 private Long id;
	 
	 @Column(name="name")
	 private String name;
	 
	 @Column(name="salary")
	 private int salary = 0;
	 
	  @OneToOne
	    @JoinColumn(name = "id")
//	    @PrimaryKeyJoinColumn
	    private User user;
	 

	  
	  public User getUser(){
		  return user;
	  }
	  
	  public void setUser(User user){
		  this.user=user;
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

	 public int getSalary() {
	  return salary;
	 }

	 public void setBarcode(int salary) {
	  this.salary = salary;
	 }

	 @Override
	 public String toString() {
	  return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	 }

	 public Employee() {
	 }

	 public Employee (String name, int salary) {
	  this.name = name;
	  this.salary = salary;
	 }

	// public contructor(String name) {
	//  this(name,0);
	// }
	 
	}