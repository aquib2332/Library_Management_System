package LMS;

import java.util.ArrayList;
import java.util.List;

class Member {
    private String name;
    private int memberId;
    private List<Book> borrowedBooks;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println("Book '" + book.getTitle() + "' is successfully borrowed.");
        } else {
            System.out.println("The book is not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            System.out.println("Book '" + book.getTitle() + "' is successfully returned.");
        } else {
            System.out.println("The book was not borrowed by this member.");
        }
    }

    // Additional methods for displaying borrowed books, etc.
}