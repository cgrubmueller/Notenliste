import java.util.*;

/**
 * Diese Klass testet die Schuler Klasse.
 * @author Christian Grubmüller
 * @version 2020-03-07
 */

public class Test {
	public static void main(String[] args) {
		System.out.println("*****Klasse Schueler wird getestet*****");
		Schueler s1 = new Schueler(1,"Georg","Burkel",'B');
		Schueler s2 = new Schueler(2,"Carmen","Dimov",'A');
		Schueler s3 = new Schueler(3,"Igor","Filipovic",'B');
		
		System.out.println(".equals wird getestet");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s1));
		System.out.println();
		System.out.println(".compareTo wird getestet");
		System.out.println(s2.compareTo(s1));
		System.out.println(s2.compareTo(s2));
		System.out.println(s2.compareTo(s3));
		System.out.println();
		System.out.println("Schuler in SortedSet wird getestet");
		Set<Schueler> ss = new HashSet<>();
		ss.add(s1);
		ss.add(s2);
		ss.add(s3);
		System.out.println("Die Vornamen der Schüler werden ausgegeben");
		for (Schueler temp: ss) {
			System.out.println(temp.getVorname());
		}
		System.out.println("Die Größe des SortedSet wird ausgegeben");
		System.out.println(ss.size());
		System.out.println();
		
		
		System.out.println("*****Klasse Emailliste wird getestet*****");
		EmailListe e1 = new EmailListe();
		e1.addAddress(s1, "gburkel@student.tgm.ac.at");
		e1.addAddress(s1, "minecraftschurli@gmail.com");
		e1.addAddress(s2, "cdimov@student.tgm.ac.at");
		e1.addAddress(s3, "ifilipovic@student.tgm.ac.at");
		System.out.println("Emailliste: ");
		System.out.println(e1.toString());
		System.out.println("Es wird nach den Email-Adressen von Georg Burkel gesucht");
		String[] temp = e1.searchAddress(s1);
		for (int i=0; i<temp.length; i++) System.out.println(temp[i]);
		System.out.println('\n');
		System.out.println("gburkel@student.tgm.ac.at wird von s1 gelöscht");
		e1.delAddress(s1,"gburkel@student.tgm.ac.at");
		System.out.println(e1.toString() + '\n');
		System.out.println("Igor Filipovic wird aus der Emailliste gelöscht");
		e1.delSchueler(s3);
		System.out.println(e1.toString() + '\n');
	}
}
