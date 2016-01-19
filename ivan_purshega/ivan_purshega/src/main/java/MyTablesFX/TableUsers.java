package MyTablesFX;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import dao.ProductDaoImpl;
import dao.UserDaoImpl;
import data.Product;
import data.User;
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

 

public class TableUsers extends Application{
	private static Logger log = Logger.getLogger(TableUsers.class);
	  UserDaoImpl user=new UserDaoImpl();
      ObservableList<User> list = 
        FXCollections.observableArrayList(
       		 user.findAll()
          );
       public static void main(String[] args) {
    	  
             launch();
       }
       @Override
       public void start(Stage stage) throws Exception {
             stage.setTitle("Table of Users");
             stage.setScene(createScene());
             stage.show();      
       }
 
       @SuppressWarnings("unchecked")
	public Scene createScene(){
           Group group = new Group();
           
           GridPane grid=new GridPane();
           TextField TextFieldName=new TextField();
           TextField TextFieldLogin=new TextField();
           TextField TextFieldPass=new TextField();
           TextField TextFieldEmployee_id=new TextField();
           
          
       
           TableView table = new TableView();
           table.setEditable(true);
          
           TableColumn firstNameCol = new TableColumn("id");
           TableColumn secondNameCol = new TableColumn("name");
           TableColumn thirdNameCol = new TableColumn("login");
           TableColumn fourthNameCol = new TableColumn("pass");
           TableColumn fivesNameCol = new TableColumn("employee_id");
          
  
                   
           firstNameCol.setCellValueFactory(new PropertyValueFactory<User,Integer>("id"));
           secondNameCol.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
           thirdNameCol.setCellValueFactory(new PropertyValueFactory<User,String>("login"));
           fourthNameCol.setCellValueFactory(new PropertyValueFactory<User,Integer>("pass"));
           fivesNameCol.setCellValueFactory(new PropertyValueFactory<User,Integer>("employee_id"));
           
           secondNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
           secondNameCol.setOnEditCommit(new EventHandler<CellEditEvent<User, String>>() {
        	   @Override
        	   public void handle(CellEditEvent<User, String> value) {
        	    String str = value.getNewValue();
        	    System.out.println(str);
        	    int activeRow = value.getTablePosition().getRow();
        	    value.getTableView().getItems().get(activeRow).setName(str);
        	    Long id=value.getTableView().getItems().get(activeRow).getId();
        	    Session session = HibernateUtil.getSessionFactory().openSession();
      		  try {

      		   session.beginTransaction();
      		   Query query = session.createQuery("update User set name='"+ str + "' where id=" + id);
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
          
           table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol,fourthNameCol,fivesNameCol);
          

           grid.add(table,0,0);
         
           Button btn = new Button("add");

           btn.setOnAction(new MyEvent(user,list,TextFieldName,TextFieldLogin,TextFieldPass,TextFieldEmployee_id));
           
           Button delete = new Button("delete");
           delete.setOnAction(new MyEvent2(user,list,table));
           
          
           
           grid.add(btn,1,0);
           grid.add(TextFieldName, 2, 0);
           grid.add(TextFieldLogin, 3, 0);
           grid.add(TextFieldPass, 4, 0);
           grid.add(TextFieldEmployee_id, 5, 0);
           grid.add(delete, 0, 1);
           group.getChildren().add(grid);
           
           return new Scene(group,600,400);
     }     
       class MyEvent implements EventHandler{
    	   UserDaoImpl user;
    	   ObservableList<User> list;
    	   TextField TextFieldName;
    	   TextField TextFieldLogin;
    	   TextField TextFieldPass;
    	   TextField TextFieldEmployee_id;
    	   
    	   
public MyEvent(UserDaoImpl user, ObservableList<User> list, TextField TextFieldName, TextField TextFieldLogin,
		TextField TextFieldPass,TextField TextFieldEmployee_id	) {
			super();
			this.user = user;
			this.list = list;
			this.TextFieldName= TextFieldName;
			this.TextFieldLogin = TextFieldLogin;
			this.TextFieldPass=TextFieldPass;
			this.TextFieldEmployee_id=TextFieldEmployee_id;
		}
@Override
   public void handle(Event event) {
	User newUser=new User(TextFieldName.getText(),TextFieldLogin.getText(),
			new Integer(TextFieldPass.getText()),new Integer(TextFieldEmployee_id.getText()));
	user.create(newUser);
    list.add(newUser); 
   }
  }      
       class MyEvent2 implements EventHandler{
    	   UserDaoImpl user;
    	   ObservableList<User> list;
    	   TableView table;
    	 
    	   
public MyEvent2(UserDaoImpl user, ObservableList<User> list,TableView table) {
			super();
			this.table=table;
			this.user = user;
			this.list = list;
		
		}
@Override
   public void handle(Event event) {
	int row = table.getSelectionModel().getSelectedIndex();
	Long id=list.get(row).getId(); 
	table.getItems().remove(row);
	user.delete(user.findAll().get(row));
         }
       }
}
