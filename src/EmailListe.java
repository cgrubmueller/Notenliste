import java.util.*;

/**
 * Diese Klasse besitzt ein Attribut emailliste, das mit verschiedenen Methoden verwaltet wird, um eine 
 * möglichst realistische Emailliste zu erstellen
 * @author Christian Grubmüller
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
	 * Diese Methode fügt eine Email zu einem Schüler hinzu.
	 * Falls dieser Schüler bereits diese Email hat, passiert nicht.
	 * Falls dieser Schüler diese Email noch nicht hat, wird sie dort hinzugefügt.
	 * Falls dieser Schüler noch nicht existiert, wird er erstellt und die Email hinzugefügt.
	 * @param schueler ist der Schüler, zu dem die Email hinzugefügt wird.
	 * @param address ist die Email, die dem Schüler hinzugefügt wird
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
	 * Diese Methode gibt die Email-Adressen des im Parameter übergebenen Schülers zurück.
	 * @param schueler ist der Schüler, dessen Email-Adressen zurückgegeben werden.
	 * @return gibt ein String-Array zurück, in dem alle Adressen als String gespeichert sind.
	 */
	public String[] searchAddress(Schueler schueler) {
		String[] temp = new String[this.emailliste.get(schueler).size()];
		this.emailliste.get(schueler).toArray(temp);
		return temp;
	}
	
	/**
	 * Diese Methode löscht den im Parameter übergebenen Schüler aus der Liste.
	 * @param schueler ist der Schüler, der gelöscht wird.
	 */
	public void delSchueler(Schueler schueler) {
		if (this.emailliste.containsKey(schueler)) this.emailliste.remove(schueler);
	}
	
	/**
	 * Diese Methode löscht die im Parameter übergebene Email-Adresse aus dem im Parameter
	 * übergebenen Schüler herraus.
	 * @param schueler ist der schüler, aus dem die Email gelöscht wird.
	 * @param address ist die Email, die gelöscht wird.
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
				//Schülername
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
