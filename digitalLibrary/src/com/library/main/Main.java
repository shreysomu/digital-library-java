package com.library.main;

import com.library.exception.InvalidBookException;
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

        int choice = 0;
        do{
            System.out.println("\n============== Digital Library menu ===================");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Delete Book by ID");
            System.out.println("5. Update Book by ID");
            System.out.println("6. Exit");

            System.out.print("Enter you choice : ");

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid choice please enter again !");
                sc.nextLine();
                continue;

            }

            switch (choice){

                case 1:
                    try {
                        System.out.print("Enter BookID: ");
                        int book_id = sc.nextInt();
                        sc.nextLine();

                        if(book_id<=0){
                            System.out.println("BookID must be a Positive number ");
                            continue;
                        }

                        System.out.print("Enter BookTitle: ");
                        String book_title = sc.nextLine();

                        if(book_title.isEmpty()){
                            System.out.println("BookTitle can not be Empty !");
                            continue;
                        }

                        System.out.print("Enter BookAuthor: ");
                        String book_author = sc.nextLine();

                        if(book_author.isEmpty()){
                            System.out.println("BookAuthor can not be Empty !");
                            continue;
                        }

                        System.out.print("Enter BookPrice: ");
                        double book_price = sc.nextDouble();
                        if(book_price<0){
                            System.out.println("BookPrice can not negative !");
                            continue;
                        }

                        Book book = new Book(book_id, book_title, book_author, book_price);
                        try {
                            library.addBook(book);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid output ! try again....");
                        continue;
                    }
                    break;

                case 2:
                    System.out.println("Books List: ");
                    library.displayBooks();
                    break;

                case 3:
                    try {
                        System.out.println("Enter Book ID to search: ");
                        int searchID = sc.nextInt();
                        library.findBookById(searchID);
                    } catch (Exception e) {
                        System.out.println("Invalid SearchId format !");
                        continue;
                    }
                    break;


                case 4:
                    try {
                        System.out.print("Enter Book ID to delete: ");
                        int deletedID = sc.nextInt();
                        library.deleteBook(deletedID);
                    } catch (Exception e) {
                        System.out.println("Invalid id to delete !");
                        continue;
                    }

                    System.out.println("\nUpdated Book List:");
                    library.displayBooks();
                    break;



                case 5:
                    try {
                        System.out.print("Enter Book ID to update: ");
                        int updatedID = sc.nextInt();
                        sc.nextLine();

                        if(updatedID<=0){
                            System.out.println("BookID must be a Positive number ");
                            continue;
                        }

                        System.out.print("Enter new Title: ");
                        String newTitle = sc.nextLine();
                        if(newTitle.isEmpty()){
                            System.out.println("BookTitle can not be Empty !");
                            continue;
                        }

                        System.out.print("Enter new Author: ");
                        String newAuthor = sc.nextLine();

                        if(newAuthor.isEmpty()){
                            System.out.println("BookTitle can not be Empty !");
                            continue;
                        }

                        System.out.print("Enter new Price : ");
                        double newPrice = sc.nextDouble();
                        if(newPrice<0){
                            System.out.println("BookPrice can not negative !");
                            continue;
                        }

                        library.updateBook(updatedID, newTitle, newAuthor, newPrice);

                        System.out.println("\nUpdated Book List:");
                        library.displayBooks();
                    } catch (Exception e) {
                        System.out.println("Invalid input entered to update !");
                        continue;
                    }
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
