package BattleShip;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Test {
public static void main(String[] args) {
//	Media media = new Media("D:/1.wav");
	
	try{
	AudioInputStream clip3 = AudioSystem.getAudioInputStream(new File("file:///d:/1.wav").getAbsoluteFile());
	Clip clip2=AudioSystem.getClip();
	clip2.open(clip3);
	clip2.start();
	} catch (Exception ex){
		System.out.println("Error with playing file");
		ex.printStackTrace();
	}
	
//	try {
//		AudioClip	clip = Applet.newAudioClip(new URL("file:///d:/mu.mp3"));
//		clip.play();
//		
//	} catch (MalformedURLException murle) {
//		System.out.println(murle);
//		
//	}
}
}
