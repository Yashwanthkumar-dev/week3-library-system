
# Console-Based Library Management System

A Java-based console application for managing library operations such as book tracking, member management, borrowing/returning books, and file-based data persistence.


## Project Overview

This project simulates a real-world library system where users can:

- Add, view, search, and manage books
- Register and manage library members
- Borrow and return books with due date tracking
- Calculate overdue fines
- Maintain persistent data using file storage

It is built using Java with Object-Oriented Programming principles.
## Features

###  Book Management
- Add new books
- View all books
- Search books by title or ID
- Remove books

###  Member Management
- Register new members
- View member list
- Manage member details

###  Borrowing System
- Borrow books
- Return books
- Track due dates

###  Fine Calculation
- Automatically calculates overdue fines
- Based on number of late days

###  Library Statistics
- Total books
- Available books
- Borrowed books
- Member count

###  Data Persistence
- File-based storage using `.txt` files
- Data retained after program exit



## Tech Stack

- Java (Core Java)
- Object-Oriented Programming (OOP)
- File Handling (I/O Streams)
- Collections Framework


## Project structure

src/main/java/com/library/
│
├── Main.java
├── Book.java
├── Library.java
├── Members.java
├── FileHandler.java
## How to run
```bash
###  Using Maven (Recommended)


mvn clean compile
mvn exec:java -Dexec.mainClass="com.library.Main"

### Using Java Compiler (Manual)

javac -d bin src/main/java/com/library/*.java
java -cp bin com.library.Main

```
## Sample menu
=== LIBRARY MANAGEMENT SYSTEM ===
1. Add New Book
2. View All Books
3. Search Books
4. Register Member
5. Borrow Book
6. Return Book
7. View Library Statistics
8. Exit
## Screenshots
## Key Concepts Used
- Encapsulation (Private fields in classes)
- Abstraction (Service layer design)
- File Handling (Data persistence)
- Exception Handling (Input validation)
- Modular OOP design
## Testing Scenarios
- Add duplicate book → handled
- Borrow unavailable book → error shown
- Invalid input → validation triggered
- Return after due date → fine calculated
## Authors
Yashwanth Kumar
