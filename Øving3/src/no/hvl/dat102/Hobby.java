package no.hvl.dat102;

public class Hobby {

	private String hobbyNavn;
	 public Hobby(String hobby){
	 hobbyNavn = hobby;
	 
	 }
	 public String toString(){
	/* … returnerer hobbynavnet med ”<” foran og ”>” bak
	som en String (Eksempel: <tegne, male>)
	*/
		 
		 
	}
	public boolean equals(Object hobby2){ //
	 Hobby hobbyDenAndre = (Hobby)hobby2;
	 return(hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	 } 
}
