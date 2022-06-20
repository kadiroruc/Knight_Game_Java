import java.io.FileWriter;
import java.util.ArrayList;

public class TXTOyunVerisi{//Her oyunda verileri dosyanin uzerine yazmay� saglayan sinif.
	private OyunVerisi oyunVerisi;
	
	
	
	public TXTOyunVerisi(OyunVerisi oyunVerisi) {
		this.oyunVerisi=oyunVerisi;
	}
	
	//Oyun baslangicinda T�m Sovalyeleri ve Secilen Aktif Sovalyeleri dosyaya yazdiran metod.
	public void kayitVerileriniYaz() {
		FileWriter fileWriter=null;
		try {
			fileWriter =new FileWriter("abdulkadir_oruc_20360859028.txt",true);
			
			fileWriter.write("========================= YEN� OYUN =========================\n\n\n");
			fileWriter.write("           T�M ��VALYELER            \n\n\n");
			for(int i=0;i<oyunVerisi.getSovalyeler().size();i++) {
				
				fileWriter.write("======================================\n");
				fileWriter.write(oyunVerisi.getSovalyeler().get(i).toString()+"\n\n");
				fileWriter.write("======================================\n");
			}
			
			fileWriter.write("\n           AKT�F ��VALYELER           \n");
			
			for(int i=0;i<oyunVerisi.getAktifSovalyeler().size();i++) {
				
				fileWriter.write((i+1)+"-->\n");
				fileWriter.write(oyunVerisi.getAktifSovalyeler().get(i).toString()+"\n\n");
				
			}
			
		} catch (Exception e) {
			System.out.println("Dosya a��l�rken bir hata olu�tu!");
		}
		finally {
			if(fileWriter!=null) {
				try {
					fileWriter.close();
				} catch (Exception e2) {
					System.out.println("Dosya kapat�l�rken bir hata olu�tu!");
				}
			}
		}
	}
	
	//Oyunun oynanmasi sirasinda olusturulan verilerin dosyaya yazdirilmasi.
	public void oyunVerileriniYaz(int temp,int temp2,boolean isWin) {
		FileWriter fileWriter=null;
		try {
			fileWriter =new FileWriter("abdulkadir_oruc_20360859028.txt",true);
			
			fileWriter.write("\n\n\n              YEN� ROUND         \n\n\n\n");
			
			fileWriter.write("\n         KULLANICI SE��MLER�          \n");
			fileWriter.write("\nSe�ilen ��valye:"+temp+"\n\n");
			fileWriter.write("\nSe�ilen D��man:"+temp2+"\n\n");
			
			if (isWin) {
				fileWriter.write("\nSONU�: ��VALYE D��MANI YEND�\n\n");
				
				
			}
			else {
				fileWriter.write("\nSONU�: ��VALYE D��MANA YEN�LD�\n\n");
			}
			
			
			fileWriter.write("\n           AKT�F ��VALYELER           \n");
			
			for(int i=0;i<oyunVerisi.getAktifSovalyeler().size();i++) {
				
				fileWriter.write((i+1)+"-->\n");
				fileWriter.write(oyunVerisi.getAktifSovalyeler().get(i).toString()+"\n\n");
				
			}
			fileWriter.write("           AKT�F D��MANLAR           \n");
			
			for(int i=0;i<oyunVerisi.getAktifDusmanlar().size();i++) {
				
				fileWriter.write((i+1)+"-->\n");
				fileWriter.write("D��man "+(i+1)+"\n\n");

				
			}
			
			
			
				
			
			
		}
			
		 catch (Exception e) {
			System.out.println("Dosyaya yaz�l�rken bir hata olu�tu!");
		}
		finally {
			if(fileWriter!=null) {
				try {
					fileWriter.close();
				} catch (Exception e2) {
					System.out.println("Dosya kapat�l�rken bir hata olu�tu!");
				}
			}
		}
		
		
	}
	
	
	//Oyun oynandiktan sonra oyun sonucunu dosyaya yazdiran metod.
	public void oyunSonucunuYaz(boolean oyunSonucu) {
		
		FileWriter fileWriter=null;
		try {
			fileWriter =new FileWriter("abdulkadir_oruc_20360859028.txt",true);
			
			
			if(oyunSonucu) {
				fileWriter.write("\n\nOYUN SONUCU:KULLANICI OYUNU KAZANDI\n");	
			}
			else {
				fileWriter.write("\n\nOYUN SONUCU:KULLANICI OYUNU KAYBETT�\n");
			}
			
		} catch (Exception e) {
			System.out.println("Dosya a��l�rken bir hata olu�tu!");
		}
		finally {
			if(fileWriter!=null) {
				try {
					fileWriter.close();
				} catch (Exception e2) {
					System.out.println("Dosya kapat�l�rken bir hata olu�tu!");
				}
			}
		}
		
	}
}
