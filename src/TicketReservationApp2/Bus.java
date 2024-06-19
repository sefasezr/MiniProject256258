package TicketReservationApp2;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    private String numberOfPlate;
    private int numberOfSeat;
    private List<String> seats = new ArrayList<>();

    public Bus(String numberOfPlate , int numberOfSeat) {
        this.numberOfPlate = numberOfPlate;
        this.numberOfSeat = numberOfSeat;

        for(int i = 1; i<=numberOfSeat;i++){
            this.seats.add(i+"");
        }
    }

    public String getNumberOfPlate() {
        return numberOfPlate;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public List<String> getSeats() {
        return seats;
    }
}


