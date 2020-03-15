import java.io.Serializable;

/**
 * Diese Klasse soll die Daten eines Schülers speichern und ist für Collections optmiert.
 * @author Christian Grubmüller
 * @version 2020-03-07
 */
public class Schueler implements Comparable<Schueler>, Serializable {
	private static final long serialVersionUID = 35L;
	
	private int katalognummer;
	private String vorname, nachname;
	private char gruppe;
	
	public Schueler (int katalognummer, String vorname, String nachname, char gruppe) {
		this.katalognummer = katalognummer;
		this.vorname = vorname;
		this.nachname = nachname;
		this.gruppe = gruppe;
	}
	
	/**
	 * Diese Methode überprüft ob das Objekt, das im Parameter übergeben wird,
	 * dem Objekt auf dem sie aufgerufen wurde gleich ist.
	 * Diese Methode enspricht den Anforderungen für equals-Methoden aus der Java-API
	 * @param obj ist das Objekt mit dem Verglichen wird.
	 * @return true, wenn die Objekte gleich sind  false, wenn die Objekte unterschiedlich sind
	 */
	@Override
	public boolean equals(Object obj) {
		//Das Objekt wird überprüft
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Schueler other = (Schueler) obj;

		//katalognummer wird überprüft
		if (this.katalognummer != other.katalognummer)
			return false;
		
		//vorname wird überprüft
		if (this.vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!this.vorname.equals(other.vorname))
			return false;
		
		//nachname wird überprüft
		if (this.nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!this.nachname.equals(other.nachname))
			return false;
		
		
		//gruppe wird überprüft
		if (this.gruppe != other.gruppe)
			return false;
		
		//falls alles ident ist wird true zurückgegeben
		return true;
	}
	
	/**
	 * Diese Methode generiert einen Hash Code, der den Anforderungen in der Java-API entspricht
	 * @return result ist der berechnete HashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + katalognummer;
		result = prime * result + ((this.vorname == null) ? 0 : this.vorname.hashCode());
		result = prime * result + ((this.nachname == null) ? 0 : this.nachname.hashCode());
		result = prime * result + gruppe;
		return result;
		
	}
	
	/**
	 * Diese Methode vergleicht das Objekt, das im Parameter übergene wird mit dem Objekt,
	 * auf dem sie aufgerufen worden ist.
	 * Diese Methode entpricht den Anfroderungen für compareTo-Methoden aus der Java-API
	 * @param o ist das Obejkt, mit dem verglichen wird.
	 * @return -1, wenn das Objekt "weniger" wert; 0, wenn die zwei Objekte "gleich viel" wert sind; 1, wenn das Objekt "mehr" wert sind
	 */
	@Override
	public int compareTo(Schueler o) {
		if (o == null)
			return -1;
		if (this.equals(o))
			return 0;
		
		if(this.katalognummer < o.katalognummer) {
			return -1;
		} else if (this.katalognummer > o.katalognummer) {
			return 1;
		}
		
		int ret = this.vorname.compareTo(o.vorname);
		if (ret != 0)
			return ret;
		ret = this.nachname.compareTo(o.nachname);
		if (ret != 0)
			return ret;
		
		if(this.gruppe < o.gruppe) {
			return -1;
		} else if (this.gruppe > o.gruppe) {
			return 1;
		}
		
		return 0;
	}

	/**
	 * @return the katalognummer
	 */
	public int getKatalognummer() {
		return katalognummer;
	}

	/**
	 * @param katalognummer the katalognummer to set
	 */
	public void setKatalognummer(int katalognummer) {
		this.katalognummer = katalognummer;
	}

	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * @param vorname the vorname to set
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return the nachname
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * @param nachname the nachname to set
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * @return the gruppe
	 */
	public char getGruppe() {
		return gruppe;
	}

	/**
	 * @param gruppe the gruppe to set
	 */
	public void setGruppe(char gruppe) {
		this.gruppe = gruppe;
	}
}
