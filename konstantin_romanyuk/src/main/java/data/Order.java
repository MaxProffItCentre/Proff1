package data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "orders")
public class Order {
	 @Id
	 @GeneratedValue(generator = "increment")
	 @GenericGenerator(name = "increment", strategy = "increment")
	 @Column(name = "id")
	 private Long id;

	 @Column(name = "number")
	 private String number;

	/* @Column(name = "contructor_id")
	 private Long contructor_id;*/

	 @Column(name = "user_id")
	 private Long user_id;
	 
	 @Column(name = "summa")
	 private Long summa;
	 
	 @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
     @JoinColumn(name="contructor_id")
	 private Contructor contructor;
	 


	

	 public Order(Long id, String number, Contructor contructor, Long user_id, Long summa) {
		super();
		this.id = id;
		this.number = number;
		this.contructor = contructor;
		this.user_id = user_id;
		this.summa = summa;
		
	}



	public Order() {
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



	public Contructor getContructor() {
		return contructor;
	}



	public void setContructor(Contructor contructor) {
		this.contructor = contructor;
	}







	public Long getSumma() {
		return summa;
	}



	public void setSumma(Long summa) {
		this.summa = summa;
	}






	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", contructor=" + contructor  + ", summa="
				+ summa  + "]";
	}



	/*public Long getContructor_id() {
		return contructor_id;
	}



	public void setContructor_id(Long contructor_id) {
		this.contructor_id = contructor_id;
	}*/



	public Long getUser_id() {
		return user_id;
	}



	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	
	}

