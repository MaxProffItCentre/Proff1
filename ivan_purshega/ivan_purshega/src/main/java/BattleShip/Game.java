package BattleShip;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends Application {
	static private int[][] pole=new int[8][8];
	static private int[][] pole2=new int[8][8];
	
	

	
	public boolean addShip(Ship ship){
	
		 int count=ship.getCount();
		 int x=(int)(0+8*Math.random());
		 int y=(int)(0+8*Math.random());
		
			
			 int xy=(int)(0+2*Math.random()); 
			 if(xy==0){
				 while(proverkaX(x,y,count)!=true){
					 x=(int)(0+8*Math.random());
					 y=(int)(0+8*Math.random());
				 } 
			 for(int i=0;i<count;i++){
			 ship.addLocation(x+i,y);
			 pole[x+i][y]=1;
			 areaAroundShipX(x,y,i);
			 }
			 areaAroundShipX2(x,y,count);
			 }
			 if(xy==1){
				 while(proverkaY(x,y,count)!=true){
					 x=(int)(0+8*Math.random());
					 y=(int)(0+8*Math.random());
				 } 
			 
				 for(int i=0;i<count;i++){
				 ship.addLocation(x,y+i);
				 pole[x][y+i]=1;
				 areaAroundShipY(x,y,i);
				 }
				 areaAroundShipY2(x,y,count);
				}
		 return true;
	}
	
	
	
	
	public boolean addShip2(Ship ship){
		
		 int count=ship.getCount();
		 int x=(int)(0+8*Math.random());
		 int y=(int)(0+8*Math.random());
		
			
			 int xy=(int)(0+2*Math.random()); 
			 if(xy==0){
				 while(proverkaXEnemy(x,y,count)!=true){
					 x=(int)(0+8*Math.random());
					 y=(int)(0+8*Math.random());
				 } 
			 for(int i=0;i<count;i++){
			 ship.addLocation(x+i,y);
			 pole2[x+i][y]=1;
			 areaAroundShipXEnemy(x,y,i);
			 }
			 areaAroundShipX2Enemy(x,y,count);
			 }
			 if(xy==1){
				 while(proverkaYEnemy(x,y,count)!=true){
					 x=(int)(0+8*Math.random());
					 y=(int)(0+8*Math.random());
				 } 
			 
				 for(int i=0;i<count;i++){
				 ship.addLocation(x,y+i);
				 pole2[x][y+i]=1;
				 areaAroundShipYEnemy(x,y,i);
				 }
				 areaAroundShipY2Enemy(x,y,count);
				}
		 return true;
	}
	
	
	
	
	
	
	public boolean proverkaX(int x, int y, int size){
		if(x+size>8) return false;
		for(int i=0; i<size;i++){
			if(pole[x+i][y]==1 || pole[x+i][y]==2) return false;
		}
		
		return true;
	}
	
	
	public void areaAroundShipX(int x, int y, int i){
		if(y!=0) pole[x+i][y-1]=2;
		 if(y!=7) pole [x+i][y+1]=2;
	}
	
	public void areaAroundShipX2(int x, int y, int count){
		 int p=count-1;
		 if(x!=0) pole [x-1][y]=2;
		 if(x!=0 && y!=0) pole [x-1][y-1]=2;
		 if(x!=0 && y!=7) pole [x-1][y+1]=2;
		 if(x+p!=7) pole[x+count][y]=2;
		 if(x+p!=7 && y!=0) pole [x+count][y-1]=2;
		 if(x+p!=7 && y!=7) pole [x+count][y+1]=2;
	}
	
	
	public boolean proverkaY(int x, int y, int size){
		if(y+size>8) return false;
		for(int i=0; i<size;i++){
			if(pole[x][y+i]==1 || pole[x][y+i]==2) return false;
		}
		
		return true;
	}
	
	public void areaAroundShipY(int x, int y, int i){
		 if(x!=0) pole[x-1][y+i]=2;
		 if(x!=7) pole[x+1][y+i]=2;
	}
	
	public void areaAroundShipY2(int x, int y, int count){
		 int p=count-1;
		 if(y!=0) pole [x][y-1]=2;
		 if(y!=0 && x!=0) pole [x-1][y-1]=2;
		 if(y!=0 && x!=7) pole [x+1][y-1]=2;
		 if(y+p!=7) pole[x][y+count]=2;
		 if(y+p!=7 && x!=0) pole [x-1][y+count]=2;
		 if(y+p!=7 && x!=7) pole [x+1][y+count]=2;
	}
	
	
	public boolean proverkaXEnemy(int x, int y, int size){
		if(x+size>8) return false;
		for(int i=0; i<size;i++){
			if(pole2[x+i][y]==1 || pole2[x+i][y]==2) return false;
		}
		
		return true;
	}
	
	
	public void areaAroundShipXEnemy(int x, int y, int i){
		if(y!=0) pole2[x+i][y-1]=2;
		 if(y!=7) pole2 [x+i][y+1]=2;
	}
	
	public void areaAroundShipX2Enemy(int x, int y, int count){
		 int p=count-1;
		 if(x!=0) pole2 [x-1][y]=2;
		 if(x!=0 && y!=0) pole2 [x-1][y-1]=2;
		 if(x!=0 && y!=7) pole2 [x-1][y+1]=2;
		 if(x+p!=7) pole2[x+count][y]=2;
		 if(x+p!=7 && y!=0) pole2 [x+count][y-1]=2;
		 if(x+p!=7 && y!=7) pole2 [x+count][y+1]=2;
	}
	
	
	public boolean proverkaYEnemy(int x, int y, int size){
		if(y+size>8) return false;
		for(int i=0; i<size;i++){
			if(pole2[x][y+i]==1 || pole2[x][y+i]==2) return false;
		}
		
		return true;
	}
	
	public void areaAroundShipYEnemy(int x, int y, int i){
		 if(x!=0) pole2[x-1][y+i]=2;
		 if(x!=7) pole2[x+1][y+i]=2;
	}
	
	public void areaAroundShipY2Enemy(int x, int y, int count){
		 int p=count-1;
		 if(y!=0) pole2 [x][y-1]=2;
		 if(y!=0 && x!=0) pole2 [x-1][y-1]=2;
		 if(y!=0 && x!=7) pole2 [x+1][y-1]=2;
		 if(y+p!=7) pole2[x][y+count]=2;
		 if(y+p!=7 && x!=0) pole2 [x-1][y+count]=2;
		 if(y+p!=7 && x!=7) pole2 [x+1][y+count]=2;
	}
	
	
	
	
	
	
	public void goToFX(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
	
		stage.setTitle("Battle");
		stage.setScene(createScene());
		stage.show();
	}
	
	public Scene createScene(){
		
		
		GridPane grid=new GridPane();
		GridPane MyField=new GridPane();
		GridPane ShooterField=new GridPane();
		
		
		
		Button[] buttons=new Button[64];
		for(int i=0; i<buttons.length;i++){
			buttons[i]=new Button();
			buttons[i].setMaxSize(30, 30);
			buttons[i].setMinSize(30, 30);
		}
		int index=0;
		
		for(int i=0; i<8;i++){
			for(int j=0; j<8;j++){
				MyField.add(buttons[index], j, i);
				if(pole[i][j]==1)buttons[index].setStyle("-fx-background-color:red");
				index++;
			}
			}
		
		Button[] ShootButtons=new Button[64];
		for(int i=0; i<ShootButtons.length;i++){
			ShootButtons[i]=new Button();
			ShootButtons[i].setMaxSize(30, 30);
			ShootButtons[i].setMinSize(30, 30);
		}
		int ShootIndex=0;
		
		for(int i=0; i<8;i++){
			for(int j=0; j<8;j++){
				ShooterField.add(ShootButtons[ShootIndex], j, i);
				ShootIndex++;
			}
			}
		int but=0;
		for(int i=0; i<8;i++){
			for(int j=0; j<8;j++){
				int but1=but;
			int k=i; int k1=j;
			ShootButtons[but].setOnAction((event) -> {
		if(pole2[k][k1]==1)ShootButtons[but1].setStyle("-fx-background-color:red");
		if(pole2[k][k1]!=1)ShootButtons[but1].setStyle("-fx-background-color:green");
	});
		but++;
		}
		}
		
		grid.setHgap(20);
		grid.setVgap(20);
		Text text1 = new Text("My Base");
		Text text2 = new Text("Enemy Base");
		grid.add(text1, 2, 0);
		grid.add(text2, 2, 3);
		grid.add(MyField, 2, 1);
		grid.add(ShooterField, 2, 4);
		return new Scene(grid,600,600);
	}
	
	
	
	public void goToHTML() throws IOException{
		FileWriter fw=new FileWriter("D:/file.html");
		fw.write("<!DOCTYPE> \n "
				+ "<html>  \n "
				+ "<head>  "
				+"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">  \n "
				+ "<title>BattleShips</title>  \n "
				+ "<link rel=\"stylesheet\" href=\"D:/styleTable.css\">  \n "
				+"</head>  \n "
				+"<body>  \n "
				+" <table border=\"1\">  \n ");
		for(int i=0;i<8;i++){		
				fw.write("<tr>  \n ");
		for(int j=0;j<8;j++){
			if(pole[i][j]==1)fw.write("<td class=\"td1\"> </td> \n");
			else fw.write("<td> </td>  \n ");
		}
				fw.write("</tr>  \n ");
		}		
				fw.write("</table>  \n "
				+"</body>  \n "
				+"</html>");
		fw.close();
	}


	public int[][] getPole() {
		return pole;
	}

	public void setPole(int[][] pole) {
		this.pole = pole;
	}
	
}



