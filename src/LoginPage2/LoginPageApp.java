package LoginPage2;

import java.util.Scanner;

public class LoginPageApp {
    public static void main(String[] args) {
        start();
    }
    public static void start() {
        Scanner scan  = new Scanner(System.in);

        UserService userService = new UserService();

        int select;

        do {
            System.out.println("=== TECHPROEDUCETION ===");
            System.out.println("1-Üye ol");
            System.out.println("2-Giriş yap");
            System.out.println("3-Şifre Güncelleme");
            System.out.println("0-ÇIKIŞ");
            System.out.print("Seçiminiz : ");
            select = scan.nextInt();//1,2,0
            switch (select){
                case 1:
                    userService.register();
                    break;
                case 2:
                    userService.login();
                    break;
                case 3:
                    userService.update();
                    break;
                default:
                    System.out.println("Geçersiz tuşlama.");
                    break;
            }

        }while (select != 0);

    }
}
