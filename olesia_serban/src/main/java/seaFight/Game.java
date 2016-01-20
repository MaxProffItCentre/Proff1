package seaFight;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private int[][] table = new int[10][10];
	private List <Ship> shipList = new ArrayList<>(); 
	private Ship s1 = new Ship();
	private Ship s2 = new Ship();
	private Ship s3 = new Ship();
	private Ship s4 = new Ship();
	private Ship2 sh1 = new Ship2();
	private Ship2 sh2 = new Ship2();
	private Ship2 sh3 = new Ship2();
	private Ship3 shi1 = new Ship3();
	private Ship3 shi2 = new Ship3();
	private Ship4 ship1 = new Ship4();
	private boolean inRecurtion = false;
	private boolean inDeepRecurtion = false;
	
	public Game (){
		for (int x = 0; x < 10; x++){
			for (int y = 0; y <10; y++){
				this.table[x][y]=0;
			}
		}
		this.shipList.add(this.s1);
		this.shipList.add(this.s2);
		this.shipList.add(this.s3);
		this.shipList.add(this.s4);
		this.shipList.add(this.sh1);
		this.shipList.add(this.sh2);
		this.shipList.add(this.sh3);
		this.shipList.add(this.shi1);
		this.shipList.add(this.shi2);
		this.shipList.add(this.ship1);
		
	}
	
	private boolean checkShip (Ship sh){
		giveShipParametrs(sh);
//		code for  universal ship
//		orientation horizontal
		if(sh.getOrientation() == 0){
//			if 0 0
			if(sh.getX() == 0 && sh.getY() == 0){
				for (int x = 0; x < 2; x++){
					for (int y = 0; y < sh.getShipSize() + 1; y++){
						
						if (table[x][y] == 2){
							inDeepRecurtion = true;
							inRecurtion = true;
							return false;
						}
					}
				}
//				fill with 1
				for (int x = 0; x < 2; x++){
					for (int y = 0; y < sh.getShipSize() + 1; y++){
						table[x][y] = 1;
					}
				}
				
//				fill with 2
				for(int y = 0; y < sh.getShipSize(); y ++){
					table[0][y] = 2;
				}
			
				
				return true;
				
			}
//			if 9 0
			else if(sh.getX() == 9 && sh.getY() == 0){
				for (int x = 9; x > 7; x--){
					for (int y = 0; y < sh.getShipSize() + 1; y++){
						if (table[x][y] == 2){
							inDeepRecurtion = true;
							inRecurtion = true;
							return false;
						}
					}
				}
//				fill with 1
				for (int x = 9; x > 7; x--){
					for (int y = 0; y < sh.getShipSize() + 1; y++){
						table[x][y] = 1;
					}
				}
				
//				fill with 2
				for(int y = 0; y < sh.getShipSize(); y ++){
					table[9][y] = 2;
				}
				
				return true;
				
			}
//			if 0 9
			else if(sh.getX() == 0 && sh.getY() == 9){
				for(int x = 0; x < 2; x++){
					for (int y = 9; y >= 9 - sh.getShipSize(); y--){
						if(table[x][y] == 2){
							inDeepRecurtion = true;
							inRecurtion = true;
							return false;
						}
					}
				}
//				fill with 1
				for(int x = 0; x < 2; x++){
					for (int y = 9; y >= 9 - sh.getShipSize(); y--){
						table[x][y] = 1;
					}
				}
//				fill with 2
				for(int y = 9; y > 9 - sh.getShipSize(); y --){
					table[0][y] = 2;
				}
				
				return true;
			}
//			if 9 9
			else if(sh.getX() == 9 && sh.getY() == 9){
				for (int x = 9; x > 7; x--){
					for (int y = 9; y >= 9 - sh.getShipSize(); y--){
						if(table[x][y] == 2){
							inDeepRecurtion = true;
							inRecurtion = true;
							return false;
						}
					}
				}
//				fill with 1
				for (int x = 9; x > 7; x--){
					for (int y = 9; y >= 9 - sh.getShipSize(); y--){
						table[x][y] = 1;
					}
				}
//				fill with 2
				for(int y = 9; y > 9 - sh.getShipSize(); y --){
					table[9][y] = 2;
				}
				return true;
			}
//			if x 0  debug +
			else if(sh.getX() != 0 && sh.getX() != 9 && sh.getY() == 0){
//				just code
//				x-1 <= x+1
//				0 <= 0 + size
				for (int x = sh.getX()-1; x <= sh.getX()+1; x++){
					for (int y = 0; y <= sh.getShipSize(); y++){
						if(table[x][y] == 2){
							inDeepRecurtion = true;
							inRecurtion = true;
							return false;
						}
					}
				}
//				fill with 1
				for (int x = sh.getX() - 1; x <= sh.getX()+1; x++){
					for (int y = 0; y <= sh.getShipSize(); y++){
						table[x][y] = 1;
					}
				}
//				fill with 2
				for(int y = 0; y < sh.getShipSize(); y++){
					table[sh.getX()][y] = 2;
				}
				return true;
			}
//			if 0 y
			else if(sh.getX() == 0 && sh.getY() != 0 && sh.getY() != 9){
//				size/2
				if(sh.getY() < 5){ //debug +
//					0 < 2
//					y-1 <= y+ size
					for(int x = 0; x < 2; x++){
						for(int y = sh.getY() - 1; y <= sh.getY() + sh.getShipSize(); y++){
							if(table[x][y] == 2){
								inDeepRecurtion = true;
								inRecurtion = true;
								return false;
							}
						}
					}
//					fill with 1
					for(int x = 0; x < 2; x++){
						for(int y = sh.getY() - 1; y <= sh.getY() + sh.getShipSize(); y++){
							table[x][y] = 1;
						}
					}
//					fill with 2
					for(int y = sh.getY(); y < sh.getY() + sh.getShipSize(); y++){
						table[0][y] = 2;
					}
					return true;
					
				}else{
//					0<2
//					y+1 >= y-size
					for(int x = 0; x < 2; x++){
						for(int y = sh.getY() + 1; y >= sh.getY() - sh.getShipSize(); y--){
							if(table[x][y] == 2){
								inDeepRecurtion = true;
								inRecurtion = true;
								return false;
							}
						} 
					}
//					fill with 1
					for(int x = 0; x < 2; x++){
						for(int y = sh.getY() + 1; y >= sh.getY() - sh.getShipSize(); y--){
							table[x][y] = 1;
						} 
					}
//					fill with 2
					for(int y = sh.getY();y > sh.getY() - sh.getShipSize(); y--){
						table[0][y] = 2;
					}
					return true;
					
				}
			}
//			if 9 y
			else if(sh.getX()==9 && sh.getY()!=0 && sh.getY()!=9){
//				size/2
				if(sh.getY() < 5){
					for(int x = 9; x > 7; x--){
						for(int y = sh.getY() - 1; y <= sh.getY() + sh.getShipSize(); y++){
							if(table[x][y] == 2){
								inDeepRecurtion = true;
								inRecurtion = true;
								return false;
							}
						}
					}
//					fill with 1
					for(int x = 9; x > 7; x--){
						for(int y = sh.getY() - 1; y <= sh.getY() + sh.getShipSize(); y++){
							table[x][y] = 1;
						}
					}
//					fill with 2
					for(int y = sh.getY(); y < sh.getY() + sh.getShipSize(); y++){
						table[9][y] = 2;
					}
					return true;
					
				}else{
					for(int x = 9; x > 7; x--){
						for(int y = sh.getY() + 1; y >= sh.getY() - sh.getShipSize(); y--){
							if(table[x][y] == 2){
								inDeepRecurtion = true;
								inRecurtion = true;
								return false;
							}
						} 
					}
//					fill with 1
					for(int x = 9; x > 7; x--){
						for(int y = sh.getY() + 1; y >= sh.getY() - sh.getShipSize(); y--){
							table[x][y] = 1;
						} 
					}
//					fill with 2
					for(int y = sh.getY();y > sh.getY() - sh.getShipSize(); y--){
						table[9][y] = 2;
					}
					return true;
				}
				
			}
//			if x 9
			else if(sh.getX() != 0 && sh.getX() != 9 && sh.getY() == 9){
//				just code
//				x-1 <= 	x+1 
//				9 >= 9 - size
				for(int x = sh.getX()-1; x <= sh.getX() + 1; x++){
					for(int y = 9; y >= 9 - sh.getShipSize(); y--){
						if(table[x][y] == 2){
							inDeepRecurtion = true;
							inRecurtion = true;
							return false;
						}
					}
				}
//				fill with 1
				for(int x = sh.getX() - 1; x <= sh.getX() + 1; x++){
					for(int y = 9; y >= 9 - sh.getShipSize(); y--){
						table[x][y] = 1;
					}
				}
				
//				fill with 2
				for(int y = 9; y > 9 - sh.getShipSize(); y--){
					table[sh.getX()][y] = 2;
				}
				return true;
			}
//			if x y
			else{
//				size/2
				if(sh.getY() < 5){
//					x-1 <= x+1
//					y-1 <= y+size
					for(int x = sh.getX() - 1; x <= sh.getX() + 1; x++){
						for(int y = sh.getY() - 1; y <= sh.getY() + sh.getShipSize(); y++){
							if(table[x][y] == 2){
								inDeepRecurtion = true;
								inRecurtion = true;
								return false;
							}
						}
					}
//					fill with 1
					for(int x = sh.getX() - 1; x <= sh.getX() + 1; x++){
						for(int y = sh.getY() - 1; y <= sh.getY() + sh.getShipSize(); y++){
							table[x][y] = 1;
						}
					}
//					fill with 2
					for(int y = sh.getY(); y < sh.getY() + sh.getShipSize(); y++){
						table[sh.getX()][y] = 2;
					}
					return true;
				}else{
//					x-1 <= x+1
//					y+1 >= y - size
					for(int x = sh.getX() - 1; x <= sh.getX() + 1; x++){
						for(int y = sh.getY()+1; y >= sh.getY()- sh.getShipSize(); y--){
							if(table[x][y] == 2){
								inDeepRecurtion = true;
								inRecurtion = true;
								
								return false;
							}
						}
					}
//					fill 1
					for(int x = sh.getX() - 1; x <= sh.getX() + 1; x++){
						
						for(int y = sh.getY() + 1; y >= sh.getY() - sh.getShipSize(); y--){
							table[x][y] = 1;
						}
					}
//					fill 2
					for(int y = sh.getY(); y > sh.getY() - sh.getShipSize(); y--){
						table[sh.getX()][y] = 2;
					}
					return true;
					
				}
			}
			
		}
//		orientation vertical
		else if(sh.getOrientation() == 1){
//			if 0 0
			if(sh.getX() == 0 && sh.getY() == 0){
				for(int x = 0; x <= sh.getShipSize(); x++){
					for(int y = 0; y < 2; y ++){
						if(table[x][y] == 2){
							inDeepRecurtion = true;
							inRecurtion = true;
							return false;
						}
					}
				}
//				fill 1
				for(int x = 0; x <= sh.getShipSize(); x++){
					for(int y = 0; y < 2; y ++){
						table[x][y] = 1;
					}
				}
//				fill 2
				for(int x = 0; x < sh.getShipSize(); x++){
					table[x][0] = 2;
				}
				return true;
			}
//			if 9 0
			else if(sh.getX() == 9 && sh.getY() == 0){
				for(int x = 9; x >= 9 - sh.getShipSize(); x--){
					for (int y = 0; y < 2; y++){
						if(table[x][y]==2){
							inDeepRecurtion = true;
							inRecurtion = true;
							return false;
						}
					}
				}
//				fill1
				for(int x = 9; x >= 9 - sh.getShipSize(); x--){
					for (int y = 0; y < 2; y++){
						table[x][y] = 1;
					}
				}
//				fill2
				for(int x = 9; x > 9 - sh.getShipSize(); x--){
					table[x][0] = 2;
				}
				return true;
			}
//			if 0 9
			else if(sh.getX()==0 && sh.getY()==9){
				for(int x = 0; x <= sh.getShipSize(); x++){
					for(int y = 9; y > 7; y --){
						if(table[x][y] == 2){
							inDeepRecurtion = true;
							inRecurtion = true;
							return false;
						}
					}
				}
//				fill 1
				for(int x = 0; x <= sh.getShipSize(); x++){
					for(int y = 9; y > 7; y --){
						table[x][y] = 1;
					}
				}
//				fill 2
				for(int x = 0; x < sh.getShipSize(); x++){
					table[x][9] = 2;
				}
				return true;
			}
//			if 9 9
			else if(sh.getX() == 9 && sh.getY() == 9){
				for(int x = 9; x >= 9 - sh.getShipSize(); x--){
					for (int y = 9; y > 7; y--){
						if(table[x][y] == 2){
							inDeepRecurtion = true;
							inRecurtion = true;
							return false;
						}
					}
				}
//				fill1
				for(int x = 9; x >= 9 - sh.getShipSize(); x--){
					for (int y = 9; y > 7; y--){
						table[x][y] = 1;
					}
				}
//				fill2
				for(int x = 9; x > 9 - sh.getShipSize(); x--){
					table[x][9] = 2;
				}
				return true;
			}
//			if x 0
			else if(sh.getX()!=0 && sh.getX()!=9 && sh.getY()==0){
//				X size/2
				if(sh.getX() < 5){
					for (int x = sh.getX()-1; x <= sh.getX()+sh.getShipSize(); x++){
						for(int y = 0; y < 2; y++){
							if(table[x][y] == 2){
								inDeepRecurtion = true;
								inRecurtion = true;
								return false;
							}
						}
					}
//					fill 1
					for (int x = sh.getX()-1; x <= sh.getX()+sh.getShipSize(); x++){
						for(int y = 0; y < 2; y++){
							table[x][y] = 1;
						}
					}
//					fill 2
					for(int x = sh.getX(); x < sh.getX() + sh.getShipSize(); x++){
						table[x][sh.getY()] = 2;
					}
					return true;
				}else{
					for (int x = sh.getX()+1; x >= sh.getX()-sh.getShipSize(); x--){
						for(int y = 0; y < 2; y++){
							if(table[x][y] == 2){
								inDeepRecurtion = true;
								inRecurtion = true;
								return false;
							}
						}
					}
//					fill 1
					for (int x = sh.getX()+1; x >= sh.getX() - sh.getShipSize(); x--){
						for(int y = 0; y < 2; y++){
							table[x][y] = 1;
						}
					}
//					fill 2
					for(int x = sh.getX(); x > sh.getX() - sh.getShipSize(); x--){
						table[x][sh.getY()] = 2;
					}
					return true;
					
				}
			}
//			if 0 y
			else if(sh.getX() == 0 && sh.getY() != 0 && sh.getY() != 9){
//				just code
				for(int x = 0; x <= sh.getShipSize(); x++){
					for (int y = sh.getY() - 1; y <= sh.getY() + 1; y++){
						if(table[x][y] == 2){
							inDeepRecurtion = true;
							inRecurtion = true;
							return false;
						}
					}
				}
//				fill 1
				for(int x = 0; x <= sh.getShipSize(); x++){
					for (int y = sh.getY() - 1; y <= sh.getY() + 1; y++){
						table[x][y] = 1;
					}
				}
//				fill 2
				for(int x = 0; x < sh.getShipSize(); x++){
					table[x][sh.getY()] = 2;
				}
				return true;
			}
//			if 9 y
			else if(sh.getX()==9 && sh.getY()!=0 && sh.getY()!=9){
//				just code
				for(int x = 9; x >= 9 - sh.getShipSize(); x--){
					for (int y = sh.getY() - 1; y<= sh.getY()+1; y++){
						if(table[x][y] == 2){
							inDeepRecurtion = true;
							inRecurtion = true;
							return false;
						}
					}
				}
//				fill 1
				for(int x = 9; x >= 9 - sh.getShipSize(); x--){
					for (int y = sh.getY() - 1; y<= sh.getY()+1; y++){
						table[x][y] = 1;
					}
				}
//				fill 2
				for( int x = 9; x > 9 - sh.getShipSize(); x--){
					table[x][sh.getY()] = 2;
				}
				return true;
			}
//			if x 9
			else if(sh.getX()!=0 && sh.getX()!=9 && sh.getY()==9){
//				X size/2
				if(sh.getX() < 5){
					for (int x = sh.getX() - 1; x <= sh.getX()+sh.getShipSize(); x++){
						for(int y = 9; y > 7; y--){
							if(table[x][y] == 2){
								inDeepRecurtion = true;
								inRecurtion = true;
								return false;
							}
						}
					}
//					fill 1
					for (int x = sh.getX() - 1; x <= sh.getX()+sh.getShipSize(); x++){
						for(int y = 9; y > 7; y--){
							table[x][y] = 1;
						}
					}
//				fill 2
					for(int x = sh.getX(); x < sh.getX() + sh.getShipSize(); x++){
						table[x][sh.getY()] = 2;
					}
					return true;
				}else{
					for (int x = sh.getX()+1; x >= sh.getX()-sh.getShipSize(); x--){
						for(int y = 9; y > 7; y--){
							if(table[x][y] == 2){
								inDeepRecurtion = true;
								inRecurtion = true;
								return false;
							}
						}
					}
//					fill 1
					for (int x = sh.getX()+1; x >= sh.getX() - sh.getShipSize(); x--){
						for(int y = 9; y > 7; y--){
							table[x][y] = 1;
						}
					}
//					fill 2
					for(int x = sh.getX(); x > sh.getX() - sh.getShipSize(); x--){
						table[x][sh.getY()] = 2;
					}
					return true;
					
				}
			}
//			if x y
			else{
				if(sh.getX() < 5){
					for(int x = sh.getX()-1; x <= sh.getX()+sh.getShipSize(); x++){
						for(int y = sh.getY()-1; y <= sh.getY()+1; y++){
							if(table[x][y]==2){
								inDeepRecurtion = true;
								inRecurtion = true;
								return false;
							}
						}
					}
//					fill 1
					for(int x = sh.getX()-1; x <= sh.getX()+sh.getShipSize(); x++){
						for(int y = sh.getY()-1; y <= sh.getY()+1; y++){
							table[x][y] = 1;
						}
					}
//					fill 2
					for(int x = sh.getX(); x < sh.getX()+ sh.getShipSize(); x++){
						table[x][sh.getY()] = 2;
					}
					return true;
				}else{
					for(int x = sh.getX()+1; x >= sh.getX()-sh.getShipSize(); x--){
						for(int y = sh.getY()-1; y <= sh.getY()+1; y++){
							if(table[x][y]==2){
								inDeepRecurtion = true;
								inRecurtion = true;
								return false;
							}
						}
					}
//					fill 1
					for(int x = sh.getX()+1; x >= sh.getX()-sh.getShipSize(); x--){
						for(int y = sh.getY()-1; y <= sh.getY()+1; y++){
							table[x][y] = 1;
						}
					}
//					fill 2
					for(int x = sh.getX(); x > sh.getX() - sh.getShipSize(); x--){
						table[x][sh.getY()] = 2;
					}
					return true;
				}
			}
			
		}
		return true;
	}
	private void giveShipParametrs(Ship sh){
		
		int rndX = (int) (Math.random()*10);
		int rndY = (int) (Math.random()*10);
		int rndOrient = (int) Math.round(Math.random());
		sh.setX(rndX);
		sh.setY(rndY);
		sh.setOrientation(rndOrient);
//		if (inRecurtion){
//			inRecurtion = false;
//			return true;
//		}
		
		
		
	}
	public boolean fillTable(){
		
		for (Ship ship : shipList) {
			
			boolean valid = false;
			while(!valid){
				valid = checkShip(ship);
			}
		}
		return true;
	}
	
	public int[][] getTable() {
		return table;
	}

	public void setTable(int[][] table) {
		this.table = table;
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.fillTable();
		
//		game.put(game.s1);
//		game.put(game.s2);
//		game.put(game.s3);
//		game.put(game.s4);
//		game.ship1.setX(2);
//		game.ship1.setY(7);
//		game.ship1.setOrientation(1);
//		game.shi1.setX(5);
//		game.shi1.setY(6);
//		game.checkShip(game.ship1);
//		game.checkShip(game.shi1);
		
		int arr[][] = game.getTable();
		for(int i = 0; i < 10; i++){
			for(int j = 0; j <10; j ++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
//		int rndX = (int) (Math.random()*10);
//		int rndY = (int) (Math.random()*10);
//		int rndOrient = (int) Math.round(Math.random());
//		System.out.println(rndX);
//		System.out.println(rndY);
//		System.out.println(rndOrient);
//		
//		for (Ship ship : game.shipList) {
//			System.out.println(ship);
//		}
//		System.out.println(game.s1);
		
	}
}
