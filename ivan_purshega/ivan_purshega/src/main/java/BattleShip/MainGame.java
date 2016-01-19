package BattleShip;

import java.io.IOException;
import java.util.ArrayList;

public class MainGame {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		 Game game=new Game();
		 ArrayList<Ship> Myships=new ArrayList();
		 Myships.add(new Ship(4));
		 Myships.add(new Ship(3));
		 Myships.add(new Ship(3));
		 Myships.add(new Ship(2));
		 Myships.add(new Ship(2));
		 Myships.add(new Ship(2));
		 
		 for(int i=0; i<Myships.size();i++){
			 while(game.addShip(Myships.get(i))!=true);
		 }
		 
		 
		 ArrayList<Ship> Enemyships=new ArrayList();
		 Enemyships.add(new Ship(4));
		 Enemyships.add(new Ship(3));
		 Enemyships.add(new Ship(3));
		 Enemyships.add(new Ship(2));
		 Enemyships.add(new Ship(2));
		 Enemyships.add(new Ship(2));
		 
		 for(int i=0; i<Enemyships.size();i++){
			 while(game.addShip2(Enemyships.get(i))!=true);
		 }
		 
		 
		  game.goToHTML();
		  game.goToFX(args);  
	}
}

