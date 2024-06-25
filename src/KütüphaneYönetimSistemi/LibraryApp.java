package KütüphaneYönetimSistemi;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Scanner scan = new Scanner(System.in);
        LibraryService service = new LibraryService();
        service.fillBookList();
        Book book;
        Member member;
        System.out.println(" *** Kutuphane Sistemine Hosgeldiniz *** ");
        int select = -1;
        while (select!=0){
            System.out.println("Seçmek istediğiniz işlemi seçiniz.");
            System.out.println("1-Üyelik Kaydı");
            System.out.println("2-Üyelik Silme");
            System.out.println("3-Kitap Ödünç Alma");
            System.out.println("4-Kitap Ödünç İade");
            select = scan.nextInt();
            scan.nextLine();
            switch (select){
                case 1:
                    System.out.println("İsminizi giriniz");
                    String name = scan.nextLine();
                    member = new Member(name,100+service.memberList.size());
                    service.addMember(member);
                    break;
                case 2:
                    System.out.println("Üye numaranızı giriniz");
                    int id = scan.nextInt();
                    scan.nextLine();
                    member = service.findMemberById(id);
                    service.deleteMember(member);
                    break;
                case 3:
                    System.out.println("Uye numaranizi giriniz");
                    id = scan.nextInt();
                    if(service.findMemberById(id)==null){  // uye bulunamadi old. icin silicez
                        break;
                    }
                    scan.nextLine();
                    member = service.findMemberById(id);
                    System.out.println("Kitap Isbn Giriniz");
                    String isbn = scan.nextLine();
                    book = service.findBookByIsbn(isbn);
                    service.borrowBook(book,member);
                    break;
                case 4:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Geçersiz giriş..");
            }
        }


    }
}
