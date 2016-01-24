package chatExample;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChatServer extends Application {
	public static TextArea txt=new TextArea();
	
	public static void main(String[] args) {
	int port=3129;
	
	new Starter(new ServerSocketChat(port));
		
	/*try {
		server = new ServerSocket(port);
		System.out.println("Server started!");
		int i=1;
		Socket socket = server.accept();
		System.out.println("Client accepted" + i);
		Runnable r=new ThreadChatServer(socket);
		Thread t=new Thread(r);
		t.start();
		i++;
	} catch (IOException e) {
		
		e.printStackTrace();
	} finally{
		if(server != null){
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}}}*/
	launch(args);}
	
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Chat_Server");
		primaryStage.setScene(createScene1());
		primaryStage.show();
		
	}
	public Scene createScene1(){
		Group group = new Group();
		txt.setPrefSize(380, 560);
		txt.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
		group.getChildren().add(txt);
		Scene scene = new Scene(group, 400, 600);
		return scene;} 
static class Starter<T extends Thread>{
	public Starter(T obj){
		obj.start();
	}
}

static class ServerSocketChat extends Thread {
	private final int port;
	public ServerSocketChat(int port){
		this.port = port;
	}
	public void run() {
		ServerSocket server =null;
		try {
			server = new ServerSocket(port);
			System.out.println("Server started!");
			while(true){int i=1;
			Socket socket = server.accept();
			Runnable r=new ThreadChatServer(socket);
			Thread t=new Thread(r);
			t.start();
			i++;}
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
}

static class ThreadChatServer implements Runnable {
private Socket socket;
    public ThreadChatServer(Socket i){this.socket=i;}
	public void run() {
		try{
			
		InputStream in = socket.getInputStream();
		//OutputStream out = socket.getOutputStream();

		DataInputStream dis = new DataInputStream(in);
		//DataOutputStream dos = new DataOutputStream(out);
		String message=" ";
		while(true) {message=dis.readUTF();
		txt.appendText(message);
		}
			
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

}}