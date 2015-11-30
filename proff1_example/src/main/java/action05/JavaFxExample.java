package action05;

public class JavaFxExample extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Первое приложение");
		stage.setScene(createScene());
		stage.show();
	}
	public Scene createScene(){
		return null;
	}
}
