package no.hvl.dat102;

public class CD {

	private int cdNummer; 
	private String artist; 
	private String tittel; 
	private int year; 
	private Sjanger sjanger; 
	private String plateselskap; 
	
	public CD(){
		
	}
	public CD( int cdNummer, String artist, String tittel, int year, Sjanger sjanger, String plateselskap) {
		
		this.cdNummer = cdNummer;
		this.artist = artist; 
		this.tittel = tittel; 
		this.year = year; 
		this.sjanger = sjanger; 
		this.plateselskap = plateselskap; 
	}
	public int getCdNummer() {
		return cdNummer;
	}
	public void setCdNummer(int cdNummer) {
		this.cdNummer = cdNummer;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTittel() {
		return tittel;
	}
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Sjanger getSjanger() {
		return sjanger;
	}
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	public String getPlateselskap() {
		return plateselskap;
	}
	public void setPlateselskap(String plateselskap) {
		this.plateselskap = plateselskap;
	}
	@Override
	public String toString() {
		return "CD [cdNummer=" + cdNummer + ", artist=" + artist + ", tittel=" + tittel + ", year=" + year
				+ ", sjanger=" + sjanger + ", plateselskap=" + plateselskap + "]";
	}
	

}
