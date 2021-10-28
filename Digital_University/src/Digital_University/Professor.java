package Digital_University;

public class Professor extends Person
{
	private String berufsgebiet;
	private String titel;
	
	public Professor(String name, String vorname, String berufsgebiet, String titel, Geschlecht geschlecht) 
	{
		super(name, vorname, geschlecht);
		this.setBerufsgebiet(berufsgebiet);
		this.setTitel(titel);
	}

	public String getBerufsgebiet() 
	{
		return berufsgebiet;
	}

	public void setBerufsgebiet(String berufsgebiet) 
	{
		this.berufsgebiet = berufsgebiet;
	}

	public String getTitel() 
	{
		return titel;
	}

	public void setTitel(String titel) 
	{
		this.titel = titel;
	}
	
	
}
