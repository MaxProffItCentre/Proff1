package action10;

import java.util.List;
import java.util.Set;

import dao.ContructorDaoImpl;
import dao.EmployeesDaoImpl;
import dao.OrdersDaoImp;
import dao.ProductDaoImpl;
import dao.RoleDaoImpl;
import dao.UserDaoImpl;
import data.Contructor;
import data.Employee;
import data.Order;
import data.Product;
import data.Role;
import data.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import util.HibernateUtil;
import view.ContructorViewer;
import view.EmployeeViewer;
import view.OrderViewer;
import view.ProductViewer;
import view.RoleViewer;
import view.UserViewer;

public class CRMFX extends Application{
	 private static ProductDaoImpl daoProduct=new ProductDaoImpl();
	 private static ContructorDaoImpl daoContructor=new ContructorDaoImpl();
	 private static OrdersDaoImp daoOrder=new OrdersDaoImp();
	 private static EmployeesDaoImpl daoEmployee=new EmployeesDaoImpl();
	 private static UserDaoImpl daoUser=new UserDaoImpl();
	 private static RoleDaoImpl daoRole=new RoleDaoImpl();
	 
	 public static void main(String[] args) {
		 
		  launch(args);
		  HibernateUtil.getSessionFactory().close();
		 }
		 @Override
		 public void start(Stage primaryStage) throws Exception {
		  primaryStage.setTitle("First CRM");
		  primaryStage.setScene(createScene());
		  primaryStage.show();
		  
		 }
		 public Scene createScene(){
		  TabPane tabPane = new TabPane();
		  
		  Tab tab1 = new Tab("Product");
		  tab1.setContent(createPane1());
		  
		  Tab tab2 = new Tab("Contructor");
		  tab2.setContent(createPane2());
		  
		  Tab tab3 = new Tab("Employee");
		  tab3.setContent(createPane3());
		  
		  Tab tab4 = new Tab("Users");
		  tab4.setContent(createPane4());
		  
		  Tab tab5 = new Tab("Roles");
		  tab5.setContent(createPane5());
		  
		  tabPane.getTabs().addAll(tab1,tab2,tab3,tab4,tab5);
		  
		  return new Scene(tabPane,800,600);
		 }
		
