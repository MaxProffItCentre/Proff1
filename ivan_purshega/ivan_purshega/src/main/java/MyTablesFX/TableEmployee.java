package MyTablesFX;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.EmployeeDaoImpl;
import data.Employee;
import data.Product;
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

 

public class TableEmployee extends Application{
	private static Logger log = Logger.getLogger(TableEmployee.class);
	  EmployeeDaoImpl employee=new EmployeeDaoImpl();
      ObservableList<Employee> list = 
        FXCollections.observableArrayList(
        		employee.findAll()
          );
       public static void main(String[] args) {
    	  
             launch();
       }
       @Override
       public void start(Stage stage) throws Exception {
             stage.setTitle("Table of employees");
             stage.setScene(createScene());
             stage.show();      
       }
 
       @SuppressWarnings("unchecked")
	public Scene createScene(){
           Group group = new Group();
           
           GridPane grid=new GridPane();
           TextField text1=new TextField();
           TextField text2=new TextField();
           
          
       
           TableView table = new TableView();
           table.setEditable(true);
          
           TableColumn firstNameCol = new TableColumn("id");
           TableColumn secondNameCol = new TableColumn("name");
           TableColumn thirdNameCol = new TableColumn("salary");
          
  
                   
           firstNameCol.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("id"));
           secondNameCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
           thirdNameCol.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("salary"));
          
           secondNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
           secondNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>() {
        	   @Override
        	   public void handle(CellEditEvent<Employee, String> value) {
        	    String str = value.getNewValue();
        	    System.out.println(str);
        	    int activeRow = value.getTablePosition().getRow();
        	    value.getTableView().getItems().get(activeRow).setName(str);
        	    Long id=value.getTableView().getItems().get(activeRow).getId();
        	    Session session = HibernateUtil.getSessionFactory().openSession();
      		  try {

      		   session.beginTransaction();
      		   Query query = session.createQuery("update Employee set name='"+ str + "' where id=" + id);
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
          
           table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
          

           grid.add(table,0,0);
         
           Button btn = new Button("add");

           btn.setOnAction(new MyEvent(employee,list,text1,text2));
           
           Button delete = new Button("delete");
           delete.setOnAction(new MyEvent2(employee,list,table));
           
          
           
           grid.add(btn,1,0);
           grid.add(text1, 2, 0);
           grid.add(text2, 3, 0);
           grid.add(delete, 0, 1);
           group.getChildren().add(grid);
           
           return new Scene(group,600,400);
     }     
       class MyEvent implements EventHandler{
    	   EmployeeDaoImpl employee;
    	   ObservableList<Employee> list;
    	   TextField text1;
    	   TextField text2;
    	   
public MyEvent(EmployeeDaoImpl employee, ObservableList<Employee> list, TextField text1, TextField text2) {
			super();
			this.employee = employee;
			this.list = list;
			this.text1 = text1;
			this.text2 = text2;
		}
@Override
   public void handle(Event event) {
	Employee newProduct=new Employee(text1.getText(),new Integer(text2.getText()));
	employee.create(newProduct);
    list.add(newProduct); 
   }
  }      
       class MyEvent2 implements EventHandler{
    	   EmployeeDaoImpl employee;
    	   ObservableList<Employee> list;
    	   TableView table;
    	 
    	   
public MyEvent2(EmployeeDaoImpl employee, ObservableList<Employee> list,TableView table) {
			super();
			this.table=table;
			this.employee = employee;
			this.list = list;
		
		}
@Override
   public void handle(Event event) {
	int row = table.getSelectionModel().getSelectedIndex();
	Long id=list.get(row).getId();
	table.getItems().remove(row);
	employee.delete(employee.findAll().get(row));
	}
  }      
}