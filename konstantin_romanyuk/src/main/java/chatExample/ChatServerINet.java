package chatExample;
import java.net.*;

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

import java.io.*;

public class ChatServerINet extends Application implements Runnable
{ 
	
private ServerSocket     server = null;
private Thread           thread = null;
private ChatServerThread client = null;
static TextArea txt;

public ChatServerINet(int port)

{txt=new TextArea();  try
   {  System.out.println("Binding to port " + port + ", please wait  ...");
      server = new ServerSocket(port);  
      System.out.println("Server started: " + server);
      start();
   }
   catch(IOException ioe)
   {  System.out.println(ioe); }
}
public void run()
{  while (thread != null)
   {  try
      {  System.out.println("Waiting for a client ..."); 
         addThread(server.accept());
      }
      catch(IOException ie)
      {  System.out.println("Acceptance Error: " + ie); }
   }
}
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
public void addThread(Socket socket)
{  System.out.println("Client accepted: " + socket);
   client = new ChatServerThread(this, socket);
   try
   {  client.open();
      client.start();
   }
   catch(IOException ioe)
   {  System.out.println("Error opening thread: " + ioe); }
}
public void start()
{  if (thread == null)
   {  thread = new Thread(this); 
      thread.start();
   }
}
public void stop()
{  if (thread != null)
   {  thread.interrupt(); 
      thread = null;
   }
}
public static void main(String[] args)
{  ChatServerINet server = null;
   server = new ChatServerINet(3129);
   launch(args);}
}
