package lab;

import java.util.*;

class Book {
    String title;
    String author;
    boolean isAvailable;
    Queue<String> waitingList;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.waitingList = new LinkedList<>();
    }
}

public class LibraryManagement {
    static Map<String, Book> books = new HashMap<>();
    static Set<String> authors = new HashSet<>();
    static Map<String, String> recentCheckout = new HashMap<>();

    public static void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.put(title, book);
        authors.add(author);
    }

    public static void checkoutBook(String title, String userName) {
        if (books.containsKey(title)) {
            Book book = books.get(title);
            if (book.isAvailable) {
                book.isAvailable = false;
                recentCheckout.put(book.author, book.title);
                System.out.println(userName + " successfully checked out: " + title);
            } else {
                book.waitingList.add(userName);
                System.out.println(title + " is currently checked out. " + userName + " added to waiting list.");
            }
        } else {
            System.out.println("Book not found!");
        }
    }

    public static void returnBook(String title) {
        if (books.containsKey(title)) {
            Book book = books.get(title);
            if (!book.waitingList.isEmpty()) {
                String nextUser = book.waitingList.poll();
                System.out.println("Book assigned to next user in waiting list: " + nextUser);
            } else {
                book.isAvailable = true;
                System.out.println(title + " is now available.");
            }
        }
    }

    public static void displayStatus() {
        System.out.println("\n--- Books by Authors ---");
        for (String author : authors) {
            System.out.print(author + ": ");
            for (Book book : books.values()) {
                if (book.author.equals(author)) {
                    System.out.print(book.title + " ");
                }
            }
            System.out.println();
        }

        System.out.println("\n--- Most Recent Checkouts ---");
        for (String author : recentCheckout.keySet()) {
            System.out.println("Most recent checked-out book for " + author + ": " + recentCheckout.get(author));
        }

        System.out.println("\n--- Book Status ---");
        for (Book book : books.values()) {
            System.out.println(book.title + ": " + (book.isAvailable ? "Available" : "Checked out"));
            if (!book.waitingList.isEmpty()) {
                System.out.println("Waiting list for " + book.title + ": " + book.waitingList);
            }
        }

        int availableCount = 0;
        for (Book book : books.values()) {
            if (book.isAvailable) {
                availableCount++;
            }
        }
        System.out.println("\nTotal number of available books: " + availableCount);
    }

    public static void main(String[] args) {
        addBook("Java Programming", "John Doe");
        addBook("Data Structures", "Jane Smith");

        checkoutBook("Java Programming", "User1");
        checkoutBook("Java Programming", "User2"); // Added to waiting list
        checkoutBook("Data Structures", "User3");

        displayStatus();

        // Returning book
        System.out.println("\nReturning 'Java Programming'...");
        returnBook("Java Programming");

        System.out.println("\nAfter returning:");
        displayStatus();
    }
}
