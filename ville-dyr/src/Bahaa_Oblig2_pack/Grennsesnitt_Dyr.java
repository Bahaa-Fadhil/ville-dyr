package Bahaa_Oblig2_pack;
import java.io.PrintStream;
import java.util.*;
import javax.swing.JOptionPane;

public class Grennsesnitt_Dyr {

	DyrRegister Dyrkontroll = new DyrRegister(); 
	
	private final String[] Meney1 = {"Register ny dyr","Gjenfanget dyr" , "S�k p� dyr","Gjenfanget dyr �rlig","Finn harer type","Rapport", "Avslutt"};
	private final String[] Meney2 = {"Harer","Gauper","Tilbake", "Avslutt"};
	private final String[] Meney3 = {"Gjennfanget Hare","Gjennfanget Gaupe","Tilbake", "Avslutt"};	
	
	private final int REG_NY_DYR = 0;
	private final int GJENFANFET = 1;
	private final int SOK_DYR = 2;
	private final int GJENFANGET_ARLIG =3 ;
	private final int FINNE_HARE = 4;
	private final int RAPPORT = 5;
	private final int AVSLUTT1 = 6;
	
	private final int HARER = 0;
	private final int GAUPER = 1;
	private final int TILBAKE = 2;
	private final int AVSLUTT2 = 3;
	
	private final int GJENFANGET_HARE = 0;
	private final int GJENFANGET_GAUPE = 1;
	private final int TILBAKE3 = 2;
	private final int AVSLUTT3 = 3;
	
	private String filnavn = "Ny_Dyr_Fil.txt"; 								// finnavn ved lagering av ny dyr med txt-format
	private String Gjenfilnavn = "Gjenfanget_Dyr_Fil.txt"; 				    // finnavn ved lagering av Gjenfanget dyr med txt-format
	
	
	// -------------------------------------------- Hoved meny Starter ----------------------------------------------------------------------
	
	public void meny1() throws Exception {
		boolean fortsett = true;
		
		while(fortsett) {	
			int valg = JOptionPane.showOptionDialog(
					null, //eventuelt foreldrevindu, her er det ikke noe
					"Gj�r et valg:", //ledetekst over knappene
					"Dyr Register", //navn p� vinduet
					JOptionPane.DEFAULT_OPTION, //vi skal ikke bry
					JOptionPane.PLAIN_MESSAGE,  //oss om hva disse to betyr
					null, //eventuelt ikon
					Meney1, //arrayen med alternativer
					Meney1[0]); //default alternativ
			
			
			
			switch(valg) {			
			case REG_NY_DYR: RegNyDyr();
			break;
			case GJENFANFET: Gjfanget();				
			break;
			case SOK_DYR : SokDyr();
			break;
			case GJENFANGET_ARLIG : gjenfangetArlig();
			break;
			case FINNE_HARE : FinnHare();
			break;
			case RAPPORT : Rapport();
			break;
			case AVSLUTT1 : Avslutt1();
			break;	
			default: fortsett = false;						
			}// Switch l�kke			
		} //L�kke		
 } //meny
	




	// ------------------------------------------- Register Ny dyr mathod ------------------------------------------------------------

	// metode for Register dyr
	public void RegNyDyr() throws Exception {	
		boolean fortsett = true;
		while(fortsett) {
			int valg = lesMenyValg(); 
	 
		 switch(valg) {		
		case HARER : Harer();
		break;
		case GAUPER : Gauper();
		break;		
		case TILBAKE: meny1();
		break;
		case AVSLUTT2 : Avslutt2();
		break;			
		default: fortsett = false;
		}// Switch l�kke	
		
	}		
} //  slutt p� RegNyDyr method
	

	// Les meny valg 2 
	public int lesMenyValg() {		
		int valg = JOptionPane.showOptionDialog(null, "Hvilke dyr vil du registere: ", "Register dyr",JOptionPane.DEFAULT_OPTION,
		JOptionPane.PLAIN_MESSAGE,null, Meney2, Meney2[0]); 	
		return  valg;
	}





// ------------------------------------------ Register Ny dyr sin mathoder -------(Harer eller Gauper)--------------------------------
	

