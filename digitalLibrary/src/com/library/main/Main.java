package com.library.main;

import com.library.exception.InvalidBookException;
import com.library.model.Book;
import com.library.service.LibraryService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryService library = new LibraryService();
        library.loadFromFile();

        int choice = 0;

        do {
            System.out.println("\n===== 📚 Digital Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Update Book");
            System.out.println("6. Sort Books by Title");
            System.out.println("7. Sort Books by Price");
            System.out.println("8. Total Books ");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    try {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        if (id <= 0) {
                            System.out.println("ID must be positive!");
                            continue;
                        }

                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        if (title.isEmpty()) {
                            System.out.println("Title cannot be empty!");
                            continue;
                        }

                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();

                        if (author.isEmpty()) {
                            System.out.println("Author cannot be empty!");
                            continue;
                        }

                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();

                        if (price < 0) {
                            System.out.println("Price cannot be negative!");
                            continue;
                        }

                        Book book = new Book(id, title, author, price);

                        try {
                            library.addBook(book);
                            library.saveToFile(); // auto-save
                        } catch (InvalidBookException e) {
                            System.out.println(e.getMessage());
                        }

                    } catch (Exception e) {
                        System.out.println("Invalid input! Please try again.");
                        sc.nextLine();
                    }
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    try {
                        System.out.print("Enter Book ID: ");
                        int searchId = sc.nextInt();
                        library.findBookById(searchId);
                    } catch (Exception e) {
                        System.out.println("Invalid ID!");
                        sc.nextLine();
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Enter Book ID to delete: ");
                        int deleteId = sc.nextInt();

                        library.deleteBook(deleteId);
                        library.saveToFile();

                        System.out.println("\nUpdated List:");
                        library.displayBooks();

                    } catch (Exception e) {
                        System.out.println("Invalid ID!");
                        sc.nextLine();
                    }
                    break;

                case 5:
                    try {
                        System.out.print("Enter Book ID: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new Title: ");
                        String newTitle = sc.nextLine();

                        System.out.print("Enter new Author: ");
                        String newAuthor = sc.nextLine();

                        System.out.print("Enter new Price: ");
                        double newPrice = sc.nextDouble();

                        library.updateBook(updateId, newTitle, newAuthor, newPrice);
                        library.saveToFile();

                        System.out.println("\nUpdated List:");
                        library.displayBooks();

                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                        sc.nextLine();
                    }
                    break;



                case 6:
                    library.sortBooksByTitle();
                    library.displayBooks();
                    break;


                case 7:
                    library.sortBooksByPrice();
                    library.displayBooks();
                    break;

                case 8:
                    library.showTotalBooks();

                case 9:
                    library.saveToFile();
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}