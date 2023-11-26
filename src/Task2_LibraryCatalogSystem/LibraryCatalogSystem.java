package Task2_LibraryCatalogSystem;

import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private boolean status;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.status = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return status;
    }

    public void checkOut() {
        status = true;
    }

    public void returnBook() {
        status = false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", checkedOut=" + status +
                '}';
    }
}

class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Search by title Book found: " + book);
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found.");
    }

    public void searchByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Search by author Book found: " + book);
                return;
            }
        }
        System.out.println("Book by author '" + author + "' not found.");
    }

    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isCheckedOut()) {
                    book.checkOut();
                    System.out.println("Book '" + title + "' checked out successfully.");
                } else {
                    System.out.println("Book '" + title + "' is already checked out.");
                }
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isCheckedOut()) {
                    book.returnBook();
                    System.out.println("Book '" + title + "' returned successfully.");
                } else {
                    System.out.println("Book '" + title + "' is not checked out.");
                }
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found.");
    }

    public void displayCatalog() {
        System.out.println("Library Catalog:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class LibraryCatalogSystem {
    public static void main(String[] args) {
        LibraryCatalog libraryCatalog = new LibraryCatalog();
        libraryCatalog.addBook(new Book("Bhagavad Gita", "S. Radhakrishnan"));
        libraryCatalog.addBook(new Book("Indian Philosophy ", "Dr. S. Radhakrishnan"));
        libraryCatalog.addBook(new Book("Ramayana", "Maharishi Valmiki"));

        libraryCatalog.searchByTitle("Bhagavad Gita");
        System.out.println();
        
        libraryCatalog.searchByAuthor("Dr. S. Radhakrishnan");
        System.out.println();
        
        libraryCatalog.checkOutBook("Bhagavad Gita");
        System.out.println();
        
        libraryCatalog.searchByTitle("Bhagavad Gita");
        System.out.println();
        libraryCatalog.returnBook("Bhagavad Gita");
        System.out.println();
        libraryCatalog.displayCatalog();
    }
}
