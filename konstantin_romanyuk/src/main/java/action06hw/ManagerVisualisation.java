package action06hw;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ManagerVisualisation extends Application{
	private GridPane grid = new GridPane();
	
	public static void main(String[] args) {
		
		launch(args);}
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("MANAGER");
		primaryStage.setScene(createScene1());
		primaryStage.show();
		
	}

	public Scene createScene1() {
		grid.setGridLinesVisible(true);
		grid.setHgap(40);
		grid.setVgap(20);
		grid.add((new Label("Заказы")), 3, 0);
		grid.add(new Label("Номер заказа"), 1, 2);
		grid.add(new TextField(), 2, 2);
		grid.add(new Label("Менеджер"), 1, 3);
		grid.add(new TextField(), 2, 3);
		grid.add(new Label("Покупатель"), 1, 4);
		grid.add(new TextField(), 2, 4);
		grid.add(new Label("Дата заказа"), 1, 5);
		grid.add(new TextField(), 2, 5);
		grid.add(new Label("Плановая Дата производства"), 1, 6);
		grid.add(new TextField(), 2, 6);
		grid.add(new Label("Статус заказа"), 1,7);
		grid.add((new TextField()), 2, 7);
		Button f5=new Button("F5 save");
		Button f6=new Button("F6 open");
		f5.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event) {
					
					
				}});
				
		grid.add(f5, 1, 15);
		grid.add(f6, 5, 15);
		Scene scene=new Scene(grid, 800,600);
		return scene;
	}

 
	 
 }
 
