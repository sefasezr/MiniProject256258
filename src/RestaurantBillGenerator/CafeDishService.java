package RestaurantBillGenerator;

import java.util.ArrayList;
import java.util.List;

public class CafeDishService {

    private List<Dish> cafeDishList = new ArrayList<>();

    public void addDishList(){
        Dish dish1 = new Dish(401,"Tiramisu",35.0);
        Dish dish2 = new Dish(402,"Dondurma",25.0);
        Dish dish3 = new Dish(403,"Profiterol",25.0);
        Dish dish4 = new Dish(404,"Kahve",17.5);
        Dish dish5 = new Dish(405,"Çay",7.5);
        Dish dish6 = new Dish(406,"Portakal Suyu",25.5);
        this.cafeDishList.add(dish1);
        this.cafeDishList.add(dish2);
        this.cafeDishList.add(dish3);
        this.cafeDishList.add(dish4);
        this.cafeDishList.add(dish5);
        this.cafeDishList.add(dish6);
    }

    public void showDishMenu(){
        System.out.println("                 Lezzetlerimiz                    ");
        System.out.printf("%-3s   %-20s   %-5s \n","Kod","Adı","Fiyat");
        System.out.printf("%-3s   %-20s   %-5s \n","---","---","-----");
        for (Dish dish : this.cafeDishList){
            System.out.printf("%-3s   %-20s   %-5s Lira\n", dish.getCode(),dish.getName(),dish.getPrice());
        }
    }

}
