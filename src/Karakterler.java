
public class Karakterler {
	private String ad;
	private int id;
	private boolean aktif;
	
	
	public Karakterler(String ad, int id) {
		this.ad = ad;
		this.id = id;
	}


	public boolean isAktif() {
		return aktif;
	}


	public void setAktif(boolean aktif) {
		this.aktif = aktif;
	}


	public String getAd() {
		return ad;
	}


	public int getId() {
		return id;
	}


	public void setAd(String ad) {
		this.ad = ad;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
}
