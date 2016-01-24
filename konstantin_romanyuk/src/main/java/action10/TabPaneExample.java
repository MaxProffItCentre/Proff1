 package action10;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;

public class TabPaneExample extends Application{
 public static void main(String[] args) {
  launch(args);
 }
 @Override
 public void start(Stage primaryStage) throws Exception {
  primaryStage.setTitle("Table Example Application");
  primaryStage.setScene(createScene());
  primaryStage.show();
  
 }
 public Scene createScene(){
  TabPane tabPane = new TabPane();
  
  Tab tab1 = new Tab("Закладка 1");
  tab1.setContent(createPane1());
  
  Tab tab2 = new Tab("Закладка 2");
  tab2.setContent(createPane2());
  
  tabPane.getTabs().addAll(tab1,tab2);
  
  return new Scene(tabPane,800,600);
 }
 public Group createPane1(){
  Group group = new Group();
  
  Button btn = new Button("Button 1");
  btn.setTooltip(new Tooltip("Кнопка 1"));
  
  group.getChildren().add(btn);
  
  return group;
 }
 public Group createPane2(){
  Group group = new Group();
  
  Button btn = new Button("Button 2");
  btn.setTooltip(new Tooltip("Кнопка 2"));
  
  group.getChildren().add(btn);
  
  return group;
 }
 
}