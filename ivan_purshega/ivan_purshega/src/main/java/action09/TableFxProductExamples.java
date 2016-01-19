package action09;


import dao.ProductDaoImpl;
import data.Product;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.ProductViewer;
 

public class TableFxProductExamples extends Application{
	  ProductDaoImpl product=new ProductDaoImpl();
      ObservableList<Product> list = 
        FXCollections.observableArrayList(
       		 product.findAll()
          );
       public static void main(String[] args) {
    	  
             launch();
       }
       @Override
       public void start(Stage stage) throws Exception {
             stage.setTitle("Table Example Application");
             stage.setScene(createScene4());
             stage.show();      
       }
 

       public Scene createScene1(){
             Group group = new Group();
            
             TableView table = new TableView();
            
             TableColumn firstNameCol = new TableColumn("field 1");
             TableColumn secondNameCol = new TableColumn("field 2");
             TableColumn thirdNameCol = new TableColumn("field 3");
            
             table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
            
             group.getChildren().add(table);
            
            
             return new Scene(group,600,400);
       }

       public Scene createScene2(){
             Group group = new Group();
            
             TableView table = new TableView();
            
             TableColumn firstNameCol = new TableColumn("field 1");
             TableColumn secondNameCol = new TableColumn("field 2");
             TableColumn superNameCol = new TableColumn("super");
             TableColumn super1NameCol = new TableColumn("super1");
             TableColumn super2NameCol = new TableColumn("super2");
            
             superNameCol.getColumns().addAll(super1NameCol,super2NameCol);
             table.getColumns().addAll(firstNameCol,secondNameCol,superNameCol);
            
             group.getChildren().add(table);
            
            
             return new Scene(group,600,400);
       }
//       ProductDaoImpl produc=new ProductDaoImpl();
//       ObservableList<Product> list = 
//         FXCollections.observableArrayList(
//        		 produc.findAll()
//               new ProductViewer(1, "Рыба", 123),
//               new ProductViewer(2, "Колбаса", 456),
//               new ProductViewer(3, "Огурец", 785),
//               new ProductViewer(4, "Сардельки", 541)
//           );
       public Scene createScene3(){
             Group group = new Group();
            
             TableView table = new TableView();
            
             TableColumn firstNameCol = new TableColumn("id");
             TableColumn secondNameCol = new TableColumn("name");
             TableColumn thirdNameCol = new TableColumn("code");
            
            
             firstNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer,Integer>("id"));
             secondNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer,String>("name"));
             thirdNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer,Integer>("code"));
            
             table.setItems(list);
            
             table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
            
             group.getChildren().add(table);
            
             return new Scene(group,600,400);
       }     
       public Scene createScene4(){
           Group group = new Group();
           
           GridPane grid=new GridPane();
           TextField text1=new TextField();
           TextField text2=new TextField();
           
          
       
           TableView table = new TableView();
           table.setEditable(true);
          
           TableColumn firstNameCol = new TableColumn("id");
           TableColumn secondNameCol = new TableColumn("name");
           TableColumn thirdNameCol = new TableColumn("code");
          
  
                   
           firstNameCol.setCellValueFactory(new PropertyValueFactory<Product,Integer>("id"));
           secondNameCol.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
           thirdNameCol.setCellValueFactory(new PropertyValueFactory<Product,Integer>("barcode"));
          
           secondNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
           secondNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Product, String>>() {
        	   @Override
        	   public void handle(CellEditEvent<Product, String> value) {
        	    String str = value.getNewValue();
        	    System.out.println(str);
        	    int activeRow = value.getTablePosition().getRow();
        	    value.getTableView().getItems().get(activeRow).setName(str);
        	   }



		
        	  });
           
           table.setItems(list);
          
           table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
          
//           group.getChildren().add(table);
           grid.add(table,0,0);
           
          
           /* add Button for adding to Table*/
           Button btn = new Button("add");
//           btn.setOnAction(event->list.add(new Product("NEWPRODUCT", (int)(1000*Math.random()))));
//           btn.setOnAction(event->product.create(new Product(text1.getText(),new Integer(text2.getText()))));
           btn.setOnAction(new MyEvent(product,list,text1,text2));
           

           //btn.setOnAction(new MyEvent());
//           group.getChildren().add(btn);
           grid.add(btn,1,0);
           grid.add(text1, 2, 0);
           grid.add(text2, 3, 0);
           group.getChildren().add(grid);
           
           return new Scene(group,600,400);
     }     
       class MyEvent implements EventHandler{
    	   ProductDaoImpl product;
    	   ObservableList<Product> list;
    	   TextField text1;
    	   TextField text2;
    	   
public MyEvent(ProductDaoImpl product, ObservableList<Product> list, TextField text1, TextField text2) {
			super();
			this.product = product;
			this.list = list;
			this.text1 = text1;
			this.text2 = text2;
		}
@Override
   public void handle(Event event) {
	Product newProduct=new Product(text1.getText(),new Integer(text2.getText()));
	product.create(newProduct);
    list.add(newProduct); 
   }
  }      
}
