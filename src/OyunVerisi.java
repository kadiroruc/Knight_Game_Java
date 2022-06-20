import java.util.ArrayList;
import java.util.Random;
public class OyunVerisi {//Oyunun verisini tanimlayan,verileri tutan,Sovalye ve Dusman havuzundan aktiflestirme islemini yapan sinif.
	private ArrayList<Sovalye> sovalyeler;
	private ArrayList<Sovalye> aktifSovalyeler;
	private ArrayList<Dusman> dusmanlar;
	private ArrayList<Dusman> aktifDusmanlar;
	private ArrayList<Sans> sanslar;
	
	public OyunVerisi() {//Butun sovalye ve dusman nesnelerinin tanimlanip birer arrayliste atilan ve aktif sovalye ve dusmanlarin secildigi constructor
						//Constructurda yapilmasi, her yeni oyunda kolay bir biçimde random olarak secilen yeni aktif sovalyelerin secilmesini saglýyor.
		sovalyeler=new ArrayList<>();
		dusmanlar=new ArrayList<>();
		
		aktifSovalyeler=new ArrayList<>();
		aktifDusmanlar= new ArrayList<>();
		
		sanslar=new ArrayList<>();//Sovalyelere atanmak uzere kullanilacak Sans sinifinin nesnelerini tutan arraylist.
		
		Random random=new Random();
		
		
		GucluSovalye gucluSovalye1=new GucluSovalye("Giantshadow",1,"Guclu Sovalye");
		GucluSovalye gucluSovalye2=new GucluSovalye("Hildegard",1,"Guclu Sovalye");
		GucluSovalye gucluSovalye3=new GucluSovalye("Matilda",1,"Guclu Sovalye");
		
		ZayifSovalye zayifSovalye1=new ZayifSovalye("Deathsworn",2,"Zayif Sovalye");
		ZayifSovalye zayifSovalye2=new ZayifSovalye("Frostblade",2,"Zayif Sovalye");
		ZayifSovalye zayifSovalye3=new ZayifSovalye("Raven",2,"Zayif Sovalye");
		ZayifSovalye zayifSovalye4=new ZayifSovalye("Grim",2,"Zayif Sovalye");
		ZayifSovalye zayifSovalye5=new ZayifSovalye("Darkfury",2,"Zayif Sovalye");
		ZayifSovalye zayifSovalye6=new ZayifSovalye("Clovis",2,"Zayif Sovalye");
		
		GucluDusman gucluDusman1=new GucluDusman("Guclu Dusman 1",1, "Guclu Dusman");
		GucluDusman gucluDusman2=new GucluDusman("Guclu Dusman 2",1, "Guclu Dusman");
		GucluDusman gucluDusman3=new GucluDusman("Guclu Dusman 3",1, "Guclu Dusman");
		
		ZayifDusman zayifDusman1=new ZayifDusman("Zayif Dusman 1", 2, "Zayif Dusman");
		ZayifDusman zayifDusman2=new ZayifDusman("Zayif Dusman 2", 2, "Zayif Dusman");
		ZayifDusman zayifDusman3=new ZayifDusman("Zayif Dusman 3", 2, "Zayif Dusman");
		ZayifDusman zayifDusman4=new ZayifDusman("Zayif Dusman 4", 2, "Zayif Dusman");
		ZayifDusman zayifDusman5=new ZayifDusman("Zayif Dusman 5", 2, "Zayif Dusman");
		ZayifDusman zayifDusman6=new ZayifDusman("Zayif Dusman 6", 2, "Zayif Dusman");
		
		//Tanimlanan sovalyelerin ve dusmanlarin arrayliste eklenmesi
		sovalyeler.add(gucluSovalye1);
		sovalyeler.add(gucluSovalye2);
		sovalyeler.add(gucluSovalye3);
		
		sovalyeler.add(zayifSovalye1);
		sovalyeler.add(zayifSovalye2);
		sovalyeler.add(zayifSovalye3);
		sovalyeler.add(zayifSovalye4);
		sovalyeler.add(zayifSovalye5);
		sovalyeler.add(zayifSovalye6);
		
		dusmanlar.add(gucluDusman1);
		dusmanlar.add(gucluDusman2);
		dusmanlar.add(gucluDusman3);
		
		dusmanlar.add(zayifDusman1);
		dusmanlar.add(zayifDusman2);
		dusmanlar.add(zayifDusman3);
		dusmanlar.add(zayifDusman4);
		dusmanlar.add(zayifDusman5);
		dusmanlar.add(zayifDusman6);
		
		//Bu kisimdan itibaren sovalye ve dusman havuzundan aktif olanlarin secilme islemi yapilir.
		
		/*Aktif olanlarin secilmesinde iki farkli durum vardir:
		1 --> Tek guclu, digerleri zayif
		2--> Iki guclu , digerleri zayif
		Bu yuzden 0 ya da 1 ureten bir temp olusturulur, 0 olmasý if ile 1 olmasi else ile kontrol edilir.
		*/
		int temp=random.nextInt(2);
		
		if(temp==0) {
			aktifSovalyeler.add(sovalyeler.get(random.nextInt(3)));//Ilk olarak guclu sovalyelerden biri secilir.
			
			//Secilen guclu sovalyeden sonra kalan 4 adet zayif sovalye de alttaki for dongusunde eklenir.
			for(int i=0;i<4;i++) {
				int temp1=random.nextInt(3,9);//Zayif sovalyelerden rastgele 1 adet secilir.
				
				if(aktifSovalyeler.contains(sovalyeler.get(temp1))) {//Eger bu secilen zayif sovalye zaten aktiflestirilmisse i dongu degiskeni 1 azaltilir.
																	//Bu sayede dongu bir kez daha calistirilarak farkli bir zayif sovalye secilmeye calisilir.
					i--;
				}
				else {
					aktifSovalyeler.add(sovalyeler.get(temp1));
				}
				
				
			}
		}
		else {//Ikinci durum yani 2 adet guclu sovalyenin eklenmesi gereken metod.
			
			int temp1=random.nextInt(3);
			aktifSovalyeler.add(sovalyeler.get(temp1));//Ilk olarak 1 adet guclu sovalye eklenir.
			
			while(true) {//Ikýnci guclu sovalyeyi, ilk eklenen guclu sovalyeden farkli olarak ekleyen sonsuz dongu.
				int temp2=random.nextInt(3);
				
				if(temp2!=temp1) {
					aktifSovalyeler.add(sovalyeler.get(temp2));
					break;
				}
				else {
					continue;
				}
			}
			
			
			//Diger 3 zayif sovalyeyi ekleyen dongu.
			for(int i=0;i<3;i++) {
				int temp3=random.nextInt(3,9);
				if(aktifSovalyeler.contains(sovalyeler.get(temp3))) {
					i--;
				}
				else {
					aktifSovalyeler.add(sovalyeler.get(temp3));
				}
				
				
			}
			
			
		}
		
		
		for(int i=0;i<aktifSovalyeler.size();i++) {
			aktifSovalyeler.get(i).setAktif(true);
		}
 
		
		
		
		//Ustteki islemlerle ayný olarak aktif Dusmanlari secen if else blogu.
		//Burada farklý olan durum, en az 3 en fazla 5 dusman ekleyebilmek icin random devam etme degerine sahip for dongulerine sahip olmasidir.
		if(temp==0) {
			
			for(int i=0;i<random.nextInt(2,5);i++) {
				int temp1=random.nextInt(3,9);
				if(aktifDusmanlar.contains(dusmanlar.get(temp1))) {
					i--;
				}
				else {
					aktifDusmanlar.add(dusmanlar.get(temp1));
				}
				
				
			}
			aktifDusmanlar.add(dusmanlar.get(random.nextInt(3)));
			
		}
		else {
			int temp1=random.nextInt(3);
			aktifDusmanlar.add(dusmanlar.get(temp1));
			while(true) {
				int temp2=random.nextInt(3);
				
				if(temp2!=temp1) {
					aktifDusmanlar.add(dusmanlar.get(temp2));
					break;
				}
				else {
					continue;
				}
			}
			
			for(int i=0;i<random.nextInt(1,4);i++) {
				int temp3=random.nextInt(3,9);
				if(aktifDusmanlar.contains(dusmanlar.get(temp3))) {
					i--;
				}
				else {
					aktifDusmanlar.add(dusmanlar.get(temp3));
				}
				
				
			}
			
			
		}
		
		//Aktif sovalyelere sans nesnesi atama.
		for(int i=0;i<aktifSovalyeler.size();i++) {
			sanslar.add(new Sans());
			aktifSovalyeler.get(i).setSans(sanslar.get(i));			
		}
		
		
		//Rastgele secilen 2 adet sovalyeye sans atayip 1 veya 2 ek vurus hakki saglayan dongu.
		for(int i=0;i<2;i++) {
			
			sanslar.get(i).sansAta(aktifSovalyeler.get(random.nextInt(5)));
		}
		
	}
	
	
	//Bu sinifta tanimlanan arraylistleri diger siniflarda kullanmak icin tanimlanan getter metodlar.
	
	public ArrayList<Sovalye> getSovalyeler() {
		return sovalyeler;
	}

	public ArrayList<Sovalye> getAktifSovalyeler() {
		return aktifSovalyeler;
	}

	public ArrayList<Dusman> getDusmanlar() {
		return dusmanlar;
	}
	
	public ArrayList<Dusman> getAktifDusmanlar() {
		return aktifDusmanlar;
	}

	public ArrayList<Sans> getSanslar() {
		return sanslar;
	}

	
	
	
}
