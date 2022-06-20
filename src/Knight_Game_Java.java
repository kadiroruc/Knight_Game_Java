
public class Knight_Game_Java {//Bu sinif, main metodunun oldugu, gerekli siniflardan nesnelerin tanimlandigi ve oyunun baslatildigi siniftir.
	public static void main(String[] args){
		
		OyunVerisi oyunVerisi=new OyunVerisi();
		SavasMotoru savasMotoru=new SavasMotoru(oyunVerisi);
		OyunGorunumu oyunGorunumu=new OyunGorunumu(oyunVerisi,savasMotoru);
		savasMotoru.setOyunGorunumu(oyunGorunumu);//Oyun gorunumunun constructor yerine setter metodla tanimlanmasinin sebebi,
												//tanimlanma sirasindan kaynakli bir hataya sebebiyet veriyor olmasidir.
		KonsolGorunumu konsolGorunumu=new KonsolGorunumu(oyunGorunumu);
		
	
		
		konsolGorunumu.goster();//Oyun; bu statementla birlikte konsol gorunumunu aktiflestirerek baslar.
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
