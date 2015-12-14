package HomeTaskMySQL;

public class Role {
	private String name;
	private String comment;
	public Role(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
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
}
