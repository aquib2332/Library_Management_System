package LMS;

import java.util.Scanner;

public class LibrarySystem {
    private Library library;
    private Scanner scanner;

    public LibrarySystem() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n------ Library Management System ------");
            System.out.println("1. Add a book");
            System.out.println("2. Display all books");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 0:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void addBook() {
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the ISBN: ");
        String isbn = scanner.nextLine();
        Book book = new Book(title, author, isbn);
        library.addBook(book);
        System.out.println("Book added successfully!");
    }

    private void displayAllBooks() {
        System.out.println("\n------ All Books in the Library ------");
        library.displayAllBooks();
    }

    private void borrowBook() {
        System.out.print("Enter the title of the book you want to borrow: ");
        String title = scanner.nextLine();
        Book book = library.findBookByTitle(title);
        if (book != null) {
            // Assume a member with memberId 1 for simplicity
            Member member = new Member("John Doe", 1);
            member.borrowBook(book);
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    private void returnBook() {
        System.out.print("Enter the title of the book you want to return: ");
        String title = scanner.nextLine();
        Book book = library.findBookByTitle(title);
        if (book != null) {
            // Assume a member with memberId 1 for simplicity
            Member member = new Member("John Doe", 1);
            member.returnBook(book);
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.run();
    }
}