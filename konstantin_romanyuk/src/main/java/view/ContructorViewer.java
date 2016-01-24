package view;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class ContructorViewer {
   private SimpleLongProperty id;
   private SimpleStringProperty name;
    
    public ContructorViewer(Long id, String name) {
    	 this.id = new SimpleLongProperty(id);
         this.name = new SimpleStringProperty(name);
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
    
}
