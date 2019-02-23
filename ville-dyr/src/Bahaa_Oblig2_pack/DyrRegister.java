package Bahaa_Oblig2_pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class DyrRegister {
		 
	ArrayList<Dyr> DyrListe = new ArrayList<Dyr>(); 						 // arraylist for å registre Gjenfanget dyr	
	ArrayList<Gjenfanges> GjenfangesListe = new ArrayList<Gjenfanges>();	 // arraylist for å registre ny dyr

	int antallH = 0; 
	int antallG = 0;
	private String postfil = "Ny_Dyr_Fil.txt"; 								// finnavn ved lagering av ny dyr med txt-format
	private String Gjenfilnavn = "Gjenfanget_Dyr_Fil.txt"; 				    // finnavn ved lagering av Gjenfanget dyr med txt-format

	
	
	public void Dyr(int ID,String kjonn,double lengde, double vekt,String sted, String dato) {
		DyrListe.add(new Dyr(ID,kjonn,lengde, vekt, sted, dato));
	}
 
	
	// ---------------------------------------- Finne dyr id mathode -------------------------------------------
	public Dyr getID(int ID) {
		boolean funnet = false;
		int teller = 0;
		Dyr id = null;
		while(!funnet) {
			id = DyrListe.get(teller);
			id.getID();
			if(id.equals(ID)) return id;
			else teller++;
		}return null;
	}
	
	
	
	// ---------------------------------------- Finne hare type mathode -------------------------------------------
	
	public Hare getType(String type) {
		boolean funnet = false;
		int teller = 0;
		Hare TypeVS = null;
		while(!funnet) {
			TypeVS = (Hare) DyrListe.get(teller) ;
			TypeVS.getType();
			if(TypeVS.equals(TypeVS)) return TypeVS;
			else teller++;
		}return null;
	}
	
	
// ---------------------------------------------- Reigster ny Hare mathod ------------------------------------------------------------
	
	
	public void RegNyHare(int ID,String kjonn,double lengde, double vekt,String sted, String dato, String type, String PelsenFarge) throws Exception {
		
		antallH = 0;	
		for ( int i = 0; i <DyrListe.size(); i++) if (i == antallH) { antallH++; }   	       
		ID = antallH ++;  		
		Hare nyhare = new Hare(ID,kjonn,lengde, vekt, sted,dato, type, PelsenFarge);
		DyrListe.add(nyhare);	

		skrivFil(postfil);
		// lesFilDyr(postfil);
				
	}


// ----------------------------------------------- Reigster ny Gaupe mathod ------------------------------------------------------------
	
	
	public void RegNyGaupe(int ID,String kjonn,double lengde, double vekt,String sted, String dato, String oretausten) throws Exception {
		
		 antallG = 0;
		for ( int i = 0; i <DyrListe.size(); i++) if (i == antallG) { antallG++; } 
		ID =  antallG++;	
		Gaupe nygaupe = new Gaupe(ID,kjonn,lengde, vekt, sted,dato,oretausten);
		DyrListe.add(nygaupe);
		
		
	}
	
	
	
// --------------------------------------------- Reigster Gjenfanget Hare matod ------------------------------------------------------------
	
	
	public void GjfangetHare(double lengde, double vekt,String sted, String dato, String PelsenFarge) throws Exception {
			
		HareGj hareGj = new HareGj(sted, vekt, lengde,dato, PelsenFarge);
		GjenfangesListe.add(hareGj);
	}	
	
// ---------------------------------------------- Reigster Gjenfanget Gaupe matod ------------------------------------------------------------
	
	
	public void GjfangetGaupe(double lengde, double vekt,String sted, String dato, String oretausten) throws Exception {
		
		GaupeGj gaupeGj = new GaupeGj(sted, vekt, lengde,dato, oretausten);
		GjenfangesListe.add(gaupeGj);
	}

// -----------------------------------------Finne Gjenfanget dyr metode ---------------------------------------------------------------
	
	public Gjenfanges finnGjenFangetID(int Id) {
		boolean funnet = false;
		int teller = 0;
		Gjenfanges enDyr = null;
		while(!funnet) {
			enDyr = GjenfangesListe.get(teller);
			enDyr.getID();
			if(enDyr.equals(Id)) return enDyr;
			else teller++;
		}return null;
	}
	
	


// ----------------------------------------------------------- Reader ------------------------------------------------------------------------
	
	public BufferedReader leseFil(String filnavn) throws Exception {
	
		BufferedReader innfil=null;
		try {
			File f=new File(filnavn);
	 		FileInputStream fs=new FileInputStream(f);
	 		InputStreamReader isr=new InputStreamReader(fs);
			innfil=new BufferedReader(isr);
		} catch(Exception e){throw new Exception(" Kan ikke opprette fil.");}
		return innfil;
	} //Slutt metode
	
	
	
// -----------------------------------------------------Skrive til fil ----------------------------------------------------
		public PrintStream skriveFil(String filnavn) throws Exception {	
			PrintStream utfil=null;
			try {
				utfil=new PrintStream(new FileOutputStream(new File(filnavn)));
			}catch(Exception e){throw new Exception(" Kan ikke opprette skriveforbinelse.");}
			return utfil;
		} //Slutt metode	
		
// ------------------------------------------- Lageringes til fil matode -------------------------------------------------------
		
		public void skrivDyr(String filnavn) throws Exception{
			PrintStream utfil = null;
			try {
				utfil = skriveFil(filnavn);
				for(int i = 0;i < DyrListe.size();i++) {
					utfil.println(DyrListe.get(i).toFile());
				}
				//utfil.close();  // lukke fil 
			}catch(Exception e) {throw new Exception("Kan ikke lagre fil");}
			finally {
				try {
					if(utfil != null) utfil.close();
				}catch(Exception e){}
			}
		}
		
// --------------------------------------------------Lesning av dyr data ----------------------------------------------------------------------------
		
		public void lesDyr(String postfil) throws Exception {
			BufferedReader innpost = leseFil(postfil);
			String innlinje;		
			StringTokenizer inndata;
	
		try {
				while(innpost.ready()) {
					innlinje = innpost.readLine();
					inndata = new StringTokenizer(innlinje,",");
					while(inndata.hasMoreTokens()) {
						
						int ID = Integer.parseInt( inndata.nextToken());
						String kjonn = inndata.nextToken();
						String sted  = inndata.nextToken();
						double lengde = Double.parseDouble(inndata.nextToken());
						double vekt  = Double.parseDouble(inndata.nextToken());		
						String dato = inndata.nextToken();									
						
						Dyr nyDyr = new Dyr(ID, kjonn,vekt , lengde, sted, dato );						
						DyrListe.add(nyDyr);					                     
					} //innlesing av dyr
				} //innlesing av dyr
				//innpost.close();
			}catch(Exception e) {throw new Exception("Kan ikke lese fil");}
			finally {
				try {
					if(innpost != null) innpost.close();
				}catch(Exception e){throw new Exception("kan ikke lukke filen");}
			}
		}
		
	
		
		
// --------------------------------------------Lesning til fil mathode----------------------------------------------------------------
		
	public void lesFilDyr(String postfil) throws Exception {
					try {
						lesDyr(postfil);
					}catch(Exception e){throw e;}		
				}
		
// ------------------------------------------------- skriving til fil matode ----------------------------------------------------------------------
		
		
		public void skrivFil(String postfil) throws Exception {

			PrintStream utDyr = null;			
			try {	
				utDyr = skriveFil(postfil);
			int teller = 0;	
			skrivDyr(postfil);
			while(teller < DyrListe.size()) {
				Dyr endyr = DyrListe.get(teller);
				utDyr.println(endyr.toFile());
				teller++;
			}//while
		
			//System.out.println(utDyr);
			utDyr.close();
					
			}catch(Exception e){throw new Exception("Kan ikke lese fil");}
			//System.out.println("Data er lagret");
			finally {
				try { 
					if(utDyr != null) utDyr.close();			
				}catch(Exception e){}
			}
		} //metode

		
		
/**         Jeg tok bort/komenterte printing gjenfanget dyr grunnen at programet kresjer mye ! 
		
// ------------------------------------------- Lageringes til Gjenfanget dyr fil matode -------------------------------------------------------
		
				public void skrivGjenfangetDyr(String filnavn) throws Exception{
					PrintStream utfil = null;
					try {
						utfil = skriveFil(filnavn);
						for(int i = 0;i < GjenfangesListe.size();i++) {
							utfil.println(GjenfangesListe.get(i).toFile());
						}
						//utfil.close();  // lukke fil 
					}catch(Exception e) {throw new Exception("Kan ikke lagre fil");}
					finally {
						try {
							if(utfil != null) utfil.close();
						}catch(Exception e){}
					}
				}
				
		// --------------------------------------------------Lesning av dur data ----------------------------------------------------------------------------
				
				public void lesGjnfangetDyr(String postfil) throws Exception {
					BufferedReader innpost = leseFil(postfil);
					String innlinje;		
					StringTokenizer inndata;
			
				try {
						while(innpost.ready()) {
							innlinje = innpost.readLine();
							inndata = new StringTokenizer(innlinje,",");
							while(inndata.hasMoreTokens()) {
								
								String dato = inndata.nextToken();
								double sted  = Double.parseDouble(inndata.nextToken());		
								double lengde = Double.parseDouble(inndata.nextToken());
								String vekt  = inndata.nextToken();
									
								Gjenfanges GjnfDyr = new Gjenfanges (dato,sted , lengde, vekt );						
								GjenfangesListe.add(GjnfDyr);					
				
								System.out.println(GjnfDyr.dato + GjnfDyr.vekt + GjnfDyr.lengde + GjnfDyr.sted);	
								System.out.print(GjnfDyr);
								
							} //innlesing av dyr
						} //innlesing av dyr
						//innpost.close();
					}catch(Exception e) {throw new Exception("Kan ikke lese fil");}
					finally {
						try {
							if(innpost != null) innpost.close();
						}catch(Exception e){throw new Exception("kan ikke lukke filen");}
					}
				}
				
			
				
				
		// --------------------------------------------Lesning til fil mathode----------------------------------------------------------------
				
			public void lesFilGjenfangetDyr(String postfil) throws Exception {
							try {
								lesGjnfangetDyr(postfil);
							}catch(Exception e){throw e;}		
						}
				
		// ------------------------------------------------- skriving til fil matode ----------------------------------------------------------------------
				
				
public void skrivGjenfangetFil(String postfil) throws Exception {

					PrintStream utDyr = null;			
					try {	
						utDyr = skriveFil(postfil);
					int teller = 0;	
					skrivGjenfangetDyr(postfil);
					while(teller < GjenfangesListe.size()) {
						Gjenfanges endyr = GjenfangesListe.get(teller);
						utDyr.println(endyr.toFile());
						teller++;
					}//while
					utDyr.close();
							
					}catch(Exception e){throw new Exception("Kan ikke lese fil");}
					//System.out.println("Data er lagret");
					finally {
						try {
							if(utDyr != null) utDyr.close();			
						}catch(Exception e){}
					}
				} //metode

*/
		
// -----------------------------------------------------------------------------------------------------------	
		public ArrayList<Dyr> hentNyDyr() {
			return DyrListe;
		}

		
		public ArrayList<Gjenfanges> hentGjenDyr() {
			return GjenfangesListe;
		}
}

