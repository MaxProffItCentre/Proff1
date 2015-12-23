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
	 
	 @Column(name="product_id")
	 private int product_id;
	 
	 @Column(name="kol")
	 private int kol;
	 
	 @Column(name="price")
	 private int price;
	 
	 @Column(name="summa")
	 private int summa;
	 
	 

	 public int getSumma() {
		return summa;
	}

	public void setSumma(int summa) {
		this.summa = summa;
	}

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
	
	


	 public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getKol() {
		return kol;
	}

	public void setKol(int kol) {
		this.kol = kol;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	 public String toString() {
	  return "Order_Position [id=" + id + ", order_id=" + order_id  + "]";
	 }

	 public Order_Position() {
	 }

	}
