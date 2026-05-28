package com.library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private final String BOOK_FILE = "data/books.txt";
    private final String MEMBER_FILE = "data/members.txt";

    public void saveBooks(List<Book> books) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOK_FILE))) {

            for (Book book : books) {
                writer.write(book.toFileString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving books!");
        }
    }

    public List<Book> loadBooks() {

        List<Book> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(BOOK_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Book book = new Book(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]));

                book.setAvailable(Boolean.parseBoolean(data[4]));

                if (!data[5].equals("null")) {
                    book.setBorrowedBy(data[5]);
                }

                if (!data[6].equals("null")) {
                    book.setDueDate(LocalDate.parse(data[6]));
                }

                books.add(book);
            }

        } catch (Exception e) {
            System.out.println("Books file not found. Starting fresh.");
        }

        return books;
    }

    public void saveMembers(List<Members> members) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBER_FILE))) {

            for (Members member : members) {
                writer.write(member.toFileString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving members!");
        }
    }

    public List<Members> loadMembers() {

        List<Members> members = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(MEMBER_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Members member = new Members(data[0], data[1]);

                members.add(member);
            }

        } catch (Exception e) {
            System.out.println("Members file not found. Starting fresh.");
        }

        return members;
    }
}
