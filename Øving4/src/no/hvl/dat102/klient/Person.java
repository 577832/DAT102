package no.hvl.dat102.klient;

public class Person implements Comparable<Person> {
	private String fornavn;
	private String etternavn;
	private int f�dsels�r;
	
	public Person() {
		fornavn = null;
		etternavn = null;
		f�dsels�r = 0;
	}
	
	public Person(String fornavn, String etternavn, int f�dsels�r) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.f�dsels�r = f�dsels�r;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public int getF�dsels�r() {
		return f�dsels�r;
	}

	public void setF�dsels�r(int f�dsels�r) {
		this.f�dsels�r = f�dsels�r;
	}
	
	public String toString() {
		return "Navn: " + fornavn + " " + etternavn + " F�dt: " + f�dsels�r;
	}

	@Override
	public int compareTo(Person p) {
		int resultat = 0;
		
		if (f�dsels�r > p.f�dsels�r) {
			resultat = -1;
		} else if (f�dsels�r < p.f�dsels�r) {
			resultat = 1;
		} else {
			if (etternavn.compareTo(p.etternavn) < 0) {
				resultat = -1;
			} else if (etternavn.compareTo(p.etternavn) > 0) {
				resultat = 1;
			} else {
				resultat = fornavn.compareTo(p.fornavn);
			}
		}
		
		return resultat;
	}
}