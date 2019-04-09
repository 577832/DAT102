package no.hvl.dat102;

import static javax.swing.JOptionPane.*;

public class Butikk {

	private String navn;
	private Vare vare[];
	private int lager[];
	private int antallTyper;

	public Butikk(String navn, int maksVarer) {

		this.navn = navn;
		vare = new Vare[maksVarer];
		lager = new int[maksVarer];
		antallTyper = 0;
	}

	public int finnVare(int varenr) {

		int pos = -1;

		for (int i = 0; i < antallTyper; i++) {
			if (vare[i].getVarenummer() == varenr) {
				pos = i;
			}

		}
		return pos;

	}

	public boolean erLedigPlass() {

		return antallTyper < vare.length;

	}

	public void leggInnNyVare(int varenr) {

		if (finnVare(varenr) == -1 && erLedigPlass()) {
			Vare nyVare = new Vare(varenr);
			nyVare.lesVare(varenr);
			vare[antallTyper] = nyVare;
			antallTyper++;
		} else if (!erLedigPlass()) {
			System.out.println("Ikke ledig plass");

		}

	}

	public void slettVare(int varenr) {
		int pos = finnVare(varenr);

		if (pos == -1) {
			System.out.println("Varen finnes ikke");
		} else {
			vare[pos] = vare[antallTyper - 1];
			lager[pos] = lager[antallTyper - 1];

			vare[antallTyper - 1] = null;
			lager[antallTyper - 1] = 0;
			antallTyper--;
		}
	}

	public void detaljSalg(int varenr) {

		int pos = finnVare(varenr);
		if (pos == -1) {
			System.out.println("Vare ikke registrert");
		} else if (lager[pos] == 0) {
			System.out.println("Ingen igjen på lager");
		} else {
			lager[pos]--;
		}
	}

	public void grossInnkjøp(int varenr, int tall) {
		int pos = finnVare(varenr);

		if (pos == -1) {
			System.out.println("Varen finnes ikke");
		} else if (tall < 0) {
			System.out.println("Negativt tall, ikke gyldig");
		} else {
			lager[pos] = lager[pos] + tall;
		}
	}

	public void salgsVerdi() {
		double sum = 0.0;
		for (int i = 0; i < antallTyper; i++) {
			sum += vare[i].getPris() * lager[i];
		}
		System.out.println(sum);
	}
}
