package BattleShip;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Game {
	private int[][] pole=new int[8][8];
	
	
	public boolean addShip(Ship ship){
		 int count=ship.getCount();
		 int p=count-1;
		 int x=(int)(0+8*Math.random());
		 int y=(int)(0+8*Math.random());
		 System.out.println("x="+x);
		 System.out.println("y="+y);
		
			 int xy=0;
//			 xy=(int)(0+2*Math.random());
			 
			 while(proverka(x,y,count)!=true){
				 x=(int)(0+7*Math.random());
				 y=(int)(0+7*Math.random());
			 }
			 
			 
			 System.out.println("xy="+xy);
			 if(xy==0){
//				 int x1=x;
//				 int count2=count;
//				 while(count2<0){
//					 if(pole[x1][y]==1 || pole[x1][y]==2)return false;
//					 x1++; count2--;
//				 }
//			 if (x+count>8) return false;
//			 pole[x][y]=1;
			 for(int i=0;i<count;i++){
			 ship.addLocation(x+i,y);
			 pole[x+i][y]=1;
			 if(y!=0) pole[x+i][y-1]=2;
			 if(y!=7) pole [x+i][y+1]=2;
			 }
			 if(x!=0) pole [x-1][y]=2;
			 if(x!=0 && y!=0) pole [x-1][y-1]=2;
			 if(x!=0 && y!=7) pole [x-1][y+1]=2;
			 if(x+p!=7) pole[x+count][y]=2;
			 if(x+p!=7 && y!=0) pole [x+count][y-1]=2;
			 if(x+p!=7 && y!=7) pole [x+count][y+1]=2;
			 }
			 if(xy==1){
//				 int y1=y;
//				 int count2=count;
//				 while(count2<0){
//					 if(pole[x][y1]==1 || pole[x][y1]==2)return false;
//					 y1++; count2--;
//				 }
//				 if (y+count>8) return false;
//				 int k=count;
				 for(int i=0;i<count;i++){
				 ship.addLocation(x,y+i);
				 pole[x][y+i]=1;
				 if(x!=0) pole[x-1][y+i]=2;
				 if(x!=7) pole[x+1][y+i]=2;
				 }
				 if(y!=0) pole[x][y-1]=2;
				 if(y!=0 && x!=0) pole [y-1][x-1]=2;
				 if(y!=0 && x!=7) pole [y-1][x+1]=2;
				 
				 if(y+p!=7) pole[x][y+count]=2;
				 if(y+p!=7 && x!=0) pole [x+1][y+count]=2;
				 if(y+p!=7 && x!=7) pole [x+1][y+count]=2;
				}
		 return true;
	}
	
	public boolean proverka(int x, int y, int size){
		for(int i=0; i<size;i++){
			System.out.println("int x="+x);
			if(pole[x+i][y]==1 || pole[x+i][y]==2 || x>=7 ) return false;
		}
		
		return true;
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
	
	
	
}