	// Register dyr Harer mathod
	public void Harer() throws Exception {
				
		int ID =  Dyrkontroll.antallH ;
		String kjonn = JOptionPane.showInputDialog("Kj�nn(Hann eller Hunn): ");
		double lengde = Double.parseDouble(JOptionPane.showInputDialog("Lengde(cm): "));
		double vekt = Double.parseDouble(JOptionPane.showInputDialog("Vekt(kg): ")); 
		String dato = JOptionPane.showInputDialog("Dato (dd.mm.yyyy): ");
		String sted = JOptionPane.showInputDialog("Sted (Tekst): ");		
		String type = JOptionPane.showInputDialog("Type (Vanlig eller S�r): ").toString();
		String PelsenFarge = JOptionPane.showInputDialog("Pelsen farge (Tekst): ");	
		Dyrkontroll.RegNyHare(ID, kjonn, lengde, vekt, sted, dato, type, PelsenFarge);
		
		JOptionPane.showMessageDialog(null,"Hare er registert: \n\n\n" +  "Hare nr: "+ ID + "\nKj�nn: "+ kjonn + "\nLengde: "+  lengde +"\nVekt: "+ vekt +"\nSted: "+ sted +"\nType: "+ type +"\nPelsen Farge: "+ PelsenFarge + "\n\n");
		RegNyDyr(); //G� tilbake til hvoedmeny
	}
	
	
// -------------------------------------------- Register dyr Gauper mathod ----------------------------------------------------------------- 
	public void  Gauper() throws Exception {
	
		int ID = Dyrkontroll.antallG;
		String kjonn = JOptionPane.showInputDialog("Kj�nn (Hann eller Hunn): ");
		double lengde = Double.parseDouble(JOptionPane.showInputDialog("Lengde(cm): "));
		double vekt = Double.parseDouble(JOptionPane.showInputDialog("Vekt(kg): ")); 
		String dato = JOptionPane.showInputDialog("Dato (dd.mm.yyyy): ");
		String sted = JOptionPane.showInputDialog("Sted (Tekst): ");
		String oretausten = JOptionPane.showInputDialog("�retausten (Tekst): ");	
		Dyrkontroll.RegNyGaupe(ID, kjonn, lengde, vekt, sted, dato, oretausten);

		JOptionPane.showMessageDialog(null, "Hare er registert: \n\n\n" +"Gaupe nr: "+ ID +"\nKj�nn: "+ kjonn + "\nLengde: "+  lengde + " cm " + "\nVekt: "+ vekt + " kg "+ "\nSted: "+ sted +"\nDato: "+ dato +"\n�retasten: "+ oretausten +"\n");
		RegNyDyr(); //G� tilbake til hvoedmeny
	}

	//---------------------------------------  Avslutt mathode for Register ny Dyr -----------------------------------------
	public void Avslutt2() {
		System.exit(AVSLUTT2);	
		
	}

// ------------------------------------------- Register Gjenfanget dyr mathod ---------------------------------------------------
	public void  Gjfanget() throws Exception {
		boolean fortsett = true;
		while(fortsett) {
		int valg = JOptionPane.showOptionDialog(
				null, //eventuelt foreldrevindu, her er det ikke noe
				"Register ny opplysning: ", //ledetekst over knappene
				"Gjenfanget dyr ", //navn p� vinduet
				JOptionPane.DEFAULT_OPTION, //vi skal ikke bry
				JOptionPane.PLAIN_MESSAGE,  //oss om hva disse to betyr
				null, //eventuelt ikon
				Meney3, //arrayen med alternativer
				Meney3[0]); //default alternativ    		   

		switch(valg) {			
		case GJENFANGET_HARE: GjenfangetHarer();
		break;
		case GJENFANGET_GAUPE: GjenfangetGauper();				
		break;			
		case TILBAKE3: meny1();
		break;
		case AVSLUTT3 : Avslutt3();
		break;			
		default: fortsett = false;				
		}// Switch l�kke	
	}			
}


	// ------------------------------------------ Gjenfanget dyr sin mathoder -------(Gjenfanget Harer eller Gjenfanget Gauper)--------------------------------

