package AppointmentApp2;

import java.util.Scanner;

public class AppointmentApp {
    public static void main(String[] args) {
        start();
    }
    public static void start() {
        Scanner scan  = new Scanner(System.in);
        UserService userService = new UserService();
        int choice = -1;
        do {
            System.out.println("****************************Randevu Sistemine Hoşgeldiniz***************************");
            System.out.println("1-Sisteme Kayıt");
            System.out.println("2-Sisteme Giriş");
            System.out.println("3-Şifre Güncelleme");
            System.out.println("0-ÇIKIŞ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    userService.register();
                    break;
                case 2:
                    userService.login();
                    userService.processMenu(userService);
                    break;
                case 3:
                    userService.update();
                    break;
                case 0:
                    System.out.println("Çıkış Yapılıyor.");
                    break;
                default:
                    System.out.println("Geçersiz İşlem Girişi!");
                    break;

            }
        }while(choice != 0);
    }
}
