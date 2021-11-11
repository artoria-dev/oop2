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
		File daten = new File("daten.csv");
		
		initialisiereStudiengang();
		initialisiereKurse();
		
		//initialisiereStudenten();
		System.out.println("Daten werden gelesen...");	
		datenLesen(daten);
		System.out.println("Daten wurden gelesen!");
		System.out.println();	
		
		//initialisiereProfessoren();
		
		kohortenZuweisung();
		
		//nachnamenAendern(personSuchen("Erik", "Priebe"), "Müller");
		System.out.println("Anzahl der Kurse: " + kursListe.size());
		
		System.out.println("\nStudenten: ");	
		ausgabeStudenten();
		System.out.println("\nDozenten: ");	
		ausgabeProfessoren();
		
		System.out.println();	
		ausgabeKohoten();
		
		System.out.println("Daten werden gespeichert...");	
		datenSpeichern(daten);
		System.out.println("Daten wurden gespeichert!");	
	}

	private static void ausgabeStudenten() {
		for(Student studi: studentenListe)
			System.out.println(studi.getVorname() + " " + studi.getName() + ": " + studi.getStudiengang().bezeichnung);
	}
	
	private static void ausgabeProfessoren() {
		for(Professor prof: professorenListe)
			System.out.println(prof.getTitel() + " " + prof.getVorname() + " " + prof.getName() + ", " + prof.getBerufsgebiet()  + ", " + gesToSg(prof.getGeschlecht()));
	}

	private static void datenLesen(File datei) {
		try {			
			Scanner leser = new Scanner(datei);
			
			while (leser.hasNextLine())
			{				
				String zeile = leser.nextLine();
				
				//System.out.println(zeile);
				
				String[] inhalte = new String[6];
				inhalte = zeile.split(";");
				
				/*System.out.println(inhalte[0]);
				System.out.println(inhalte[1]);
				System.out.println(inhalte[2]);
				System.out.println(inhalte[3]); */
				
				if(inhalte[0].equals("Student"))
					studentenListe.add(new Student(inhalte[1], inhalte[2], Integer.parseInt(inhalte[3]), sgBezToSG(inhalte[4])));
				
				if(inhalte[0].equals("Professor"))
					professorenListe.add(new Professor(inhalte[1], inhalte[2], inhalte[3], inhalte[4], sgToGes(inhalte[5])));	
			}
			leser.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static Geschlecht sgToGes(String string) {
		
		if(string.equals("Männlich"))
			return Geschlecht.Männlich;
		
		if(string.equals("Weiblich"))
			return Geschlecht.Weiblich;
					
		return Geschlecht.Divers;
	}
	
	private static String gesToSg(Geschlecht geschlecht) {
		
		if(geschlecht == Geschlecht.Männlich)
			return "Männlich";
		
		if(geschlecht == Geschlecht.Weiblich)
			return "Weiblich";
					
		return "Divers";
	}

	private static void datenSpeichern(File datei) {
		try {
			FileWriter schreiber = new FileWriter(datei);
			for(Student studi: studentenListe)
			{
				schreiber.write("Student" + ";" + studi.getName() + ";" + studi.getVorname() + ";" + studi.getMatrikelnummer() + ";" + studi.getStudiengang().getBezeichnung() + "\n");
			}
			for(Professor prof: professorenListe)
			{
				schreiber.write("Professor" + ";" + prof.getName() + ";" + prof.getVorname() + ";" + prof.getBerufsgebiet() + ";" + prof.getTitel() + ";" + gesToSg(prof.getGeschlecht()) + "\n");
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