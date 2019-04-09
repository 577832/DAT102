package no.hvl.dat102;

public class ButikkMain {

	public static void main(String[] args) {
		
		Butikk b = new Butikk("Elkjøp", 100);
		
		b.leggInnNyVare(3);
		b.leggInnNyVare(10);
		b.leggInnNyVare(50);
		
		
		b.grossInnkjøp(3, 15);
		b.grossInnkjøp(10, 30);
		b.grossInnkjøp(50, 80);
		
		b.salgsVerdi();
		
		b.slettVare(4);
		
		b.detaljSalg(3);
		b.detaljSalg(10);
		
		b.finnVare(1);
		
		b.salgsVerdi();
		
		
		
		
		
		

	}

}
