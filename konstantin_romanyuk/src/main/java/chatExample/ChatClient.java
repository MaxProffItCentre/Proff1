package chatExample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import chatExample.ChatServer.ServerSocketChat;
import chatExample.ChatServer.Starter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChatClient extends Application {
	public static TextField txt=new TextField("");
	public static int port;
	public static OutputStream out;
	public static DataOutputStream dos;
	
	public static void main(String[] args) {
		port=3129;
		try {
			
			Socket socket = new Socket("localhost", port);
			
			System.out.println("Client started!");
			
			out = socket.getOutputStream();
           dos = new DataOutputStream(out);
            
			}catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
			launch(args);}
	
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Chat_Client");
		primaryStage.setScene(createScene1());
		primaryStage.show();
	}

	public Scene createScene1() {
		Group group = new Group();
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
		Scene scene = new Scene(group, 400, 200);
		return scene;
	}

}
