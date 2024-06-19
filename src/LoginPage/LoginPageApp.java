package LoginPage;

    /*

Project: Bir siteye üye olma ve giriş yapma sayfası tasarlayınız.

         menü: kullanıcıya işlem seçimi için menü gösterilir.

         üye olma(register): kullanıcıdan ad-soyad, email ve şifre bilgileri alınız.
                             email ve şifre birer listede tutulur.
                             aynı email kabul edilmez.

         giriş(login): email ve şifre girilir.
                       email bulunamazsa kayıtlı değil, üye olun uyarısı verilir.
                       email ile aynı indekste kayıtlı şifre doğrulanırsa siteye giriş yapılır.

         email validation: boşluk içermemeli
                         : @ içermeli
                         : gmail.com,hotmail.com veya yahoo.com ile bitmeli.
                         : mailin kullanıcı adı kısmında(@ den önce) sadece büyük-küçük harf,rakam yada -._ sembolleri olabilir.

         password validation: boşluk içermemeli
                            : en az 6 karakter olmalı
                            : en az bir tane küçük harf içermeli
                            : en az bir tane büyük harf içermeli
                            : en az bir tane rakam içermeli
                            : en az bir tane sembol içermeli
*/

import java.util.Scanner;

public class LoginPageApp {

    public static void main(String[] args) {
        start();
        //2-adım:user nesnesini olusturalim
    }



    //1-adim:
    private static void start() {

        Scanner scan = new Scanner(System.in);

        //UserService objesi oluşturalım
        UserService service = new UserService();

        int select;//ÇIKIŞ için 0 seçilsin
        //menü
        do{
            System.out.println("=== TECHPROEDUCETION ===");
            System.out.println("1-Üye ol");
            System.out.println("2-Giriş yap");
            System.out.println("0-ÇIKIŞ");
            System.out.print("Seçiminiz : ");
            select = scan.nextInt();//1,2,0

            switch (select){
                case 1:
                    //üye olma
                    service.register();
                    break;
                case 2:
                    //giriş yap
                    service.login();
                    break;
                case 0:
                    System.out.println("İyi günler dileriz...");
                    break;
                default:
                    System.out.println("Hatalı giriş yaptınız , tekrar deneyiniz.");
                    break;
            }

        }while(select!=0);

    }

}
