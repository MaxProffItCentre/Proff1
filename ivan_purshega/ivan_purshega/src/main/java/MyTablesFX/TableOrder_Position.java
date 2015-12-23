package MyTablesFX;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.Order_PositionDaoImpl;
import data.Order_Position;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import util.HibernateUtil;

 

public class TableOrder_Position extends Application{
	private static Logger log = Logger.getLogger(TableOrder_Position.class);
	Order_PositionDaoImpl order_position=new Order_PositionDaoImpl();
      ObservableList<Order_Position> list = 
        FXCollections.observableArrayList(
        	order_position.findAll()
          );
       public static void main(String[] args) {
    	  
             launch();
       }
       @Override
       public void start(Stage stage) throws Exception {
             stage.setTitle("Table Order Position");
             stage.setScene(createScene());
             stage.show();  
             stage.setOnCloseRequest(event->HibernateUtil.getSession().close());
       }
 
       @SuppressWarnings("unchecked")
	public Scene createScene(){
           Group group = new Group();
           
           GridPane grid=new GridPane();
         
    
           TableView table = new TableView();
           table.setEditable(true);
          
           TableColumn firstNameCol = new TableColumn("id");
           TableColumn secondNameCol = new TableColumn("order_id");
           TableColumn thirdNameCol = new TableColumn("product_id");
           TableColumn fourthNameCol = new TableColumn("kol");
           TableColumn fivesdNameCol = new TableColumn("price");
           
                   
           firstNameCol.setCellValueFactory(new PropertyValueFactory<Order_Position,Integer>("id"));
           secondNameCol.setCellValueFactory(new PropertyValueFactory<Order_Position,String>("order_id"));
           thirdNameCol.setCellValueFactory(new PropertyValueFactory<Order_Position,String>("product_id"));
           fourthNameCol.setCellValueFactory(new PropertyValueFactory<Order_Position,String>("kol"));
           fivesdNameCol.setCellValueFactory(new PropertyValueFactory<Order_Position,String>("price"));
          
           table.setItems(list);
          
           table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol,fourthNameCol,fivesdNameCol);
          

           grid.add(table,0,0);
          
           group.getChildren().add(grid);
           
           return new Scene(group,600,400);
     }     
}
