package com.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

     Scanner scan = new Scanner(System.in);

        Library library = new Library();

        while (true) {

            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. Add New Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Books");
            System.out.println("4. Register Member");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. View Statistics");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter ISBN: ");
                    String isbn = scan.nextLine();

                    System.out.print("Enter Title: ");
                    String title = scan.nextLine();

                    System.out.print("Enter Author: ");
                    String author = scan.nextLine();

                    System.out.print("Enter Year: ");
                    int year = scan.nextInt();
                    scan.nextLine();

                    library.addBook(
                            new Book(isbn, title, author, year)
                    );

                    break;

                case 2:

                    library.displayBooks();

                    break;

                case 3:

                    System.out.print("Enter keyword: ");
                    String keyword = scan.nextLine();

                    library.searchBook(keyword);

                    break;

                case 4:

                    System.out.print("Enter Member ID: ");
                    String memberId = scan.nextLine();

                    System.out.print("Enter Member Name: ");
                    String memberName = scan.nextLine();

                    library.registerMember(
                            new Members(memberId, memberName)
                    );

                    break;

                case 5:

                    System.out.print("Enter ISBN: ");
                    String borrowIsbn = scan.nextLine();

                    System.out.print("Enter Member ID: ");
                    String borrowMember = scan.nextLine();

                    library.borrowBook(
                            borrowIsbn,
                            borrowMember
                    );

                    break;

                case 6:

                    System.out.print("Enter ISBN: ");
                    String returnIsbn = scan.nextLine();

                    library.returnBook(returnIsbn);

                    break;

                case 7:

                    library.showStatistics();

                    break;

                case 8:

                    System.out.println("Thank You!");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }

    }
