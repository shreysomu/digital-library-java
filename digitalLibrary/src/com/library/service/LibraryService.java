package com.library.service;

import com.library.exception.InvalidBookException;
import com.library.model.Book;

import java.util.ArrayList;

public class LibraryService {
    private ArrayList<Book> bookList = new ArrayList<>();

    //Add Book

    public void addBook(Book book) throws InvalidBookException {
        if (book.getBook_id() <= 0) {
            throw new InvalidBookException("Invalid Book ID!");
        }

        bookList.add(book);
        System.out.println("Book added successfully!");
    }

    //Show All books
    public void displayBooks(){
        if(bookList.isEmpty()){
            System.out.println("No books available");
            return;
        }
        for (Book book : bookList){
            book.displayBook();
        }
    }

    //findBooksByID

    public void findBookById(int id){
        for (Book book : bookList){
            if(book.getBook_id() == id){
                book.displayBook();
                return;
            }
        }
        System.out.println("Book not found! ");
    }

    public void deleteBook(int id){
        for (Book book : bookList){
            if(book.getBook_id() == id){
                bookList.remove(book);
                System.out.println("Book deleted successfully!");
                return;

            }
        }
        System.out.println("Book not found!");
    }


    public void updateBook(int book_id,String newTitle, String newAuthor,Double newPrice){
        for (Book book: bookList){
            if(book.getBook_id() == book_id){
                book.setBook_title(newTitle);
                book.setBook_author(newAuthor);
                book.setBook_price(newPrice);

                System.out.println("Book Updated Successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
