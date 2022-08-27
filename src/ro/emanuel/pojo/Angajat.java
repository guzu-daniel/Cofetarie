package ro.emanuel.pojo;

public class Angajat {

	private int id;
	private String nume;
	private String prenume;
	private String adresa;
	private String telefon;
	
	public Angajat() {
		
	}

	public Angajat(int id, String nume, String prenume, String adresa, String telefon) {
		super();
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		this.adresa = adresa;
		this.telefon = telefon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	
}
