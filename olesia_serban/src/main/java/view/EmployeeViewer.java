package view;

import java.util.List;

import data.Employees;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeViewer {
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleIntegerProperty salary;

	public EmployeeViewer(int id, String name, int salary) {
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.salary = new SimpleIntegerProperty(salary);
	}

	public int getId() {
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

	public int getSalary() {
		return salary.get();
	}

	public void setSalary(int salary) {
		this.salary.set(salary);
	}

	public static ObservableList<EmployeeViewer> obsListFromData(List<Employees> list) {
		
		ObservableList<EmployeeViewer> obsList = FXCollections.observableArrayList();
		
		list.forEach(emp -> obsList.add(new EmployeeViewer(emp.getId().intValue()
				, emp.getName(), emp.getSalary())));
		
		return obsList;

	}

}
