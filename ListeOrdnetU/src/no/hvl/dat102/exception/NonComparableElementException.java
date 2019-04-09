package no.hvl.dat102.exception;

public class NonComparableElementException extends RuntimeException {


   /******************************************************************
     Setter opp et unntak med passende melding.
   ******************************************************************/
   public NonComparableElementException (String samling) {
      super ("" + samling + " er tom.");
   }
}

