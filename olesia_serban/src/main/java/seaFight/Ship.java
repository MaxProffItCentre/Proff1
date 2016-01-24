package seaFight;

public class Ship {
//	0-9
	private int x;
//	0-9
	private int y;
	private int shipSize = 1;
//	0 = horizontal 1 = vertical
	private int orientation;
	
	
	public Ship() {
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

	public int getShipSize() {
		return this.shipSize;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	@Override
		public String toString() {
			
			return "ship";
		}
}
