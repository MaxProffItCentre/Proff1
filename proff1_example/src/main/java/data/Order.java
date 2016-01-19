package data;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="orders")
public class Order<mapped> {
	@Id
	@GeneratedValue(generator = "incr")
	@GenericGenerator(name = "incr", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="number")
	private String number;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="contructor_id")
	private Contructor contructor;
	
	@Column(name="user_id")
	private Long user_id;

	@Column(name="summa")
	private int summa;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="order")
	Set<OrderPositions> positions;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="data")
	private Date data;

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

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public int getSumma() {
		return summa;
	}

	public void setSumma(int summa) {
		this.summa = summa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Order() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Order [id=" + id + ", number=" + number + ", contructor=" + contructor + ", user_id=" + user_id
				+ ", summa=" + summa + ", data=" + data);
		positions.forEach(pos->sb.append("\n\t\t"+pos));
		return sb.toString();

	}
	
}
