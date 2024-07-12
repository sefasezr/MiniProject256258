package MiniBookStore;

import java.util.Scanner;

/*
Proje:  Mini Book Store
        Online bir kitap market için ürün yönetim uyg yapiniz
        Kitap markette kitap ve defter satışı olacak, ancak ileride yeni ürün çeşidi eklenebilir olmalı

        Kitap özellikleri: id, isim, birim fiyat, stok, yazar adı, yayınevi
        Defter özellikleri: id, isim , birim fiyat, stok, marka, yaprak sayısı

        Kullanıcı ilgili kategorideki ürünleri listeleyebilmeli
        Kutllanıcı kategoriye göre ürün ekleyebilmeli
        Kullanıcı ürünleri benzersiz numaralarına göre silebilmeli
        Kullanıcı ürünleri marka(kitap) veya yayınevine göre filtreleyip listeleyebilmeli
        Kullanıcı ürün miktarını güncelleyebilsin Id'sine göre

 */
public class MiniBookStore {
    public static void main(String[] args) {
        enter();
    }

    //1-product, book, notebook classları oluştur.
    private static void enter() {
        //10-kategori menü
        Scanner scan  = new Scanner(System.in);
        System.out.println("--- Mini Book Store ---");
        int select = -1;
        while(select!=0){
            System.out.println("Ürün Yönetim Paneli");
            System.out.println("1-Kitaplar");
            System.out.println("2-Defterler");
            System.out.println("3-Kalemler");
            System.out.println("0-Çıkış");
            System.out.println("Seçiminiz: ");
            select = scan.nextInt();
            //ProductService i referans alarak service oluştur
            ProductService service;

            switch (select){
                case 1:
                    service = new BookService();
                    service.processMenu();
                    break;
                case 2:
                    service = new NotebookService();
                    service.processMenu();
                    break;
                case 3:
                    service = new PencilService();
                    service.processMenu();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor");
                    break;
                default:
                    System.out.println("Geçersiz işlem girişi tekrar deneyiniz");
                    break;
            }
        }
    }
}
