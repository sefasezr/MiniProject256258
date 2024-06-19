package LoginPage;

import java.util.*;

//3-adım:Userla ilgili metodlar için
public class UserService {

    Scanner scan = new Scanner(System.in);

    //List<User> users = new ArrayList<>(); -->Practice
    Map<String,String> userInfo = new HashMap<>();//K:email , V:password

    //4-adım:üye olma metodu:kullanicidan alinan isim,email,sifre ile
    //kullanıcı olusturma

    public void register(){

        System.out.println("Ad-Soyad giriniz: ");
        String name = scan.nextLine();

        //email geçersizse tekrar girilmeli
        String email;
        boolean isValid; //T:gecerli, F:gecersiz
        do {
            System.out.println("Email giriniz: ");
            email = scan.nextLine(); //asd@gmail.com
            //email geçerli mi
            isValid=validateEmail(email); //T:

            //email unique olmalı:bu email ile daha önce kayıt var mı
            boolean isExistEmail = this.userInfo.containsKey(email);//T
            if(isExistEmail){
                System.out.println("Bu email ile kayıtlı kullanıcı zaten var");
                isValid = false;
            }

        }while(!isValid);


        //Geçerli şifre alma
        String password;
        boolean isValidPassword;
        do {
            System.out.println("Şifre belirleyiniz: ");
            password = scan.nextLine();
            isValidPassword = validatePassword(password);

        }while(!isValidPassword);

        //user oluşturalım:çok yakında..........
        User user = new User(name,email,password);

        //email ve password userInfoya ekleyelim
        this.userInfo.put(user.getEmail(),user.getPassword());

        System.out.println("Sayin "+user.getName()+", tebrikler, kayıt işlemi başarıyla gerçekleşti. ");
        System.out.println("Email ve şifrenizi kullanarak sisteme giriş yapabilirsiniz.");



    }

    //7-adım:giriş işlemi
    public void login(){
        System.out.println("Email giriniz : ");
        String email = scan.nextLine();

        //kullanıcı kaydı var mı?
        if(this.userInfo.containsKey(email)){ //şifre soralım

            boolean isSuccess = false;
            int counter = 3;

            while(!isSuccess && counter>0){
                System.out.println("Şifrenizi giriniz : ");
                String passw=scan.nextLine();

                //email ile şifre eşleşiyor
                if(this.userInfo.get(email).equals(passw)){
                    //giriş başarılı
                    System.out.println("Harika, sisteme giriş yaptınız. Hoşgeldiniz:");
                    isSuccess = true;
                }else{
                    //şifre yanlış
                    counter--; //2-1-0
                    if(counter==0){
                        System.out.println("3 kez hatalı giriş yaptınız! Ana menüye yönlendiriliyorsunuz.");
                    }else{
                        System.out.println("Şifreniz yanlış, tekrar deneyiniz, kalan hakkınız : "+counter);
                    }
                }

            }

        }else{
            System.out.println("Sisteme bu email ile kayıtlı kullanıcı bulunamadı.");
            System.out.println("Üyeyseniz bilgilerinizi kontrol ediniz, değilseniz üye olunuz!");
        }
    }

    //5-adım: email validation
    public boolean validateEmail(String email){
        boolean isValid;





        return true;
    }

    //6-adım:password validation
    public boolean validatePassword(String password){
        boolean isValid;
        return true;
    }

}
