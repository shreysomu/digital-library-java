package com.library.model;

public class Book {
    public Object getbook_title;
    private int book_id;
    private String book_title;
    private String book_author;
    private double book_price;

    public Book(int book_id, String book_title, String book_author, double book_price) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_price = book_price;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getBook_author() {
        return book_author;
    }

    public double getBook_price() {
        return book_price;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }

    public void displayBook(){
        System.out.println("BookID: " + book_id + ", BookTitle: " + book_title + ", BookAuthor: " + book_author + ", BookPrice : " + book_price);
    }
}
