package AppointmentApp2;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String tck;
    private String name;
    private String email;


    public User(String tck, String name, String email) {
        this.tck = tck;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
