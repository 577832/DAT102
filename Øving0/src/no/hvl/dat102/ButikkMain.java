package no.hvl.dat102;

public class ButikkMain {

	public static void main(String[] args) {
		
		Butikk b = new Butikk("Elkj�p", 100);
		
		b.leggInnNyVare(3);
		b.leggInnNyVare(10);
		b.leggInnNyVare(50);
		
		
		b.grossInnkj�p(3, 15);
		b.grossInnkj�p(10, 30);
		b.grossInnkj�p(50, 80);
		
		b.salgsVerdi();
		
		b.slettVare(4);
		
		b.detaljSalg(3);
		b.detaljSalg(10);
		
		b.finnVare(1);
		
		b.salgsVerdi();
		
		
		
		
		
		

	}

}
