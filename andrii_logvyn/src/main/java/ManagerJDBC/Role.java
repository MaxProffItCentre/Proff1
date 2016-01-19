package ManagerJDBC;

public class Role {
	private String name;
	private String comment;
	private int id;
	
	public Role(int id, String name, String comment){
		this.id = id;
		this.name = name;
		this.comment = comment;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
