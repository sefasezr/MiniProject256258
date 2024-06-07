package TicketReservationApp;

public class Ticket {

    //4-mesafe(KM),yolculuk tipi,koltuk no,fiyat,otobüs


    private double distance;

    private int typeNo;//1-tek yön 2- çift yön

    private String seatNo;

    private double price;

    private Bus bus;//bu bilet hangi otobüse ait

    //paramli const
    public Ticket(double distance, int typeNo, String seatNo, Bus bus) {
        this.distance = distance;
        this.typeNo = typeNo;
        this.seatNo = seatNo;
        this.bus = bus;
    }

    //getter
    public double getDistance() {
        return distance;
    }

    public int getTypeNo() {
        return typeNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public double getPrice() {
        return price;
    }

    public Bus getBus() {
        return bus;
    }

    //setter
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTypeNo(int typeNo) {
        this.typeNo = typeNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    //5-bilet fiyatını hesaplama ve set etme
    public void setPrice() {
        //buradaki hesaplamaları kendimiz yapacağız
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
