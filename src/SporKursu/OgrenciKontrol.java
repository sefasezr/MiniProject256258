package SporKursu;

import java.util.ArrayList;
import java.util.List;

public class OgrenciKontrol {

    List<Ogrenci> basvuruListesi = new ArrayList<>();
    List<Ogrenci> kabulListesi = new ArrayList<>();
    List<Ogrenci> redListesi = new ArrayList<>(); //YAPICAKTIM AMA GEREKSIZ GELDI

    public void basvuruListesiDoldurma(String isim,String cinsiyet,int kilo,int boy){
        Ogrenci ogrenci = new Ogrenci(isim,cinsiyet,kilo,boy);
        this.basvuruListesi.add(ogrenci);
    }

    public void ogrenciKontrol(){
        for(Ogrenci ogrenci : basvuruListesi){
            if(cinsiyetKontrol(ogrenci).equalsIgnoreCase("erkek") && boyKontrol(ogrenci) && kiloKontrol(ogrenci)){
                this.kabulListesi.add(ogrenci);
            }else if (cinsiyetKontrol(ogrenci).equalsIgnoreCase("kadın") && boyKontrol(ogrenci) && kiloKontrol(ogrenci)){
                this.kabulListesi.add(ogrenci);
            }
        }
        System.out.println("Kabul edilen öğrenci sayısı : "+ this.kabulListesi.size()+"/"+this.basvuruListesi.size());
    }

    public String cinsiyetKontrol(Ogrenci ogrenci){
        String cinsiyet = null;

            if(ogrenci.getCinsiyet().equalsIgnoreCase("erkek")){
                cinsiyet = ogrenci.getCinsiyet();
            }else if(ogrenci.getCinsiyet().equalsIgnoreCase("kadın")){
                cinsiyet = ogrenci.getCinsiyet();
            }

        return cinsiyet;
    }

    public boolean boyKontrol(Ogrenci ogrenci){
        boolean boyKontrol = true;

            if(cinsiyetKontrol(ogrenci).equalsIgnoreCase("erkek")){
                if(ogrenci.getBoy()>160){
                    boyKontrol = true;
                }else{
                    boyKontrol = false;
                }
            }else if(cinsiyetKontrol(ogrenci).equalsIgnoreCase("kadın")){
                if(ogrenci.getBoy()>150){
                    boyKontrol = true;
                }else{
                    boyKontrol = false;
                }
            }


        return boyKontrol;
    }

    public boolean kiloKontrol(Ogrenci ogrenci){
        boolean kiloKontrol = true;

            if(cinsiyetKontrol(ogrenci).equalsIgnoreCase("erkek")){
                if(ogrenci.getKilo()>=70 && ogrenci.getKilo()<=90){
                    kiloKontrol = true;
                }else{
                    kiloKontrol = false;
                }
            }else if(cinsiyetKontrol(ogrenci).equalsIgnoreCase("kadın")){
                if(ogrenci.getKilo()>=50 && ogrenci.getKilo()<=70){
                    kiloKontrol = true;
                }else{
                    kiloKontrol = false;
                }
            }

        return kiloKontrol;
    }





}
