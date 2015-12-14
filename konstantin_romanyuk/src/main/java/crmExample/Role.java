package crmExample;

public class Role {
	private String name;
	private String comment;
	
	public Role(){}

	public Role(String name, String comment) {
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

	@Override
	public String toString() {
		return "Role [name=" + name + ", comment=" + comment + "]";
	}
	
	
}
