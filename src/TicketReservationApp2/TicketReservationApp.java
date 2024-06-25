package TicketReservationApp2;

import java.util.Scanner;

public class TicketReservationApp {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Bus bus = new Bus("41 UV 328",38);
        Ticket ticket;

        Scanner scan = new Scanner(System.in);
        int secenek;

        do{
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
            System.out.println(bus.getKoltuklar());
            String seat = scan.nextLine();

            boolean isReserved = !(bus.getKoltuklar().contains(seat));
            if(km>0 && age>0 && (type==1||type==2)&& !isReserved){
                ticket = new Ticket(bus,type,seat,km);
                ticket.setPrice(age);

                ticket.getBus().getKoltuklar().remove(seat);
                ticket.printTicket(name);
            }else{
                if(isReserved){
                    System.out.println("Bilet rezerve edilmiş yada geçersiz koltuk no!");
                }
                else{
                    System.out.println("Sayin "+name +" gecersiz giris yaptiniz");
                }
            }
            System.out.println("Cikiş yapmak icin 0'a basiniz devam etmek istiyorsaniz herhangi sayiya basiniz");
            secenek = scan.nextInt();
            scan.nextLine();

        }while(secenek != 0);
        System.out.println("İyi günler diler yeniden bekleriz...");

    }
}
