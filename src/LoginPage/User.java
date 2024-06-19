package LoginPage;
//POLO
//POJO CLASS : DATALARI SAKLAYACAGIMIZ ilkel CLASS lardır.
//POJO-Plain Old JJava Object
//fields,constructor,getter-setter,toString()

public class User {
    //isim,username(email),password

    private String name;
    private String email;
    private String password;

    //user objesi oluştururken fieldlarının değerleri set edilmiş

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
