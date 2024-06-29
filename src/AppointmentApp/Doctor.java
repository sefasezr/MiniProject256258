package AppointmentApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor {

    private int id;
    private String name;
    private String department;
    private List<String> dates = new ArrayList<>();

    public Doctor(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
        //4-Doktor oluşturuldugunda doktorun 7 günlük takvimi olsun
        LocalDate day = LocalDate.now();  //sisteme girilen tarih: 29.06.2024
        for (int i = 0 ; i<3;i++){//test edebilmek için 3 yaptım
            day = day.plusDays(1); //30.06.2024
            this.dates.add(day.toString());
        }
    }

//5-getter-setter metodlarını oluştur


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
}
