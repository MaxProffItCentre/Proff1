package data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orders")
public class Orders {
 
 @Id
 @GeneratedValue(generator = "increment")
 @GenericGenerator(name = "increment", strategy = "increment")
 @Column(name = "id")
 private Long id;

 @Column(name = "number")
 private String number;

 @Column(name = "contructor_id")
 private int contructor_id;

 @Column(name = "user_id")
 private int user_id;
 
 @Column(name = "summa")
 private int summa;
 
 
 @Column (name="data")
 @Temporal(value=TemporalType.DATE)
 private Date date;

 

 public Orders(String number, int contructor_id, int user_id, int summa) {
	super();
	this.number = number;
	this.contructor_id = contructor_id;
	this.user_id = user_id;
	this.summa = summa;
}
 
 public Orders(String number, Date date){
	 this.number=number;
	 this.date=date;
 }

public Orders() {
 }

 

 public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
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

public int getContructor_id() {
	return contructor_id;
}

public void setContructor_id(int contructor_id) {
	this.contructor_id = contructor_id;
}

public int getUser_id() {
	return user_id;
}

public void setUser_id(int user_id) {
	this.user_id = user_id;
}

public int getSumma() {
	return summa;
}

public void setSumma(int summa) {
	this.summa = summa;
}

@Override
 public String toString() {
	
  return "User [id=" + id + ", number=" + number + ", contructor_id=" + contructor_id + ", user_id " + user_id + ", summa=" + summa
    + "]";
 }

}