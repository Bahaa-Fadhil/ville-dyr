package Bahaa_Oblig2_pack;

import java.sql.Date;

public class GaupeGj extends Gjenfanges{
	
	String oretausten;
	
	public GaupeGj(String Sted,double lengde, double vekt, String dato, String oretausten ) {
		super(Sted, lengde, vekt, dato);	
		this.oretausten = oretausten;
	}
	
	
	public String getOretausten() {
		return oretausten;
	}

	public void setOretausten(String oretausten) {
		this.oretausten = oretausten;
	}

	
	@Override
	public String toString() {
		return "GaupeGj [oretausten=" + oretausten + "]";
	}
	
}
