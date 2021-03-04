/*
 * 
 * Modèle Producteurs / Consommateurs sur une mémoire partagée (tapis)
 * 
 * @author : BENSLIMANE AMINE
 *  Feb 2021
 *  Master 1 STL, Sorbonne Université
 */

package com.pc3r.tme1;

//Les paquets encapsulent une unique chaîne de caractère, ça représente les entités présentes dans le tapis;
public class Paquet {
	
	private String str;
	
	//constructeur du paquet avec sa dénomination
	public Paquet(String str) {
		this.str = str;
	}
	//getteur de la dénomination du paquet
	public String getNom() {
		return str;
	}

	/*
	public void setStr(String str) {
		this.str = str;
	}  */

}
