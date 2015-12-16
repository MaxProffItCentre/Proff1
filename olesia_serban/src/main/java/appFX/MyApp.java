package appFX;

import dao.ContractorDaoImpl;
import dao.ProductDaoImpl;
import data.Contractor;
import data.Product;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.ContractorViewer;
import view.ProductViewer;

public class MyApp extends Application {
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("My Manager app");
		primaryStage.setScene(createScene());
		primaryStage.show();

	}

	public Scene createScene() {
		TabPane tabPane = new TabPane();

		Tab tab1 = new Tab("Main page");
		tab1.setContent(createGroupForTab1());
		tab1.setClosable(false);

		Tab tab2 = new Tab("Products");
		tab2.setContent(createGroupForTab2());
		tab2.setClosable(false);

		Tab tab3 = new Tab("Contractors");
		tab3.setContent(createGroupForTab3());
		tab3.setClosable(false);

		Tab tab4 = new Tab("Employees");
		tab4.setContent(createGroupForTab4());
		tab4.setClosable(false);

		tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);

		Scene scene = new Scene(tabPane, 750, 700);

		return scene;

	}

	public Group createGroupForTab1() {
		// texts
		Text headline = new Text("Orders");
		headline.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		// labels
		Label labelNumOfOrder = new Label("Order no.");

		Label labelManager = new Label("Manger");

		Label labelClient = new Label("Client");

		Label labelOrderDate = new Label("Order Date");

		Label labelTargetDate = new Label("Target date of Production");

		Label labelStatuts = new Label("Status");

		Label labelTotalAmount = new Label("Total amount");

		Label labelSumForPay = new Label("Total sum for payment");

		// text fields
		TextField numOfOrderField = new TextField();
		numOfOrderField.setEditable(true);

		TextField mangerField = new TextField();
		mangerField.setEditable(true);

		TextField clientField = new TextField();
		clientField.setEditable(true);

		TextField orderDateField = new TextField();
		orderDateField.setEditable(true);

		TextField targetDateField = new TextField();
		targetDateField.setEditable(true);

		TextField statusField = new TextField();
		statusField.setEditable(false);
		statusField.setMouseTransparent(true);

		TextField totalAmField = new TextField();
		totalAmField.setEditable(false);
		totalAmField.setMouseTransparent(true);

		TextField sumForPayField = new TextField();
		sumForPayField.setEditable(false);
		sumForPayField.setMouseTransparent(true);

		// buttons
		Button helpBtn = new Button("F1 - help");
		Button saveBtn = new Button("F2 - save order");
		Button editBtn = new Button("F4 - edit");
		Button addNewItemBtn = new Button("F7 - add new item");
		Button deleteItemBtn = new Button("F8 - delete item");
		Button exitBtn = new Button("F10 - exit");
		Button importBtn = new Button("F11 - import order");
		Button exportBtn = new Button("F12 - export order");

		// create grid for data input
		GridPane generalGrid = new GridPane();
		generalGrid.setPadding(new Insets(10, 10, 10, 10));
		generalGrid.setAlignment(Pos.TOP_LEFT);
		generalGrid.setVgap(5);
		generalGrid.setHgap(5);

		// add children
		generalGrid.add(headline, 5, 0);
		generalGrid.add(labelNumOfOrder, 0, 1);
		generalGrid.add(numOfOrderField, 1, 1);
		generalGrid.add(labelManager, 0, 2);
		generalGrid.add(mangerField, 1, 2);
		generalGrid.add(labelClient, 0, 3);
		generalGrid.add(clientField, 1, 3);
		generalGrid.add(labelOrderDate, 0, 4);
		generalGrid.add(orderDateField, 1, 4);
		generalGrid.add(labelTargetDate, 0, 5);
		generalGrid.add(targetDateField, 1, 5);
		generalGrid.add(labelStatuts, 0, 6);
		generalGrid.add(statusField, 1, 6);
		generalGrid.add(labelTotalAmount, 0, 8);
		generalGrid.add(totalAmField, 1, 8);
		generalGrid.add(labelSumForPay, 0, 9);
		generalGrid.add(sumForPayField, 1, 9);

		// Hbox for buttons
		HBox buttonBox = new HBox();
		buttonBox.setLayoutX(15);
		buttonBox.setLayoutY(650);
		buttonBox.setAlignment(Pos.BOTTOM_CENTER);

		buttonBox.getChildren().add(helpBtn);
		buttonBox.getChildren().add(saveBtn);
		buttonBox.getChildren().add(editBtn);
		buttonBox.getChildren().add(addNewItemBtn);
		buttonBox.getChildren().add(deleteItemBtn);
		buttonBox.getChildren().add(exitBtn);
		buttonBox.getChildren().add(importBtn);
		buttonBox.getChildren().add(exportBtn);

		// create Group
		Group root = new Group();

		root.getChildren().add(generalGrid);
		root.getChildren().add(buttonBox);
		return root;

	}

	public Group createGroupForTab2() {
		// create group
		Group group = new Group();

		// create table
		TableView<ProductViewer> table = new TableView<ProductViewer>();
		table.setEditable(true);

		// create table columns
		TableColumn<ProductViewer, Integer> firstNameCol = new TableColumn<ProductViewer, Integer>("id");
		TableColumn<ProductViewer, String> secondNameCol = new TableColumn<ProductViewer, String>("name");
		TableColumn<ProductViewer, Integer> thirdNameCol = new TableColumn<ProductViewer, Integer>("code");

		firstNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, Integer>("id"));
		secondNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, String>("name"));
		thirdNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, Integer>("code"));

		ProductDaoImpl daoPr = new ProductDaoImpl();
		// create Observable list for Table
		ObservableList<ProductViewer> list2 = ProductViewer.createListOfProductsFromData(daoPr.findAll());

		table.setItems(list2);

		// table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
		table.getColumns().add(firstNameCol);
		table.getColumns().add(secondNameCol);
		table.getColumns().add(thirdNameCol);

		// set name on edit
		secondNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		secondNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ProductViewer, String>>() {

			@Override
			public void handle(CellEditEvent<ProductViewer, String> event) {
				// get new value for name
				String str = event.getNewValue();
				// find active row
				int activeRow = event.getTablePosition().getRow();
				// find id of product for data
				int id = event.getTableView().getItems().get(activeRow).getId();
				// cast id into Long value
				Long idLong = (long) id;
				// find product in data and update it
				Product pr = daoPr.read(idLong);
				pr.setName(str);
				daoPr.update(pr);
				// change value of name i row
				event.getTableView().getItems().get(activeRow).setName(str);

			}
		});

		// add table to group
		group.getChildren().add(table);

		return group;

	}

	public Group createGroupForTab3() {

		// create group
		Group group = new Group();

		// create table
		TableView<ContractorViewer> table = new TableView<ContractorViewer>();
		table.setEditable(true);

		// create table columns
		TableColumn<ContractorViewer, Integer> firstNameCol = new TableColumn<ContractorViewer, Integer>("id");
		TableColumn<ContractorViewer, String> secondNameCol = new TableColumn<ContractorViewer, String>("name");

		firstNameCol.setCellValueFactory(new PropertyValueFactory<ContractorViewer, Integer>("id"));
		secondNameCol.setCellValueFactory(new PropertyValueFactory<ContractorViewer, String>("name"));

		ContractorDaoImpl contrDao = new ContractorDaoImpl();
		// create Observable list for Table
		ObservableList<ContractorViewer> list = ContractorViewer.createListOfContractorsFromData(contrDao.findAll());

		table.setItems(list);

		// table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
		table.getColumns().add(firstNameCol);
		table.getColumns().add(secondNameCol);

		// set name on edit
		secondNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		secondNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ContractorViewer, String>>() {

			@Override
			public void handle(CellEditEvent<ContractorViewer, String> event) {
				// get new value for name
				String str = event.getNewValue();
				// find active row
				int activeRow = event.getTablePosition().getRow();
				// find id of product for data
				int id = event.getTableView().getItems().get(activeRow).getId();
				// cast id into Long value
				Long idLong = (long) id;
				// find product in data and update it
				Contractor cont = contrDao.read(idLong);
				cont.setName(str);
				contrDao.update(cont);
				// change value of name i row
				event.getTableView().getItems().get(activeRow).setName(str);

			}
		});

		// add table to group
		group.getChildren().add(table);

		return group;

	}

	public Group createGroupForTab4() {
		return null;

	}

}
