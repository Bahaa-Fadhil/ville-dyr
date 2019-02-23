package Bahaa_Oblig2_pack;
import java.util.*;

public class Dyr{
	
	int ID;
	String kjonn, sted;
	double lengde, vekt;
	String dato;
	
	ArrayList<Gjenfanges> gjenfanges = new ArrayList<Gjenfanges>();
	
		
	public Dyr(int ID ,String kjonn,double lengde,double vekt ,String sted, String dato) {
		super();
		this.ID = ID;
		this.kjonn = kjonn;
		this.lengde = lengde;
		this.vekt = vekt;
		this.sted = sted;
		this.dato = dato;
	}
	


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getKjonn() {
		return kjonn;
	}


	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
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


	
	public String alleDyr() {
		String utDyr = "";
		for(int i = 0;i< gjenfanges.size();i++) {
			utDyr += gjenfanges.get(i).toString();			
			utDyr += "\n";
		}
		return utDyr;
	}
	
	
	
	
	@Override // toString methode 
	public String toString() {
		return "Dyr [ID=" + ID + ", kjonn=" + kjonn + ", sted=" + sted + ", lengde=" + lengde + ", vekt=" + vekt
				+ ", dato=" + dato + "]";
	}



	public String toFile() {
		return ID + "," + kjonn + "," + sted +  "," + lengde + ","+ vekt + ","+ dato;
	}



}
