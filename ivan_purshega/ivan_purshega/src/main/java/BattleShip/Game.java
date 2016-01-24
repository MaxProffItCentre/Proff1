package BattleShip;

import java.applet.Applet;
import java.applet.AudioClip;
import javafx.scene.media.Media;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


import javax.sound.sampled.Clip;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends Application {
	static private int[][] pole=new int[8][8];
	static private int[][] pole2=new int[8][8];
	static private boolean[][] ShootField=new boolean[8][8];
	static private boolean Target=false;
	static private boolean TargetEnemy=false;
	static private int LastX;
	static private int LastY;
	static private boolean Left=false;
	static private boolean Rigth=false;
	static private boolean Up=false;
	static private boolean Down=false;
	static private int NumberOfShip=0;
	static private int NumberOfEnemyShip=0;
	static private int count=0;
	static private int count2=0;
	static private int dop=0;
	static private boolean yes=false;
	static private int shot=0;
	static private int MyLife=18;
	static private int EnemyLife=18;
	
	
	Button[] buttons=new Button[64];
	Button[] ShootButtons=new Button[64];
	static private  ArrayList<Ship> Myships=new ArrayList();
	static private  ArrayList<Ship> EnemyShips=new ArrayList();
	

	
	public boolean addShip(Ship ship){
		
		 
		 int count=ship.getCount();
		 int x=(int)(0+8*Math.random());
		 int y=(int)(0+8*Math.random());
		
			
			 int xy=(int)(0+2*Math.random()); 
			 if(xy==0){
				 while(proverkaX(x,y,count)!=true){
					 System.out.println("Proverka");
					 x=(int)(0+8*Math.random());
					 y=(int)(0+8*Math.random());
				 } 
			 for(int i=0;i<count;i++){
			 ship.addLocation(x+i,y);
			 pole[x+i][y]=1;
			 areaAroundShipX(x,y,i,ship);
			 }
			 areaAroundShipX2(x,y,count,ship);
			 }
			 if(xy==1){
				 System.out.println("Proverka");
				 while(proverkaY(x,y,count)!=true){
					 x=(int)(0+8*Math.random());
					 y=(int)(0+8*Math.random());
				 } 
			 
				 for(int i=0;i<count;i++){
				 ship.addLocation(x,y+i);
				 pole[x][y+i]=1;
				 areaAroundShipY(x,y,i,ship);
				 }
				 areaAroundShipY2(x,y,count,ship);
				}
			 Myships.add(ship);	
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
			 areaAroundShipXEnemy(x,y,i,ship);
			 }
			 areaAroundShipX2Enemy(x,y,count,ship);
			 }
			 if(xy==1){
				 while(proverkaYEnemy(x,y,count)!=true){
					 x=(int)(0+8*Math.random());
					 y=(int)(0+8*Math.random());
				 } 
			 
				 for(int i=0;i<count;i++){
				 ship.addLocation(x,y+i);
				 pole2[x][y+i]=1;
				 areaAroundShipYEnemy(x,y,i,ship);
				 }
				 areaAroundShipY2Enemy(x,y,count,ship);
				}
			 EnemyShips.add(ship);	
		 return true;
	}
	
	
	
	
	
	
	public boolean proverkaX(int x, int y, int size){
		if(x+size>8) return false;
		for(int i=0; i<size;i++){
			if(pole[x+i][y]==1 || pole[x+i][y]==2) return false;
		}
		
		return true;
	}
	
	
	public void areaAroundShipX(int x, int y, int i,Ship ship){
		if(y!=0) {
			pole[x+i][y-1]=2;
			ship.setAreaAroundShip(x+i, y-1);
		}
		 if(y!=7){ pole [x+i][y+1]=2;
		 ship.setAreaAroundShip(x+i, y+1);
		 }
	}
	
	public void areaAroundShipX2(int x, int y, int count, Ship ship){
		 int p=count-1;
		 if(x!=0) {pole [x-1][y]=2; ship.setAreaAroundShip(x-1, y);}
		 if(x!=0 && y!=0) {pole [x-1][y-1]=2;ship.setAreaAroundShip(x-1, y-1);}
		 if(x!=0 && y!=7) {pole [x-1][y+1]=2;ship.setAreaAroundShip(x-1, y+1);}
		 if(x+p!=7) {pole[x+count][y]=2;ship.setAreaAroundShip(x+count, y);}
		 if(x+p!=7 && y!=0) {pole [x+count][y-1]=2;ship.setAreaAroundShip(x+count, y-1);}
		 if(x+p!=7 && y!=7) {pole [x+count][y+1]=2;ship.setAreaAroundShip(x+count, y+1);}
	}
	
	
	public boolean proverkaY(int x, int y, int size){
		if(y+size>8) return false;
		for(int i=0; i<size;i++){
			if(pole[x][y+i]==1 || pole[x][y+i]==2) return false;
		}
		
		return true;
	}
	
	public void areaAroundShipY(int x, int y, int i,Ship ship){
		 if(x!=0) {pole[x-1][y+i]=2;ship.setAreaAroundShip(x-1, y+i);}
		 if(x!=7) {pole[x+1][y+i]=2;ship.setAreaAroundShip(x+1, y+i);}
	}
	
	public void areaAroundShipY2(int x, int y, int count, Ship ship){
		 int p=count-1;
		 if(y!=0) {pole [x][y-1]=2;ship.setAreaAroundShip(x, y-1);}
		 if(y!=0 && x!=0) {pole [x-1][y-1]=2;ship.setAreaAroundShip(x-1, y-1);}
		 if(y!=0 && x!=7) {pole [x+1][y-1]=2;ship.setAreaAroundShip(x+1, y-1);}
		 if(y+p!=7) {pole[x][y+count]=2;ship.setAreaAroundShip(x, y+count);}
		 if(y+p!=7 && x!=0) {pole [x-1][y+count]=2;ship.setAreaAroundShip(x-1, y+count);}
		 if(y+p!=7 && x!=7) {pole [x+1][y+count]=2;ship.setAreaAroundShip(x+1, y+count);}
	}
	
	
	public boolean proverkaXEnemy(int x, int y, int size){
		if(x+size>8) return false;
		for(int i=0; i<size;i++){
			if(pole2[x+i][y]==1 || pole2[x+i][y]==2) return false;
		}
		
		return true;
	}
	
	
	public void areaAroundShipXEnemy(int x, int y, int i,Ship ship){
		
		if(y!=0) {
			pole2[x+i][y-1]=2;
			ship.setAreaAroundShip(x+i, y-1);
		}
		 if(y!=7){ pole2 [x+i][y+1]=2;
		 ship.setAreaAroundShip(x+i, y+1);
		 }
	}
	
	public void areaAroundShipX2Enemy(int x, int y, int count,Ship ship){
		 int p=count-1;
		 if(x!=0) {pole2 [x-1][y]=2; ship.setAreaAroundShip(x-1, y);}
		 if(x!=0 && y!=0) {pole2 [x-1][y-1]=2;ship.setAreaAroundShip(x-1, y-1);}
		 if(x!=0 && y!=7) {pole2 [x-1][y+1]=2;ship.setAreaAroundShip(x-1, y+1);}
		 if(x+p!=7) {pole2[x+count][y]=2;ship.setAreaAroundShip(x+count, y);}
		 if(x+p!=7 && y!=0) {pole2 [x+count][y-1]=2;ship.setAreaAroundShip(x+count, y-1);}
		 if(x+p!=7 && y!=7) {pole2 [x+count][y+1]=2;ship.setAreaAroundShip(x+count, y+1);}
	}
	
	
	public boolean proverkaYEnemy(int x, int y, int size){
		if(y+size>8) return false;
		for(int i=0; i<size;i++){
			if(pole2[x][y+i]==1 || pole2[x][y+i]==2) return false;
		}
		
		return true;
	}
	
	public void areaAroundShipYEnemy(int x, int y, int i, Ship ship){
		
		if(x!=0) {pole2[x-1][y+i]=2;ship.setAreaAroundShip(x-1, y+i);}
		 if(x!=7) {pole2[x+1][y+i]=2;ship.setAreaAroundShip(x+1, y+i);}
	}
	
	public void areaAroundShipY2Enemy(int x, int y, int count, Ship ship){
		 int p=count-1;
		 if(y!=0) {pole2 [x][y-1]=2;ship.setAreaAroundShip(x, y-1);}
		 if(y!=0 && x!=0) {pole2 [x-1][y-1]=2;ship.setAreaAroundShip(x-1, y-1);}
		 if(y!=0 && x!=7) {pole2 [x+1][y-1]=2;ship.setAreaAroundShip(x+1, y-1);}
		 if(y+p!=7) {pole2[x][y+count]=2;ship.setAreaAroundShip(x, y+count);}
		 if(y+p!=7 && x!=0) {pole2 [x-1][y+count]=2;ship.setAreaAroundShip(x-1, y+count);}
		 if(y+p!=7 && x!=7) {pole2 [x+1][y+count]=2;ship.setAreaAroundShip(x+1, y+count);}
		 
	}
	
	public void goToFX(String[] args) {
		
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
	
		stage.setTitle("Battle");
		stage.setScene(createScene());
		stage.show();
	}
	
	
	@SuppressWarnings("restriction")
	public Scene createScene() {
		 
		
		GridPane grid=new GridPane();
		GridPane MyField=new GridPane();
		GridPane ShooterField=new GridPane();
		
		
		
		
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
			ShootButtons[but1].setOnAction((event) -> {
//				Media music = new Media("file:///d:/pushka.mp3");
//			     MediaPlayer mediaP = new MediaPlayer(music);
//			     mediaP.play();	
			  
		if(pole2[k][k1]==1){
			EnemyLife--;
			if(TargetEnemy!=true){
			ShootButtons[but1].setStyle("-fx-background-color:red");
			pole2[k][k1]=10;
			
			for(int i4=0; i4<EnemyShips.size();i4++){
				for(int j4=0; j4<EnemyShips.get(i4).getCount();j4++){
					if(EnemyShips.get(i4).getLocation().get(j4).getX()==k && EnemyShips.get(i4).getLocation().get(j4).getY()==k1){
						count2=EnemyShips.get(i4).getCount()-1;
						NumberOfEnemyShip=i4;
						TargetEnemy=true;
						
						if(count2==0){
							for(int i3=0; i3<EnemyShips.get(NumberOfEnemyShip).getAreaAroundShip().size();i3++){
								int xx=EnemyShips.get(NumberOfEnemyShip).getAreaAroundShip().get(i3).getX();
								int yy=EnemyShips.get(NumberOfEnemyShip).getAreaAroundShip().get(i3).getY();
								if(xx==0)ShootButtons[yy].setStyle("-fx-background-color:green");
								else ShootButtons[8*xx+yy].setStyle("-fx-background-color:green");
								TargetEnemy=false;
							}
						}
						
					}
				}
			}
		}
		else if(TargetEnemy==true){
			if(pole2[k][k1]==1){
				ShootButtons[but1].setStyle("-fx-background-color:red");
				count2--;
				
				
				if(count2==0){
					
					System.out.println("COUNT    ===== 0");
					for(int i3=0; i3<EnemyShips.get(NumberOfEnemyShip).getAreaAroundShip().size();i3++){
						int xx=EnemyShips.get(NumberOfEnemyShip).getAreaAroundShip().get(i3).getX();
						int yy=EnemyShips.get(NumberOfEnemyShip).getAreaAroundShip().get(i3).getY();
						if(xx==0)ShootButtons[yy].setStyle("-fx-background-color:green");
						else ShootButtons[8*xx+yy].setStyle("-fx-background-color:green");
						TargetEnemy=false;
						}	
					}	
				}
			}
			if(EnemyLife==0){
				Text text = new Text("  VICTORY");
				text.setStyle("-fx-fill:green; -fx-font-size: 60pt;");
				grid.add(text,2,3);
			}
		}
		
		else if(pole2[k][k1]!=1){
			ShootButtons[but1].setStyle("-fx-background-color:green");
			Media music2 = new Media("file:///d:/waterExplo.mp3");
		     MediaPlayer mediaP2 = new MediaPlayer(music2);
		     mediaP2.play();	
		}
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}	
			if(Target==false){
			int x=(int)(0+8*Math.random());
			int y=(int)(0+8*Math.random());
			while (ShootField[x][y]!=false){
				x=(int)(0+8*Math.random());
				y=(int)(0+8*Math.random());
			}
			ShootField[x][y]=true;
			
			
			for(int i2=0; i2<Myships.size();i2++){
				for(int j2=0; j2<Myships.get(i2).getCount();j2++){
					if(Myships.get(i2).getLocation().get(j2).getX()==x && Myships.get(i2).getLocation().get(j2).getY()==y){
						count=Myships.get(i2).getCount()-1;
						NumberOfShip=i2;
						Target=true;
						LastX=x;
						LastY=y;
						MyLife--;
						if(MyLife==0){
							Text text = new Text(" FAIL  ");
							text.setStyle("-fx-fill:red; -fx-font-size: 60pt;");
							grid.add(text,2,3);
						}
						if(count==0){
							for(int i3=0; i3<Myships.get(NumberOfShip).getAreaAroundShip().size();i3++){
								int xx=Myships.get(NumberOfShip).getAreaAroundShip().get(i3).getX();
								int yy=Myships.get(NumberOfShip).getAreaAroundShip().get(i3).getY();
								System.out.println("xx ="+xx+"  yy="+yy);
								ShootField[xx][yy]=true;
								if(xx==0)buttons[yy].setStyle("-fx-background-color:green");
								else buttons[8*xx+yy].setStyle("-fx-background-color:green");
								Target=false;
							}
						}
						
					}
				}
			}
			
			if(pole[x][y]==1){
				if(x==0)buttons[y].setStyle("-fx-background-color:black");
				else buttons[8*x+y].setStyle("-fx-background-color:black");
			}
			if(pole[x][y]!=1){
				if(x==0)buttons[y].setStyle("-fx-background-color:green");
				else buttons[8*x+y].setStyle("-fx-background-color:green");
			}
			}
			else  {
				
				int x=LastX;
				int y=LastY;
				System.out.println("Target true  x= "+x+"  y= "+y);
				if(Left==true){y=y-1-dop;}
				else if(Rigth==true){y=y+1+dop;}
				else if(Up==true){x=x-1-dop;}
				else if(Down==true){x=x+1+dop;}
				else {  yes=false;
				while(yes==false){
					shot=(int)(0+4*Math.random());
					System.out.println("shot = "+shot);
					System.out.println("while   "+x+"  "+y);
				if(shot==0 && y-1>=0 ){
					if(ShootField[x][y-1]!=true){
					y-=1; yes=true;
					}
				} else if (shot==1 && y+1!=8  ){
					if(ShootField[x][y+1]!=true){
					y+=1; yes=true;
					}
				} else if(shot==2 && x-1>=0){
					if(ShootField[x-1][y]!=true ){
					x-=1; yes=true;
					}
				} else if (shot==3 && x+1!=8){
					if(ShootField[x+1][y]!=true){
					x+=1; yes=true;
					}
				}
			}
		}
				if(pole[x][y]==1){
					
					System.out.println("DA");
					if(x==0)buttons[y].setStyle("-fx-background-color:black");
					else buttons[8*x+y].setStyle("-fx-background-color:black");
					count--;
					dop++;
					System.out.println("Shot=  "+shot);
					if(shot==0)Left=true;
					if(shot==1)Rigth=true; 
					if(shot==2)Up=true; 
					if(shot==3)Down=true; 
					ShootField[x][y]=true;
					if(x==0 && Up==true){
						dop=0;
						yes=false;
						Up=false; 	
					}
					if(x==7 && Down==true){
						dop=0;
						yes=false;
						Down=false; 	
					}
					if(y==0 && Left==true){
						dop=0;
						yes=false;
						Left=false; 	
					}
					if(y==7 && Rigth==true){
						dop=0;
						yes=false;
						Rigth=false; 	
					}
					MyLife--;
					if(MyLife==0){
						Text text = new Text("  FAIL ");
						text.setStyle("-fx-fill:red; -fx-font-size: 60pt;");
						grid.add(text,2,3);
					}
					
				}
				if(pole[x][y]!=1){
					System.out.println("NET");
					if(x==0)buttons[y].setStyle("-fx-background-color:green");
					else buttons[8*x+y].setStyle("-fx-background-color:green");
					dop=0;
					yes=false;
					Left=false;
					Rigth=false; 
					Up=false; 
					Down=false; 
					ShootField[x][y]=true;
			}
			
				if(count==0){
					for(int i3=0; i3<Myships.get(NumberOfShip).getAreaAroundShip().size();i3++){
						int xx=Myships.get(NumberOfShip).getAreaAroundShip().get(i3).getX();
						int yy=Myships.get(NumberOfShip).getAreaAroundShip().get(i3).getY();
						System.out.println("xx ="+xx+"  yy="+yy);
						ShootField[xx][yy]=true;
						if(xx==0)buttons[yy].setStyle("-fx-background-color:green");
						else buttons[8*xx+yy].setStyle("-fx-background-color:green");
				
					}
					Target=false;
					Left=false;
					Rigth=false;
					Up=false;
					Down=false;
					dop=0;
				}
			
			
			}	
			
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
		return new Scene(grid,720,720);
		
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
