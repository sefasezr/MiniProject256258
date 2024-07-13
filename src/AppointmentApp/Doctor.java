package AppointmentApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
4-Doktor:
            -id, isim, branş,takvim
            -takvim: sistemin kullanıldığı günden 1 gün sonra başlamak üzere
                     7 günlük uygun randevu tarihleri
 */
public class Doctor {
    private int id;
    private String name;
    private String department;
    private List<String>dates = new ArrayList<>();


    public Doctor(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
//4-doctor oluşturuldugunda 3 günlük takvimi olsun
        LocalDate day = LocalDate.now(); //sisteme girilen tarih
        for (int i = 0; i < 3; i++) {  //test edebilmek icin 3 yaptik

            this.dates.add(day.plusDays(i).toString());
        }
    }
//5-getter-setter metodlarini oluştur


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }
}