	public void  GjenfangetHarer() throws Exception {
							
		int dyr = Dyrkontroll.hentGjenDyr().size(); 
		
		int finnID = Integer.parseInt(JOptionPane.showInputDialog("Skriv dyrets identitet:(kun nummer): "));
					
        boolean funnet = false; 
        for ( int i = 0; i < Dyrkontroll.DyrListe.size(); i++)   	  
        {
           if (dyr  == finnID)        
              	
        	   funnet = true;      
                       break;
               }
        {
        	  if (funnet)   // n�r funnet = true s� vil IDnr skrives ut
	          {
        		  JOptionPane.showMessageDialog(null, "Dyre hare  " + dyr + " er funnet i liste.");	  
        		  
        	        double lengde = Double.parseDouble(JOptionPane.showInputDialog("Lengde(cm): "));
        			double vekt = Double.parseDouble(JOptionPane.showInputDialog("Vekt(kg): ")); 
        			String dato = JOptionPane.showInputDialog("Dato(dd.mm.yyyy): ");
        			String sted = JOptionPane.showInputDialog("Sted(Tekst): ");		
        			String PelsenFarge = JOptionPane.showInputDialog("Pelsen farge(Tekst): ");						
        			
        			Dyrkontroll.GjfangetHare(lengde, vekt, sted, dato, PelsenFarge);		
        			JOptionPane.showMessageDialog(null, "Opplysning er registert  \n\n " + "Lengde: " + lengde + " cm \n" 
        			+ " Vekt: " + vekt + " kg" + "\nDato: " + dato + "\nSted: " + sted + "\nPelsenFarge: " + PelsenFarge + "\n");	

        		Gjfanget(); // G� tilbake til Gjenfanget meny
	          }
	          else
	          {
	                JOptionPane.showMessageDialog(null, "Fant ikke i dyr liste ");
	                
	                Gjfanget(); // G� tilbake til Gjenfanget meny
	          }	          	
			}
		
}	
	
	
	// -------------------------------------------------- Gjenfanget gaupe ------------------------------------------------------------------ 
	public void  GjenfangetGauper() throws Exception {
				
		int dyr = Dyrkontroll.hentGjenDyr().size(); 
		int finnID = Integer.parseInt(JOptionPane.showInputDialog("Skriv dyrets identitet:(kun nummer): "));
					
        boolean funnet = false; 
        for ( int i = 0; i < Dyrkontroll.DyrListe.size(); i++)
      	  
        {
           if (dyr  == finnID)        
              	
        	   funnet = true;      
                       break;
               }
        {
        	  if (funnet)   // n�r funnet = true s� vil IDnr skrives ut
	          {
        		  JOptionPane.showMessageDialog(null, "Dyre gaupe " + dyr + " er funnet i liste.");	
        		  
        	        JOptionPane.showMessageDialog(null, "Register ny opplysning: ");
        			double lengde = Double.parseDouble(JOptionPane.showInputDialog("Lengde(cm): "));
        			double vekt = Double.parseDouble(JOptionPane.showInputDialog("Vekt(kg): ")); 
        			String dato = JOptionPane.showInputDialog("Dato(dd.mm.yyyy): ");
        			String sted = JOptionPane.showInputDialog("Sted(Tekst): ");		
        			String oretausten = JOptionPane.showInputDialog("�retausten(Tekst): ");			
        			
        			Dyrkontroll.GjfangetGaupe(lengde, vekt, sted, dato, oretausten);
        			JOptionPane.showMessageDialog(null, "Opplysning er registert  \n\n " + "Lengde: " + lengde + " cm \n" 
                	+ " Vekt: " + vekt + " kg" + "\nDato: " + dato + "\nSted: " + sted + "\n �retausten: " + oretausten  + "\n");
        			 Gjfanget(); // G� tilbake til Gjenfanget meny
	          }
	          else
	          {
	        	  JOptionPane.showMessageDialog(null, "Fant ikke i dyr liste ");
	        	  Gjfanget(); // G� tilbake til Gjenfanget meny
	          }	          	
			}
							
}

