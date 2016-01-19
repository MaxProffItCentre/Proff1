package data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

@Entity
public class Orders {
	@Id
	@GeneratedValue(generator = "increment1")
	@GenericGenerator(name = "increment1", strategy = "increment")
	@Column(name = "id")
	private Long id;
	@Column(name = "number")
	private String number;
	@Column(name = "summa")
	private int summa;
	
	@Column(name = "constructor_id")
	private int constId;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Orders() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getSumma() {
		return summa;
	}

	public void setSumma(int summa) {
		this.summa = summa;
	}

	

	public int getConstId() {
		return constId;
	}

	public void setConstId(int constId) {
		this.constId = constId;
	}

	@Override
	public String toString() {

		return "[id: " + id + ",number: " + number + ",summa: " + summa +  "]";
	}
}
