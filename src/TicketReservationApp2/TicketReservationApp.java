package TicketReservationApp2;

import java.util.Scanner;

public class TicketReservationApp {
    public static void main(String[] args) {
        start();
    }

    private static void start() {

        Bus bus = new Bus("41 UV 328",39);
        Scanner scan = new Scanner(System.in);
        Ticket ticket;
        int select;
        do{
            System.out.println("Lutfen isminizi giriniz : ");
            String name = scan.nextLine();
            System.out.println("Lutfen KM giriniz       : ");
            double km = scan.nextDouble();
            System.out.println("Lutfen yasinizi giriniz : ");
            int age = scan.nextInt();
            System.out.println("Yolculuk turu giriniz   : ");
            System.out.println("1-Tek Yön");
            System.out.println("2-Çift Yön");
            int type = scan.nextInt();
            scan.nextLine();
            System.out.println("Lutfen koltuk no giriniz: ");
            System.out.println("(3 ve kati olan numaralara %20 fazla ücret uygulanır!)");
            System.out.println(bus.getSeats());
            String seatNo = scan.nextLine();

            boolean isReserved = bus.getSeats().contains(seatNo);

            if(age>0 && isReserved && (type==1||type==2) && km>0){
                ticket = new Ticket(km,type,bus,seatNo);
                ticket.setPrice(age);

                ticket.getBus().getSeats().remove(seatNo);
                ticket.biletDokumuYazdirma(name);
            }else{
                if(!isReserved){
                    System.out.println("Gecersiz Koltuk numarasi veya koltuk baskasi tarafindan rezerv edilmiş");
                }else{
                    System.out.println("Gecersiz tus girisi");
                }
            }
            System.out.println("Isleme devam etmek istiyorsanız herhangi sayiyi tuslayin ÇIKIŞ için 0'i tuslayin");
            select = scan.nextInt();
            scan.nextLine();
        }while (select!=0);

    }
}
