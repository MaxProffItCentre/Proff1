package crmExample;

public class Employee {
	private String name;
	private double salary;
	
		
	public Employee(String name, double d) {
		super();
		this.name = name;
		this.salary = d;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
