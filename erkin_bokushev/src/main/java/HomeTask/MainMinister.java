package HomeTask;

import java.util.ArrayList;

import HomeTask.MinisterBuilder.BuilderMinisterBuilder;

public class MainMinister {
	public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
		ArrayList<Deputy> deputies = new ArrayList<Deputy>();
		Minister ministerSingl = MinisterSingleTon.getPrimeMinister();
		Minister ministerBuild = new BuilderMinisterBuilder().setName("MinistrFinansov").setTarif((int)(Math.random()*10000)).build();
		MinisterPrototype prototypeMin = new MinisterPrototype();
		prototypeMin.setName("MinistrEconomy");
		prototypeMin.setTarif((int)(Math.random()*10000));
		Minister ministerProt = prototypeMin.copy();
		
		ArrayList<Deputy> deputs = new ArrayList<Deputy>();
		Budget.setSummaBudget(15000000);
		
		while (Budget.getSummaBudget() > 0) {
			try {
				deputs.add(ministerSingl.newAssistant());
				deputs.add(ministerBuild.newAssistant());
				deputs.add(ministerProt.newAssistant());
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("ministerSingl " + ministerSingl.name() + " = " + ministerSingl.grab());
		System.out.println("ministerBuild " + ministerBuild.name() + " = " + ministerBuild.grab());
		System.out.println("ministerProt " + ministerBuild.name() + " = " + ministerProt.grab());
		for (Deputy dep: deputs) {
			System.out.println("Deputy from " + dep.name() + " = " + dep.grab());
		}
	}
	
}
