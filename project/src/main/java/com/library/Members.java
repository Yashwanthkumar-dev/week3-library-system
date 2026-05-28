package com.library;

import java.util.ArrayList;
import java.util.List;

public class Members {
    private String id;
    private String name;
    private List<String> borrowedBooks;

    public Members(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(String isbn) {
        borrowedBooks.add(isbn);
    }

    public void returnBook(String isbn) {
        borrowedBooks.remove(isbn);
    }

    @Override
    public String toString() {
        return "Member ID: " + id +
                " | Name: " + name +
                " | Borrowed Books: " + borrowedBooks.size();
    }

    public String toFileString() {
        return id + "," + name;
    }
}
