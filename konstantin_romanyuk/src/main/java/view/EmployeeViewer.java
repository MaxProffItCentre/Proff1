package view;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmployeeViewer {

	   private SimpleLongProperty id;
	   private SimpleStringProperty name;
	   private SimpleLongProperty salary;
	    
	    public EmployeeViewer(Long id, String name, Long salary) {
	    	 this.id = new SimpleLongProperty(id);
	         this.name = new SimpleStringProperty(name);
	         this.salary=new SimpleLongProperty(salary);
		}
	    public long getId() {
	        return id.get();
	  }
	  public void setId(int id) {
	        this.id.set(id);
	  }
	  public String getName() {
	        return name.get();
	  }
	  public void setName(String name) {
	        this.name.set(name);
	  }
	public Long getSalary() {
		return salary.get();
	}
	public void setSalary(Long salary) {
		this.salary.set(salary);
	}
	    

}
