package view;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class RoleViewer {


	   private SimpleLongProperty id;
	   private SimpleStringProperty name;
	   private SimpleStringProperty comment;
	  
	    
	    public RoleViewer(Long id, String name,String comment) {
	    	 this.id = new SimpleLongProperty(id);
	         this.name = new SimpleStringProperty(name);
	         this.comment = new SimpleStringProperty(comment);
	        
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
	  public String getComment() {
	        return comment.get();
	  }
	  public void setComment(String name) {
	        this.comment.set(name);
	  } 

}
