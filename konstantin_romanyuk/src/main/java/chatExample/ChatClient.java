package chatExample;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChatClient extends Application implements Runnable{
	private static TextField txt=new TextField("");
	private static int port;
	private static OutputStream out;
	private static DataOutputStream dos;
	private Socket socket=null;
	
	public static void main(String[] args) {
		port=3129;
		Thread th = new Thread(new ChatClient());
		th.start();
		
			launch(args);}
	public ChatClient(){
		
	} 
	
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Chat_Client");
		primaryStage.setScene(createScene1());
		primaryStage.show();
	}

	public Scene createScene1() {
		Group group = new Group();
			txt.setMinSize(100, 40);
		group.getChildren().add(txt);
		Button b1=new Button("Send Message");
		b1.setOnAction(new EventHandler<ActionEvent>(){

			public void handle(ActionEvent event) {
				try {
	                dos.writeUTF(txt.getText());
	                txt.clear();
	                dos.flush();}catch (UnknownHostException e) {
	    				e.printStackTrace();
	    			} catch (IOException e) {
	    				e.printStackTrace();
	    			}
				
			
		}});
		group.getChildren().add(b1);
		b1.setLayoutY(50);
		Scene scene = new Scene(group, 400, 200);
		return scene;
	}
	/*class ClientSocket extends Thread{
		private final int port;
		public ClientSocket(int port){
			this.port = port;
		}
		public void run() {
			try {
				Socket socket = new Socket("localhost", port);
				System.out.println("Client started!");
				
				InputStream in = socket.getInputStream();
				OutputStream out = socket.getOutputStream();

				DataInputStream dis = new DataInputStream(in);
				DataOutputStream dos = new DataOutputStream(out);
				
				
				
					String message = txt.getText();
					dos.writeUTF(message);
					dos.flush();
									
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}}*/
	@Override
	public void run() {
try {
			
			 socket = new Socket("localhost", port);
			
			System.out.println("Client started!");
			
			out = socket.getOutputStream();
           dos = new DataOutputStream(out);
            
			}catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
}
