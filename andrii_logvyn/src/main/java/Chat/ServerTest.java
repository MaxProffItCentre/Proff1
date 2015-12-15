package Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	
	public ServerTest() {
		ServerSocket sSocket = null;
		try{
		sSocket = new ServerSocket(6533);
		while(true){
			Socket socket = sSocket.accept();
			new Thread(new ServerSocketRun(socket)).start();
		}
		}catch(IOException exp){
			exp.printStackTrace();
		}finally{
			try {
				sSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)  {
		new ServerTest();
	}


}

class ServerSocketRun implements Runnable{
	private Socket socket;
	public  ServerSocketRun(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		//System.out.println("Run");
		
	}
	
}