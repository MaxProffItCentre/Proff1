package action10;

import dao.ProductDaoImpl;
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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import view.ProductViewer;

public class UpdateTableFxProductExamples extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Table Example Application");
		stage.setScene(createScene5());
		stage.show();
	}

	ObservableList<ProductViewer> list = FXCollections.observableArrayList(new ProductViewer(1, "Рыба", 123),
			new ProductViewer(2, "Колбаса", 456), new ProductViewer(3, "Огурец", 785),
			new ProductViewer(4, "Сардельки", 541));
	

	public Scene createScene5() {
		Group group = new Group();

		TableView<ProductViewer> table = new TableView<ProductViewer>();
		table.setEditable(true);

		TableColumn<ProductViewer, Integer> firstNameCol = new TableColumn<ProductViewer, Integer>("id");
		TableColumn<ProductViewer, String> secondNameCol = new TableColumn<ProductViewer, String>("name");
		TableColumn<ProductViewer, Integer> thirdNameCol = new TableColumn<ProductViewer, Integer>("code");

		firstNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, Integer>("id"));
		secondNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, String>("name"));
		thirdNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, Integer>("code"));
		
		ProductDaoImpl daoPr = new ProductDaoImpl();
		//create Observable list for Table
		ObservableList<ProductViewer> list2 = ProductViewer.createListOfProductsFromData(daoPr.findAll());
		
		table.setItems(list2);

		// table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
		table.getColumns().add(firstNameCol);
		table.getColumns().add(secondNameCol);
		table.getColumns().add(thirdNameCol);

		group.getChildren().add(table);

		// add Button /
		Button btn = new Button("add");
		// btn.setOnAction(event -> list.add(new ProductViewer(5, "NEWPRODUCT",
		// (int) (1000 * Math.random()))));
		btn.setOnAction(new MyEvent());
		group.getChildren().add(btn);

		// add eidtable cell /
		secondNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		secondNameCol.setOnEditCommit(new EventHandler<CellEditEvent<ProductViewer, String>>() {
			@Override
			public void handle(CellEditEvent<ProductViewer, String> value) {
				String str = value.getNewValue();
				int activeRow = value.getTablePosition().getRow();
				value.getTableView().getItems().get(activeRow).setName(str);
			}
		});

		return new Scene(group, 600, 400);
	}

	class MyEvent<T extends Event> implements EventHandler<T> {
		@Override
		public void handle(Event event) {
			// list.add(new ProductViewer(5, "NEWPRODUCT", (int) (1000 *
			// Math.random())));
			list.removeIf(prod -> prod.getId() < 3);
		}
	}
}
