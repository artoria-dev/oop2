package Digital_University;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class University 
{
	private int studentenAnzahl;
	
	private static ArrayList <Student> studentenListe = new ArrayList<Student>();
	private static ArrayList <Verwaltungsangestellter> verwaltungsangestelltenListe = new ArrayList<Verwaltungsangestellter>();
	private static ArrayList <Studiengang> studiengangListe = new ArrayList<Studiengang>();
	private static ArrayList <Professor> professorenListe = new ArrayList<Professor>();
	private static ArrayList <Kurs> kursListe = new ArrayList<Kurs>();
	private static ArrayList <Kohorte> kohortenListe = new ArrayList<Kohorte>();
	
	public static void main(String[] args) 
	{
		initialisiereStudiengang();
		initialisiereKurse();
		
		//initialisiereStudenten();
		System.out.println("Daten werden gelesen...");	
		datenLesen();
		System.out.println("Daten wurden gelesen!");
		System.out.println();	
		
		initialisiereProfessoren();
		kohortenZuweisung();
		
		//nachnamenAendern(personSuchen("Erik", "Priebe"), "Müller");
		System.out.println("Anzahl der Kurse: " + kursListe.size());
		
		ausgabeStudenten();
		
		System.out.println();	
		ausgabeKohoten();
		
		System.out.println("Daten werden gespeichert...");	
		datenSpeichern();
		System.out.println("Daten wurden gespeichert!");	
	}

	private static void ausgabeStudenten() {
		for(Student studi: studentenListe)
			System.out.println(studi.getVorname() + " " + studi.getName() + ": " + studi.getStudiengang().bezeichnung);
	}

	private static void datenLesen() {
		try {
			File datei = new File("studierende.csv");
			
			Scanner leser = new Scanner(datei);
			
			while (leser.hasNextLine())
			{				
				String zeile = leser.nextLine();
				
				//System.out.println(zeile);
				
				String[] inhalte = new String[4];
				inhalte = zeile.split(";");
				
				/*System.out.println(inhalte[0]);
				System.out.println(inhalte[1]);
				System.out.println(inhalte[2]);
				System.out.println(inhalte[3]); */
				
				studentenListe.add(new Student(inhalte[0], inhalte[1], Integer.parseInt(inhalte[2]), sgBezToSG(inhalte[3])));
			}
			leser.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void datenSpeichern() {
		try {
			FileWriter schreiber = new FileWriter("studierende.csv");
			for(Student studi: studentenListe)
			{
				schreiber.write(studi.getName() + ";" + studi.getVorname() + ";" + studi.getMatrikelnummer() + ";" + studi.getStudiengang().getBezeichnung() + "\n");
			}
			schreiber.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	private static void initialisiereProfessoren() {
		professorenListe.add(new Professor("McProfessores", "Professorius", "Theologie", "Professor", Geschlecht.Männlich));
		professorenListe.add(new Professor("Dieeule", "Wiemacht", "Physik", "Doktor", Geschlecht.Divers));
	}

	private static void initialisiereStudiengang() {
		studiengangListe.add(new Studiengang("Wirtschaftsinformatik", SGTyp.Bachlor, 180));
		studiengangListe.add(new Studiengang("Informatik", SGTyp.Bachlor, 180));
	}

	private static void initialisiereStudenten() { 
		//Nullpointer exception möglich!
		
		String wirtschaftsinformatik = "Wirtschaftsinformatik";
		String informatik = "Informatik";

		studentenListe.add(new Student("Priebe", "Erik", 1010101, sgBezToSG(wirtschaftsinformatik)));	
		studentenListe.add(new Student("Kai", "Kawai", 1010102, sgBezToSG(informatik)));		
		studentenListe.add(new Student("Dermondbär", "Desmomnd", 1010103, sgBezToSG(wirtschaftsinformatik)));	
		studentenListe.add(new Student("Tom", "Tom", 1010104, sgBezToSG(informatik)));
	}

	private static void kohortenZuweisung() {
		for(Studiengang studigang: studiengangListe)
		{
			Kohorte kohorte = new Kohorte(studigang.getBezeichnung());
			for(Student studi: studentenListe)
			{
				if(studi.getStudiengang().getBezeichnung() == studigang.getBezeichnung())
				{
					kohorte.mitgliederHinzufuegen(studi);
				}
			}
			kohortenListe.add(kohorte);
		}
	}
	
	private static void ausgabeKohoten()
	{
		for(Kohorte kh: kohortenListe)
		{
			System.out.println("Kohorte: " + kh.getBezeichnung());
			for(Student studi: kh.getMitgliederListe())
			{
				System.out.println("Mitglied: " + studi.getVorname() + " " + studi.getName() + ": " + studi.getStudiengang().bezeichnung);
			}
			System.out.println();
		}
	}

	private static Studiengang sgBezToSG(String string) {
		for(int x = 0; x < studiengangListe.size(); x++)
		{
			if(studiengangListe.get(x).bezeichnung.equals(string))
				return studiengangListe.get(x);
		}	
		return null;
	}

	private static void initialisiereKurse() 
	{
		kursListe.add(new Kurs("OOP-I", "oop-1", 5, 50, 150));
		kursListe.add(new Kurs("OOP-II", "oop-2", 5, 50, 150));
		kursListe.add(new Kurs("RE-I", "re-1", 5, 50, 150));
	}
	
	private static void nachnamenAendern(Person person, String nachname)
	{
		person.setName(nachname);
	}
	
	private static Person personSuchen(int matrikelnummer)
	{		
		//Nullpointer exception möglich!
		for(int x = 0; x < studentenListe.size(); x++)
		{
			if(studentenListe.get(x).getMatrikelnummer() == matrikelnummer)
				return studentenListe.get(x);
		}	
		return null;
	}
	
	private static Person personSuchen(Kurs kurs)
	{		
		//Nullpointer exception möglich!
		for(int x = 0; x < studentenListe.size(); x++)
		{
			if(studentenListe.get(x).getStudiengang().getBezeichnung() == kurs.getBezeichnung())
				return studentenListe.get(x);
		}	
		return null;
	}
	
	private static Person personSuchen(String vorname, String nachname)
	{
		//Nullpointer exception möglich!
		for(int x = 0; x < studentenListe.size(); x++)
		{
			if(studentenListe.get(x).getName().equals(nachname) && studentenListe.get(x).getVorname().equals(vorname))
				return studentenListe.get(x);
		}
		
		for(int x = 0; x < verwaltungsangestelltenListe.size(); x++)
		{
			if(verwaltungsangestelltenListe.get(x).getName().equals(nachname) && verwaltungsangestelltenListe.get(x).getVorname().equals(vorname))
				return verwaltungsangestelltenListe.get(x);
		}
		
		for(int x = 0; x < professorenListe.size(); x++)
		{
			if(professorenListe.get(x).getName().equals(nachname) && professorenListe.get(x).getVorname().equals(vorname))
				return professorenListe.get(x);
		}
		return null;
	}
}