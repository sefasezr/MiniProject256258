package TicketReservationApp2;

public class Ticket {
    private double distance;
    private double price;
    private int typeNo;
    private Bus bus;
    private String seatNo;

    public Ticket(double distance,int typeNo, Bus bus, String seatNo) {
        this.distance = distance;
        this.typeNo = typeNo;
        this.bus = bus;
        this.seatNo = seatNo;
    }

    public double getDistance() {
        return distance;
    }

    public double getPrice() {
        return price;
    }

    public int getTypeNo() {
        return typeNo;
    }

    public Bus getBus() {
        return bus;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setPrice(int age) {
        //Kendim yapacagim

        double total=0;
        int seatNo = Integer.valueOf(this.seatNo);
        switch (this.typeNo){
            case 1:
                if(seatNo%3==0){
                    total = distance*1.2;
                }else{
                    total = distance;
                }
                break;
            case 2:
                if(seatNo%3==0){
                    total = distance*2*1.2;
                }else{
                    total = distance*2;
                }
                total = total*0.8;
                break;
        }
        if(age<12){
            total = distance * 0.5;
        }else if (age>65){
            total = distance * 0.7;
        }
        this.price = total;
    }

    public void setTypeNo(int typeNo) {
        this.typeNo = typeNo;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
    public void biletDokumuYazdirma(String name){
        System.out.println("*".repeat(42));
        System.out.println("---- Bilet Detayı ----");
        System.out.println("Sayın "+name);
        System.out.println("Otobus plakası : "+this.bus.getNumberOfPlate());
        System.out.println("Mesafe(KM)     : "+this.distance);
        System.out.println("Yolculuk Tipi  : "+(this.typeNo==1?"Tek Yön":"Çift Yön"));
        System.out.println("Koltuk No      : "+this.seatNo);
        System.out.println("Toplam Tutar   : "+this.price);
        System.out.println("Keyifli Yolculuklar Dileriz...");
        System.out.println("*".repeat(42));
    }
}
