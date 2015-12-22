package data;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Table;

	import org.hibernate.annotations.GenericGenerator;

	@Entity
	@Table(name="order_positions")
	public class  Order_Position {
	 @Id
	 @GeneratedValue(generator = "increment1")
	 @GenericGenerator(name = "increment1", strategy = "increment")
	 @Column(name="id")
	 private Long id;
	 
	 @Column(name="order_id")
	 private Long order_id;
	 

	 public Long getId() {
	  return id;
	 }

	 public void setId(Long id) {
	  this.id = id;
	 }
	
	 public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}


	 @Override
	 public String toString() {
	  return "Order_Position [id=" + id + ", order_id=" + order_id  + "]";
	 }

	 public Order_Position() {
	 }

	}
