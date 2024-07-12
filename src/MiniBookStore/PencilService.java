package MiniBookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PencilService implements ProductService{

    List<Pencil> pencils = new ArrayList<Pencil>();

    public PencilService() {
        Pencil pencil1 = new Pencil(100,"Rotring","85",50,"0.7","Beyaz");
        Pencil pencil2 = new Pencil(101,"Rotring","85",50,"0.5","Beyaz");
        Pencil pencil3 = new Pencil(102,"Faber Castel","110",50,"0.7","Siyah");
        Pencil pencil4 = new Pencil(102,"Faber Castel","110",50,"0.7","Beyaz");
        this.pencils.add(pencil1);
        this.pencils.add(pencil2);
        this.pencils.add(pencil3);
        this.pencils.add(pencil4);
    }


    @Override
    public void processMenu() {
        Scanner scan  = new Scanner(System.in);
        int choice = -1;
        while(choice !=0){
            System.out.println("-----------------------------------------------");
            System.out.println("1-Kalemleri Listele");
            System.out.println("2-Kalem ekle");
            System.out.println("3-Kalem sil");
            System.out.println("4-Markaya göre filtrele");
            System.out.println("0-Çıkış");
            System.out.println("Seçiminiz:");
            choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    listProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    System.out.println("Marka giriniz");
                    String marka = scan.nextLine();
                    filterProduct(marka);
                    break;
                case 0:
                    System.out.println("Ana menüye yönlendiriliyorsunuz.");
                    break;
                default:
                    System.out.println("Geçersiz işlem girişi");
                    break;
            }
        }
    }

    @Override
    public void listProduct() {
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-5s \n","ID","Marka","Fiyat","Stok Sayısı","Uç Tipi","Renk");
        for(Pencil pencil : this.pencils){
            System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-5s \n",pencil.getId(),pencil.getName(),pencil.getPrice(),pencil.getStock(),pencil.getPenTip(),pencil.getColor());
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    @Override
    public void addProduct() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Kalem Markası giriniz.");
        String marka = scan.nextLine();
        System.out.println("Fiyat giriniz.");
        String fiyat = scan.nextLine();
        System.out.println("Stok giriniz.");
        int stok = scan.nextInt();
        scan.nextLine();
        System.out.println("Uç Tipi giriniz.");
        String penTip ;
        while(true){
            System.out.println("0.5-0.7-0.9 olarak üç tip seçebilirsiniz");
            penTip = scan.nextLine();
            if(penTip!="0.5"&&penTip!="0.7"&&penTip!="0.9"){
                System.out.println("Geçersiz uç girişi tekrar giriniz");
                break;
            }
        }
        System.out.println("Renk giriniz.");
        String renk = scan.nextLine();
        Pencil newPencil = new Pencil(1+this.pencils.size(),marka,fiyat,stok,penTip,renk);
        this.pencils.add(newPencil);
        System.out.println("Kalem ekleme başarılı");
    }

    @Override
    public void removeProduct() {
        Scanner scan = new Scanner(System.in);
        boolean isExist = true;
        System.out.println("Silmek istediginiz kalemin ID'sini giriniz");
        int id = scan.nextInt();
        scan.nextLine();
        for (Pencil pencil : this.pencils){
            if(pencil.getId()==id){
                isExist = true;
                this.pencils.remove(pencil);
                System.out.println("Kalem başarıyla silindi");
                break;
            }else{
                isExist = false;
            }
        }
        if (isExist == false){
            System.out.println("Kalem bulunamadı");
        }
    }

    @Override
    public void filterProduct(String filter) {
        for (Pencil pencil : this.pencils){
            if(pencil.getName().equalsIgnoreCase(filter)){
                System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-5s \n",pencil.getId(),pencil.getName(),pencil.getPrice(),pencil.getStock(),pencil.getPenTip(),pencil.getColor());
            }
        }
    }
}