		/*// Editable Name
			secondNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
			secondNameCol.setOnEditCommit(new EventHandler<CellEditEvent<ProductViewer, String>>() {
				@Override
				public void handle(CellEditEvent<ProductViewer, String> value) {
					String str = value.getNewValue();
					int activeRow = value.getTablePosition().getRow();
					ProductViewer productViewer = value.getTableView().getItems().get(activeRow);
					productViewer.setName(str);
					
					// update product by DataBase
					servisProduct.updateProduct(productViewer.toProduct());
				}
			});
			// Editable Code
			thirdNameCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
			thirdNameCol.setOnEditCommit(new EventHandler<CellEditEvent<ProductViewer, Integer>>() {
				@Override
				public void handle(CellEditEvent<ProductViewer, Integer> value) {
					Integer val = value.getNewValue();
					int activeRow = value.getTablePosition().getRow();
					ProductViewer productViewer = value.getTableView().getItems().get(activeRow);
					productViewer.setCode(val);
					
					// update product by DataBase
					servisProduct.updateProduct(productViewer.toProduct());
				}
			});*/
		 public Group createPane1(){
		  Group group = new Group();
		   TableView<ProductViewer> table = new TableView<ProductViewer>();
		  table.setEditable(true);
		  

		  TableColumn<ProductViewer, Integer> firstNameCol = new TableColumn<ProductViewer, Integer>("id");
		  TableColumn<ProductViewer, String> secondNameCol = new TableColumn<ProductViewer, String>("name");
		  TableColumn<ProductViewer, Integer> thirdNameCol = new TableColumn<ProductViewer, Integer>("code");

		  firstNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, Integer>("id"));
		  secondNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, String>("name"));
		  thirdNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, Integer>("code"));
		  /*secondNameCol.setCellFactory(TextFieldTableCell.forTableColumn());;
		  secondNameCol.setOnEditCommit(event->{
			 Product newProd=daoProduct.read(table.getSelectionModel().getSelectedItem().getId());
			 newProd.setName(table.getSelectionModel().getSelectedItem().getName());
					daoProduct.update(newProd);});*/
		  secondNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		secondNameCol.setOnEditCommit(new EventHandler<CellEditEvent<ProductViewer, String>>() {
				public void handle(CellEditEvent<ProductViewer, String> value) {
					String str = value.getNewValue();
					int activeRow = value.getTablePosition().getRow();
					ProductViewer productViewer = value.getTableView().getItems().get(activeRow);
					productViewer.setName(str);
					
					// update product by DataBase
					daoProduct.update(new Product(productViewer.getId(),productViewer.getName(),productViewer.getCode()));
				}
			});

		  table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
    
		  //group.getChildren().add(table);
		  GridPane grid=new GridPane();
		  HBox hBox=new HBox();
		  TextField txt=new TextField("Name");
		  txt.visibleProperty().set(false);
		  TextField txt2=new TextField("Barcode");
		  txt2.visibleProperty().set(false);
		  Button btn1 = new Button("Show All");
		  btn1.setTooltip(new Tooltip("Show"));
		  btn1.setOnAction(event-> table.setItems(CreateListP(daoProduct.findAll())));
		  Button btn2 = new Button("Add");
		  btn2.setTooltip(new Tooltip("Add"));
		  btn2.setOnAction(event->{txt.visibleProperty().set(true);
		  txt.setOnAction(event2->{daoProduct.create(new Product(txt.getText())); txt.clear();txt.visibleProperty().set(false);});
		  });
		  Button btn3 = new Button("Delete");
		  btn3.setOnAction(event->{daoProduct.delete(daoProduct.read(table.getSelectionModel().getSelectedItem().getId()));});
		  hBox.getChildren().addAll(btn1,btn2,btn3);
		 /* grid.add(btn1, 0, 0);
		  grid.add(btn2, 1, 0);
		  grid.add(btn3, 2, 0);*/
		  grid.add(txt, 3, 0);
		  grid.add(hBox, 0, 0);
		  grid.add(table, 0, 1);
		  group.getChildren().add(grid);
		  
		  return group;
		 }
		 
		 public Group createPane2(){
		 Group group = new Group();
		  TableView<ContructorViewer> table=new TableView<ContructorViewer>();
          table.setEditable(true);
          	  
		  TableColumn<ContructorViewer, Long> firstNameCol = new TableColumn<ContructorViewer, Long>("id");
		  TableColumn<ContructorViewer, String> secondNameCol = new TableColumn<ContructorViewer, String>("name");
		  firstNameCol.setCellValueFactory(new PropertyValueFactory<ContructorViewer, Long>("id"));
		  secondNameCol.setCellValueFactory(new PropertyValueFactory<ContructorViewer, String>("name"));
		  
		  table.getColumns().addAll(firstNameCol,secondNameCol);
		
		  
		  TableView<OrderViewer> tableInfo=new TableView<OrderViewer>();
		  tableInfo.setVisible(false);
         	  
		  TableColumn<OrderViewer, Long> firstNameCol2 = new TableColumn<OrderViewer, Long>("id");
		  TableColumn<OrderViewer, String> secondNameCol2 = new TableColumn<OrderViewer, String>("name");
		  TableColumn<OrderViewer, Long> thirdNameCol2 = new TableColumn<OrderViewer, Long>("summa");
		  firstNameCol2.setCellValueFactory(new PropertyValueFactory<OrderViewer, Long>("id"));
		  secondNameCol2.setCellValueFactory(new PropertyValueFactory<OrderViewer, String>("name"));
		 thirdNameCol2.setCellValueFactory(new PropertyValueFactory<OrderViewer, Long>("summa"));
		  
		  tableInfo.getColumns().addAll(firstNameCol2,secondNameCol2,thirdNameCol2);
		  
		  table.setOnMouseClicked((event->{tableInfo.setItems(CreateListO(daoContructor.read(table.getSelectionModel().getSelectedItem().getId()).getOrders()));
			  tableInfo.setVisible(true);
			  ;}));
		 // group.getChildren().add(0,table);
		 
		  GridPane grid=new GridPane();
		  TextField txt=new TextField();
		  HBox hBox=new HBox();
		  Button btn1 = new Button("Show All");
		  btn1.setTooltip(new Tooltip("Show"));
		  btn1.setOnAction(event-> table.setItems(CreateListC(daoContructor.findAll())));
		  Button btn2 = new Button("Add");
		  btn2.setTooltip(new Tooltip("Add"));
		  btn2.setOnAction(event->{daoContructor.create(new Contructor(txt.getText()));table.setItems(CreateListC(daoContructor.findAll()));
		  txt.clear();
		  });
		  Button btn3 = new Button("Delete");
		  btn3.setOnAction(event->{daoContructor.delete(daoContructor.read(table.getSelectionModel().getSelectedItem().getId()));
		  table.setItems(CreateListC(daoContructor.findAll()));});
		  Button btn4 = new Button("Info");
		  btn4.setOnAction(event->{tableInfo.setItems(CreateListO(daoContructor.read(table.getSelectionModel().getSelectedItem().getId()).getOrders()));
			  tableInfo.setVisible(true);
			  ;});
		 /* grid.add(btn1, 0, 0);
		  grid.add(btn2, 1, 0);
		  grid.add(btn3, 2, 0);
		  grid.add(btn4, 4, 0);*/
		 hBox.getChildren().addAll(btn1,btn2,btn3,btn4);
		  grid.add(hBox, 0, 0);
		  grid.add(txt, 3, 0);
		 grid.add(table, 0, 1);
		  grid.add(tableInfo, 2, 1);
		 	  
		 // group.getChildren().add(tableInfo);
		  group.getChildren().add(grid);
		 
		  return group;
		 }
		 public Group createPane3(){
			  Group group = new Group();
			  TableView<EmployeeViewer> table = new TableView<EmployeeViewer>();
			  table.setEditable(true);
			  

			  TableColumn<EmployeeViewer, Integer> firstNameCol = new TableColumn<EmployeeViewer, Integer>("id");
			  TableColumn<EmployeeViewer, String> secondNameCol = new TableColumn<EmployeeViewer, String>("name");
			  TableColumn<EmployeeViewer, Integer> thirdNameCol = new TableColumn<EmployeeViewer, Integer>("Salary");

			  firstNameCol.setCellValueFactory(new PropertyValueFactory<EmployeeViewer, Integer>("id"));
			  secondNameCol.setCellValueFactory(new PropertyValueFactory<EmployeeViewer, String>("name"));
			  thirdNameCol.setCellValueFactory(new PropertyValueFactory<EmployeeViewer, Integer>("Salary"));
			  table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
			    
			  GridPane grid=new GridPane();
			  TextField txt=new TextField("Name");
			  txt.visibleProperty().set(false);
			  TextField txt2=new TextField("Salary");
			  txt2.visibleProperty().set(false);
			  HBox hBox=new HBox();
			  Button btn1 = new Button("Show All");
			  btn1.setTooltip(new Tooltip("Show"));
			  btn1.setOnAction(event-> table.setItems(CreateListE(daoEmployee.findAll())));
			  Button btn2 = new Button("Add");
			  btn2.setTooltip(new Tooltip("Add"));
			  btn2.setOnAction(event->{txt.visibleProperty().set(true); 
			  txt.setOnAction(event2->{txt2.visibleProperty().set(true);
			  txt2.setOnAction(event3->{daoEmployee.create(new Employee(txt.getText(),Long.parseLong(txt2.getText()))); txt.clear();txt.visibleProperty().set(false);
			  txt2.clear();txt2.visibleProperty().set(false);table.setItems(CreateListE(daoEmployee.findAll())); });
			  });
			  });
			  Button btn3 = new Button("Delete");
			  btn3.setOnAction(event->{daoEmployee.delete(daoEmployee.read(table.getSelectionModel().getSelectedItem().getId()));
			  table.setItems(CreateListE(daoEmployee.findAll()));});
			  hBox.getChildren().addAll(btn1,btn2,btn3);
			  grid.add(hBox, 0, 0);
			  grid.add(txt, 3, 0);
			  grid.add(txt2, 4, 0);
			  grid.add(table, 0, 1);
			  group.getChildren().add(grid);
			  
			  return group;
			 }
		 
		 
			public Node createPane5() {
				 Group group=new Group();
				 TableView<RoleViewer> table = new TableView<RoleViewer>();
				  table.setEditable(true); 
				TableColumn<RoleViewer, Integer> firstNameCol = new TableColumn<RoleViewer, Integer>("id");
				  TableColumn<RoleViewer, String> secondNameCol = new TableColumn<RoleViewer, String>("name");
				  TableColumn<RoleViewer, String> thirdNameCol = new TableColumn<RoleViewer, String>("comment");
				  
				  firstNameCol.setCellValueFactory(new PropertyValueFactory<RoleViewer, Integer>("id"));
				  secondNameCol.setCellValueFactory(new PropertyValueFactory<RoleViewer, String>("name"));
				  thirdNameCol.setCellValueFactory(new PropertyValueFactory<RoleViewer, String>("comment"));
					  table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
				    
				  GridPane grid=new GridPane();
				  TextField txt=new TextField("Name");
				  TextField txt2=new TextField("Comment");
				  txt2.visibleProperty().set(false);
				  txt.visibleProperty().set(false);
				  HBox hBox=new HBox();
				  Button btn1 = new Button("Show All");
				  btn1.setTooltip(new Tooltip("Show"));
				  btn1.setOnAction(event-> table.setItems(CreateListR(daoRole.findAll())));
				  Button btn2 = new Button("Add");
				  btn2.setTooltip(new Tooltip("Add"));
				  btn2.setOnAction(event->{txt.visibleProperty().set(true);
				  txt.setOnAction(event2->{txt2.visibleProperty().set(true); 
				  txt2.setOnAction(event3->{daoRole.create(new Role(txt.getText(),txt2.getText())); 
				  txt.clear();txt.visibleProperty().set(false);
				  txt2.clear();txt2.visibleProperty().set(false);
				  table.setItems(CreateListR(daoRole.findAll())); });
				  });
				  });
				  Button btn3 = new Button("Delete");
				  btn3.setOnAction(event->{daoRole.delete(daoRole.read(table.getSelectionModel().getSelectedItem().getId())); table.setItems(CreateListR(daoRole.findAll()));});
				  hBox.getChildren().addAll(btn1,btn2,btn3);
				  grid.add(hBox, 0, 0);
				  grid.add(txt, 3, 0);
				  grid.add(txt2, 3, 0);
				  grid.add(table, 0, 1);
				 
				group.getChildren().add(grid);
				  
				  return group;
			}
			public Group createPane4() {
				 Group group=new Group();
				 TableView<UserViewer> table = new TableView<UserViewer>();
				  table.setEditable(true); 
				TableColumn<UserViewer, Integer> firstNameCol = new TableColumn<UserViewer, Integer>("id");
				  TableColumn<UserViewer, String> secondNameCol = new TableColumn<UserViewer, String>("name");
				  TableColumn<UserViewer, String> thirdNameCol = new TableColumn<UserViewer, String>("login");
				  TableColumn<UserViewer, String> fourthNameCol = new TableColumn<UserViewer, String>("pass");

				  firstNameCol.setCellValueFactory(new PropertyValueFactory<UserViewer, Integer>("id"));
				  secondNameCol.setCellValueFactory(new PropertyValueFactory<UserViewer, String>("name"));
				  thirdNameCol.setCellValueFactory(new PropertyValueFactory<UserViewer, String>("login"));
				  fourthNameCol.setCellValueFactory(new PropertyValueFactory<UserViewer, String>("pass"));
				  table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol,fourthNameCol);
				    
				  GridPane grid=new GridPane();
				  TextField txt=new TextField("Name");
				  TextField txt2=new TextField("Login");
				  TextField txt3=new TextField("Password");
				  txt.visibleProperty().set(false);txt2.visibleProperty().set(false);txt3.visibleProperty().set(false);
				  HBox hBox=new HBox();
				  Button btn1 = new Button("Show All");
				  btn1.setTooltip(new Tooltip("Show"));
				  btn1.setOnAction(event-> table.setItems(CreateListU(daoUser.findAll())));
				  Button btn2 = new Button("Add");
				  btn2.setTooltip(new Tooltip("Add"));
				  btn2.setOnAction(event->{txt.visibleProperty().set(true);
				  txt.setOnAction(event2->{txt2.visibleProperty().set(true); 
				  txt2.setOnAction(event3->{txt3.visibleProperty().set(true);
				  txt3.setOnAction(event4->{daoUser.create(new User(txt.getText(),txt2.getText(),txt3.getText())); txt.clear();txt.visibleProperty().set(false);
				  txt2.clear();txt2.visibleProperty().set(false);txt3.clear();txt3.visibleProperty().set(false);table.setItems(CreateListU(daoUser.findAll())); });
				  });
				  });
				  });
				
				  Button btn3 = new Button("Delete");
				  btn3.setOnAction(event->{daoUser.delete(daoUser.read(table.getSelectionModel().getSelectedItem().getId()));});
				  hBox.getChildren().addAll(btn1,btn2,btn3);
				  grid.add(hBox, 0, 0);
				  grid.add(txt, 3, 0);
				  grid.add(txt2, 3, 0);
				  grid.add(txt3, 3, 0);
				  grid.add(table, 0, 1);
				 
				group.getChildren().add(grid);
				  
				  return group;
							}
		 public static ObservableList<ProductViewer> CreateListP(List<Product> list){
			 ObservableList<ProductViewer> newList=FXCollections.observableArrayList();
			 for (Product product:list){newList.add(new ProductViewer(product.getId(), product.getName(), product.getBarcode()));}
			 return newList;}
		 
		 public static ObservableList<ContructorViewer> CreateListC(List<Contructor> list){
			 ObservableList<ContructorViewer> newList=FXCollections.observableArrayList();
			 for (Contructor product:list){newList.add(new ContructorViewer(product.getId(), product.getName()));}
			 return newList;}
		 
		 public static ObservableList<OrderViewer> CreateListO(List<Order> list){
			 ObservableList<OrderViewer> newList=FXCollections.observableArrayList();
			 for (Order product:list){newList.add(new OrderViewer(product.getId(), product.getNumber(), product.getSumma()));}
			 return newList;}
		 
		 public static ObservableList<EmployeeViewer> CreateListE(List<Employee> list){
			 ObservableList<EmployeeViewer> newList=FXCollections.observableArrayList();
			 for (Employee product:list){newList.add(new EmployeeViewer(product.getId(), product.getName(), product.getSalary()));}
			  return newList;}
		 
		 public static ObservableList<UserViewer> CreateListU(List<User> list){
			 ObservableList<UserViewer> newList=FXCollections.observableArrayList();
			 for (User product:list){newList.add(new UserViewer(product.getId(), product.getName(), product.getLogin(), product.getPass()));}
			  return newList;}
		 
		 public static ObservableList<RoleViewer> CreateListR(List<Role> list){
			 ObservableList<RoleViewer> newList=FXCollections.observableArrayList();
			 for (Role product:list){newList.add(new RoleViewer(product.getId(), product.getName(), product.getComment()));}
			  return newList;}
		
}