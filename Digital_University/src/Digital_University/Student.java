package Digital_University;

import java.util.ArrayList;

public class Student extends Person
{
	private int matrikelnummer;
	private Studiengang studiengang;
	
	private ArrayList <Kurs> bestandeneKurseListe = new ArrayList<Kurs>();
	private ArrayList <Kurs> aktuelleKurseListe = new ArrayList<Kurs>();

	
	public Student(String name)
	{
		super(name);
	}
	
	public Student(String name, String vorname)
	{
		super(name, vorname);
	}
	
	public Student(String name, String vorname, int matrikelnummer)
	{
		super(name, vorname);
		this.setMatrikelnummer(matrikelnummer);
	}

	public Student(String name, String vorname, int matrikelnummer, Studiengang studiengang)
	{
		super(name, vorname);
		this.setMatrikelnummer(matrikelnummer);
		this.setStudiengang(studiengang);
	}

	public int getMatrikelnummer() 
	{
		return matrikelnummer;
	}

	public void setMatrikelnummer(int matrikelnummer) 
	{
		this.matrikelnummer = matrikelnummer;
	}

	public Studiengang getStudiengang() 
	{
		return studiengang;
	}

	public void setStudiengang(Studiengang studiengang) 
	{
		this.studiengang = studiengang;
	}

	public ArrayList <Kurs> getBestandeneKurseListe() {
		return bestandeneKurseListe;
	}

	public void setBestandeneKurseListe(ArrayList <Kurs> bestandeneKurseListe) {
		this.bestandeneKurseListe = bestandeneKurseListe;
	}

	public ArrayList <Kurs> getAktuelleKurseListe() {
		return aktuelleKurseListe;
	}

	public void setAktuelleKurseListe(ArrayList <Kurs> aktuelleKurseListe) {
		this.aktuelleKurseListe = aktuelleKurseListe;
	}
}
