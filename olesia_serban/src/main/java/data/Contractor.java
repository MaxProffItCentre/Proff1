package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "contructurs")
public class Contractor {
	@Id
	@GeneratedValue(generator = "increment1")
	@GenericGenerator(name = "increment1", strategy = "increment")
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
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

	public Contractor() {
	}

	public Contractor(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		
		return "[id is: "+id +", name is: "+name+"]";
	}
}
