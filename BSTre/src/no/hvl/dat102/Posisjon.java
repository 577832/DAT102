package no.hvl.dat102;

public class Posisjon {

	private int pos; 
	public Posisjon() {
		pos = 0;
	}
	public int getPos() {
		return pos; 
	}
	public void neste() {
		pos++;
	}
	int f(int a) {
		a++; 
		return a; 
	}
	
}
