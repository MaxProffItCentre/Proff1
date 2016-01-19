package CMS;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

public class Events {
		 //static Zakaz zakaz;
		
		public static class ButtonF12Event<T> implements EventHandler{
			private Zakaz zakaz;
			
			public ButtonF12Event(Zakaz zakaz){
				this.zakaz = zakaz;
			}
			@Override
			public void handle(Event event) {
				FileChooser fW = new FileChooser();
				File file = fW.showSaveDialog(null);
				try {
					FileWriter fwr = new FileWriter(file);
					fwr.write(zakaz.getClient().getText() +"\n");
					fwr.write(zakaz.getDateZakaz().getValue().toString());
					fwr.flush();
					fwr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(file.getName());
				//System.out.println(zakaz.getClient().getText());
				//System.out.println(zakaz.getDateZakaz().getValue().toString());
				
			}
			
		}
		
		public static class ButtonF11Event<T> implements EventHandler{
			private Zakaz zakaz;
			
			public ButtonF11Event(Zakaz zakaz){
				this.zakaz = zakaz;
			}
			@Override
			public void handle(Event event) {
				FileChooser fW = new FileChooser();
				String tmpStr = "";
				//File file = fW.showOpenDialog(null);
				try {
					FileReader fr = new FileReader(fW.showOpenDialog(null));
					Scanner scanFile = new Scanner(fr);
					while(scanFile.hasNext()){
						tmpStr += scanFile.next()+"~";
					}
					//System.err.println(tmpStr);
					String[] str = tmpStr.split("~");
					zakaz.setClient(str[0]);
					zakaz.setDateZakazValue(str[1]);
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(file.getName());
				//System.out.println(zakaz.getClient().getText());
				//System.out.println(zakaz.getDateZakaz().getValue().toString());
				
			}
			
		}
}
