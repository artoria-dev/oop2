package Digital_University;

public class Kurs 
{
	String bezeichnung;
	String kurzbezeichnung;
	int etcs;
	int praesenzUE;
	int selbstUE;
	
	public Kurs(String bezeichnung, String kurzbezeichnung, int etcs, int praesenzUE, int selbstUE)
	{
		this.bezeichnung = bezeichnung;
		this.kurzbezeichnung = kurzbezeichnung;
		this.etcs = etcs;
		this.praesenzUE = praesenzUE;
		this.selbstUE = selbstUE;	
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getKurzbezeichnung() {
		return kurzbezeichnung;
	}

	public void setKurzbezeichnung(String kurzbezeichnung) {
		this.kurzbezeichnung = kurzbezeichnung;
	}

	public int getEtcs() {
		return etcs;
	}

	public void setEtcs(int etcs) {
		this.etcs = etcs;
	}

	public int getPraesenzUE() {
		return praesenzUE;
	}

	public void setPraesenzUE(int praesenzUE) {
		this.praesenzUE = praesenzUE;
	}

	public int getSelbstUE() {
		return selbstUE;
	}

	public void setSelbstUE(int selbstUE) {
		this.selbstUE = selbstUE;
	}
}
