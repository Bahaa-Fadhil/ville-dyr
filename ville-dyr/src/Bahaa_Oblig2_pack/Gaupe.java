package Bahaa_Oblig2_pack;


public class Gaupe extends Dyr {

	String oretausten;
	
	public Gaupe(int ID ,String kjonn,double lengde,double vekt ,String sted, String dato, String oretausten ) {
		super(ID, kjonn, lengde, vekt, sted, dato);
		this.sted = sted;
		this.dato = dato;
	}
	
	
	public String getOretausten() {
		return oretausten;
	}

	public void setOretausten(String oretausten) {
		this.oretausten = oretausten;
	}
	
	
	@Override
	public String toString() {
		return "Gaupe [oretausten=" + oretausten + "]";
	}

	
	public String toFile() {
		return ID + "," + kjonn + "," + sted +  "," + lengde + ","+ vekt + ","+ dato  + "," + oretausten ;
	}
	
}
