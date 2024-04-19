package library;

import java.util.*;

public class managementClasses {
    private static class Book {
        String title;
        String author;
        String ISBN;

        Book(String title, String author, String ISBN) {
            this.title = title;
            this.author = author;
            this.ISBN = ISBN;
        }

        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN;
        }
    }

    private List<Book> books = new ArrayList<>();
    private Map<String, String> members = new HashMap<>();
    private Map<String, List<String>> borrowedBooks = new HashMap<>();

    public void addBook(String title, String author, String ISBN) {
        books.add(new Book(title, author, ISBN));
    }

    public void displayBooks() {
        books.forEach(System.out::println);
    }

    public void addMember(String name, String ID) {
        members.put(ID, name);
    }

    public void borrowBook(String ISBN, String memberID) {
        for (Book book : books) {
            if (book.ISBN.equals(ISBN)) {
                System.out.println(members.get(memberID) + " has checked out the book titled '" + book.title + "' with the ISBN: " + ISBN);
                
                List<String> borrowedTitles = borrowedBooks.get(memberID);
                if (borrowedTitles == null) {
                    borrowedTitles = new ArrayList<>();
                    borrowedBooks.put(memberID, borrowedTitles);
                }
                borrowedTitles.add(book.title);
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found.");
    }

    public static void main(String[] args) {
        managementClasses managementClasses = new managementClasses();
        
        managementClasses.addBook("Atomic Habits", "James Clear", "00001");
        managementClasses.addBook("You Are A Badass", "Jen Sincero", "00002");
        managementClasses.addBook("Tokyo Ueno Station", "Yu Miri", "00003");
        managementClasses.addBook("The Stranger", "Albert Camus", "00004");

        managementClasses.addMember("Sadie Rosario", "12345");
        managementClasses.addMember("Carol Dang", "12346");
        managementClasses.addMember("Isa Andia", "12348");

        System.out.println("Available books:");
        managementClasses.displayBooks();

        managementClasses.borrowBook("00001", "12345");
        managementClasses.borrowBook("00002", "12346");
        managementClasses.borrowBook("00003", "12347");
        managementClasses.borrowBook("00004", "12348");
    }
}
