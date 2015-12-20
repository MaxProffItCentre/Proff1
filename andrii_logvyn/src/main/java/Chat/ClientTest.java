package Chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {

	public static void main(String[] args) throws UnknownHostException, IOException {
		new Thread(new ClientRun()).start();
	}

}

class ClientRun implements Runnable{

	@Override
	public void run() {
		Socket socket = null;
		try {
			socket = new Socket("localhost", 6633);
			//if(socket.isConnected())System.out.println("Connected!");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
