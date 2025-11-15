import java.util.ArrayList;
import java.util.Scanner;

/**
 * SIMPLE LIBRARY MANAGEMENT SYSTEM (CONSOLE-BASED)
 * Demonstrates: OOP, Lists, Search, Loops, Input Handling
 */

class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void issue() { isIssued = true; }
    public void returnBook() { isIssued = false; }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Status: " + (isIssued ? "Issued" : "Available");
    }
}

public class LibraryManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        books.add(new Book(title, author));
        System.out.println("Book added successfully!\n");
    }

    public static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.\n");
            return;
        }

        System.out.println("===== BOOK LIST =====");
        for (Book b : books) {
            System.out.println(b);
        }
        System.out.println();
    }

    public static void issueBook() {
        System.out.print("Enter the title of the book to issue: ");
        String title = scanner.nextLine();

        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (!b.isIssued()) {
                    b.issue();
                    System.out.println("Book issued successfully!\n");
                } else {
                    System.out.println("Book is already issued.\n");
                }
                return;
            }
        }
        System.out.println("Book not found!\n");
    }

    public static void returnBook() {
        System.out.print("Enter the title of the book to return: ");
        String title = scanner.nextLine();

        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (b.isIssued()) {
                    b.returnBook();
                    System.out.println("Book returned!\n");
                } else {
                    System.out.println("This book was not issued.\n");
                }
                return;
            }
        }
        System.out.println("Book not found!\n");
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (choice) {
                case 1: addBook(); break;
                case 2: viewBooks(); break;
                case 3: issueBook(); break;
                case 4: returnBook(); break;
                case 5: System.out.println("Exiting system..."); break;
                default: System.out.println("Invalid choice!\n");
            }
        } while (choice != 5);
    }
}
