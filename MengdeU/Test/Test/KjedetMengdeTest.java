package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

	public class KjedetMengdeTest {

	
		protected final static int SIZE = 6; 
		
		private MengdeADT<Integer> m1; 
		private MengdeADT<Integer> m2;
		private MengdeADT<Integer> fasitmengde; 
		
		private Integer e0 = 1; 
		private Integer e1 = 2; 
		private Integer e2 = 3; 
		private Integer e3 = 4; 
		private Integer e4 = 5; 
		private Integer e5 = 6; 
		
		@Before
		public final void setup() throws Exception {
			m1 = new KjedetMengde<Integer>(); 
			m2 = new KjedetMengde<Integer>(); 
			fasitmengde = new KjedetMengde<Integer>(); 
		}
		@Test
		public final void unionMedFelles() {
			
			m1.leggTil(e0);
			m1.leggTil(e1);
			m1.leggTil(e2);
			m1.leggTil(e3);
			m1.leggTil(e4);
			m1.leggTil(e5);
			
			m2.leggTil(e0);
			m2.leggTil(e1);
			m2.leggTil(e2);
			m2.leggTil(e3);
			m2.leggTil(e4);
			m2.leggTil(e5);
			
			fasitmengde.leggTil(e0);
			fasitmengde.leggTil(e1);
			fasitmengde.leggTil(e2);
			fasitmengde.leggTil(e3);
			fasitmengde.leggTil(e4);
			fasitmengde.leggTil(e5);
			
			MengdeADT<Integer> begge = m1.union(m2); 
			
			assertTrue(fasitmengde.equals(begge));
		}
		
		@Test
		public final void unionMedDisjunktiv() {
			m1.leggTil(e0);
			m1.leggTil(e1);
			m1.leggTil(e2);
			
			
			m2.leggTil(e5);
			m2.leggTil(e4);
			m2.leggTil(e3);
			
			
			fasitmengde.leggTil(e0);
			fasitmengde.leggTil(e1);
			fasitmengde.leggTil(e2);
			fasitmengde.leggTil(e3);
			fasitmengde.leggTil(e4);
			fasitmengde.leggTil(e5);
			
			MengdeADT<Integer> begge = m1.union(m2);
			assertTrue(fasitmengde.equals(begge));
		}
		
		@Test
		public final void snittMedDisjunktive() {
			
			m1.leggTil(e0);
			m1.leggTil(e1);
			m1.leggTil(e2);
			
			
			m2.leggTil(e3);
			m2.leggTil(e4);
			m2.leggTil(e5);
			
			MengdeADT<Integer>begge = m1.snitt(m2);
			assertTrue(begge.erTom()); 
			
			
		}
		@Test
		public final void snittMedFelles() {
			
			m1.leggTil(e0);
			m1.leggTil(e1);
			m1.leggTil(e2);
			
			m2.leggTil(e0);
			m2.leggTil(e1);
			m2.leggTil(e2);
			
			fasitmengde.leggTil(e0);
			fasitmengde.leggTil(e1);
			fasitmengde.leggTil(e2);
			
			MengdeADT<Integer> begge = m1.snitt(m2); 
			assertTrue(fasitmengde.equals(begge));
		}
		
		@Test
		public final void differensMedFelles() {
			
			m1.leggTil(e0);
			m1.leggTil(e1);
			m1.leggTil(e2);
			m1.leggTil(e3);
			
			m2.leggTil(e0);
			m2.leggTil(e1);
			m2.leggTil(e2);
			m2.leggTil(e3);
			
			
			MengdeADT<Integer> begge = m1.differens(m2);
			assertTrue(begge.erTom()); 
			
		}
		@Test
		public final void differensMedDisjunktiv() {
			
			m1.leggTil(e0);
			m1.leggTil(e1);
			m1.leggTil(e2);
			
			m2.leggTil(e3);
			m2.leggTil(e4);
			m2.leggTil(e5);
			
			fasitmengde.leggTil(e0);
			fasitmengde.leggTil(e1);
			fasitmengde.leggTil(e2);
			
			MengdeADT<Integer> begge = m1.differens(m2);
			assertTrue(fasitmengde.equals(begge)); 
		}
		
	
}
