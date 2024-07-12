package SifreOlusturucuApp;

import java.util.Scanner;

public class AnaProgram {
    public static void main(String[] args) {

        Scanner scan  = new Scanner(System.in);
        int uzunluk = 0;
        while (true){
            try{
                System.out.println("Sifre uzunlugu giriniz : ");
                uzunluk = scan.nextInt();
                if(uzunluk<0){
                    throw new IllegalArgumentException("Uzunluk negatif olamaz");
                }
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println("Rakam disinda bir karakter girdiniz");
                scan.nextLine();
            }
        }

        boolean buyukHarf = false;
        while (true){
            try {
                System.out.println("Buyuk harf kullanilsin mi ? (true/false)");
                buyukHarf = scan.nextBoolean();
                break;
            } catch (Exception e) {
                System.out.println("Buyuk harf disinda bir karakter girdiniz");
                scan.nextLine();
            }
        }

        boolean kucukHarf = false;
        while (true){
            try {
                System.out.println("Kucuk harf kullanilsin mi? (true/false)");
                kucukHarf = scan.nextBoolean();
                break;
            } catch (Exception e) {
                System.out.println("Kucuk harf disinda bir karakter girdiniz");
                scan.nextLine();
            }
        }

        boolean rakam = false;
        while (true){
            try {
                System.out.println("Rakam kullanilsin mi? (true/false)");
                rakam = scan.nextBoolean();
                break;
            } catch (Exception e) {
                System.out.println("Kucuk harf disinda bir karakter girdiniz" );
                scan.nextLine();
            }
        }

        boolean ozelKarakter = false;
        while (true){
            try {
                System.out.println("Ozel karakter kullanilsin mi? (true/false)");
                ozelKarakter = scan.nextBoolean();
                break;
            } catch (Exception e) {
                System.out.println("Kucuk harf disinda bir karakter girdiniz" );
                scan.nextLine();
            }
        }

        SifreAyarlar ayarlar = new SifreAyarlar(uzunluk,buyukHarf,kucukHarf,rakam,ozelKarakter);
        SifreOlusturucu olusturucu = new SifreOlusturucu();

        String rastgeleSifre = olusturucu.sifreOlustur(ayarlar);
        System.out.println("Olusturulan sifre: "+rastgeleSifre);

    }
}
