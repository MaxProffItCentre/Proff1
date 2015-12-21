package MyTablesFX;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.ContructorDaoImpl;
import dao.EmployeeDaoImpl;
import data.Employee;
import data.Product;
import data.contructor;
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

 

public class TableContructor extends Application{
	private static Logger log = Logger.getLogger(TableContructor.class);
	ContructorDaoImpl contruct=new ContructorDaoImpl();
      ObservableList<contructor> list = 
        FXCollections.observableArrayList(
        		contruct.findAll()
          );
       public static void main(String[] args) {
    	  
             launch();
       }
       @Override
       public void start(Stage stage) throws Exception {
             stage.setTitle("Table of contructors");
             stage.setScene(createScene());
             stage.show();      
       }
 
       @SuppressWarnings("unchecked")
	public Scene createScene(){
           Group group = new Group();
           
           GridPane grid=new GridPane();
           TextField text1=new TextField();
           
           
          
       
           TableView table = new TableView();
           table.setEditable(true);
          
           TableColumn firstNameCol = new TableColumn("id");
           TableColumn secondNameCol = new TableColumn("name");
         
          
  
                   
           firstNameCol.setCellValueFactory(new PropertyValueFactory<contructor,Integer>("id"));
           secondNameCol.setCellValueFactory(new PropertyValueFactory<contructor,String>("name"));
           
          
           secondNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
           secondNameCol.setOnEditCommit(new EventHandler<CellEditEvent<contructor, String>>() {
        	   @Override
        	   public void handle(CellEditEvent<contructor, String> value) {
        	    String str = value.getNewValue();
        	    System.out.println(str);
        	    int activeRow = value.getTablePosition().getRow();
        	    value.getTableView().getItems().get(activeRow).setName(str);
        	    Long id=value.getTableView().getItems().get(activeRow).getId();
        	    Session session = HibernateUtil.getSessionFactory().openSession();
      		  try {

      		   session.beginTransaction();
      		   Query query = session.createQuery("update Contructors set name='"+ str + "' where id=" + id);
      		   query.executeUpdate();
      		   session.getTransaction().commit();
      		   } catch (HibernateException e) {
   	            log.error("Transaction failed");
   	            session.getTransaction().rollback();
   	        } finally {
   	            session.close();
   	        }
        	   }
        	  });
           
           table.setItems(list);
          
           table.getColumns().addAll(firstNameCol,secondNameCol);
          

           grid.add(table,0,0);
         
           Button btn = new Button("add");

           btn.setOnAction(new MyEvent(contruct,list,text1));
           
           Button delete = new Button("delete");
           delete.setOnAction(new MyEvent2(contruct,list,table));
           
          
           
           grid.add(btn,1,0);
           grid.add(text1, 2, 0);
           
           grid.add(delete, 0, 1);
           group.getChildren().add(grid);
           
           return new Scene(group,600,400);
     }     
       class MyEvent implements EventHandler{
    	   ContructorDaoImpl contructor;
    	   ObservableList<contructor> list;
    	   TextField text1;
    	  
    	   
public MyEvent(ContructorDaoImpl contructor, ObservableList<contructor> list, TextField text1) {
			super();
			this.contructor = contructor;
			this.list = list;
			this.text1 = text1;
			
		}
@Override
   public void handle(Event event) {
	contructor newContructor=new contructor(text1.getText());
	contructor.create(newContructor);
    list.add(newContructor); 
   }
  }      
       class MyEvent2 implements EventHandler{
    	   ContructorDaoImpl contructor;
    	   ObservableList<contructor> list;
    	   TableView table;
    	 
    	   
public MyEvent2(ContructorDaoImpl contructor, ObservableList<contructor> list,TableView table) {
			super();
			this.table=table;
			this.contructor = contructor;
			this.list = list;
		
		}
@Override
   public void handle(Event event) {
	int row = table.getSelectionModel().getSelectedIndex();
	Long id=list.get(row).getId();
	System.out.println("id"+id);
	
	table.getItems().remove(row);
	Session session = HibernateUtil.getSessionFactory().openSession();
	  try {

	   session.beginTransaction();
	   Query query = session.createQuery("DELETE FROM  contructor where id="+id);
	   query.executeUpdate();
	   session.getTransaction().commit();
	   } catch (HibernateException e) {
         log.error("Transaction failed");
         session.getTransaction().rollback();
     } finally {
         session.close();
     } 
   }
  }      
}