package action16;

import java.util.ArrayList;
import java.util.List;

public class Lift {
	private String name;
	private String operator;
	private List<String> list = new ArrayList<String>();
	
	public Lift() {
	}
	public Lift(String name) {
		this.name = name;
	}
	public Lift(String name, String operator) {
		this.name = name;
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}


	public void setOperator(String operator) {
		this.operator = operator;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Lift [name=" + name + ", operator=" + operator + "]";
	}
	
}
