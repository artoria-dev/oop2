package Digital_University;

public class Adresse 
{
	private String strasse;
	private int nummer;
	private int plz;
	private String ort;
	private String land;
	
	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public Adresse(String strasse, int nummer, int plz, String ort) {
		super();
		this.strasse = strasse;
		this.nummer = nummer;
		this.plz = plz;
		this.ort = ort;
	}

	public Adresse(String strasse, int nummer, int plz, String ort, String land) {
		this.strasse = strasse;
		this.nummer = nummer;
		this.plz = plz;
		this.ort = ort;
		this.land = land;
	}
	
	
	
}
