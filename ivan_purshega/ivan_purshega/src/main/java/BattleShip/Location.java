package BattleShip;

public class Location {
	private int x;
	private int y;
	Ship ship;
	
	public Location(int x, int y, Ship ship) {
		this.ship=ship;
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Ship getShip() {
		return ship;
	}
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	
	
}