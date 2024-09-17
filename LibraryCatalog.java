import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Book class to store book details
class Book {
    private String title;
    private String author;
    private int publicationYear;  // Added publication year attribute

    // Constructor
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    // Override toString to display book details
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Year: " + publicationYear;
    }
}

// LibraryCatalog class to manage the list of books
public class LibraryCatalog {
    private List<Book> books;

    // Constructor initializes the book list
    public LibraryCatalog() {
        books = new ArrayList<>();
    }

    // Method to add a new book to the catalog
    public void addBook(Scanner scanner) {
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter the book author: ");
        String author = scanner.nextLine();

        System.out.print("Enter the publication year: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine();  // Consume newline after nextInt()

        Book newBook = new Book(title, author, publicationYear);
        books.add(newBook);
        System.out.println("Book added successfully!\n");
    }

    // Method to display all books in the catalog
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the catalog.\n");
        } else {
            System.out.println("Listing all books:");
            for (Book book : books) {
                System.out.println(book);
            }
            System.out.println();
        }
    }

    // Method to search for a book by title
    public void searchBookByTitle(Scanner scanner) {
        System.out.print("Enter the title to search: ");
        String title = scanner.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No book found with the title '" + title + "'.\n");
        }
    }

    // Method to search for a book by author
    public void searchBookByAuthor(Scanner scanner) {
        System.out.print("Enter the author to search: ");
        String author = scanner.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Book found: " + book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found by the author '" + author + "'.\n");
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();

        // Use try-with-resources to automatically close the Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do {
                System.out.println("Library Catalog System");
                System.out.println("1. Add a Book");
                System.out.println("2. List All Books");
                System.out.println("3. Search Book by Title");
                System.out.println("4. Search Book by Author");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline after nextInt()

                switch (choice) {
                    case 1:
                        catalog.addBook(scanner);
                        break;
                    case 2:
                        catalog.listBooks();
                        break;
                    case 3:
                        catalog.searchBookByTitle(scanner);
                        break;
                    case 4:
                        catalog.searchBookByAuthor(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting the system.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.\n");
                }
            } while (choice != 5);
        }  // Scanner will be automatically closed here
    }
}
