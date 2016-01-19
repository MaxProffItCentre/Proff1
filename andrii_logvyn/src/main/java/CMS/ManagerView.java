package CMS;

import CMS.Events.ButtonF12Event;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ManagerView extends Application {
	Zakaz zakaz = new Zakaz();
	@Override
	public void start(Stage stage) {
		stage.setTitle("Manager");
		stage.setScene(createScene());
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public Scene createScene(){
		Label labelTop = new Label("ЗАКАЗЫ");
		labelTop.setStyle("-fx-font-weight: bold;");
		SplitPane pane = new SplitPane();
		pane.setOrientation(Orientation.VERTICAL);
		Label lNumberZakaz = new Label("Номер заказа");
		Label lManager = new Label("Менеджер");
		Label lClient = new Label("Покупатель");
		Label lDateZakaz = new Label("Дата заказа");
		Label lDatePlanProduction = new Label("Плановая дата производства");
		Label lStatus = new Label("Статус");
		Label lAmountZakaz = new Label("Итого количество");
		Label lPriceAll = new Label("Итого сумма к оплате");
		
//		TextField numberZakaz = new TextField(); 
//		TextField manager = new TextField();
//		TextField client = new TextField();
//		DatePicker dateZakaz = new DatePicker();
//		DatePicker datePlanProduction = new DatePicker();
//		TextField status = new  TextField();
//		TextField amountZakaz = new TextField();
//		TextField priceAll = new  TextField();
		
		Button btnF1 = new Button(" F1 ");
		Button btnF2 = new Button(" F2 ");
		Button btnF4 = new Button(" F4 ");
		Button btnF7 = new Button(" F7 ");
		Button btnF8 = new Button(" F8 ");
		Button btnF10 = new Button(" F10 ");
		Button btnF11 = new Button(" F11 ");
		Button btnF12 = new Button(" F12 ");
		btnF11.setOnAction(new Events.ButtonF11Event<ActionEvent>(zakaz));
		btnF12.setOnAction(new Events.ButtonF12Event<ActionEvent>(zakaz));
		//btnF1.setPrefSize(5, 4);
		
		GridPane root = new GridPane();
		root.setPrefSize(900, 300);
		root.setHgap(20);
	    root.setVgap(10);
	    
	    TableView<String> tableZakaz = new TableView<String>();
	    tableZakaz.setEditable(true);
	    //tableZakaz.getColumns().
	    TableColumn indexColumn = new TableColumn("№");
	    TableColumn nameColumn = new TableColumn("Наименование");
	    TableColumn kolvoColumn = new TableColumn("Кол-во");
	    TableColumn priceNotNDSColumn = new TableColumn("цена без ндс");
	    TableColumn summNotNDSColumn = new TableColumn("сумма без ндс");
	    TableColumn priceNDSColumn = new TableColumn("цена с ндс");
	    TableColumn summNDSColumn = new TableColumn("сумма с ндс");
	    tableZakaz.getColumns().addAll(indexColumn, nameColumn, kolvoColumn, priceNotNDSColumn, summNotNDSColumn,
	    		 priceNDSColumn, summNDSColumn);
	    tableZakaz.setPrefSize(600, 300);
	    //tableZakaz.;
		//root.setGridLinesVisible(true);
		HBox box = new HBox(10);
		box.getChildren().addAll(btnF1, btnF2, btnF4, btnF7, btnF8, btnF10, btnF11, btnF12);
		
		root.add(box, 2, 0);
		root.add(labelTop, 5, 1);
		root.add(lNumberZakaz, 2, 3);
		root.add(lManager, 2, 4);
		root.add(lClient, 2, 5);
		root.add(lDateZakaz, 2, 6);
		root.add(lDatePlanProduction, 2, 7);
		root.add(lStatus, 2, 8);
		root.add(lAmountZakaz, 2, 9);
		root.add(lPriceAll, 2, 10);
		//root.add(labelTop, 15, 1);
		root.add(zakaz.getNumberZakaz(), 4, 3);
		root.add(zakaz.getManager(), 4, 4);
		root.add(zakaz.getClient(), 4, 5);
		root.add(zakaz.getDateZakaz(), 4, 6);
		root.add(zakaz.getDatePlanProduction(), 4, 7);
		root.add(zakaz.getStatus(), 4, 8);
		root.add(zakaz.getAmountZakaz(), 4, 9);
		root.add(zakaz.getPriceAll(), 4, 10);
		pane.getItems().add(root);
		pane.getItems().add(tableZakaz);
		//scene.(tableZakaz, 4, 12);
		Scene scene = new Scene(pane, 900,600);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent key) {
				if(key.getCode() == KeyCode.F12){
					ButtonF12Event<ActionEvent> ev = new Events.ButtonF12Event<ActionEvent>(zakaz);
					ev.handle(key);
				}
				
			}});
		return scene;
	}
}
