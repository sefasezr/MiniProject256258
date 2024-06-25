package RestaurantBillGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    Scanner scan  = new Scanner(System.in);
    List<Order> orderList = new ArrayList<>();

    public void createOrder(DishService dishService){

        int dishCode=-1;
        while(dishCode!=0){
            System.out.println("Lütfen ürün kodunu giriniz: (ÇIKIŞ:0)"); //100
            dishCode = scan.nextInt();//code ile ürünü bulmamız gerekiyor?
            Dish dish = dishService.findDishByCode(dishCode);
            if(dish.getCode()>0){
                System.out.println("Adet giriniz:");
                int num = scan.nextInt();  //2
                Order order = new Order(dish,num);
                order.setPrice();
                order.setOrderCode(1000+this.orderList.size());
                this.orderList.add(order);
            }
            for (Order order : this.orderList){
                System.out.printf("Sipariş kodu:%-5s   lezzet kodu:%-4s  adı:%-20s adet:%-3s\n",
                        order.orderCode,order.dish.getCode(),order.dish.getName(),order.numOfDish);
            }
        }
    }
    public void deleteOrder(){
        boolean isValid = true;
        if(this.orderList.isEmpty()){
            System.out.println("Siparisiniz bulunmamaktadir");
        }else{
            System.out.println("İptal etmek istediğiniz siparişin kodunu giriniz:");
            int code = scan.nextInt();
            for (Order order : this.orderList){
                if(order.orderCode==code){
                    this.orderList.remove(order);
                    System.out.println("Siparişiniz iptal edildi: "+order.dish.toString());
                    isValid=true;
                    break;
                }else{
                    isValid=false;
                }
            }
            if(!isValid){
                System.out.println("Sipariş kodu geçersiz!");
            }
            for (Order order : this.orderList){
                System.out.printf("Sipariş kodu:%-5s   lezzet kodu:%-4s  adı:%-20s adet:%-3s\n",
                        order.orderCode,order.dish.getCode(),order.dish.getName(),order.numOfDish);
            }
        }
    }

    public void printBill(){
        double totalPrice=0.0;
        System.out.println("                Lezzet Fişiniz              ");
        for (Order order : this.orderList){
            System.out.printf("Lezzet Kodu:%-5s  Adı:%-20s  Adet:%-5s Sipariş Tutarı: %-5s Lira\n",
                    order.dish.getCode(),order.dish.getName(),order.numOfDish,order.orderPrice);
            totalPrice+=order.orderPrice;
            ;
        }
        System.out.println("Toplam tutar: "+totalPrice);
        System.out.println("Afiyet Olsun...");
    }
}
