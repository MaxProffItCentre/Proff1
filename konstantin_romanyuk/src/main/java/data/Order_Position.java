package data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="order_positions")
public class Order_Position {
	 @Id
	 @GeneratedValue(generator = "increment")
	 @GenericGenerator(name = "increment", strategy = "increment")
	 @Column(name = "id")
	 private Long id;

	 @Column(name = "order_id")
	 private Order order;

	 public Order_Position(){}
	 public Order_Position(Long id, Order order, Product product, Long kol, Long price, Long summa) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.kol = kol;
		this.price = price;
		this.summa = summa;
	}

	@Column(name = "product_id")
	 private Product product;

	 @Column(name = "kol")
	 private Long kol;
	 
	 @Column(name = "price")
	 private Long price;
	 
	 @Column(name = "summa")
	 private Long summa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getKol() {
		return kol;
	}

	public void setKol(Long kol) {
		this.kol = kol;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getSumma() {
		return summa;
	}

	public void setSumma(Long summa) {
		this.summa = summa;
	}

	

}
