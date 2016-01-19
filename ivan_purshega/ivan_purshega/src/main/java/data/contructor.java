package data;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Table;

	import org.hibernate.annotations.GenericGenerator;

	@Entity
	@Table(name="contructors")
	public class  contructor {
	 @Id
	 @GeneratedValue(generator = "increment1")
	 @GenericGenerator(name = "increment1", strategy = "increment")
	 @Column(name="id")
	 private Long id;
	 
	 @Column(name="name")
	 private String name;
	 
//	 @Column(name="code")
//	 private int barcode = 0;

	 public Long getId() {
	  return id;
	 }

	 public void setId(Long id) {
	  this.id = id;
	 }

	 public String getName() {
	  return name;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }

//	 public int getBarcode() {
//	  return barcode;
//	 }
//
//	 public void setBarcode(int barcode) {
//	  this.barcode = barcode;
//	 }

	 @Override
	 public String toString() {
	  return "Contructor [id=" + id + ", name=" + name  + "]";
	 }

	 public contructor() {
	 }

	 public contructor(String name) {
	  this.name = name;
	 }

//	 public contructor(String name) {
//	  this(name,0);
//	 }
	 
	}
