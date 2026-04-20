package com.library.service;

import com.library.exception.InvalidBookException;
import com.library.model.Book;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryService {

    private ArrayList<Book> bookList = new ArrayList<>();

    // Add Book
    public void addBook(Book book) throws InvalidBookException {

        if (book.getBook_id() <= 0) {
            throw new InvalidBookException("Invalid Book ID!");
        }

        // Duplicate ID check
        for (Book b : bookList) {
            if (b.getBook_id() == book.getBook_id()) {
                throw new InvalidBookException("Book ID already exists!");
            }
        }

        bookList.add(book);
        System.out.println("Book added successfully!");
    }

    // Display Books
    public void displayBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books available");
            return;
        }

        System.out.println("\n----- Book List -----");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    // Search Book
    public void findBookById(int id) {
        for (Book book : bookList) {
            if (book.getBook_id() == id) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // Delete Book (FIXED)
    public void deleteBook(int id) {
        boolean removed = bookList.removeIf(book -> book.getBook_id() == id);

        if (removed) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    // Update Book
    public void updateBook(int book_id, String newTitle, String newAuthor, Double newPrice) {
        for (Book book : bookList) {
            if (book.getBook_id() == book_id) {
                book.setBook_title(newTitle);
                book.setBook_author(newAuthor);
                book.setBook_price(newPrice);

                System.out.println("Book updated successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Save to File (IMPROVED)
    public void saveToFile() {
        try (FileWriter writer = new FileWriter("books.txt")) {

            for (Book book : bookList) {
                writer.write(book.getBook_id() + "," +
                        book.getBook_title() + "," +
                        book.getBook_author() + "," +
                        book.getBook_price() + "\n");
            }

            System.out.println("Data saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    // Load from File (FIXED)
    public void loadFromFile() {
        try {
            File file = new File("books.txt");

            if (!file.exists()) return;

            bookList.clear(); // prevent duplicates

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length < 4) continue;

                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String author = parts[2];
                double price = Double.parseDouble(parts[3]);

                bookList.add(new Book(id, title, author, price));
            }

            fileScanner.close();

        } catch (Exception e) {
            System.out.println("Error loading data!");
        }
    }
}