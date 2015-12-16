package view;

import java.util.List;

import data.Product;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    
    //changes List into ObservableList
    public static ObservableList<ProductViewer> obsListFromData(List<Product> list){
    	ObservableList<ProductViewer> listObserve = FXCollections.observableArrayList();
    	for (int i = 0; i < list.size(); i++) {
    		Product pr = list.get(i);
    		listObserve.add(new ProductViewer(pr.getIntegerId(), pr.getName(), pr.getBarcode()));
			
		}
    	
    	return listObserve;
    	
    }
}
