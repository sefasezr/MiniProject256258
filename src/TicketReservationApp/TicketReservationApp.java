package TicketReservationApp;
/*
Project: Bilet Rezervasyon ve Bilet Fiyatı Hesaplama Uygulaması

    1- Uygulama mesafe ve kurallara göre otobüs bileti fiyatı hesaplar sonuç olarak bilet bilgisini verir
    2- Kullanıcıdan     mesafe (KM),
                        yolcu adı, yaşı ,
                        yolculuk tipi (Tek Yön, Gidiş-Dönüş)
                        ve koltuk no bilgilerini alınır.
             NOT: Koltuk numaraları her otobüs için dinamik olmalıdır.)
                  Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
                  Aksi halde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

    3-Fiyat hesaplama kuralları:
       -Mesafe başına ücret:
                  Tek yön: 1 Lira / km       Çift Yön(Gidiş-Dönüş): 2 Lira/km
       -Tekli Koltuk ücreti:
                  Koltuk no 3 veya 3 ün katı ise fiyat %20 daha fazladır(Tek yön: 1.2 Lira/km, Çift Yön:2.4 Lira/km).
       -İlk olarak seferin mesafe, yön ve koltuk no bilgisine göre fiyatı hesaplanır,
        sonrasında koşullara göre aşağıdaki indirimler uygulanır ;
                   i)-Çift Yön indirimi:
                               "Yolculuk Tipi" gidiş dönüş seçilmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
                   ii)-Yaş indirimi:
                                Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
                                Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.

 */

import java.util.Scanner;

public class TicketReservationApp {

    public static void main(String[] args) {
        start();
    }

    private static void start() {

        //1-bilet ve otobus objelerini olusturalim
        Bus bus =new Bus("34 TPE 789",33);
        //plaka:"34 TPE 789", koltuk sayisi:33,koltuklar:1,2,3,4....,33

        Ticket ticket;

        Scanner scan = new Scanner(System.in);
        int select; //ÇIKIŞ için 0 ı seçiniz.

        do {
            //kullanıcıdan bilgileri alalım:
            System.out.println("* Bilet Rezervasyon Sistemine Hoşgeldiniz *");
            System.out.println("Lutfen ad-soyad giriniz : ");
            String name = scan.nextLine();
            System.out.println("Lutfen yaşınızı giriniz : ");
            int age = scan.nextInt();
            System.out.println("Lutfen gidilecek mesafeyi KM olarak giriniz : ");
            double km = scan.nextDouble();
            System.out.println("Lutfen yolculuk tipini giriniz : ");
            System.out.println("1-Tek Yön");
            System.out.println("2-Gidiş-Dönüş");
            int type = scan.nextInt();
            scan.nextLine();
            System.out.println("Lütfen koltuk no giriniz : ");
            System.out.println("(Tekli koltuk ücreti %20 daha fazladır!)");
            System.out.println(bus.getSeats()); //"1","2"....,"33"
            String seat = scan.nextLine();

            //koltuk no rezerve edilmiş mi veya listede var mı
            boolean isReserved = !bus.getSeats().contains(seat);//True ise rezerve edilmiş ya da listede yok

            //girilen geçerler değerli mi
            if(km>0 && age>0 && (type==1 ||type==2) && !isReserved){
                //bileti hazırla
                ticket = new Ticket(km,type,seat,bus);
                ticket.setPrice(age);

                //rezerve edilen koltugu listeden kaldıralım
                ticket.getBus().getSeats().remove(seat);

                //bileti yazdıralım
                ticket.printTicket(name);
            }else{
                if(isReserved){
                    System.out.println("Seçilen koltuk mevcut değil veya rezerve edilmiştir!");
                }else{
                    System.out.println("Sayin "+name+", Geçersiz giriş yaptınız!");
                }
            }
            System.out.println("Yeni işlem için bir sayı giriniz, ÇIKIŞ için 0 giriniz : ");
            select=scan.nextInt();
            scan.nextLine();

        }while(select!=0);

        System.out.println("İyi günler diler, yine bekleriz...");
    }

}
