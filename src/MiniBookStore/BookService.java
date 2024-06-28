package MiniBookStore;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2-a-ProductService i implemente et ve metodları book a uygun sekilde doldur
public class BookService implements ProductService{
    //3-bookları saklamak için list oluştur

    List<Book> bookList = new ArrayList<Book>();

    //Başlangıçta kayıtlı kitaplar olsun
    public BookService(){
        Book book1 = new Book(1,"Vadideki Zambak","150 Lira",25,"Balzac","Penguin");
        Book book2 = new Book(2,"Suç ve Ceza","150 Lira",12,"Dostoyevski","Penguin");
        Book book3 = new Book(3,"Sefiller","125 Lira",15,"V.Hugo","Dream");
        this.bookList.add(book1);
        this.bookList.add(book2);
        this.bookList.add(book3);
    }

    //5-bookla ilgili işlemleri gösteren bir menü


    @Override
    public void processMenu() {
        Scanner scan  = new Scanner(System.in);
        int choice = -1;
        while(choice!=0){
            System.out.println("-----------------------------------------------");
            System.out.println("1-Kitapları Listele");
            System.out.println("2-Kitap ekle");
            System.out.println("3-Kitap sil");
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
                    System.out.println("Yayınevi :");
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

    //6-bookları formatla yazdır

    @Override
    public void listProduct() {
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-5s \n","ID","Kitap Adı","Yazar Adı","Yayınevi","Birim Fiyat","Stok");
        for(Book book : bookList){
            System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-5s \n",book.getId(),book.getName(),book.getAuthorName(),book.getPublisher(),book.getPrice(),book.getStock());
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    //7-kullanıcıdan alınan bilgilerle book oluştur, listeye ekliycez

    @Override
    public void addProduct() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Kitap adı:");
        String bookName = scan.nextLine();
        System.out.println("Yazar adı:");
        String authorName = scan.nextLine();
        System.out.println("Yayınevi:");
        String pub = scan.nextLine();
        System.out.println("Birim Fiyat:");
        String price = scan.nextLine();
        System.out.println("Stok:");
        int stock = scan.nextInt();

        Book newBook = new Book(1+this.bookList.size(),bookName,price,stock,authorName,pub);
        this.bookList.add(newBook);
        System.out.println("Listeye kitap ekleme başarılı");

    }

    //8-kullanıcıdan id al,id ile booku bul ve listeden kaldır

    @Override
    public void removeProduct() {
        Scanner scan = new Scanner(System.in);
        boolean isExist = true;
        System.out.println("Silmek istediginiz kitabın ID'sini girin: ");
        int id = scan.nextInt();
        for(Book book : bookList){
            if(book.getId()==id){
                isExist = true;
                this.bookList.remove(book);
                System.out.println("Kitap silindi");
                break;
            }else{
                isExist = false;
            }
        }
        if(isExist==false){
            System.out.println("Kitap bulunamadı");
        }
    }

    //9-tüm kitapların yayınevine bak, filter ile aynı ise yazdır

    @Override
    public void filterProduct(String filter) {
        for(Book book : bookList){
            if(book.getPublisher().equalsIgnoreCase(filter)){
                System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-5s \n",book.getId(),book.getName(),book.getAuthorName(),book.getPublisher(),book.getPrice(),book.getStock());
            }
        }
    }
}
