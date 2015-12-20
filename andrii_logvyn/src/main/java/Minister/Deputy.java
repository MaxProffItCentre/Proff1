package Minister;

public abstract class Deputy {
	private int summaGrab;
	private int tarif;
	private String name;
	private boolean isReg = false;
	
	public void setSummaGrab(int summa){
		summaGrab = summa;
	}
	
	public int getSummaGrab(){
		return summaGrab;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setIsReg(boolean set){
		isReg = set;
	}

}
