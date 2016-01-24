package view;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class OrderViewer {
	   private SimpleLongProperty id;
	   private SimpleStringProperty name;
	   private SimpleLongProperty summa;
	    
	    public OrderViewer(Long id, String name, Long summa) {
	    	 this.id = new SimpleLongProperty(id);
	         this.name = new SimpleStringProperty(name);
	         this.summa=new SimpleLongProperty(summa);
		}
	    public long getId() {
	        return id.get();
	  }
	  public void setId(int id) {
	        this.id.set(id);
	  }
	  public String getName() {
	        return name.get();
	  }
	  public void setName(String name) {
	        this.name.set(name);
	  }
	    
	  public long getSumma() {
	        return summa.get();
	  }
	  public void setSumma(int summa) {
	        this.summa.set(summa);
}
}