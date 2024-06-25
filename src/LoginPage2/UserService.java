package LoginPage2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class UserService {

    Scanner scan  = new Scanner(System.in);

    Map<String,String> userInfo = new HashMap<>();

    public void register(){
        System.out.println("Ad-Soyad Giriniz");
        String name = scan.nextLine();

        String email;
        boolean isValid ;
        do {
            System.out.println("Email giriniz");
            email = scan.nextLine();
            isValid = validateEmail(email);

            boolean isExistEmail = userInfo.containsKey(email);
            if(isExistEmail){
                System.out.println("Email already exist");
                isValid = false;
            }

        }while(!isValid);

        String password;
        boolean isValidPassword;
        do {
            System.out.println("Password giriniz");
            password = scan.nextLine();
            isValidPassword = validatePassword(password);

        }while(!isValidPassword);

        User user = new User(name,email,password);

        this.userInfo.put(email,password);
        System.out.println("Sayin "+user.getName()+", tebrikler, kayıt işlemi başarıyla gerçekleşti. ");
        System.out.println("Email ve şifrenizi kullanarak sisteme giriş yapabilirsiniz.");
    }
    public void login(){
        System.out.println("Email giriniz.");
        String email = scan.nextLine();

        if(this.userInfo.containsKey(email)){
            boolean isSuccess = false;
            int count = 3;
            while(!isSuccess && count>0){
                String password = scan.nextLine();
                if(this.userInfo.get(email).equals(password)){
                    isSuccess = true;
                    System.out.println("Harika, sisteme giriş yaptınız. Hoşgeldiniz:");
                }else{
                    count--;
                    if(count==0){
                        System.out.println("3 kez hatalı giriş yaptınız!");
                        System.out.println("Eğer sifrenizi yenilemek isterseniz 1'e basiniz");
                        System.out.println("Ana menüye yönlendirilmek için herhangi bir tuşa basınız");
                        String choice = scan.nextLine();
                        if(choice.equals("1")){
                            update();
                        }else {
                            System.out.println("Ana menüye yönlendiriliyorsunuz");
                        }
                    }else{
                        System.out.println("Şifreniz yanlış, tekrar deneyiniz, kalan hakkınız : "+count);
                    }
                }
            }
        }else{
            System.out.println("Email kayıtlı değil lutfen kayıtlı bir email giriniz.");
            System.out.println("Üyeyseniz bilgilerinizi kontrol ediniz, değilseniz üye olunuz!");
        }
    }
    public void update(){
        Random rnd =new Random();
        String newPassw = null;
        System.out.println("Lutfen isminizi giriniz");
        String name = scan.nextLine();
        System.out.println("Lutfen kontrol icin Email giriniz");
        System.out.println("Ardindan mailinize gelen kodu giriniz");
        String email = scan.nextLine();
        if(this.userInfo.containsKey(email)){
            boolean isSuccess;
            do {
                System.out.println("Mailinize kod gönderildi...");
                int code = rnd.nextInt(100000,1000000);
                System.out.println("Mailinize gelen kod : "+code);
                int giris = scan.nextInt();
                scan.nextLine();
                if(code==giris){

                    boolean isValidatePassword;
                    do {
                        System.out.println("Kod girişiniz doğrulandı yeni şifrenizi giriniz...");
                        newPassw = scan.nextLine();
                        isValidatePassword = validatePassword(newPassw);
                    }while(!isValidatePassword);
                 isSuccess = true;
                }else{
                    System.out.println("Kodu yanlıs girdiniz tekrar kod gonderiliyor");
                    isSuccess = false;
                }

            }while(!isSuccess);
            User user = new User(name,email,newPassw);

            this.userInfo.put(email,newPassw);
            System.out.println("Sayin "+user.getName()+", tebrikler, şifre güncelleme işlemi başarıyla gerçekleşti. ");
            System.out.println("Email ve şifrenizi kullanarak sisteme giriş yapabilirsiniz.");

        }
    }

    private boolean validatePassword(String password) {
        return true;
    }

    private boolean validateEmail(String email) {
        return true;
    }
}
