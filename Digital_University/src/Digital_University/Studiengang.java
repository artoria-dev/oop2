package Digital_University;

public class Studiengang 
{
	String bezeichnung;
	SGTyp typ;
	int etcs;

	public Studiengang(String bezeichnung, SGTyp typ, int etcs) 
	{
		this.bezeichnung = bezeichnung;
		this.typ = typ;
		this.etcs = etcs;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public SGTyp getTyp() {
		return typ;
	}

	public void setTyp(SGTyp typ) {
		this.typ = typ;
	}

	public int getEtcs() {
		return etcs;
	}

	public void setEtcs(int etcs) {
		this.etcs = etcs;
	}
	
	
	
}
