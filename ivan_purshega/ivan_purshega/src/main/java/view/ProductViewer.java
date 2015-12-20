package view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProductViewer {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleIntegerProperty code;
   
    public ProductViewer(int id, String name, int code) {
          this.id = new SimpleIntegerProperty(id);
          this.name = new SimpleStringProperty(name);
          this.code = new SimpleIntegerProperty(code);
    }
    public int getId() {
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
    public Integer getCode() {
          return code.get();
    }
    public void setCode(Integer code) {
          this.code.set(code);
    }     
}