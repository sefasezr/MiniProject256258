package TicketReservationApp;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    //2-plaka,koltuk sayısı, koltuk numaraları

    private String numberPlate;   //34 TPE 69
    private int numberOfSeat;  //33
    private List<String> seats = new ArrayList<>();//"1","2","3"...

    //3-paramli const:otobus objesini oluşturduğumda öz.leri belli olsun

    public Bus(String numberPlate, int numberOfSeat) {
        this.numberPlate = numberPlate;  //34 TPE 69
        this.numberOfSeat = numberOfSeat; //33
        for (int i = 1; i <= numberOfSeat; i++) {
            this.seats.add(String.valueOf(i));
            //this.seats.add(i+"");
        }
    }

    //getter: değerlerin okunmasını sağlar


    public String getNumberPlate() {
        return numberPlate;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public List<String> getSeats() {
        return seats;
    }
}
