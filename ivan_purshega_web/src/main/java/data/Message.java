package data;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


	
	@Entity
	@Table(name="messages")
	public class Message {
	 @Id
	 @GeneratedValue(generator = "increment1")
	 @GenericGenerator(name = "increment1", strategy = "increment")
	 @Column(name="id")
	 private int id;
	 
	 @Column(name="typeMessege")
	 private String typeMessage;
	 
	 @Column(name="user_question")
	 private int user_question;
	 
	 @Column(name="user_answer")
	 private int user_answer;
	 
	 @Column(name="question")
	 private String question;
	 
	 @Column(name="answer")
	 private String answer;
	 
	 @Temporal(TemporalType.DATE)
	 @Column(name="data_question")
	 private Date data_question;
	
//	 @Temporal(value=TemporalType.DATE)
//	 @Column(name="time_question")
//	 private Time time_question;
	 
	 @Temporal(TemporalType.DATE)
	 @Column(name="data_answer")
	 private Date data_answer;
	 
//	 @Temporal(value=TemporalType.DATE)
//	 @Column(name="time_answer")
//	 private Time time_answer;
	 
	 @OneToMany (mappedBy = "typeMessage", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	 private Set<TypeMessage> typeOfMessage;
	 
	 
	 @ManyToOne 
	 @JoinColumn(name="user_question",  insertable=false, updatable=false,
	   nullable=false)
	 private User user;
	 

	 

	public Message() {	
	}




	public Message(String typeMessage, int user_question, int user_answer, String question, String answer) {
	
		this.typeMessage = typeMessage;
		this.user_question = user_question;
		this.user_answer = user_answer;
		this.question = question;
		this.answer = answer;
//		Date date=new Date();
//		this.data_question=date;
		
	}




	@Override
	public String toString() {
		return "Message [id=" + id + ", typeMessage=" + typeMessage + ", user_question=" + user_question
				+ ", user_answer=" + user_answer + ", question=" + question + ", answer=" + answer + ", data_question="
				+ data_question + ", time_question="  + ", data_qanswer=" + data_answer
				+ ", time_answer=" + ", user=" + user + "]";
	}




	public Date getData_answer() {
		return data_answer;
	}




	public void setData_answer(Date data_answer) {
		this.data_answer = data_answer;
	}




	public Set<TypeMessage> getTypeOfMessage() {
		return typeOfMessage;
	}




	public void setTypeOfMessage(Set<TypeMessage> typeOfMessage) {
		this.typeOfMessage = typeOfMessage;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getTypeMessage() {
		return typeMessage;
	}




	public void setTypeMessage(String typeMessage) {
		this.typeMessage = typeMessage;
	}




	public int getUser_question() {
		return user_question;
	}




	public void setUser_question(int user_question) {
		this.user_question = user_question;
	}




	public int getUser_answer() {
		return user_answer;
	}




	public void setUser_answer(int user_answer) {
		this.user_answer = user_answer;
	}




	public String getQuestion() {
		return question;
	}




	public void setQuestion(String question) {
		this.question = question;
	}




	public String getAnswer() {
		return answer;
	}




	public void setAnswer(String answer) {
		this.answer = answer;
	}




	public Date getData_question() {
		return data_question;
	}




	public void setData_question(Date data_question) {
		this.data_question = data_question;
	}




//	public Time getTime_question() {
//		return time_question;
//	}
//
//
//
//
//	public void setTime_question(Time time_question) {
//		this.time_question = time_question;
//	}




	public Date getData_qanswer() {
		return data_answer;
	}




	public void setData_qanswer(Date data_qanswer) {
		this.data_answer = data_qanswer;
	}



//
//	public Time getTime_answer() {
//		return time_answer;
//	}
//
//
//
//
//	public void setTime_answer(Time time_answer) {
//		this.time_answer = time_answer;
//	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}
	
	

	
	 
}
