package chatExample;
import java.net.*;
import java.io.*;
public class ChatServerThread extends Thread
{  private Socket          socket   = null;
private ChatServerINet      server   = null;
private int             ID       = -1;
private DataInputStream streamIn =  null;

public ChatServerThread(ChatServerINet _server, Socket _socket)
{  server = _server;  socket = _socket;  ID = socket.getPort();
}
public void run()
{  System.out.println("Server Thread " + ID + " running.");
   while (true)
   {  try
      {  ChatServerINet.txt.appendText(streamIn.readUTF());
      }
      catch(IOException ioe) {  }
   }
}
public void open() throws IOException
{  streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
}
public void close() throws IOException
{  if (socket != null)    socket.close();
   if (streamIn != null)  streamIn.close();
}
}
