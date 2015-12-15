package Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Server extends Application {
	private static ServerSocket sSocket = null;
	static Thread tr = null;
	private static boolean state = true;
	public static void main(String[] args) throws Exception {

		tr = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					//System.out.println("test");
					sSocket = new ServerSocket(6633);
					while (state) {
						Socket socket = sSocket.accept();
						new Thread(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								System.out.println(Math.random()+123);
							}

						}).start();
					}
				} catch (IOException exp) {
					exp.printStackTrace();
				} finally {
					try {
						sSocket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		});
		//tr.join();
		tr.start();
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ServerChat");
		stage.setScene(CreateScene());
		stage.show();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				System.exit(0);

			}
		});

	}

	public Scene CreateScene() {
		Pane pane = new Pane();
		TextArea text = new TextArea();
		text.setPrefSize(150, 200);
		text.appendText("Test \n");
		text.appendText("Test1");
		pane.getChildren().add(text);
		Scene scene = new Scene(pane, 600, 600);
		return scene;

	}

}

/*class ServerS {
	private boolean state = true;
	ServerSocket sSocket = null;

	public ServerS() {
		// sSocket = null;
		try {
			sSocket = new ServerSocket(6633);
			while (state) {
				Socket socket = sSocket.accept();
				Thread tr = new Thread(new ServerSocketRun(socket));
			}
		} catch (IOException exp) {
			exp.printStackTrace();
		} finally {
			try {
				sSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void setState(boolean stateWhile) {
		this.state = stateWhile;
	}

	public ServerSocket getServerSocket() {
		return this.sSocket;
	}
}
*/
class ServerSRun {
	private Socket socket;

	public ServerSRun(Socket socket) {
		this.socket = socket;
		System.out.println("Run");
	}

}
