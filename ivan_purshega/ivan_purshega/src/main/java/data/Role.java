package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="roles")
public class Role {
 @Id
 @GeneratedValue(generator = "increment1")
 @GenericGenerator(name = "increment1", strategy = "increment")
 @Column(name="id")
 private Long id;
 
 @Column(name="name")
 private String name;
  	
 @Column(name="comment")
 private int comment;
 

 
 

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

public int getComment() {
	return comment;
}

public void setComment(int comment) {
	this.comment = comment;
}

@Override
 public String toString() {
  return "Role [name "+name+" ]";
 }

 public Role() {
 }



 
}