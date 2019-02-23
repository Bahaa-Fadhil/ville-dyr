package Bahaa_Oblig2_pack;
import java.sql.Date;

public class Hare extends Dyr{
	
	String type, pelsensfarge;
	
	public Hare(int ID ,String kjonn,double lengde,double vekt ,String sted,String dato, String type, String pelsensfarge) {
	super(ID, kjonn, lengde, vekt, sted, dato);
		this.type = type;
		this.pelsensfarge = pelsensfarge;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPelsensfarge() {
		return pelsensfarge;
	}

	public void setPelsensfarge(String pelsensfarge) {
		this.pelsensfarge = pelsensfarge;
	}
	
	@Override
	public String toString() {
		return "Hare [type=" + type + ", pelsensfarge=" + pelsensfarge + "]";
	}


	public int compareTo(Hare HareType) {
		return this.type.compareTo(HareType.getType());
	}	
	
	public String toFile() {
		return ID + "," + kjonn + "," + sted +  "," + lengde + ","+ vekt + ","+ dato  + "," + type  + "," + pelsensfarge ;
	}

	
}
