package RestaurantBillGenerator;

import java.util.Scanner;

/*
    Proje: Restaurant fiş üretme uygulaması (Bill Generator)
        1-Bir restaurantın online siparis sisteminde
          hesabı yazdıran uygulama tasarlayınız.

        2-Restauranttaki yiyecekler bir listte tutulsun.
          Yiyeceklerin kodu, ismi ve ucreti olsun

        3-Yiyecek menüsü, sipariş oluşturma/iptal ve hesap
          oluşturma için seçim menüsü gösterilsin

        4-Yiyecek menü: Listedeki yiyecekler menü şeklinde listelensin
          Sipariş girme: Yiyeceğin kodu ve istenilen adet girilerek sipariş oluşturulsun
                         Her sipariş için kod uretilsin(başlangıç 1000 artarak devam eder)
                         her bir yiyecek siparişi için tutar hesaplansin

          Sipariş iptal: Sipariş kodu girilerek sipariş silinsin
          Hesap oluşturma: Tutarları ile birlikte tüm siparişleri ve
                           toplam tutarı gösteren bir hesap fişi yazdırılsın.

     */
     /*
     Ödev: Şirket büyüdü, cafe kısmı açıldı.
     Aynı uygulama cafe kısmında da kullanılsın.
     Cafede farklı menü var.
        Dish dish1 = new Dish(401,"Tiramisu",35.0);
        Dish dish2 = new Dish(402,"Dondurma",25.0);
        Dish dish3 = new Dish(403,"Profiterol",25.0);
        Dish dish4 = new Dish(404,"Kahve",17.5);
        Dish dish5 = new Dish(405,"Çay",7.5);
        Dish dish6 = new Dish(406,"Portakal Suyu",25.5);
        Uygulama başlandığında restaurant/cafe seçeneği olsun
      */
public class RestaurantBillGenerator {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        DishService dishService = new DishService();
        OrderService orderService = new OrderService();
        dishService.fillDishList();
        getSelectionMenu(dishService,orderService);


    }

    public static void getSelectionMenu(DishService dishService,OrderService orderService){
        Scanner scan  = new Scanner(System.in);
        int select = -1;
        while(select!=0){
            System.out.println("------------------------------------------------------");
            System.out.println(" *** Lezzet Restaurant Sipariş Uygulaması *** ");
            System.out.println("1-Menü");
            System.out.println("2-Sipariş Girme");
            System.out.println("3-Sipariş İptal Etme");
            System.out.println("4-Hesap Oluşturma");
            System.out.println("0-Çıkış");
            System.out.println("Seçiminiz Nedir");
            System.out.println("------------------------------------------------------");
            select = scan.nextInt();
            switch(select){
                case 1:
                    dishService.showDishMenu();
                    break;
                case 2:
                    orderService.createOrder(dishService);
                    break;
                case 3:
                    orderService.deleteOrder();
                    break;
                case 4:
                    orderService.printBill();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hatalı giriş!");
                    break;
            }
        }
        System.out.println("İyi günler dileriz...");


    }
}
