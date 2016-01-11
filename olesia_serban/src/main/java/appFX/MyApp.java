package appFX;

import dao.ContractorDaoImpl;
import dao.EmployeesDaoImpl;
import dao.ProductDaoImpl;
import data.Contractor;
import data.Employee;

import data.Product;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.control.Tooltip;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import util.HibernateUtil;
import view.ContractorViewer;
import view.EmployeeViewer;
import view.ProductViewer;

public class MyApp extends Application {
	public static void main(String[] args) {
		launch(args);
		HibernateUtil.getSessionFactory().close();
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
		table.setPrefWidth(450);
		table.setPrefHeight(300);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.setLayoutX(100);

		// create table columns
		TableColumn<ProductViewer, Integer> firstNameCol = new TableColumn<ProductViewer, Integer>("id");
		TableColumn<ProductViewer, String> secondNameCol = new TableColumn<ProductViewer, String>("name");
		TableColumn<ProductViewer, Integer> thirdNameCol = new TableColumn<ProductViewer, Integer>("code");

		firstNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, Integer>("id"));
		secondNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, String>("name"));
		thirdNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, Integer>("code"));
		// thread for data connecting
		ProductDaoImpl daoPr = new ProductDaoImpl();
		Thread thr = new Thread(new Runnable() {

			@Override
			public void run() {

				// create Observable list for Table

				ObservableList<ProductViewer> list2 = ProductViewer.obsListFromData(daoPr.findAll());

				table.setItems(list2);

			}
		});

		thr.start();
		thr.interrupt();

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
				// change value of name in row
				event.getTableView().getItems().get(activeRow).setName(str);

			}
		});
		// set code on edit
		thirdNameCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		thirdNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ProductViewer, Integer>>() {

			@Override
			public void handle(CellEditEvent<ProductViewer, Integer> event) {
				// get new value for code
				int val = event.getNewValue();
				// find active row
				int activeRow = event.getTablePosition().getRow();
				// find id of product for data
				int id = event.getTableView().getItems().get(activeRow).getId();
				// cast id into Long value
				Long idLong = (long) id;
				// find product in data and update it
				Product pr = daoPr.read(idLong);
				pr.setBarcode(val);
				daoPr.update(pr);
				// change value of code in row
				event.getTableView().getItems().get(activeRow).setCode(val);
				;

			}
		});

		// add table to group
		group.getChildren().add(table);

		// create add button
		Button addBtn = new Button("add new product");
		addBtn.setLayoutX(100);
		addBtn.setLayoutY(350);
		Tooltip btnTip = new Tooltip();
		btnTip.setText("press to add new Product");
		addBtn.setTooltip(btnTip);
		// hBox for fields
		HBox boxik = new HBox();

		boxik.setLayoutX(250);
		boxik.setLayoutY(350);
		boxik.setSpacing(20);
		// fields for adding
		TextField nameField = new TextField();
		nameField.setMaxWidth(90);
		Tooltip tooltipName = new Tooltip();
		tooltipName.setText("Write Product name");
		nameField.setTooltip(tooltipName);

		TextField codeField = new IntegerTextField();
		codeField.setMaxWidth(50);
		Tooltip tooltipCode = new Tooltip();
		tooltipCode.setText("Write Product code and press Enter");
		codeField.setTooltip(tooltipCode);
		// Labels
		HBox labelBox = new HBox();
		labelBox.setLayoutX(250);
		labelBox.setLayoutY(330);
		labelBox.setSpacing(80);

		Label lbName = new Label("name:");
		lbName.setMaxSize(90, 20);
		Label lbCode = new Label("code:");
		lbCode.setMaxSize(50, 20);

		// boxik.getChildren().addAll(nameField, codeField);
		// button on action

		addBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				boxik.getChildren().addAll(nameField, codeField);
				group.getChildren().add(boxik);

				labelBox.getChildren().addAll(lbName, lbCode);
				group.getChildren().add(labelBox);

				addBtn.setMouseTransparent(true);

			}
		});
		// second field on action
		codeField.setOnAction(new EventHandler<ActionEvent>() {
			// add new item to data and table View
			@Override
			public void handle(ActionEvent event) {
				String str = nameField.getText();
				if (str.equals(""))
					return;
				String tmp = codeField.getText();
				if (tmp.equals(""))
					return;
				int code = Integer.parseInt(tmp);
				Product pr = new Product(str, code);

				daoPr.create(pr);
				ProductViewer prView = new ProductViewer(pr.getId().intValue(), pr.getName(), pr.getBarcode());
				table.getItems().add(prView);
				nameField.clear();
				codeField.clear();
				// group.getChildren().remove(boxik);

			}
		});
		//gridpane for delete system
		GridPane gridDel = new GridPane();
		gridDel.setLayoutY(400);
		gridDel.setLayoutX(100);
		gridDel.setHgap(50);
		//button "delete"
		Button delBtn = new Button("delete");
		//text field for id input
		IntegerTextField idTxt = new IntegerTextField();
		idTxt.setMaxWidth(50);
		//label for id text field
		Label idLb = new Label("id:");
		
		//tool tip for id Text Field
		Tooltip idTip = new Tooltip();
		idTip.setText("print id and press Enter");
		idTxt.setTooltip(idTip);
		
		gridDel.add(delBtn,0,1 );
		
		//delete button on Action
		delBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				delBtn.setMouseTransparent(true);
				gridDel.add(idTxt, 1, 1);
				gridDel.add(idLb, 1, 0);
				
			}
		});
		idTxt.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//daoPr
				String tmp = idTxt.getText();
				if(tmp.equals("")){
					return;
				}
				long id = Long.parseLong(tmp);
				Product pr = daoPr.read(id);
				ProductViewer viewPr = new ProductViewer(pr.getId().intValue(), pr.getName(), pr.getBarcode());
				daoPr.delete(pr);
				table.getItems().remove(viewPr);				
				idTxt.clear();
				
			}
		});
		// add button to group
		group.getChildren().add(addBtn);
		// group.getChildren().add(boxik);
		group.getChildren().add(gridDel);

		return group;

	}

	public Group createGroupForTab3() {

		// create group
		Group group = new Group();
		// create border pane
		// BorderPane border = new BorderPane();

		// create table
		TableView<ContractorViewer> table = new TableView<ContractorViewer>();
		table.setEditable(true);
		table.setPrefWidth(450);
		table.setPrefHeight(300);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		// create table columns
		TableColumn<ContractorViewer, Integer> firstNameCol = new TableColumn<ContractorViewer, Integer>("id");
		TableColumn<ContractorViewer, String> secondNameCol = new TableColumn<ContractorViewer, String>("name");

		firstNameCol.setCellValueFactory(new PropertyValueFactory<ContractorViewer, Integer>("id"));
		secondNameCol.setCellValueFactory(new PropertyValueFactory<ContractorViewer, String>("name"));

		ContractorDaoImpl contrDao = new ContractorDaoImpl();
		// create Observable list for Table

		Thread thr = new Thread(new Runnable() {

			@Override
			public void run() {
				ObservableList<ContractorViewer> list = ContractorViewer.obsListFromData(contrDao.findAll());
				table.setItems(list);
			}
		});
		thr.start();
		thr.interrupt();
		// table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {

				table.getColumns().add(firstNameCol);
				table.getColumns().add(secondNameCol);

			}
		});
		th2.start();
		th2.interrupt();

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
		// border.setCenter(table);

		return group;

	}

	public Group createGroupForTab4() {
		// create group
		Group group = new Group();
		// create table
		TableView<EmployeeViewer> table = new TableView<>();
		table.setEditable(true);
		table.setPrefWidth(450);
		table.setPrefHeight(300);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		// create columns
		TableColumn<EmployeeViewer, Integer> firstColumn = new TableColumn<>("id");
		TableColumn<EmployeeViewer, String> secondColumn = new TableColumn<>("name");
		TableColumn<EmployeeViewer, Integer> thirdColumn = new TableColumn<>("salary");

		firstColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		secondColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		thirdColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

		// taking Employees from data
		EmployeesDaoImpl dao = new EmployeesDaoImpl();

		Thread thr = new Thread(new Runnable() {

			@Override
			public void run() {
				ObservableList<EmployeeViewer> list = EmployeeViewer.obsListFromData(dao.findAll());
				table.setItems(list);
			}
		});
		thr.start();
		thr.interrupt();
		// add columns
		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				table.getColumns().add(firstColumn);
				table.getColumns().add(secondColumn);
				table.getColumns().add(thirdColumn);

			}
		});
		th2.start();
		th2.interrupt();

		// set name column on edit
		secondColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		secondColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EmployeeViewer, String>>() {

			@Override
			public void handle(CellEditEvent<EmployeeViewer, String> event) {
				String newValue = event.getNewValue();

				int row = event.getTablePosition().getRow();

				// Employee id for updating
				int id = event.getTableView().getItems().get(row).getId();
				Employee emp = dao.read((long) id);
				emp.setName(newValue);
				dao.update(emp);

				// change name in column
				event.getTableView().getItems().get(row).setName(newValue);
			}
		});
		// set salary on edit
		thirdColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		thirdColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EmployeeViewer, Integer>>() {

			@Override
			public void handle(CellEditEvent<EmployeeViewer, Integer> event) {
				int newValue = event.getNewValue();

				int row = event.getTablePosition().getRow();

				// Employee id for updating
				int id = event.getTableView().getItems().get(row).getId();
				Employee emp = dao.read((long) id);
				emp.setSalary(newValue);
				dao.update(emp);

				// change name in column
				event.getTableView().getItems().get(row).setSalary(newValue);

			}
		});

		group.getChildren().add(table);

		return group;

	}

}
