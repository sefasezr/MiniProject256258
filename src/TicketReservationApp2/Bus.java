package TicketReservationApp2;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    private String plaka;
    private List<String> koltuklar = new ArrayList<String>();
    private int koltukSayisi;


    public Bus(String plaka, int koltukSayisi) {
        this.plaka = plaka;
        this.koltukSayisi = koltukSayisi;
        for (int i = 1 ; i <= koltukSayisi; i++) {
            this.koltuklar.add(String.valueOf(i));
        }
    }

    public String getPlaka() {
        return plaka;
    }

    public List<String> getKoltuklar() {
        return koltuklar;
    }

    public int getKoltukSayisi() {
        return koltukSayisi;
    }
}
