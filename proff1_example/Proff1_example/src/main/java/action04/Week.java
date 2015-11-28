package action04;

public enum Week {
	Mon("Понедельник"), Tue("Вторний");
	private String str;
	private Week(String s){
		str = s;
	}
	public String toString(){
		return str;
	}
	public static void main(String[] args){
		Week obj = Week.Mon;
		System.out.println(obj);
	}
}
