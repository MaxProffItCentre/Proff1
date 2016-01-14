package BattleShip;

import java.io.IOException;
import java.util.ArrayList;

public class MainGame {
	public static void main(String[] args) throws IOException {
		 Game game=new Game();
		 ArrayList<Ship> ships=new ArrayList();
		 ships.add(new Ship(4));
		 ships.add(new Ship(3));
		 ships.add(new Ship(3));
		 ships.add(new Ship(2));
		 ships.add(new Ship(2));
		 ships.add(new Ship(2));
		 
		 for(int i=0; i<ships.size();i++){
			 while(game.addShip(ships.get(i))!=true);
		 }
		 
		 for(int i=0; i<ships.size();i++) {
			 System.out.println("Ship "+ i);
			 ships.get(i).printLocation();		
		 }
		  game.goToHTML();
		 
	}
}