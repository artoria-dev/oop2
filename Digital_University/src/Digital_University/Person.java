package Digital_University;

public abstract class Person 
{
	private String name;
	private String vorname;
	private String emailAdresse;
	private Adresse adresse;
	private Geschlecht geschlecht;
	
	public Adresse getAdresse() 
	{
		return adresse;
	}

	public Person(String name, String vorname, String emailAdresse, Geschlecht geschlecht) {
		this.name = name;
		this.vorname = vorname;
		this.emailAdresse = emailAdresse;
		this.geschlecht = geschlecht;
	}

	public void setAdresse(Adresse adresse) 
	{
		this.adresse = adresse;
	}
	
	public String getName() 
	{
		return name;
	}

	public Person(String name, String vorname, Geschlecht geschlecht) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.geschlecht = geschlecht;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getVorname() 
	{
		return vorname;
	}

	public void setVorname(String vorname) 
	{
		this.vorname = vorname;
	}
	
	public String getEmailAdresse() 
	{
		return emailAdresse;
	}

	public void setEmailAdresse(String emailAdresse) 
	{
		this.emailAdresse = emailAdresse;
	}
	
	public Person(String name)
	{
		this.setName(name);		
	}
	
	public Person(String name, String vorname)
	{
		this.setName(name);
		this.setVorname(vorname);
	}

	public Geschlecht getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(Geschlecht geschlecht) {
		this.geschlecht = geschlecht;
	}
	

}
