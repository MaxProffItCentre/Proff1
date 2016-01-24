package BattleShip;

import java.util.ArrayList;

public class Ship {
	private int count;
	private ArrayList<Location> location=new ArrayList();
	private ArrayList<AreaAroundShip> areaAroundShip=new ArrayList();
	
	
	public void setAreaAroundShip(int x, int y){
		areaAroundShip.add(new AreaAroundShip(x,y));
	}
	
	public ArrayList<AreaAroundShip> getAreaAroundShip(){
		return areaAroundShip;
	}
	

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
		location.add(new Location(x,y,this));
	}
	
	public ArrayList<Location> getLocation(){
		return location;
	}
}
