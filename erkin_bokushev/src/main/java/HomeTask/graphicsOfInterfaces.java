package HomeTask;

import java.awt.Label;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*Задача2. Написать метод, который принимает два объекта любых типов и рисует в графике, иерархию общий классов.
(просто прямоугольниками BUTTON)*/

public class graphicsOfInterfaces extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		arg0.setTitle("Graphics of buttons");
		arg0.setScene(MyScene(new ArrayList<>(), new LinkedList<>()));
		arg0.show();
	}
	
	public Scene MyScene (Object obj1, Object obj2) {
		Class [] classes1 = myMethod(obj1);
		Class [] classes2 = myMethod(obj2);
		ArrayList<Class> commonClasses = new ArrayList<Class>();
		
		for (int i = 0; i < classes1.length; i++) {
			for (int k = 0; k < classes2.length; k++) {
				if (classes2[k] == classes1[i]) commonClasses.add(classes2[k]);
			}
		}
	
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.TOP_CENTER);
		gp.setVgap(20);
		gp.setPadding(new Insets(20, 25, 25, 25));
		HBox hb = new HBox();
		TitledPane tp = new TitledPane();
		tp.setText(obj1.getClass().getSimpleName() + " & " + obj2.getClass().getSimpleName());
		hb.getChildren().add(tp);
		gp.add(hb, 0, 0);
		
		for (int i = 0; i < commonClasses.size(); i++) {
			Button bt = new Button((i+1) + ". " + commonClasses.get(i).getSimpleName());
			bt.setStyle("-fx-background-color:#BEF781");
			Button strelka = new Button("----------------->");
			strelka.setStyle("-fx-background-color:#E6E6E6");
			if (i != commonClasses.size()-1)gp.add(strelka, i, i+2);
			gp.add(bt, i, i+1);
		}
		
		Scene scene = new Scene(gp);
		
		return scene;
	}
	
	public static Class [] myMethod (Object obj) {
		ArrayList<Class> list = new ArrayList<Class>();
		list.add(obj.getClass());
		for (int i = 0; i<list.size(); i++) {
			Class superCl = list.get(i).getSuperclass();
			if (superCl != null) list.add(superCl);
		}
		return list.toArray(new Class[0]);
	}
}
