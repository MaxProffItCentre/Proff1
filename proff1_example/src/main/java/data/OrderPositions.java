package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="order_positions")
public class OrderPositions {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	@Column(name="kol")
	private int kol;
	
	@Column(name="price")
	private int price;

	@Column(name="summa")
	private int summa;

	@Override
	public String toString() {
		return "OrderPositions [id=" + id + ", product=" + product.getName() + ", order=" + order.getNumber() + ", kol=" + kol + ", price="
				+ price + ", summa=" + summa + "]";
	}
	
}
