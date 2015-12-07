package TableOrder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Order extends Application {
	static ArrayList <Button> buttonHelp=buttonHelp();
	static String [] strOfTable=strOfTable();
	static ArrayList <TextField> table=table(strOfTable);
	private GridPane grid1=grid1();
	private GridPane grid2=grid2();
	private GridPane grid3=grid3(table,strOfTable);
	private GridPane grid4=grid4(buttonHelp);

	
	public static void main(String[] args) {
		launch(args);
		
	}

	private  GridPane grid1(){
    GridPane grid1=new GridPane();
		grid1.setAlignment(Pos.TOP_CENTER);
		grid1.setHgap(20);
		grid1.setVgap(20);
		grid1.setMinWidth(100);
		grid1.setPadding(new Insets(0, 0, 0, 25));
		
		Text main =new Text("ORDERS");
		main.setStyle("-fx-font-size: 25;");
		grid1.add(main,0,0);
		return grid1;
	}
	
	private GridPane grid2(){
		GridPane grid2=new GridPane();
		grid2.setAlignment(Pos.TOP_LEFT);
		grid2.setHgap(20);
		grid2.setVgap(20);
		grid2.setMinWidth(100);
		grid2.setPadding(new Insets(0, 0, 0, 25));
		
		String [] str={"Number order","Manager","Buyer","Date order",
				"Planned production date","Status","      Total number of:","      Total to pay:",
				};
		ArrayList <Text> text=new ArrayList<Text>();
		ArrayList <TextField> buttons =new ArrayList<TextField>();
	
		for(int i=0; i<str.length;i++){
			text.add(new Text());
			text.get(i).setText(str[i]);
			grid2.add(text.get(i),0,i+1);
			
			buttons.add(new TextField());
			buttons.get(i).setMinWidth(150);
			buttons.get(i).setStyle("-fx-background-color: black,gainsboro");
			grid2.add(buttons.get(i), 1, i+1);
		}
		return grid2;
	}
	
	private static String[] strOfTable(){
		String[] str={"№","Name","Amount","Price without NDS","Total without NDS",
				"Price with NDS","Total with NDS"};
		return str;
	}
	
	private static ArrayList<TextField> table(String[]str){
		ArrayList <TextField> buttons =new ArrayList<TextField>();
		int buton=0;
		for(int i=0;i<str.length;i++){
			for(int j=0; j<str.length;j++){
			buttons.add(new TextField());
			if(i==0){buttons.get(j).setStyle("-fx-background-color: black,gainsboro");
			buttons.get(buton).setText(str[j]);}
			else buttons.get(buton).setStyle("-fx-background-color: black,white");
			if(j==0)buttons.get(buton).setMaxWidth(40);
			else if (j==1)buttons.get(buton).setMinWidth(250);
			else if (j==2)buttons.get(buton).setMinWidth(70);
			else buttons.get(buton).setMinWidth(140);
			buton++;
			}
		} return buttons;
	}
	
private GridPane grid3(ArrayList<TextField> buttons,String []string) {
	GridPane grid3=new GridPane();
	GridPane gridText=new GridPane();

	grid3.setPadding(new Insets(0, 0, 0, 0));
	Text text=new Text("Order specification:");
	 gridText.add(text,0,0);
	 int buton=0;
	for(int i=0;i<string.length;i++){
		for(int j=0; j<string.length;j++){
		grid3.add(buttons.get(buton), j, i+1);
		buton++;
		}
	}
	
	GridPane gridLast = new GridPane();
	gridLast.add(gridText, 0, 0);
	gridLast.add(grid3, 0, 1);
	return gridLast;
	}

private static ArrayList <Button> buttonHelp(){
	String [] buttonsMenu={"F1-help","F2-save order","F4-change","F7-add new position",
			"F8-delete psition from order","F10-exit","F11-import order","F12-export order"};
	ArrayList <Button> buttonHelp=new ArrayList<Button>();
	for(int i=0; i<buttonsMenu.length;i++){
		buttonHelp.add(new Button());
		buttonHelp.get(i).setText(buttonsMenu[i]);
	}
		return buttonHelp;
}
	
 	private GridPane grid4(ArrayList <Button> butt) {
 		GridPane gridHelp=new GridPane();
 		gridHelp.setHgap(20);
 		
		for(int i=0; i<butt.size();i++){
			gridHelp.add(buttonHelp.get(i), i, 0);
		}
		return gridHelp;
		
 	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ORDERS");
		stage.setScene(createScene());
		stage.show();
		
	}
	
	public  Scene createScene() {
		
		GridPane grid5=new GridPane();
		grid5.setAlignment(Pos.TOP_LEFT);
		grid5.setHgap(20);
		grid5.setVgap(20);
		grid5.setMinWidth(100);
		grid5.setPadding(new Insets(0, 0, 0, 25));
		
		grid5.add(grid1, 0, 0);
		grid5.add(grid2, 0, 1);
		grid5.add(grid3, 0, 2);
		grid5.add(grid4, 0, 3);
		
		
		buttonHelp.get(7).setOnAction(new MyEvent2<ActionEvent>(table,strOfTable,buttonHelp.get(7).getText()));
		
		Scene scene = new Scene(grid5,1200, 700);
		return scene;
	}
}


class MyEvent2<T> implements EventHandler {
	ArrayList<TextField> table;
	String[] strOfTable;
	
	String str;
	public MyEvent2(ArrayList<TextField> table,String[]str,String str2) {
		this.table=table;
		strOfTable=str;
		this.str=str2;
		
	}

	@Override
	public void handle(Event arg0) {
		if (str.equals("F12-export order")){
			 try {
				FileWriter fw = new FileWriter("file.txt");
				int textField=strOfTable.length;
				int k=0;
				for(int i=0; i<3;i++){
					k=0;
					for(int j=0; j<strOfTable.length;j++){
						if(table.get(textField).getText().equals("") && j==0)break;
						fw.write(table.get(k).getText()+" : " +
								table.get(textField).getText()+"\n");
						textField++;
						k++;
					} 
				}
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	
	
	
	
}

