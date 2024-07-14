package AppointmentApp2;

public class Appointment {
    private static int counter=0;
    private int id;
    private Doctor doctor;
    private String date;
    private User user;

    public Appointment( Doctor doctor, String date,User user) {
        counter++;
        this.id = counter;

        this.doctor = doctor;
        this.date = date;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
