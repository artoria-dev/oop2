package Digital_University;

import java.util.ArrayList;

public class Kohorte {

	private ArrayList <Student> mitgliederListe;
	private String bezeichnung;
	
	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public Kohorte(String bezeichnung)
	{
		this.setBezeichnung(bezeichnung);
		mitgliederListe = new ArrayList<Student>();
	}

	public ArrayList<Student> getMitgliederListe() {
		return mitgliederListe;
	}

	public void setMitgliederListe(ArrayList<Student> mitgliederListe) {
		this.mitgliederListe = mitgliederListe;
	}
	
	public void mitgliederHinzufuegen(Student neuerStudent)
	{
		mitgliederListe.add(neuerStudent);
	}
	
	public void mitgliederEntfernen(Student neuerStudent)
	{
		mitgliederListe.remove(neuerStudent);
	}
}
