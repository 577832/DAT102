package no.hvl.dat102;

public class ParforholdKlient {  
public static void main(String[] args) {
    Par<String> strPar = new Par<String>("Ole", "Kari");   
    Par<Integer> intPar = new Par<Integer>(2018, 2019);
    
    String navn1 = strPar.getFoerste(); 
    System.out.println(navn1);
    
    String navn2 = strPar.getAndre(); 
    System.out.println(navn2);
    
    System.out.println(navn2);
    System.out.println(strPar);
    
    System.out.println();
    System.out.println();
    
    
    
    int tall1 = intPar.getFoerste(); 
    System.out.println(tall1);
    
    System.out.println(strPar);
    String maksStreng = strPar.maks();
    System.out.printf("stoerste %s%n",maksStreng);        
    //--------------------------------------
    System.out.println(intPar);
    int maksHeltall = intPar.maks();
    System.out.printf("stoerste %d%n",maksHeltall);      
  }
}

