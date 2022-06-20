import java.util.Scanner;

public class SavasMotoru {//Oyun basladiktan sonradi islemlerin yapildigi siniftir. OyunVerisi ve OyunGorunumune erisimi vardir.
	private OyunVerisi oyunVerisi;
	private OyunGorunumu oyunGorunumu;
	

	public SavasMotoru(OyunVerisi oyunVerisi) {
		this.oyunVerisi=oyunVerisi;
		
	}
	
	
	public void setOyunGorunumu(OyunGorunumu oyunGorunumu) {
		this.oyunGorunumu = oyunGorunumu;
	}
	
	

	public void calis() {//OyunGorunumundeki switch caseden cagirilan ve oyunu baslatan metod.
		
		Scanner sc=new Scanner(System.in);
		
		//Oyun baslangicinda,secilen aktif sovalyelerin ekrana yazdirilmasi.
		oyunGorunumu.oyunDurumunuGoster(oyunVerisi.getAktifDusmanlar(),oyunVerisi.getAktifSovalyeler());
		
		//Dosya islemleri icin TXTOyunVerisi sinifindan nesne tanimlanmasi.
		TXTOyunVerisi txtOyunVerisi=new TXTOyunVerisi(oyunVerisi);
		
		
		boolean oyunSonucu=false;//Dosya islemlerinde oyunun sonucunu yazdirmak icin üretilen metoda arguman olarak verilmesi icin bir degisken.
		
		
		txtOyunVerisi.kayitVerileriniYaz();//Oyun baslangicinda Tüm Sovalyeleri ve Secilen Aktif Sovalyeleri dosyaya yazdiran metod.

		while (true) {
			
			System.out.println("Kullanilacak sovalyenin numarasini giriniz:");
			int temp=sc.nextInt();
			
			System.out.println("Hedeflenilen dusmanin numarasini giriniz:");
			int temp2=sc.nextInt();
			
			if(temp>oyunVerisi.getAktifSovalyeler().size()) {
				System.out.println("Hatalý secim yaptiniz.Lutfen tekrar giriniz:");
				continue;
				
			}
			else if(temp2>oyunVerisi.getAktifDusmanlar().size()) {
				System.out.println("Hatalý secim yaptiniz.Lutfen tekrar giriniz:");
				continue;
			}
			
	
			
			boolean isWin=false;//Dosya islemlerinde roundun sonucunu yazdirmak icin üretilen metoda arguman olarak verilmesi icin bir degisken.
			
			
			/*
			 	isWin metodu,verilen Sovalye ve Dusman argumanlarina gore onlarin Guclu veya Zayif oldugunu sýnýflarina bakarak kontrol eder ve
			 	sövalyenin dusmani yenmesi durumunda true, yenilmesi durumunda false dondurur.
			 	
			 	Eger sovalye yenmisse asagidaki if blogu calisir, yenilmisse else calisir.
			 */
			if (isWin(oyunVerisi.getAktifSovalyeler().get(temp-1),oyunVerisi.getAktifDusmanlar().get(temp2-1))) {
				
				//Burada, sovalye normalde dusmani yenebilecektir fakat %20 iskalama olasiligi Sans sinifindeki bir metodla kontrol edilir.
				if(oyunVerisi.getAktifSovalyeler().get(temp-1).getSans().isMiss()) {
					
					System.out.println("------------ :( Maalesef sectiginiz sovalye dusmani iskaladi :( ------------\n\n");
					oyunVerisi.getAktifSovalyeler().get(temp-1).vurusHakkiAzalt();
					
					if(oyunVerisi.getAktifSovalyeler().get(temp-1).getVurusHakki()==0) {//Sovalyenin vurus hakki bitmisse arraylistten kaldirilir.
						oyunVerisi.getAktifSovalyeler().get(temp-1).setAktif(false);
						
						oyunVerisi.getAktifSovalyeler().remove(temp-1);
						
					}
					
				}
				else {
					System.out.println("\n+++++++++++ Dusman olduruldu +++++++++++\n\n");
					
					oyunVerisi.getAktifSovalyeler().get(temp-1).vurusHakkiAzalt();
					isWin=true;
					
					if(oyunVerisi.getAktifSovalyeler().get(temp-1).getVurusHakki()==0) {//Sovalyenin vurus hakki bitmisse arraylistten kaldirilir.
						oyunVerisi.getAktifSovalyeler().get(temp-1).setAktif(false);
						
						oyunVerisi.getAktifSovalyeler().remove(temp-1);
						
						
					}
					
					oyunVerisi.getAktifDusmanlar().remove(temp2-1);//Bitmemisse sadece yenilen dusman arraylistten kaldirilir.
				}
				
				
				
				
			}
			else {
				
				System.out.println("----------- Sectiginiz sovalye dusmana yenildi -----------\n");
				oyunVerisi.getAktifSovalyeler().get(temp-1).setAktif(false);
				oyunVerisi.getAktifSovalyeler().remove(temp-1);//Yenilen sovalye kaldirilir.
				
				
			}
			
			if(oyunVerisi.getAktifDusmanlar().size()==0) {//Dusmanlar bitmisse ekrana ve dosyaya oyunun sonucu yazdirilir ve oyundan cikis yapilir.
				
				System.out.println("+++++++++++ TEBRIKLER OYUNU KAZANDINIZ +++++++++++");
				oyunSonucu=true;
				txtOyunVerisi.oyunSonucunuYaz(oyunSonucu); 
				System.exit(1);
			}
			
			if(oyunVerisi.getAktifSovalyeler().size()==0) {//Eger sovalyeler bitmisse ekrana ve dosyaya oyunun sonucu yazdirilir ve cikis yapilir.
			
				System.out.println("----------- :( HIC SOVALYENÝZ KALMADI :( -----------");
				txtOyunVerisi.oyunSonucunuYaz(oyunSonucu); 
				System.exit(3);
			}
			
			/*Baska bir yenilme kosulu olan sovalye sayisinindusman sayisindan daha az olmasini 
			 * kontrol eden ve ayrýca sovalyelerin ek vurus hakkinina sahip olmadýgýný da kontrol eden 
			ve oyunu bitiren if else blogu.
			 */
			if(oyunVerisi.getAktifSovalyeler().size()<oyunVerisi.getAktifDusmanlar().size()) {
				
				for (int i=0;i<oyunVerisi.getAktifSovalyeler().size();i++) {
					if(oyunVerisi.getAktifSovalyeler().get(i).getVurusHakki()>1) {//Eger sovalyelerin ek vurus hakki varsa hic bir sey yapma.
						;
					}
					else {
						System.out.println("------- :( SOVALYELERINIZ DUSMANLARDAN DAHA AZ SAYIDA OLDUGU ICIN OYUNU KAYBETTINIZ :( -------");
						txtOyunVerisi.oyunSonucunuYaz(oyunSonucu); 
						System.exit(4);
					}
					
				}
				
				
			}
			
			
			
			txtOyunVerisi.oyunVerileriniYaz(temp, temp2, isWin);//Round sirasindaki verileri ekrana yazdiran metod.
			
			
			//Her roundda, kalan aktif sovalyelerin ekrana yazdirilmasi.
			oyunGorunumu.oyunDurumunuGoster(oyunVerisi.getAktifDusmanlar(),oyunVerisi.getAktifSovalyeler());
			
			
			
		}
		 
		
		
	}
	
	
	/*
	 isWin metodu,verilen Sovalye ve Dusman argumanlarina gore onlarin Guclu veya Zayif oldugunu sýnýflarina bakarak kontrol eder ve
	 sövalyenin dusmani yenmesi durumunda true, yenilmesi durumunda false dondurur.
	 */
	public boolean isWin(Sovalye sovalye,Dusman dusman) {
		if(sovalye.getClass().equals(GucluSovalye.class)) {//Verilen sovalyenin sahip oldugu sinifin GucluSovalye sinifina ait olup olmadigi.
			return true;
		}
		//Verilen sovalyenin zayif sovalye ancak dusmaninda zayif sovalye olup, yendigi durum.
		else if(sovalye.getClass().equals(ZayifSovalye.class)&&dusman.getClass().equals(ZayifDusman.class)) {
			return true;
		}
		
		else {
			return false;
		}
		
		
		
	}
}
