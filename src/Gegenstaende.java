/**
 * Dieses Enum speichert die Kurz und Langnamen der  Gegenstände.
 * @author Christian Grubmüller
 * @version 2020-03-15
 */
public enum Gegenstaende {
	AM("Angewante Mathematik"), E("Englisch"), D("Deutsch"), SYT("Systemtechnik"), SEW("Softwareentiwcklung"), NWTK("Netzwerktechnik");
	
	private String langbezeichnung;
	
	/**
	 * Ist der Konstruktor des Enums.
	 * @param langbezeichnung
	 */
	private Gegenstaende(String langbezeichnung) {
		this.langbezeichnung = langbezeichnung;
	}
	
	/**
	 * Gibt einen schön formatierten String mit allen wichtigen Informationen aus.
	 */
	@Override
	public String toString() {
		return this.name() + "(" + this.langbezeichnung + ")";
	}
}
