import java.util.*;

class Book {
    private int id;
    private String title, author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public void display() {
        System.out.println(id + " | " + title + " | " + author);
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        if (books.isEmpty()) System.out.println("No books available.");
        else for (Book b : books) b.display();
    }

    public void searchBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                b.display();
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        while (true) {
            System.out.println("1. Add Book  2. Show Books  3. Search  4. Exit");
            int ch = sc.nextInt();
            if (ch == 4) break;
            switch (ch) {
                case 1:
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Title: "); String title = sc.nextLine();
                    System.out.print("Author: "); String author = sc.nextLine();
                    lib.addBook(new Book(id, title, author));
                    break;
                case 2:
                    lib.showBooks();
                    break;
                case 3:
                    System.out.print("Enter ID: "); int searchId = sc.nextInt();
                    lib.searchBook(searchId);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
