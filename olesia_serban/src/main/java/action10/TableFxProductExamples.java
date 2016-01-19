package action10;

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

public class TableFxProductExamples extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Table Example Application");
		stage.setScene(createScene4());
		stage.show();
	}

	public Scene createScene1() {
		Group group = new Group();

		TableView table = new TableView();

		TableColumn firstNameCol = new TableColumn("field 1");
		TableColumn secondNameCol = new TableColumn("field 2");
		TableColumn thirdNameCol = new TableColumn("field 3");

		table.getColumns().addAll(firstNameCol, secondNameCol, thirdNameCol);

		group.getChildren().add(table);

		return new Scene(group, 600, 400);
	}

	public Scene createScene2() {
		Group group = new Group();

		TableView table = new TableView();

		TableColumn firstNameCol = new TableColumn("field 1");
		TableColumn secondNameCol = new TableColumn("field 2");
		TableColumn superNameCol = new TableColumn("super");
		TableColumn super1NameCol = new TableColumn("super1");
		TableColumn super2NameCol = new TableColumn("super2");

		superNameCol.getColumns().addAll(super1NameCol, super2NameCol);
		table.getColumns().addAll(firstNameCol, secondNameCol, superNameCol);

		group.getChildren().add(table);

		return new Scene(group, 600, 400);
	}

	ObservableList<ProductViewer> list = FXCollections.observableArrayList(new ProductViewer(1, "Р С‹Р±Р°", 123),
			new ProductViewer(2, "РљРѕР»Р±Р°СЃР°", 456), new ProductViewer(3, "РћРіСѓСЂРµС†", 785),
			new ProductViewer(4, "РЎР°СЂРґРµР»СЊРєРё", 541));

	public Scene createScene3() {
		Group group = new Group();

		TableView table = new TableView();

		TableColumn firstNameCol = new TableColumn("id");
		TableColumn secondNameCol = new TableColumn("name");
		TableColumn thirdNameCol = new TableColumn("code");

		firstNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, Integer>("id"));
		secondNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, String>("name"));
		thirdNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, Integer>("code"));

		table.setItems(list);

		table.getColumns().addAll(firstNameCol, secondNameCol, thirdNameCol);

		group.getChildren().add(table);

		return new Scene(group, 600, 400);
	}

	public Scene createScene4() {
		Group group = new Group();

		TableView<ProductViewer> table = new TableView<ProductViewer>();
		table.setEditable(true);

		TableColumn<ProductViewer, Integer> firstNameCol = new TableColumn<ProductViewer, Integer>("id");
		TableColumn<ProductViewer, String> secondNameCol = new TableColumn<ProductViewer, String>("name");
		TableColumn<ProductViewer, Integer> thirdNameCol = new TableColumn<ProductViewer, Integer>("code");

		firstNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, Integer>("id"));
		secondNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, String>("name"));
		thirdNameCol.setCellValueFactory(new PropertyValueFactory<ProductViewer, Integer>("code"));

		table.setItems(list);

		// table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
		table.getColumns().add(firstNameCol);
		table.getColumns().add(secondNameCol);
		table.getColumns().add(thirdNameCol);

		group.getChildren().add(table);

		/* add Button */
		Button btn = new Button("add");
		//btn.setOnAction(event -> list.add(new ProductViewer(5, "NEWPRODUCT", (int) (1000 * Math.random()))));
		 btn.setOnAction(new MyEvent());
		group.getChildren().add(btn);

		/* add eidtable cell */
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
			//list.add(new ProductViewer(5, "NEWPRODUCT", (int) (1000 * Math.random())));
			list.removeIf(prod->prod.getId()<3);
		}
	}
}
