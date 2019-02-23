package Bahaa_Oblig2_pack;

import java.sql.Date;

public class Gjenfanges {
	
	String sted;
	double lengde, vekt;
	String dato;
	Dyr ID;
	
	
	public Gjenfanges(String Sted,double lengde, double vekt, String dato) {
		super();
		this.sted = Sted;
		this.lengde = lengde;
		this.vekt = vekt;
		this.dato = dato;
	}
	

	public String getSted() {
		return sted;
	}


	public void setSted(String sted) {
		this.sted = sted;
	}


	public double getLengde() {
		return lengde;
	}


	public void setLengde(double lengde) {
		this.lengde = lengde;
	}


	public double getVekt() {
		return vekt;
	}


	public void setVekt(double vekt) {
		this.vekt = vekt;
	}


	public String getDato() {
		return dato;
	}


	public void setDato(String dato) {
		this.dato = dato;
	}


	public Dyr getID() {
		return ID;
	}


	public void setID(Dyr iD) {
		ID = iD;
	}
	
	
	@Override
	public String toString() {
		return "Gjenfanges [sted=" + sted + ", lengde=" + lengde + ", vekt=" + vekt + ", dato=" + dato + ", ID=" + ID
				+ "]";
	}


	public String toFile() {		
		return ID  + "," + sted +  "," + lengde + ","+ vekt + ","+ dato;
	}


}
