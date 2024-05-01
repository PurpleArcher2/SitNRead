package Codes;


import javax.swing.*;
import java.io.Serializable;
import java.util.LinkedList;

public class User extends Person implements UserProcedures, Serializable {

    private int libraryCardNum;
    private static LinkedList<User> users = new LinkedList<>();

    public User(String name, int age, String gender, int libraryCardNum) {
        super(name, age, gender);
        this.libraryCardNum = libraryCardNum;
    }

    public User(User user) {
        super(user.getName(), user.getAge(), user.getGender());
        this.libraryCardNum = user.libraryCardNum;
    }

    public User() {
        super();
    }

    public int getLibraryCardNum() {
        return libraryCardNum;
    }

    public void setLibraryCardNum(int libraryCardNum) {
        this.libraryCardNum = libraryCardNum;
    }

    public static LinkedList<User> getUsers() {
        return users;
    }
    @Override
    public String check_information() {
        System.out.println(toString());
        return null;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", libraryCardNum=" + libraryCardNum +
                '}';
    }

    @Override
    public void searchBookByTitle(String title) {
        boolean found = false;
        StringBuilder resultMessage = new StringBuilder("Search Results for Title: " + title + "\n");

        for (Book book : Book.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                resultMessage.append("Found!");
                found = true;
            }
        }
        if (!found) {
            resultMessage.append("Book with title '").append(title).append("' not found.");
        }
        JOptionPane.showMessageDialog(null, resultMessage.toString());
    }

    @Override
    public void searchBookByAuthor(String author) {
        boolean found = false;
        for (Book book : Book.getBooks()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Books by author '" + author + "' not found.");
        }
    }

    @Override
    public void searchBookByGenre(String genre) {
        boolean found = false;
        for (Book book : Book.getBooks()) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(book.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Books in genre '" + genre + "' not found.");
        }
    }

    @Override
    public void borrowBook(String title) {
        boolean found = false;
        for (Book book : Book.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailability() && !book.isReserved()) {
                    book.setAvailability(false);
                    System.out.println("Book '" + title + "' borrowed successfully.");
                } else {
                    System.out.println("Book '" + title + "' cannot be borrowed.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book with title '" + title + "' not found.");
        }
    }

    @Override
    public void returnBook(String title) {
        boolean found = false;
        for (Book book : Book.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailability() && !book.isReserved()) {
                    book.setAvailability(true);
                    System.out.println("Book '" + title + "' returned successfully.");
                } else {
                    System.out.println("Book '" + title + "' cannot be returned.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book with title '" + title + "' not found.");
        }
    }

    @Override
    public void reserveBook(String title) {
        boolean found = false;
        for (Book book : Book.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailability() && !book.isReserved()) {
                    book.setReserved(true);
                    System.out.println("Book '" + title + "' reserved successfully.");
                } else {
                    System.out.println("Book '" + title + "' cannot be reserved.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book with title '" + title + "' not found.");
        }
    }
}
