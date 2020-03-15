import java.util.*;

/**
 * Diese Klasse besitzt ein Attribut emailliste, das mit verschiedenen Methoden verwaltet wird, um eine 
 * m�glichst realistische Emailliste zu erstellen
 * @author Christian Grubm�ller
 * @version 14-02-2020
 */

public class EmailListe {
	SortedMap<Schueler, HashSet<String>> emailliste;
	
	/**
	 * Der Konstruktor initialisiert das Attribut
	 */
	public EmailListe() {
		this.emailliste = new TreeMap<>();
	}
	
	/**
	 * Diese Methode f�gt eine Email zu einem Sch�ler hinzu.
	 * Falls dieser Sch�ler bereits diese Email hat, passiert nicht.
	 * Falls dieser Sch�ler diese Email noch nicht hat, wird sie dort hinzugef�gt.
	 * Falls dieser Sch�ler noch nicht existiert, wird er erstellt und die Email hinzugef�gt.
	 * @param schueler ist der Sch�ler, zu dem die Email hinzugef�gt wird.
	 * @param address ist die Email, die dem Sch�ler hinzugef�gt wird
	 */
	public void addAddress(Schueler schueler, String address) {
		if (this.emailliste.containsKey(schueler)) {
			if (this.emailliste.get(schueler).contains(address)) {
			} else {
				this.emailliste.get(schueler).add(address);
			}
		} else {
			HashSet<String> temp = new HashSet<String>();
			temp.add(address);
			this.emailliste.put(schueler, temp);
		}
	}
	
	/**
	 * Diese Methode gibt die Email-Adressen des im Parameter �bergebenen Sch�lers zur�ck.
	 * @param schueler ist der Sch�ler, dessen Email-Adressen zur�ckgegeben werden.
	 * @return gibt ein String-Array zur�ck, in dem alle Adressen als String gespeichert sind.
	 */
	public String[] searchAddress(Schueler schueler) {
		String[] temp = new String[this.emailliste.get(schueler).size()];
		this.emailliste.get(schueler).toArray(temp);
		return temp;
	}
	
	/**
	 * Diese Methode l�scht den im Parameter �bergebenen Sch�ler aus der Liste.
	 * @param schueler ist der Sch�ler, der gel�scht wird.
	 */
	public void delSchueler(Schueler schueler) {
		if (this.emailliste.containsKey(schueler)) this.emailliste.remove(schueler);
	}
	
	/**
	 * Diese Methode l�scht die im Parameter �bergebene Email-Adresse aus dem im Parameter
	 * �bergebenen Sch�ler herraus.
	 * @param schueler ist der sch�ler, aus dem die Email gel�scht wird.
	 * @param address ist die Email, die gel�scht wird.
	 */
	public void delAddress(Schueler schueler, String address) {
		if (this.emailliste.containsKey(schueler)) {
			if (this.emailliste.get(schueler).contains(address)) this.emailliste.get(schueler).remove(address);
		}
	}
	
	/** 
	 * Diese Methode gibt die Emailliste als formatierten String aus. 
	 */
	public String toString() {
		StringBuilder temp = new StringBuilder();
			if (!this.emailliste.isEmpty()) {
			for (Schueler cache1: this.emailliste.keySet()) {
				//Sch�lername
				temp.append(cache1.getVorname() + cache1.getNachname() + ": ");
				//Email-Adressen
				Iterator<String> it = this.emailliste.get(cache1).iterator();
				String cache2 = "";
				while (it.hasNext()) {
					cache2 = it.next();
					if (it.hasNext()) {
						temp.append(cache2 + ", ");
					} else {
						temp.append(cache2);
					}
				}
				//Zeilenumbruch
				temp.append("\r\n");
			}
			return temp.toString();
		}
		return "isEmpty";
	}
}
