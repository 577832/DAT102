package ADT;

import no.hvl.dat102.CD;
import no.hvl.dat102.Sjanger;

public interface CDarkivADT {

	/**
	 * 
	 * @return cd tabell
	 */
	
	 CD[] hentCdTabell();
	 /**
	  * 
	  * @param nyCd
	  */
	
	 void leggTilCd(CD nyCd);
	 /**
	  * 
	  * @param cdNr
	  * @return boolean
	  */
	
	 boolean slettCd(int cdNr);
	 
	 /**
	  * 
	  * @param delstreng
	  * @return CD[]
	  */
	
	 CD[] sokTittel(String delstreng);
	 /**
	  * 
	  * @param delstreng
	  * @return CD[]
	  */
	 
	 CD[] sokArtist(String delstreng);
	 /**
	  * 
	  * @param sjanger
	  * @return int
	  */
	
	 int antallSjanger(Sjanger sjanger);
	 /**
	  * 
	  * @return int
	  */
	
	 
	 int antall();
	 /**
	  * 
	  */
	}//interface 