	// Avslutt mathod for gjenfanget dyr meny
	public void  Avslutt3() {
		System.exit(AVSLUTT3);	
		
	}
	
	
	// ------------------------------------------ S�ke etter dyr metode ---------------------------------------------------------------
	
	
	public void  SokDyr() {
				
		   Dyr  allrDyr = Dyrkontroll.DyrListe.get(0); 	
		   int IDnr = Integer.parseInt(JOptionPane.showInputDialog("Skriv IDnr: "));

	           boolean funnet = false;    // set the boolean value to false until the Dyr is found
	         
	          for ( int i = 0; i < Dyrkontroll.DyrListe.size(); i++)	        	  
	          {
	             if (i  == IDnr)        
	                	 funnet = true;      
	                         break;                            
	                 }
	           
	          {		          
	          if (funnet)   // n�r funnet = true s� vil Dyret skrives ut
	           {	        	  
	        	  JOptionPane.showMessageDialog(null, "Dyet " + IDnr + " funnet med opplysning: \n\n" + "Dyr ID: " + allrDyr.ID 
	        			 + "\n Kj�nn: " +  allrDyr.kjonn +  "\n Lengde: " + allrDyr.lengde + " cm " +  "\n Vekt: " + allrDyr.vekt + " kg " 
	        			 +  "\n Sted:" + allrDyr.sted + "\n Dato: " + allrDyr.dato  + "\n"); 
	          }  
	         
	           
	          else
	          {
	        	  JOptionPane.showMessageDialog(null, "Dyr nr:  " + IDnr + " Finnes ikke i liste.");
	          }
	          	          
}
}	       


	// ------------------------------------------------------------- Gjenfanget �rlig mathode -------------------------------
	
	
	public void  gjenfangetArlig() {
				
		Gjenfanges Gjdyr = (Gjenfanges) Dyrkontroll.GjenfangesListe.get(0);		
		String IDnr = JOptionPane.showInputDialog("Skriv �rstall:  ");
	
        for ( int i = 1; i < Dyrkontroll.DyrListe.size(); i++)	        	  
          {       
             	if (Gjdyr.dato.equals(IDnr))  {   JOptionPane.showMessageDialog(null, "Antall  er:  " + Gjdyr.dato.length() + "\n " );  }      	  
            	
             	else  JOptionPane.showMessageDialog(null, "Dyr Type:  " + IDnr + " Finnes ikke i liste.");
        	  i++; 
          } 
		
	}		
// ------------------------------------------------------------- Hare kj�nn mathode -------------------------------
	public void  FinnHare() {
		
		
		int i = 0; 
		Hare haredyr = (Hare) Dyrkontroll.DyrListe.get(i);		
		String IDnr = JOptionPane.showInputDialog("Skriv Type (v eller s): ");
	
        for ( i = 0; i < Dyrkontroll.DyrListe.size(); i++)	        	  
          {  
             	if (haredyr.type.equals("v"))  {   JOptionPane.showMessageDialog(null, "Antall Vanlig harer er:  " + haredyr.type.length() + "\n " 
             			+ "Antall S�r harer er:  " + haredyr.type.length() + "\n "  );  }      	  
            	else  JOptionPane.showMessageDialog(null, "Dyr Type:  " + IDnr + " Finnes ikke i liste.");

        	  i++; 
          }  	  
	}
         
		
		

// -----------------------------------------------------Rapport metode -------------------------------------------------------------------	
	
	public void  Rapport() {

			try {	
				Dyrkontroll.skriveFil(filnavn); 
			}catch(Exception e){JOptionPane.showMessageDialog(null,e.getMessage());}
		}
	
	// ----------------------------------------------------- Avslutt metode -------------------------------------------------------------------	
	public void  Avslutt1() {
		System.exit(AVSLUTT1);	
		
	}
// -----------------------------------------------------Lese dyr Hare metode -------------------------------------------------------------------	
	public void lesFilDyr() {
		try {
			Dyrkontroll.lesDyr(filnavn);	
		}catch(Exception e){JOptionPane.showMessageDialog(null,e.getMessage());}
		
	}	
	
	public void skrivFiler() {
		try{
			Dyrkontroll.skrivFil(filnavn);		
		}catch(Exception e){JOptionPane.showMessageDialog(null,e.getMessage());}
	}
	
	
/** program slutter � leser andre metoder n�r to innlesning og skriver metoder er p� program.
	// ----------------------------------------------------- Lesening  gjenfanget dyr metode -------------------------------------------------------------------	
		public void lesFilGjefangetDyr() {
			try {
				Dyrkontroll.lesGjnfangetDyr(Gjenfilnavn);	
			}catch(Exception e){JOptionPane.showMessageDialog(null,e.getMessage());}
			
		}	
		
		public void skrivGjenfangetFil() {
			try{
				Dyrkontroll.skrivFil(Gjenfilnavn);
			}catch(Exception e){JOptionPane.showMessageDialog(null,e.getMessage());}
		}
			
*/
// ---------------------------------------- Slutt p� Hoved meny sim mathoder -------------------------------------------------------------

} // Slutt p� Grennsesnitt_Dyr klasse
