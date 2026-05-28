package com.library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Members> members;
    private FileHandler fileHandler;

    public Library() {

        fileHandler = new FileHandler();

        books = fileHandler.loadBooks();
        members = fileHandler.loadMembers();
    }

    public void addBook(Book book) {

        books.add(book);

        fileHandler.saveBooks(books);

        System.out.println("Book added successfully!");
    }

    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBook(String keyword) {

        boolean found = false;

        for (Book book : books) {

            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {

                System.out.println(book);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found.");
        }
    }

    public void registerMember(Members member) {

        members.add(member);

        fileHandler.saveMembers(members);

        System.out.println("Member registered successfully!");
    }

    public Book findBook(String isbn) {

        for (Book book : books) {

            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }

        return null;
    }

    public Members findMember(String memberId) {

        for (Members member : members) {

            if (member.getId().equals(memberId)) {
                return member;
            }
        }

        return null;
    }

    public void borrowBook(String isbn, String memberId) {

        Book book = findBook(isbn);
        Members member = findMember(memberId);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (member == null) {
            System.out.println("Member not found!");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book already borrowed!");
            return;
        }

        book.setAvailable(false);
        book.setBorrowedBy(memberId);
        book.setDueDate(LocalDate.now().plusDays(14));

        member.borrowBook(isbn);

        fileHandler.saveBooks(books);
        fileHandler.saveMembers(members);

        System.out.println("Book borrowed successfully!");
        System.out.println("Due Date: " + book.getDueDate());
    }

    public void returnBook(String isbn) {

        Book book = findBook(isbn);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (book.isAvailable()) {
            System.out.println("Book already in library.");
            return;
        }

        if (book.isOverdue()) {

            long days = ChronoUnit.DAYS.between(
                    book.getDueDate(),
                    LocalDate.now());

            double fine = days * 10;

            System.out.println("Overdue Fine: ₹" + fine);
        }

        Members member = findMember(book.getBorrowedBy());

        if (member != null) {
            member.returnBook(isbn);
        }

        book.setAvailable(true);
        book.setBorrowedBy(null);
        book.setDueDate(null);

        fileHandler.saveBooks(books);
        fileHandler.saveMembers(members);

        System.out.println("Book returned successfully!");
    }

    public void showStatistics() {

        int available = 0;
        int borrowed = 0;

        for (Book book : books) {

            if (book.isAvailable()) {
                available++;
            } else {
                borrowed++;
            }
        }

        System.out.println("\n=== LIBRARY STATISTICS ===");
        System.out.println("Total Books: " + books.size());
        System.out.println("Available Books: " + available);
        System.out.println("Borrowed Books: " + borrowed);
        System.out.println("Members: " + members.size());
    }
}
