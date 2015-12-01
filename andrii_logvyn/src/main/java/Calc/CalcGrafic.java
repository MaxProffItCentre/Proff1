package Calc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CalcGrafic extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("SuperCalc");
		stage.setScene(createScene());
		stage.show();

	}

	public Scene createScene() {
		
		char[] charsButton = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', '+', '-', '*', '/', '=', 'C' };
		Button[] buttons = new Button[charsButton.length];
		GridPane root = new GridPane();
		GridPane childGrid = new GridPane();
		TextField textRezultField = new TextField();
		MenuBar menuBar = new MenuBar();
		Menu menuFile = new Menu("  File  ");
		MenuItem exitMenu = new MenuItem("  Exit  ");
		
		exitMenu.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {
		        System.exit(0);
		    }
		});
		
		menuBar.getMenus().add(menuFile);
		menuFile.getItems().add(exitMenu);
		Font fTextField = new Font(25);
		Font fButtons = new Font(25);
		root.setAlignment(Pos.TOP_CENTER);
		root.setPadding(new Insets(25, 25, 25, 25));
		root.setHgap(50);
		root.setVgap(10);
		childGrid.setAlignment(Pos.CENTER);
		childGrid.setHgap(50);
		childGrid.setVgap(10);
		textRezultField.setMinSize(280, 40);
		textRezultField.setFont(fTextField);
		root.add(textRezultField, 0, 1);
		root.add(menuBar, 0, 0);
		

		for (int i = 0; i < charsButton.length; i++) {
			buttons[i] = new Button("" + charsButton[i]);
			buttons[i].setMinSize(50, 50);
			buttons[i].setOnAction(new CalcEvents.ButtonEvent<ActionEvent>(textRezultField));
			buttons[i].setFont(fButtons);

		}
		int xB = 0;
		int yB = 0;
		for (int i = 0; i < buttons.length; i++) {
			childGrid.add(buttons[i], yB++, xB);
			if (yB == 3) {
				xB++;
				yB = 0;
			}
		}

		root.add(childGrid, 0, 2);
		Scene scene = new Scene(root, 300, 500);

		return scene;
	}

	public static void main(String[] args) {
		launch();
	}

}

