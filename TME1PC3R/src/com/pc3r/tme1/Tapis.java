/*
 * 
 * Modèle Producteurs / Consommateurs sur une mémoire partagée (tapis)
 * 
 * @author : BENSLIMANE AMINE
 *  Feb 2021
 *  Master 1 STL, Sorbonne Université
 */

package com.pc3r.tme1;

import java.util.ArrayList;

public class Tapis {
	
	//capacité maximale du tapis en nombre de paquets simultanéments présents;
	private int capMax;
	
	//tableau de paquets présents sur le tapis
	//private Paquet packs[];
	ArrayList<Paquet> packs;

	//taille actuelle du tapis (size <= capMax)
	private int size;
	
	//tête du tapis (position du premier paquet sur le tapis)
//	private int head;
	
	public Tapis(int capMax) {
		this.capMax = capMax;
		//this.packs = new Paquet[capMax];
		 this.packs = new ArrayList<Paquet>();
		this.size = 0;
		//this.head = 0;
	 
	}
 
	public int getSize() {
		return this.size;
	}
 
	/*public int getHead() {
		return this.head;
	}
	*/
	
	public synchronized void enfiler(Paquet pack) {
		synchronized(this) {
			//gérer le cas si tapis plein
			while(this.getSize() >= this.capMax)
				try {
					this.wait(); //endormir les producteurs
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt(); 
					System.err.println(e);
				}
			//enfilement du paquet
			 packs.add(pack);
			 
			this.notifyAll();

	
			//incrémentation de la taille actuelle (plutôt actualisation)
			this.size=packs.size();
		}
	}
	
	public synchronized Paquet defiler() {
		synchronized(this) {
			//gérer le cas si tapis vide
			while(this.getSize() ==0)
				try {
					this.wait(); //endormir les consommateurs
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt(); 
	                e.printStackTrace();
				} 
		//défiler l'élement le plus ancien (FIFO)
		Paquet p = packs.remove(0);
		
		notifyAll();
		return p;
			
		}
		
	}
 
 

}
