package SporKursu;

import java.util.Scanner;

//Proje: Spor kursu icin secilecek ogrencileri belirleyelim.
//
//Spor kursu icin secilecek ogrencileri belirleyen bir uygulama yaziniz.
//
//Kurs gereklilikleri:
//Erkekler: boy: 1,60 ve ustu
//kilo: 70-90 kg
//Kadinlar: boy: 1,50 ve ustu
//kilo: 50-70 kg
//
//Kullanicidan ogrenci sayisi ve her bir ogrenci icin:
//isim, cinsiyet, kilo, boy bilgilerini aliniz.
//
//
//                 --> start() = Scanner'in olup kullanicidan bilgileri aldigi metod
//        --> isimKontrol() =
//        --> cinsiyetKontrol() = Cinsiyet kontrolunun yapildigi method
//Rakam ya da karakter girme gibi negatif olasiliklari dusunulerek gelistirilsin.
//        --> boyKontrol() = Boy kontrolunun yapildigi method
//                 --> kiloKontrol() = Kilo kontrolunun yapildigi method
public class SporKursApp {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Scanner scan  = new Scanner(System.in);
        OgrenciKontrol ogrenciKontrol = new OgrenciKontrol();
        System.out.println("Kurs başvuru uygulamasına hoş geldiniz");
        System.out.println("Aşağıda belirtilen soruları cevaplayınız");
        System.out.println("Kayıt için başvuracak öğrenci sayısı : ");
        int mevcut = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < mevcut; i++) {
            System.out.println(i+1 + ". Öğrenci bilgileri" );
            System.out.println("Öğrenci ismini giriniz: ");
            String isim = scan.nextLine();
            while(true){
                System.out.println("Öğrenci cinsiyeti giriniz: (Erkek/Kız)");
                String cinsiyet = scan.next();
                System.out.println("Öğrenci boy giriniz: ");
                int boy = scan.nextInt();
                System.out.println("Öğrenci kilo giriniz: ");
                int kilo = scan.nextInt();
                scan.nextLine();
                if(boy>0 && kilo>0 && (cinsiyet.equalsIgnoreCase("erkek") || cinsiyet.equalsIgnoreCase("kadın"))){
                    ogrenciKontrol.basvuruListesiDoldurma(isim,cinsiyet,kilo,boy);
                    break;
                }else{
                    System.out.println("Lütfen boy-kilo ve cinsiyet bilgilerini doğru giriniz!");
                }
            }
        }
        ogrenciKontrol.ogrenciKontrol();

    }
}
