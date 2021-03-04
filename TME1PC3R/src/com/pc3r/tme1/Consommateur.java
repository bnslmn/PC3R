package com.pc3r.tme1;

public class Consommateur implements Runnable {
	private static int nbCons = 0;
	
	private Tapis tapis;
	private Compteur cpt;
	private int id;
	
	public Consommateur(Tapis tapis, Compteur cpt) {
		nbCons++;

		this.tapis = tapis;
		this.id = nbCons;
		this.cpt = cpt;	
	}
	
	@Override
	public synchronized void run() {		
		synchronized(this) {
			while(this.cpt.getValue() > 0) {
				Paquet paquet = tapis.defiler();
				System.out.println("C"+this.id+" mange "+paquet.getNom());
				this.cpt.decrementer();
			}
		}
		
	}

}
