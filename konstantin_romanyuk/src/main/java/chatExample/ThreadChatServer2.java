package chatExample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.io.OutputStream;
import java.net.Socket;

public class ThreadChatServer2 implements Runnable {
private Socket socket;
    public ThreadChatServer2(Socket socket){this.socket=socket;}
	public void run() {
		try{
			
		InputStream in = socket.getInputStream();
		//OutputStream out = socket.getOutputStream();

		DataInputStream dis = new DataInputStream(in);
		//DataOutputStream dos = new DataOutputStream(out);
		String message=" ";
		while(true) {message=dis.readUTF();}
			
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				if(socket != null){
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		
	}

}
