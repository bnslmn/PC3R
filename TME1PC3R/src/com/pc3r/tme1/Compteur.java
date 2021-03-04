package com.pc3r.tme1;

public class Compteur{
	
	private int cp;
	
	public Compteur(int c) {
		this.cp  = c;
	}
	

	public synchronized void decrementer() {
		this.cp--;
	}
	
	public int getValue() {
		return this.cp;
	}
	
	
}