package Codes;

import java.util.LinkedList;

public class Book {

    private int isbn;
    private String title;
    private String author;
    private String genre;
    private boolean availability;
    private boolean reserved;
    private static LinkedList<Book> books = new LinkedList<>();


    public Book() {

        this.title = "Unknown";
        this.author = "Unknown";
        this.genre = "Unknown";
        this.availability = false;
        this.reserved = false;

    }

    public Book(int isbn, String title, String author, String genre, boolean availability, boolean reserved) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = availability;
        this.reserved = reserved;
        books.add(this);
    }

    public Book(Book bookz){

        this.isbn = bookz.isbn;
        this.title = bookz.title;
        this.author= bookz.author;
        this.genre = bookz.genre;
        this.availability = bookz.availability;
        this.reserved= bookz.reserved;

    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", availability=" + availability +
                ", reserved=" + reserved +
                '}';
    }

    public static void addBookToList(Book book) {
        books.add(book);
    }
    public static LinkedList<Book> getBooks(){
        return books;
    }


}
