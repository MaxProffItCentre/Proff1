package action09;

	import javafx.application.Application;
	import javafx.beans.property.SimpleIntegerProperty;
	import javafx.beans.property.SimpleStringProperty;
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.event.Event;
	import javafx.event.EventHandler;
	import javafx.scene.Group;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.cell.PropertyValueFactory;
	import javafx.stage.Stage;
	import view.ProductViewer;
	 

	public class TableFxProductExamples extends Application{
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
	       ObservableList<ProductViewer> list = 
	         FXCollections.observableArrayList(
	               new ProductViewer(1, "Рыба", 123),
	               new ProductViewer(2, "Колбаса", 456),
	               new ProductViewer(3, "Огурец", 785),
	               new ProductViewer(4, "Сардельки", 541)
	           );
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
	          
	           TableView table = new TableView();
	           table.setEditable(true);
	          
	           TableColumn firstNameCol = new TableColumn("id");
	           TableColumn secondNameCol = new TableColumn("name");
	           TableColumn thirdNameCol = new TableColumn("code");
	          
	  
	                   
	           firstNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer,Integer>("id"));
	           secondNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer,String>("name"));
	           thirdNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer,Integer>("code"));
	          
	           table.setItems(list);
	          
	           table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
	          
	           group.getChildren().add(table);
	          
	           /* add Button for adding to Table*/
	           Button btn = new Button("add");
	           btn.setOnAction(event->list.add(new ProductViewer(5,"NEWPRODUCT", (int)(1000*Math.random()))));
	           //btn.setOnAction(new MyEvent());
	           group.getChildren().add(btn);
	          
	           return new Scene(group,600,400);
	     }     
	       class MyEvent implements EventHandler{
	   @Override
	   public void handle(Event event) {
	    list.add(new ProductViewer(5,"NEWPRODUCT", (int)(1000*Math.random())));    
	   }
	  }      
	}


