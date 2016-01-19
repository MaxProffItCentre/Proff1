package BattleShip;

import java.util.ArrayList;

public class Ship {
	private int count;
	private ArrayList<Location> location=new ArrayList();
	
	
	

	public void printLocation(){
		for(int i=0;i<location.size();i++){
			System.out.println("x="+location.get(i).getX()+"  y="+location.get(i).getY());
		}
	}

	public Ship(){
		
	}
	
	public Ship(int count){
		this.count=count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void addLocation(int x, int y){
		location.add(new Location(x,y));
	}
	
	public ArrayList<Location> getLocation(){
		return location;
	}
}