package masini.pojo;

import java.sql.Date;

public class Masini {

	private int id;
	private String tip_masina;
	private int nr_usi;
	private Date an_fabricatie;
	
	public Masini() {
	}
	
	public Masini(int id, String tip_masina, int nr_usi, Date an_fabricatie) {
		this.id = id;
		this.tip_masina = tip_masina;
		this.nr_usi = nr_usi;
		this.an_fabricatie = an_fabricatie;
	}

	public Masini(String tip_masina, int nr_usi, Date an_fabricatie) {
		this.tip_masina = tip_masina;
		this.nr_usi = nr_usi;
		this.an_fabricatie = an_fabricatie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTip_masina() {
		return tip_masina;
	}

	public void setTip_masina(String tip_masina) {
		this.tip_masina = tip_masina;
	}

	public int getNr_usi() {
		return nr_usi;
	}

	public void setNr_usi(int nr_usi) {
		this.nr_usi = nr_usi;
	}

	public Date getAn_fabricatie() {
		return an_fabricatie;
	}

	public void setAn_fabricatie(Date an_fabricatie) {
		this.an_fabricatie = an_fabricatie;
	}
	
	
	
}
