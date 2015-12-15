package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "employees")

public class Employees {
	@Id
	@GeneratedValue(generator = "increment1")
	@GenericGenerator(name = "increment1", strategy = "increment")
	@Column(name= "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column (name = "salary")
	private int salary = 0;
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
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employees (){
		
	}
	public Employees(String name){
		this.name = name;
	}
	public Employees(String name, int salary){
		this(name);
		this.salary = salary;
	}
	@Override
	public String toString() {
		
		return "[id = "+ id +", name: "+ name +", salary: "+ salary+"]";
	}
}
