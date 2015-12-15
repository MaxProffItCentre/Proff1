package CMS;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Zakaz {
	private TextField numberZakaz = new  TextField();
	private TextField manager = new  TextField();
	private TextField client = new  TextField();
	private DatePicker dateZakaz = new DatePicker();
	private DatePicker datePlanProduction = new DatePicker();
	private TextField status = new  TextField();
	private TextField amountZakaz = new  TextField();
	private TextField priceAll = new  TextField();
	
	public TextField getNumberZakaz() {
		return numberZakaz;
	}
	
	public void setNumberZakaz(String numberZakaz) {
		this.numberZakaz.setText(numberZakaz);;
	}
	public TextField getManager() {
		return manager;
	}
	
	public void setManager(TextField manager) {
		this.manager = manager;
	}
	public TextField getClient() {
		return client;
	}
	
	public void setClient(String str) {
		this.client.setText(str);
	}
	public DatePicker getDateZakaz() {
		return dateZakaz;
	}
	
	public void setDateZakazValue(String dateZakaz) {
		this.dateZakaz.setValue(LocalDate.parse(dateZakaz));
	}
	public DatePicker getDatePlanProduction() {
		return datePlanProduction;
	}
	
	public void setDatePlanProductionValue(String datePlanProduction) {
		this.datePlanProduction.setValue(LocalDate.parse(datePlanProduction)); 
	}
	public TextField getStatus() {
		return status;
	}
	public String getStatusValue() {
		return status.getText();
	}
	public void setStatus(TextField status) {
		this.status = status;
	}
	public TextField getAmountZakaz() {
		return amountZakaz;
	}
	
	public void setAmountZakaz(TextField amountZakaz) {
		this.amountZakaz = amountZakaz;
	}
	public TextField getPriceAll() {
		return priceAll;
	}
	public void setPriceAll(TextField priceAll) {
		this.priceAll = priceAll;
	}
	
	
	
}
