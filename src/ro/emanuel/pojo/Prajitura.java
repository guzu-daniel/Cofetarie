package ro.emanuel.pojo;

public class Prajitura {
	
	private int id;
	private String nume;
	private String descriere;
	private int pret;
	private String imagine;
	
	public Prajitura() {
		
	}

	public Prajitura(int id, String nume, String descriere, int pret, String imagine) {
		super();
		this.id = id;
		this.nume = nume;
		this.descriere = descriere;
		this.pret = pret;
		this.imagine = imagine;
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

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	public int getPret() {
		return pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}

	public String getImagine() {
		return imagine;
	}

	public void setImagine(String imagine) {
		this.imagine = imagine;
	}
	
	
	
	
	

}
