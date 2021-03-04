package com.pc3r.tme1;

public class Producteur implements Runnable {

	private Tapis tapis;
	private int cibleProd;
	private String prod;
	
	public Producteur(String prod, int cibleProd, Tapis tapis) {
		this.prod = prod;
		this.cibleProd = cibleProd;
		this.tapis = tapis;
	}
	
	@Override
	public void run() {
		for(int i=0 ; i < this.cibleProd ; i++) {
			tapis.enfiler(new Paquet(prod+" "+i));
		}
		
	}
	
	public int getCible() {
		return this.cibleProd;
	}

	
}
