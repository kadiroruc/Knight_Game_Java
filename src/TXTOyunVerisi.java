import java.io.FileWriter;
import java.util.ArrayList;

public class TXTOyunVerisi{//Her oyunda verileri dosyanin uzerine yazmayý saglayan sinif.
	private OyunVerisi oyunVerisi;
	
	
	
	public TXTOyunVerisi(OyunVerisi oyunVerisi) {
		this.oyunVerisi=oyunVerisi;
	}
	
	//Oyun baslangicinda Tüm Sovalyeleri ve Secilen Aktif Sovalyeleri dosyaya yazdiran metod.
	public void kayitVerileriniYaz() {
		FileWriter fileWriter=null;
		try {
			fileWriter =new FileWriter("abdulkadir_oruc_20360859028.txt",true);
			
			fileWriter.write("========================= YENÝ OYUN =========================\n\n\n");
			fileWriter.write("           TÜM ÞÖVALYELER            \n\n\n");
			for(int i=0;i<oyunVerisi.getSovalyeler().size();i++) {
				
				fileWriter.write("======================================\n");
				fileWriter.write(oyunVerisi.getSovalyeler().get(i).toString()+"\n\n");
				fileWriter.write("======================================\n");
			}
			
			fileWriter.write("\n           AKTÝF ÞÖVALYELER           \n");
			
			for(int i=0;i<oyunVerisi.getAktifSovalyeler().size();i++) {
				
				fileWriter.write((i+1)+"-->\n");
				fileWriter.write(oyunVerisi.getAktifSovalyeler().get(i).toString()+"\n\n");
				
			}
			
		} catch (Exception e) {
			System.out.println("Dosya açýlýrken bir hata oluþtu!");
		}
		finally {
			if(fileWriter!=null) {
				try {
					fileWriter.close();
				} catch (Exception e2) {
					System.out.println("Dosya kapatýlýrken bir hata oluþtu!");
				}
			}
		}
	}
	
	//Oyunun oynanmasi sirasinda olusturulan verilerin dosyaya yazdirilmasi.
	public void oyunVerileriniYaz(int temp,int temp2,boolean isWin) {
		FileWriter fileWriter=null;
		try {
			fileWriter =new FileWriter("abdulkadir_oruc_20360859028.txt",true);
			
			fileWriter.write("\n\n\n              YENÝ ROUND         \n\n\n\n");
			
			fileWriter.write("\n         KULLANICI SEÇÝMLERÝ          \n");
			fileWriter.write("\nSeçilen Þövalye:"+temp+"\n\n");
			fileWriter.write("\nSeçilen Düþman:"+temp2+"\n\n");
			
			if (isWin) {
				fileWriter.write("\nSONUÇ: ÞÖVALYE DÜÞMANI YENDÝ\n\n");
				
				
			}
			else {
				fileWriter.write("\nSONUÇ: ÞÖVALYE DÜÞMANA YENÝLDÝ\n\n");
			}
			
			
			fileWriter.write("\n           AKTÝF ÞÖVALYELER           \n");
			
			for(int i=0;i<oyunVerisi.getAktifSovalyeler().size();i++) {
				
				fileWriter.write((i+1)+"-->\n");
				fileWriter.write(oyunVerisi.getAktifSovalyeler().get(i).toString()+"\n\n");
				
			}
			fileWriter.write("           AKTÝF DÜÞMANLAR           \n");
			
			for(int i=0;i<oyunVerisi.getAktifDusmanlar().size();i++) {
				
				fileWriter.write((i+1)+"-->\n");
				fileWriter.write("Düþman "+(i+1)+"\n\n");

				
			}
			
			
			
				
			
			
		}
			
		 catch (Exception e) {
			System.out.println("Dosyaya yazýlýrken bir hata oluþtu!");
		}
		finally {
			if(fileWriter!=null) {
				try {
					fileWriter.close();
				} catch (Exception e2) {
					System.out.println("Dosya kapatýlýrken bir hata oluþtu!");
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
				fileWriter.write("\n\nOYUN SONUCU:KULLANICI OYUNU KAYBETTÝ\n");
			}
			
		} catch (Exception e) {
			System.out.println("Dosya açýlýrken bir hata oluþtu!");
		}
		finally {
			if(fileWriter!=null) {
				try {
					fileWriter.close();
				} catch (Exception e2) {
					System.out.println("Dosya kapatýlýrken bir hata oluþtu!");
				}
			}
		}
		
	}
}
