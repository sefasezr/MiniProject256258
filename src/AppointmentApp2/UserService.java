package AppointmentApp2;

import java.util.*;

public class UserService {

    Scanner scan  = new Scanner(System.in);
    List<User> userList = new ArrayList<>();
    Map<String, String> loginMap = new HashMap<String, String>();
    User user;

    public void register(){
        System.out.println("İsim-Soyisim giriniz");
        String name = scan.nextLine();

        String tck;
        boolean isValid ;
        do {
            System.out.println("TCK giriniz");
            tck = scan.nextLine();
            isValid = tckValidate(tck);

            boolean isExistEmail = loginMap.containsKey(tck);
            if(isExistEmail){
                System.out.println("TC already exist");
                isValid = false;
            }

        }while(!isValid);

        String password;
        boolean isValidPassword;
        do {
            System.out.println("Password giriniz");
            password = scan.nextLine();
            isValidPassword = passValidate(password);

        }while(!isValidPassword);

        user = new User(tck, name, password);
        this.userList.add(user);

        loginMap.put(tck,password);
        System.out.println("Sayın "+user.getName()+ " üyelik işleminiz başarıyla gerçekleştirildi");
        System.out.println("TC kimlik numaranızı ve şifrenizi kullanarak sisteme giriş yapabilirsiniz.");
    }

    public void login(){
        System.out.println("TCK giriniz.");
        String tck = scan.nextLine();

        if(this.loginMap.containsKey(tck)){
            boolean isSuccess = false;
            int count = 3;
            while(!isSuccess && count>0){
                String password = scan.nextLine();
                if(this.loginMap.get(tck).equals(password)){
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
            System.out.println("TCK kayıtlı değil lutfen kayıtlı bir TCK giriniz.");
            System.out.println("Üyeyseniz bilgilerinizi kontrol ediniz, değilseniz üye olunuz!");
        }
    }

    public void update(){
        Random rnd =new Random();
        String newPassw = null;
        System.out.println("Lutfen isminizi giriniz");
        String name = scan.nextLine();
        System.out.println("Lutfen kontrol icin TCK giriniz");
        System.out.println("Ardindan sisteme gelen kodu giriniz");
        String tck = scan.nextLine();
        if(this.loginMap.containsKey(tck)){
            boolean isSuccess;
            do {
                System.out.println("Sisteme kod gönderildi...");
                int code = rnd.nextInt(100000,1000000);
                System.out.println("Sisteme gelen kod : "+code);
                int giris = scan.nextInt();
                scan.nextLine();
                if(code==giris){

                    boolean isValidatePassword;
                    do {
                        System.out.println("Kod girişiniz doğrulandı yeni şifrenizi giriniz...");
                        newPassw = scan.nextLine();
                        isValidatePassword = passValidate(newPassw);
                    }while(!isValidatePassword);
                    isSuccess = true;
                }else{
                    System.out.println("Kodu yanlıs girdiniz tekrar kod gonderiliyor");
                    isSuccess = false;
                }

            }while(!isSuccess);
            user = new User(tck, name, newPassw);

            this.loginMap.put(tck,newPassw);
            System.out.println("Sayin "+user.getName()+", tebrikler, şifre güncelleme işlemi başarıyla gerçekleşti. ");
            System.out.println("TC Kimlik numaranızı ve şifrenizi kullanarak sisteme giriş yapabilirsiniz.");

        }
    }

    public void processMenu(UserService userService){
        Scanner scan  = new Scanner(System.in);
        AppointmentService appointmentService = new AppointmentService();
        DoctorService doctorService = new DoctorService();
        System.out.println("Merhaba, randevu sistemine hoşgeldiniz...");
        int select;
        do {
            System.out.println("1-Randevu al");
            System.out.println("2-Randevu görüntüle");
            System.out.println("0-ÇIKIŞ");
            System.out.print("Seçiminiz");
            select = scan.nextInt();
            scan.nextLine();
            switch (select) {
                case 1:
                    appointmentService.getAppointment(user,doctorService);
                    break;
                case 2:
                    appointmentService.printApp();
                    break;
                case 0:
                    System.out.println("İyi günler dileriz...");
                    break;
                default:
                    System.out.println("Hatalı giriş, tekrar deneyiniz!");
                    break;
            }

        }while(select!=0);
    }



    public boolean tckValidate(String tck){
        boolean validate ;
        if (tck.length()==11){
            validate = true;
        }else{
            validate = false;
        }
        return validate;
    }

    public boolean passValidate(String password){
        return true;
    }




}
