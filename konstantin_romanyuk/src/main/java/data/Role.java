package data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="roles")
public class Role {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="comment")
	private String comment;
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER) 
	@JoinTable(name="roles_users", joinColumns=@JoinColumn(name="role_id"), inverseJoinColumns=@JoinColumn(name="user_id"))
	private List<User> user;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Role() {
		super();
	}

	public Role(Long id, String name, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.comment = comment;
	}
	public Role(String name, String comment) {
		super();
		
		this.name = name;
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", comment=" + comment + "]";
	}
	
}