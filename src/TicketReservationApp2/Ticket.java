package TicketReservationApp2;

public class Ticket {
    private double distance;

    private Bus bus;

    private int gidisDonus; //1-tek yön 2- çift yön

    private String koltukNo;

    private double fiyat;

    public Ticket(Bus bus, int gidisDonus, String koltukNo,double distance) {
        this.bus = bus;
        this.gidisDonus = gidisDonus;
        this.koltukNo = koltukNo;
        this.distance = distance;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public void setGidisDonus(int gidisDonus) {
        this.gidisDonus = gidisDonus;
    }
    public void setKoltukNo(String koltukNo) {
        this.koltukNo = koltukNo;
    }


    public void setPrice (int yas){
        //buradaki hesaplamalari kendimiz yapacağiz
        double total=0;
        int seat = Integer.valueOf(this.koltukNo);
        switch (this.gidisDonus){
            case 1:
                if(seat%3==0){  //tekli koltuk
                    total = this.distance*1*1.2;
                }else {
                    total = this.distance*1;
                }
                System.out.println("Toplam tutar : "+total);
                break;
            case 2:
                if(seat%3==0){
                    total = this.distance*2*1.2;
                }else{
                    total = this.distance*2;
                }
                System.out.println("Toplam tutar : "+total);
                total = total - total*0.2;
                System.out.println("Çift yön indirimli tutar : "+total);
                break;
        }
        if(yas<12){
            total = total*0.5;
            System.out.println("12 yaş indirimli tutar : "+total);
        }else if (yas>65){
            total = total*0.7;
            System.out.println("65 yaş indirimli tutar : "+total);
        }
        this.fiyat = total;
    }
    public void printTicket(String name){
        System.out.println("*".repeat(42));
        System.out.println("---- Bilet Detayı ----");
        System.out.println("Sayın "+name);
        System.out.println("Otobus plakası : "+this.bus.getPlaka());
        System.out.println("Mesafe(KM)     : "+this.distance);
        System.out.println("Yolculuk Tipi  : "+(this.gidisDonus==1?"Tek Yön":"Çift Yön"));
        System.out.println("Koltuk No      : "+this.koltukNo);
        System.out.println("Toplam Tutar   : "+this.fiyat);
        System.out.println("Keyifli Yolculuklar Dileriz...");
        System.out.println("*".repeat(42));
    }
}
