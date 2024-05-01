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
        StringBuilder resultMessage = new StringBuilder("Search Results for Title: " + title + "\n\n");

        for (Book book : Book.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                resultMessage.append("Title: ").append(book.getTitle()).append("\n");
                resultMessage.append("Author: ").append(book.getAuthor()).append("\n");
                resultMessage.append("Genre: ").append(book.getGenre()).append("\n");
                resultMessage.append("ISBN: ").append(book.getIsbn()).append("\n");
                resultMessage.append("Availability: ").append(book.isAvailability() ? "Available" : "Not Available").append("\n");
                resultMessage.append("Reserved: ").append(book.isReserved() ? "Yes" : "No").append("\n");
                resultMessage.append("\n");
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
        StringBuilder resultMessage = new StringBuilder("Search Results for Author: " + author + "\n\n");

        for (Book book : Book.getBooks()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                resultMessage.append("Title: ").append(book.getTitle()).append("\n");
                resultMessage.append("Author: ").append(book.getAuthor()).append("\n");
                resultMessage.append("Genre: ").append(book.getGenre()).append("\n");
                resultMessage.append("ISBN: ").append(book.getIsbn()).append("\n");
                resultMessage.append("Availability: ").append(book.isAvailability() ? "Available" : "Not Available").append("\n");
                resultMessage.append("Reserved: ").append(book.isReserved() ? "Yes" : "No").append("\n");
                resultMessage.append("\n");
                found = true;
            }
        }
        if (!found) {
            resultMessage.append("Book with author '").append(author).append("' not found.");
        }
        JOptionPane.showMessageDialog(null, resultMessage.toString());
    }



    @Override
    public void searchBookByGenre(String genre) {
        boolean found = false;
        StringBuilder resultMessage = new StringBuilder("Search Results for Author: " + genre + "\n\n");

        for (Book book : Book.getBooks()) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                resultMessage.append("Title: ").append(book.getTitle()).append("\n");
                resultMessage.append("Author: ").append(book.getAuthor()).append("\n");
                resultMessage.append("Genre: ").append(book.getGenre()).append("\n");
                resultMessage.append("ISBN: ").append(book.getIsbn()).append("\n");
                resultMessage.append("Availability: ").append(book.isAvailability() ? "Available" : "Not Available").append("\n");
                resultMessage.append("Reserved: ").append(book.isReserved() ? "Yes" : "No").append("\n");
                resultMessage.append("\n");
                found = true;
            }
        }
        if (!found) {
            resultMessage.append("Book with author '").append(genre).append("' not found.");
        }
        JOptionPane.showMessageDialog(null, resultMessage.toString());
    }

    @Override
    public void borrowBook(String title) {
        boolean found = false;
        for (Book book : Book.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailability() && !book.isReserved()) {
                    book.setAvailability(false);
                    JOptionPane.showMessageDialog(null, "Book '" + book.getTitle() + "' borrowed successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Book '" + "Cannot be borrowed!" );
                }
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Book " + "Not Found");
        }
    }

    @Override
    public void returnBook(String title) {
        boolean found = false;
        for (Book book : Book.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailability() && !book.isReserved()) {
                    book.setAvailability(true);
                    JOptionPane.showMessageDialog(null, "Book '" + book.getTitle() + "' returned successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Book '" + "Cannot be returned!" );
                }
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Book " + "Not Found");
        }
    }

    @Override
    public void reserveBook(String title) {
        boolean found = false;
        for (Book book : Book.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailability() && !book.isReserved()) {
                    book.setReserved(true);
                    JOptionPane.showMessageDialog(null, "Book '" + book.getTitle() + "' reserved successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Book '" + "Cannot be reserved!" );
                }
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Book " + "Not Found");
        }
    }
}
