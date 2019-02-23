package Bahaa_Oblig2_pack;

import java.sql.Date;

public class HareGj extends Gjenfanges{


String pelsensfarge;
	
	public HareGj( String Sted,double lengde, double vekt, String dato, String pelsensfarge) {
		super(Sted,lengde, vekt, dato);
		this.pelsensfarge = pelsensfarge;
	}
	
	
	public String getPelsensfarge() {
		return pelsensfarge;
	}

	public void setPelsensfarge(String pelsensfarge) {
		this.pelsensfarge = pelsensfarge;
	}
	
	
	@Override
	public String toString() {
		return "HareGj [pelsensfarge=" + pelsensfarge + "]";
	}
	
}
