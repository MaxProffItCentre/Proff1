package Ministry;

import java.util.ArrayList;

public interface IMinister   {
	public Assistants newAssistant() throws InterruptedException;
	public int Grub();
	public void setGrub(int k);
	public ArrayList<Assistants> getAssistentu();
	public int getTarif();
	public Object clone() throws CloneNotSupportedException;
	
	
}

