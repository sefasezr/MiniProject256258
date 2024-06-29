package MiniBookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2-a-ProductService i implemente et ve metodları book a uygun sekilde doldur
//ÖDEV
public class NotebookService implements ProductService{

    List<Notebook> noteBookList = new ArrayList<>();

    //Başlangıçta kayıtlı kitaplar olsun
    public NotebookService(){
        Notebook notebook1 = new Notebook(1,"Büyük Defter","150 Lira",25,"Victoria","96");
        Notebook notebook2 = new Notebook(2,"Büyük Defter","150 Lira",12,"Journals","72");
        Notebook notebook3 = new Notebook(3,"Orta Defter","125 Lira",15,"Pemya","72");
        this.noteBookList.add(notebook1);
        this.noteBookList.add(notebook2);
        this.noteBookList.add(notebook3);
    }




    @Override
    public void processMenu() {
        Scanner scan  = new Scanner(System.in);
        int choice = -1;
        while(choice!=0){
            System.out.println("-----------------------------------------------");
            System.out.println("1-Defterleri Listele");
            System.out.println("2-Defter ekle");
            System.out.println("3-Defter sil");
            System.out.println("4-Yayınevine göre filtrele");
            System.out.println("0-Çıkış");
            System.out.println("Seçiminiz:");
            choice = scan.nextInt();
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
                    System.out.println("Marka :");
                    String pub = scan.next();
                    filterProduct(pub);
                    break;
                case 0:
                    System.out.println("Ana menüye yönlendiriliyorsunuz.");
                    break;
                default:
                    System.out.println("Hatalı giriş");
                    break;
            }
        }
    }

    @Override
    public void listProduct() {
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-5s \n","ID","Kitap Adı","Marka","Sayfa Sayısı","Birim Fiyat","Stok");
        for(Notebook notebook : noteBookList){
            System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-5s \n",notebook.getId(),notebook.getName(),notebook.getBrand(),notebook.getSheet(),notebook.getPrice(),notebook.getStock());
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    @Override
    public void addProduct() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Kitap adı:");
        String bookName = scan.nextLine();
        System.out.println("Marka adı:");
        String brand = scan.nextLine();
        System.out.println("Sayfa sayısı:");
        String sheet = scan.nextLine();
        System.out.println("Birim Fiyat:");
        String price = scan.nextLine();
        System.out.println("Stok:");
        int stock = scan.nextInt();

        Notebook newNoteBook = new Notebook(1+this.noteBookList.size(),bookName,price,stock,brand,sheet);
        this.noteBookList.add(newNoteBook);
        System.out.println("Listeye defter ekleme başarılı");

    }

    @Override
    public void removeProduct() {
        Scanner scan = new Scanner(System.in);
        boolean isExist = true;
        System.out.println("Silmek istediginiz defterin ID'sini girin: ");
        int id = scan.nextInt();
        for(Notebook notebook : noteBookList){
            if(notebook.getId()==id){
                isExist = true;
                this.noteBookList.remove(notebook);
                System.out.println("Defter silindi");
                break;
            }else{
                isExist = false;
            }
        }
        if(isExist==false){
            System.out.println("Defter bulunamadı");
        }
    }

    @Override
    public void filterProduct(String filter) {
        for(Notebook notebook : noteBookList){
            if(notebook.getBrand().equalsIgnoreCase(filter)){
                System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-5s \n",notebook.getId(),notebook.getName(),notebook.getBrand(),notebook.getSheet(),notebook.getPrice(),notebook.getStock());
            }
        }
    }
}
