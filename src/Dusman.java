
public class Dusman extends Karakterler{
	private String dusmanTipi;
	
	
	public Dusman(String ad, int id,String dusmanTipi) {
		super(ad, id);
		this.dusmanTipi=dusmanTipi;
	}
	
	public String getDusmanTipi() {
		return this.dusmanTipi;
	}
	
}
