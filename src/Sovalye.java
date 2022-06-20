
public class Sovalye extends Karakterler{
	
	private int vurusHakki=1;
	private	String sovalyeTipi;
	private Sans sans;
	
	
	
	public Sovalye(String ad, int id,String sovalyeTipi) {
		super(ad, id);
		this.sovalyeTipi=sovalyeTipi;
		
	}


	public int getVurusHakki() {
		return vurusHakki;
	}


	public void setVurusHakki(int vurusHakki) {
		this.vurusHakki = vurusHakki;
	}
	
	public void setSans(Sans sans) {
		this.sans = sans;
	}
	
	public Sans getSans() {
		return sans;
	}
	
	
	public void vurusHakkiAzalt(){
		this.vurusHakki-=1;
	}
	
	
	public String toString() {
		return ("Sovalye Ismi: " +getAd()+"\nSovalye Tipi :" + getSovalyeTipi()+"\nSovalye id: "+getId()+"\nSovalye Vurus Hakki:"+getVurusHakki());
	}
	
	public String getSovalyeTipi() {
		return this.sovalyeTipi;
	}
	
	
	
	
	
}

