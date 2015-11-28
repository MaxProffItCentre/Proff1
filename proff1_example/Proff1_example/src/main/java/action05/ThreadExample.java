package action05;

public class ThreadExample extends Thread{
	@Override
	public void run(){
		
	}
	public static void main(String[] args) {
		ThreadExample obj = new ThreadExample();
		
	}
	public synchronized void f(){
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
