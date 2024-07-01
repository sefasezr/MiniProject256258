package AppointmentApp;
//6-Randevu:
//              -id: otomatik üretilsin
//              -hasta adi,doktor,randevu tarihi
public class Appointment {
    private static int counter = 0;
    private int id;
    private String name;
    private Doctor doctor;
    private String date;

    public Appointment(String name, Doctor doctor, String date) {
        counter++;
        this.id = counter;
        this.name = name;
        this.doctor = doctor;
        this.date = date;
    }
}
