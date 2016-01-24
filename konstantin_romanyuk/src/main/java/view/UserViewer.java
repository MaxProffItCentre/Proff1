package view;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserViewer {


	   private SimpleLongProperty id;
	   private SimpleStringProperty name;
	   private SimpleStringProperty login;
	   private SimpleStringProperty pass;
	    
	    public UserViewer(Long id, String name,String login, String pass) {
	    	 this.id = new SimpleLongProperty(id);
	         this.name = new SimpleStringProperty(name);
	         this.login = new SimpleStringProperty(login);
	         this.pass = new SimpleStringProperty(pass);
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
	  public String getLogin() {
	        return login.get();
	  }
	  public void setLogin(String name) {
	        this.login.set(name);
	  } public String getPass() {
	        return pass.get();
	  }
	  public void setPass(String name) {
	        this.pass.set(name);
	  }
}
