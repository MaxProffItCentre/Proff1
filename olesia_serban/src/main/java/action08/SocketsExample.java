package action08;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketsExample {
	public static void main(String[] args) {
		int port = 3129;
		new Starter<ServerSocketExample>(new ServerSocketExample(port));
		new Starter<ClientSocketExample>(new ClientSocketExample(port));
	}
}
class Starter<T extends Thread>{
	public Starter(T obj){
		obj.start();
	}
}

class ServerSocketExample extends Thread {
	private final int port;
	public ServerSocketExample(int port){
		this.port = port;
	}
	public void run() {
		ServerSocket server =null;
		try {
			server = new ServerSocket(port);
			System.out.println("Server started!");
			
			Socket socket = server.accept();
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();

			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);

			String message = "";
			while (true) {
				message = dis.readUTF();
				System.out.println("Server. I get message[" + message+"] ");
				dos.writeUTF("Server send message to client[" + message+"] ");
				dos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(server != null){
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class ClientSocketExample extends Thread{
	private final int port;
	public ClientSocketExample(int port){
		this.port = port;
	}
	public void run() {
		Socket socket = null;
		try {
			socket = new Socket("localhost", port);
			System.out.println("Client started!");
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();

			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			while(true){
				System.out.print("Client. I am waiting:");
				String message = keyboard.readLine();
				dos.writeUTF(message);
				dos.flush();
				String backMassage = dis.readUTF();
				System.out.println("Client. I get message from server[" + backMassage+"] ");				
			} 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(socket!=null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
