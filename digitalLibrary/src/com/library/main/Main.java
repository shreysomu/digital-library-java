package com.library.main;

import com.library.model.Book;
import com.library.service.LibraryService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        LibraryService library = new LibraryService();
//        Book book1 = new Book(1,"Java ","James Goslin",500);
//        Book book2 = new Book(2,"SpringBoot","John Doe",600);

//      library.addBook(book1);
//      library.addBook(book2);
//
//        System.out.println("\n All Books : ");
//        library.displayBooks();
//
//        System.out.println("Enter Book ID to search : ");
//        int searchID = sc.nextInt();
//        library.findBookById(searchID);

        LibraryService library = new LibraryService();

        int choice;
        do{
            System.out.println("\n============== Digital Library menu ===================");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Delete Book by ID");
            System.out.println("5. Update Book by ID");
            System.out.println("6. Exit");

            System.out.print("Enter you choice : ");
            choice = sc.nextInt();

            switch (choice){

                case 1:
                    System.out.print("Enter BookID: ");
                    int book_id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter BookTitle: ");
                    String book_title = sc.nextLine();

                    System.out.print("Enter BookAuthor: ");
                    String book_author = sc.nextLine();

                    System.out.print("Enter BookPrice: ");
                    double book_price = sc.nextDouble();

                    Book book = new Book(book_id,book_title,book_author,book_price);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.println("Books List: ");
                    library.displayBooks();
                    break;

                case 3:
                    System.out.println("Enter Book ID to search: ");
                    int searchID = sc.nextInt();
                    library.findBookById(searchID);
                    break;

                case 4:
                    System.out.print("Enter Book ID to delete: ");
                    int deletedID = sc.nextInt();
                    library.deleteBook(deletedID);

                    System.out.println("\nUpdated Book List:");
                    library.displayBooks();
                    break;



                case 5:
                    System.out.print("Enter Book ID to update: ");
                    int updatedID = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter new Author: ");
                    String newAuthor = sc.nextLine();

                    System.out.print("Enter new Price : ");
                    double newPrice = sc.nextDouble();

                    library.updateBook(updatedID,newTitle,newAuthor,newPrice);

                    System.out.println("\nUpdated Book List:");
                    library.displayBooks();
                    break;


                case 6:
                    System.out.println("Exiting......Thank You!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again...");
            }
        }while (choice != 6);
         sc.close();
    }
}
