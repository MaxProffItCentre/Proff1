package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="contructors")
public class Contructor {
	@Id
	@GeneratedValue(generator="increment1")
	@GenericGenerator(name="increment1", strategy="increment")
	@Column(name="id")
	Long id;
	
	@Column(name="name")
	private String name;

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
	
	public Contructor(){
		
	}
	
	public Contructor(String name){
		this.name = name;
	}
	
	
}
