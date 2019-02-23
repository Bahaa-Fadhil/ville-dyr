package Bahaa_Oblig2_pack;

public class Dyr_Program {

	public static void main(String[] args) {
		// Program starter i grennesnitt 
		try{
		 	
			
		// Grensesnitt Starter i hovedmeny (Meny1)	
		Grennsesnitt_Dyr grensesnitt = new Grennsesnitt_Dyr();		
		
		grensesnitt.skrivFiler();
		grensesnitt.lesFilDyr();
				
		grensesnitt.meny1();
		}catch(Exception e){}
	}

}
