package no.hvl.dat102;

import java.util.Scanner;

import ADT.CDarkivADT;

import static java.lang.Integer.*;

public class Meny {

	private Tekstgrensesnitt tekstgr;
	private CDarkivADT cda;
	public static final Scanner IN = new Scanner(System.in);
	public static final String SKILLE = "-------------------------------------------";

	public Meny(CDarkivADT cda) {
		tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
	}

	public void start() {
		boolean gyldig = false;
		String filnavn = " ";

		do {
			System.out.println("Vil du jobbe med et eksisterende arkiv? Ja/Nei");
			String svar = IN.nextLine();
			System.out.println(SKILLE);

			if (svar.equals("ja")) {
				System.out.println("Skriv inn filnavnet du vil jobbe med: ");
				filnavn = IN.nextLine();
				System.out.println(SKILLE);
				cda = Fil.lesFraFil(filnavn);
				gyldig = true;

			} else if (svar.equals("nei")) {
				System.out.println("Skriv inn navnet på den nye filen: ");
				filnavn = IN.nextLine();
				System.out.println(SKILLE);
				gyldig = true;
			} else {
				System.out.println(svar + " er et ugyldig svar ");
			}
		} while (!gyldig);

		int input = 1;

		do {
			Tekstgrensesnitt.operasjoner();

			input = Integer.parseInt(IN.nextLine());
			switch (input) {
			case 1:
				cda.leggTilCd(tekstgr.lesCD());
				break;
			case 2:
				System.out.println("Hvilken CD vil du slette? Skriv CD nummer");
				int valg1 = Integer.parseInt(IN.nextLine());
				cda.slettCd(valg1);
				break;
			case 3:
				System.out.println("Skriv delstrengen du vil hente CD med");
				String ds = IN.nextLine();
				tekstgr.skrivUtCdDelstrengITittel(cda, ds);
				break;
			case 4:
				System.out.println("Skriv deler av navnet på artisten du vil hente CD fra");
				String ds2 = IN.nextLine();
				tekstgr.skrivUtCdArtist(cda, ds2);
				break;
			case 5:
				System.out.println("Antall CD'er: " + cda.antall());
				break;
			case 6:
				tekstgr.skrivUtStatistikk(cda);
				break;

			}
		} while (input != 0);

		Fil.skrivTilFil(cda, filnavn);
		System.out.println("Filen " + filnavn + ".txt ble lagret i mappen" + System.getProperty("user.dir"));
		System.out.println("Programmet er avsluttet");
		IN.close();
	}

}
