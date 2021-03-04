package com.pc3r.tme1;

public class Main {
	
	public static void main(String[] args) {
		
		Tapis tapis =  	new Tapis(5);
		Compteur compteur = new Compteur(10);
		
		Thread th_p1 = new Thread(
									new Producteur("Pomme", 5, tapis));
		Thread th_p2 = new Thread(
									new Producteur("Abricot", 8, tapis));
		Thread th_p3 = new Thread(
									new Producteur("Datte", 7, tapis));
		
		Thread th_c1 = new Thread(
									new Consommateur(tapis, compteur));
		Thread th_c2 = new Thread(
									new Consommateur(tapis, compteur));
		Thread th_c3 = new Thread(
									new Consommateur(tapis, compteur));
		
		//***** starting producers..
		th_p1.start();
		th_p2.start();
		th_p3.start();
		//**** starting consumers...
		th_c1.start();
		th_c2.start(); 
		th_c3.start();
		
		synchronized(compteur) {
			while(compteur.getValue() > 0) {
				try {
					tapis.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Fin d'execution");
			
		}
		
		
	}
	
	

}
