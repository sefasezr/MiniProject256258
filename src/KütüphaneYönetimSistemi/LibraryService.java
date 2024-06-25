package KütüphaneYönetimSistemi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryService {
    List<Book> bookList = new ArrayList<>();
    List<Member> memberList = new ArrayList<>();
    Map<Member,Book> bookMap = new HashMap<>();

    public void fillBookList(){
        Book book1 = new Book("1984", "George Orwell", "101");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "102");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "103");
        Book book4 = new Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez", "104");
        Book book5 = new Book("Moby Dick", "Herman Melville", "105");
        Book book6 = new Book("War and Peace", "Leo Tolstoy", "106");
        Book book7 = new Book("Pride and Prejudice", "Jane Austen", "107");
        Book book8 = new Book("The Catcher in the Rye", "J.D. Salinger", "108");
        Book book9 = new Book("The Hobbit", "J.R.R. Tolkien", "109");
        Book book10 = new Book("Brave New World", "Aldous Huxley", "110");
        Book book11 = new Book("Crime and Punishment", "Fyodor Dostoevsky", "111");
        Book book12 = new Book("The Brothers Karamazov", "Fyodor Dostoevsky", "112");
        Book book13 = new Book("Anna Karenina", "Leo Tolstoy", "113");
        Book book14 = new Book("The Adventures of Huckleberry Finn", "Mark Twain", "114");
        Book book15 = new Book("Alice's Adventures in Wonderland", "Lewis Carroll", "115");
        Book book16 = new Book("The Iliad", "Homer", "116");
        Book book17 = new Book("The Odyssey", "Homer", "117");
        Book book18 = new Book("Ulysses", "James Joyce", "118");
        Book book19 = new Book("Madame Bovary", "Gustave Flaubert", "119");
        Book book20 = new Book("The Divine Comedy", "Dante Alighieri", "120");
        Book book21 = new Book("The Picture of Dorian Gray", "Oscar Wilde", "121");
        Book book22 = new Book("The Count of Monte Cristo", "Alexandre Dumas", "122");
        Book book23 = new Book("Dracula", "Bram Stoker", "123");
        Book book24 = new Book("Frankenstein", "Mary Shelley", "124");
        Book book25 = new Book("Don Quixote", "Miguel de Cervantes", "125");
        Book book26 = new Book("Les Misérables", "Victor Hugo", "126");
        Book book27 = new Book("Wuthering Heights", "Emily Brontë", "127");
        Book book28 = new Book("The Catch-22", "Joseph Heller", "128");
        Book book29 = new Book("The Lord of the Rings", "J.R.R. Tolkien", "129");
        Book book30 = new Book("The Grapes of Wrath", "John Steinbeck", "130");
        this.bookList.add(book1);
        this.bookList.add(book2);
        this.bookList.add(book3);
        this.bookList.add(book4);
        this.bookList.add(book5);
        this.bookList.add(book6);
        this.bookList.add(book7);
        this.bookList.add(book8);
        this.bookList.add(book9);
        this.bookList.add(book10);
        this.bookList.add(book11);
        this.bookList.add(book12);
        this.bookList.add(book13);
        this.bookList.add(book14);
        this.bookList.add(book15);
        this.bookList.add(book16);
        this.bookList.add(book17);
        this.bookList.add(book18);
        this.bookList.add(book19);
        this.bookList.add(book20);
        this.bookList.add(book21);
        this.bookList.add(book22);
        this.bookList.add(book23);
        this.bookList.add(book24);
        this.bookList.add(book25);
        this.bookList.add(book26);
        this.bookList.add(book27);
        this.bookList.add(book28);
        this.bookList.add(book29);
        this.bookList.add(book30);
    }

    public void addMember(Member member) {
        this.memberList.add(member);
        System.out.println(member.getName() + " adlı üye kütüphaneye eklendi.");
    }
    public void deleteMember(Member member){
        this.memberList.remove(member);
        System.out.println(member.getName()+ " adlı üye kütüphaneden silindi");
    }
    public Member findMemberById(int memberId) {
        for (Member member : memberList) {
            if (member.getMemberId()==memberId) {
                return member;
            }
        }
        System.out.println("Üye bulunamadı: " + memberId);
        return null;
    }

    // ISBN numarasına göre kitap bulma metodu
    public Book findBookByIsbn(String isbn) {
        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        System.out.println("Kitap bulunamadı: " + isbn);
        return null;
    }

    public void borrowBook(Book book,Member member){
        this.bookMap.put(member,book);
        this.bookList.remove(book);
    }
}
