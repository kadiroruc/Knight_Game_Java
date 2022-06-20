
public class KonsolGorunumu {
	private OyunGorunumu oyunGorunumu;
	
	
	public KonsolGorunumu(OyunGorunumu oyunGorunumu) {
		this.oyunGorunumu = oyunGorunumu;
	}
	
	/*
	 Oyun Gorunumu sinifinin nesnesine sahip Konsol Gorunumu sinifi, oyun baslangicinda alttaki goster metoduyla 
	 sonsuz bir dongu icerisinde menuyu göstermesine ve kullanicinin bu menudan secim yapmasina olanak saglar.
	 
	 Ek olarak, menuden oyundan cýkma islemi yapilir.
	 */
	public void goster(){
		
		oyunGorunumu.baslangicEkrani();
		
		while(true) {
			
			oyunGorunumu.anaMenuyuGoster();
			int temp=oyunGorunumu.menudenSecimYap();
			if(temp==6)
				break;
			else if (temp==7) {
				System.out.println("Oyundan cikiliyor...");
				System.out.println("Oyundan cikildi.");
				System.exit(0);
			}
			
		}
		
		
		
		
	}
	
	public KonsolGorunumu() {
		super();
	}
}
