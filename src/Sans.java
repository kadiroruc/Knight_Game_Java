import java.util.Random;

public class Sans {//Bazý sovalyelere  1 ya da 2 ek vurus hakki eklemek icin kullanilan sinif.
	private boolean iyiSans;
	private boolean kotuSans;
	private int sans;
	
	public void sansAta(Sovalye s) {
		Random random=new Random();
		sans=random.nextInt(3);
		
		if(sans==0) {
			;
		}
		else {//Uretilen sans 1 ya da 2 ise sovalyeye vurus hakki eklenir.
			s.setVurusHakki(sans+1);
		}
		
	}
	
	public String toString() {
		return ("Iyi Sans Durumu: "+iyiSans+"Koto Sans Durumu: "+kotuSans);
		
	}
	
	public boolean isMiss() {//Sovalyelerin %20 iskalama olasiligi vardir. Buna gore iyiSans veya kotuSans dondurulur.
		Random random=new Random();
		int temp=random.nextInt(5);
		if(temp==1) {
			kotuSans=true;
			return kotuSans;
			
		}
		else {
			iyiSans=false;
			return iyiSans;
		}
		
	}
}
