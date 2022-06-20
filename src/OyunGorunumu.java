import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class OyunGorunumu {// Ekrana yazdirma islemlerinde daha cok bu sinif kullanilir. OyunVerisi ve SavasMotoru sinifina erisimi vardir.
	private OyunVerisi oyunVerisi;
	private SavasMotoru savasMotoru;
	
	//Parametreli ve parametresiz constructor
	public OyunGorunumu(OyunVerisi oyunVerisi,SavasMotoru savasMotoru) {
		this.oyunVerisi=oyunVerisi;
		this.savasMotoru=savasMotoru;
	}
	
	public OyunGorunumu() {
		
	}
	
	
	
	public void baslangicEkrani() {//Oyunun karsilama ekraninin gosterildigi metod.
		System.out.println("============================");
		System.out.println("    OYUNA HOS GELDÝNÝZ");
		System.out.println("============================\n");
	}
	
	public void anaMenuyuGoster() {//Menuyu gosteren metod
		System.out.println("============================");
		System.out.println("         ANA MENÜ\n");
		System.out.println("1. Tum sovalyeleri goster\r\n"
				+ "2. Aktif olan sovalyeleri goster\r\n"
				+ "3. Adi girilen sovalye bilgilerini goster\r\n"
				+ "4. Adi girilen sovalyeyi degistir\r\n"
				+ "5. Yardim\r\n"
				+ "6. Oyunu baslat\r\n"
				+ "7. Oyundan cýk\r\n"
				+ "Lutfen seciminizi yapiniz:");
		System.out.println("============================\n");
	}
	
	public void yardim () {//Oyun kurallarinin kullanicinin istemesi dahilinde ekrana yazdirildigi metod
		System.out.println("--> Sovalyelerden ve dusmanlardan olusan bu oyunun amaci, sovalyelerin cesitli eylemleri\r\n"
				+ "gerceklestirerek dusmana galip gelmeye calismasidir. Oyunu oynayacak olan kullanici sadece\r\n"
				+ "sovalyeleri yonetecek, dusmanlarin hareketleri otomatik olarak sistem tarafindan\r\n"
				+ "gerceklestirilecektir.\r\n\n"
				+ "--> Oyunun baslangicinda rastgele secilen 5 adet sovalye aktiflestirilir.\r\n\n"
				+ "--> Bir kez dusmana vuran sovalye yense de yenilse de aktif sovalyeler arasindan cikarilir.\r\n\n"
				+ "--> Eger oyuncu, aktif sovalyeleri bitmeden tum dusmanlari yok edebilirse oyunun galibi olur.\r\n"
				+ "Ancak dusman sayisindan daha az sayida sovalye kaldigi durumda, oyuncu oyunu\r\n"
				+ "kaybeder.\r\n\n"
				+ "--> Sovalyelerin iki cesidi vardir:\r\n\n"
				+ "- Guclu Sovalyeler: Guclu sovalye, hem guclu hem de zayif dusmani vurdugunda\r\n"
				+ "onu yok edebilir.\r\n"
				+ "- Zayif Sovalyeler: Zayif sovalye yalnizca zayif dusmana vurdugunda yok edebilir.\r\n"
				+ "Guclu dusmana vurdugunda kendisi yok olur ancak dusmana bir zarar veremez. \r\n"
				+ "\r\n"
				+ "--> Sovalyelerde oldugu gibi guclu dusmanlar ve zayif dusmanlar vardir. Ancak oyuncu dusmanlarin tipini goremez.\r\n"
				+ "\r\n"
				+ "--> Sovalyelerin vurus hakki birdir. Ama bazi sovalyelere ozel sans tanimlanarak vurus hakki 2 yada 3 e cikarilmistir.\r\n"
				+ "\r\n"
				+ "\n		           ++++++++++++++++     IYI OYUNLAR    ++++++++++++++++\n\n\n");
		
	}
	
	public void sovalyeleriGoster() {//OyunVerisi sinifindaki getSovalyeler() metodu yardimiyla arraylistte tutulan Sovalye nesnelerinin bilgilerini
									//Sovalye sinifindaki toString metodu ile ekrana yazdiran metod.
		for(int i=0;i<oyunVerisi.getSovalyeler().size();i++) {
			System.out.println("============================");
			System.out.println(oyunVerisi.getSovalyeler().get(i).toString());
			System.out.println("============================");
		}
	}
	
	public void aktifSovalyeleriGoster() {//Ustteki metodun aynisi olup oyun baslangicinda aktiflestirilen sovalyeleri ekrana yazdiran metod.
		for(int i=0;i<oyunVerisi.getAktifSovalyeler().size();i++) {
			
			
			System.out.println("============================");
			System.out.println(oyunVerisi.getAktifSovalyeler().get(i).toString());
			System.out.println("============================");
			
		}
	}
	
	public int menudenSecimYap(){//7 adet secenege sahip menuden secim yapmaya yarayan switch case bloguna sahip metod.
		Scanner scanner=new Scanner(System.in);
		Random random=new Random();
		int girdi=scanner.nextInt();
		scanner.nextLine();
		int temp=0;
		switch (girdi) {
		case 1: 
			sovalyeleriGoster();
			break;
		
		case 2:
			aktifSovalyeleriGoster();
			break;
		
		case 3://Adi girilen sovalyenin arraylistte olup olmadýgýný kontrol eden, buldugunda bilgilerini yazdiran, 
			//bulamadiginda aranilan sovalyenin bulunamadigini yazdiran case.
			
			System.out.println("Sovalyenin adini giriniz:");
			String s1=scanner.nextLine();
			int sayac=0;
			
			for(int i=0;i<oyunVerisi.getSovalyeler().size();i++) {
				if(oyunVerisi.getSovalyeler().get(i).getAd().compareTo(s1)==0) {
					System.out.print("\n\n");
					System.out.println(oyunVerisi.getSovalyeler().get(i).toString());
					break;
				}
				sayac++;
				
			}
			if(sayac==oyunVerisi.getSovalyeler().size()) {
				System.out.println("Boyle bir sovalye bulunmamaktadir!");
			}
			
			break;
			
		case 4://Adi girilen guclu sovalyenin yerine iki adet farklý zayif sovalye ekleyen metod.
			
			//Guclu sovalyenin iki adet olup olmadigini kontrol eden boolean degeri.
			boolean guclusovalyeikimi=(oyunVerisi.getAktifSovalyeler().get(0).getClass().equals(GucluSovalye.class) &&
					(oyunVerisi.getAktifSovalyeler().get(1).getClass().equals(GucluSovalye.class)
					));
			
			//Ustteki boolean degeri true dondurmusse degisim islemini baslatan dondurmemisse tek guclu sovalye degistirilemediginden hata veren if else blogu.
			if(guclusovalyeikimi) {
				System.out.println("Degistirilecek sovalyenin ismini giriniz:");
				String degistirilecek_sovalye=scanner.nextLine();
				
				//Adi girilen sovalyenin guclu sovalyeler arasinda bulunup bulunmadigini kontrol eden if else blogu.
				if(oyunVerisi.getAktifSovalyeler().get(0).getAd().compareTo(degistirilecek_sovalye)==0) {
					
					System.out.println("\nDegisim yapiliyor...");
					System.out.println("Degisim islemi tamamlandi.\n");
					int sayacc=0;
					oyunVerisi.getAktifSovalyeler().remove(0);//Adi girilen guclu sovalyenin ilk olarak arraylistten kaldirilmasi.
					
					//Kaldirilan sovalyenin yerine iki adet zayif sovalye ekleyen ancak bu sovalyelerin daha once aktiflestirilmedigini de kontrol eden dongu.
					while (true) {
						int sayi=random.nextInt(3,9);
						if(oyunVerisi.getAktifSovalyeler().contains(oyunVerisi.getSovalyeler().get(sayi))) {
							continue;
							
						}
						else {
							
							oyunVerisi.getAktifSovalyeler().add(0,oyunVerisi.getSovalyeler().get(sayi));
							
							sayacc++;//Iki adet sovalyenin eklendigini kontrol etmek icin sayac.
							
							if (sayacc==2) {
								break;
							}
						}
						
					}
							
					
				}
				
				//Ustteki if le ayni islemi degistirilmek istenen guclu sovalyenin 1.indise sahip olmasi durumunda kullanilan else if.
				else if(oyunVerisi.getAktifSovalyeler().get(1).getAd().compareTo(degistirilecek_sovalye)==0) {
					
					System.out.println("\nDegisim yapiliyor...");
					System.out.println("Degisim islemi tamamlandi.\n");
					int sayac2=0;
					oyunVerisi.getAktifSovalyeler().remove(1);
					while (true) {
						int sayi=random.nextInt(3,9);
						if(oyunVerisi.getAktifSovalyeler().contains(oyunVerisi.getSovalyeler().get(sayi))) {
							continue;
							
						}
						else {
							
							oyunVerisi.getAktifSovalyeler().add(1,oyunVerisi.getSovalyeler().get(sayi));
							sayac2++;
							if (sayac2==2) {
								break;
							}
						}
						
					}
				}
				else {
					System.out.println("Boyle bir sovalye bulunmamaktadir!");
				}
			}
			else {
				System.out.println("Iki adet guclu sovalyeniz bulunmadigi icin degisim yapamazsiniz!");
			}
			
			break;
			
		case 5:
			yardim();
			break;
		case 6://SavasMotorunda bulunan calis metodu vasitasiyla oyunu baslatan case.
			savasMotoru.calis();
			temp=6;
			break;
			
		case 7:
			temp=7; //Geri dondurulmek uzere temp e deger ataniyor ve buna gore KonsolGorunumu sinifinda oyun sonlandiriliyor.
			break;
		
		default:
			System.out.println("Hatali secim yaptiniz!");
		}
		
		return temp;
	}
	
	
	
	public void oyunDurumunuGoster(ArrayList<Dusman> dusmanlar,ArrayList<Sovalye> sovalyeler) {//Oyunun oynanmasi sirasinda her roundda oyunda kalan sovalyeleri ve 
																								//dusmanlari ekrana yazdiran, SavasMotoru sinifinda kullanilan metod.
		
		
		System.out.println("SOVALYELER VE DUSMANLAR \n");
		for(int i=0;i<oyunVerisi.getAktifSovalyeler().size();i++) {
			System.out.println((i+1)+"-->");
			System.out.println(oyunVerisi.getAktifSovalyeler().get(i).toString()+"\n");
		}
		
		for(int i=0;i<oyunVerisi.getAktifDusmanlar().size();i++) {
			System.out.println((i+1)+"-->");
			System.out.println("Dusman "+(i+1));
		}
	}
	
	
	
	
}
