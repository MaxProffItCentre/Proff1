package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="typemessage")

public class TypeMessage {
	 @Id
	 @GeneratedValue(generator = "increment1")
	 @GenericGenerator(name = "increment1", strategy = "increment")
	
	 
	 @Column(name="idTypeMessage")
	 private int idTypeMessage;
	 
	 @Column(name="name")
	 private String name;
	
	 @ManyToOne 
	 @JoinColumn(name="idTypeMessage",  insertable=false, updatable=false,
	   nullable=false)
	 private Message typeMessage;

	public TypeMessage() {
		
	}

	public TypeMessage(String name, Message typeMessage) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Message getTypeMessage() {
		return typeMessage;
	}

	public void setTypeMessage(Message typeMessage) {
		this.typeMessage = typeMessage;
	}

	public int getIdTypeMessage() {
		return idTypeMessage;
	}
	
	
	 
	 
	 
	 
}
