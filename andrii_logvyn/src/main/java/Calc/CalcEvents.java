package Calc;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalcEvents  {
	private static AbstractProcessor processor = new TestProcessor();
	private static Calc calcProc = new Calc(processor);
	
	public static class ButtonEvent<T> implements EventHandler {

		private Button btn;
		private TextField txtField;

		@Override
		public void handle(Event event) {
			btn = (Button) event.getSource();
			if (btn.getText().charAt(0) == 'C') {
				txtField.clear();
				calcProc.inSymv('C');
			} else {
				txtField.setText(txtField.getText()
						+ btn.getText());
				calcProc.inSymv(btn.getText().charAt(0));
				if (btn.getText().charAt(0) == '=') {
					txtField.setText(txtField.getText()
							+ String.valueOf(processor.getResult()));
				}
			}

		}

		public ButtonEvent(TextField field) {
			txtField = field;
		}
	}

}
