package Codes;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Random;

public class Librarian extends Person implements LibrarianProcedures {
    private int employeeID;
    private static LinkedList<Librarian> librarians = new LinkedList<>();

    public Librarian(String Name, int Age, String Gender, int employeeID) {
        super(Name, Age, Gender);
        this.employeeID = employeeID;
    }


    public Librarian(Librarian other) {
        super(other.getName(), other.getAge(), other.getGender());
        this.employeeID = other.getEmployeeID();
    }


    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }



    public void AddLibrarian() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter librarian's name:");
        String name = scanner.nextLine();
        System.out.println("Enter librarian's age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        if (age < 18) {
            throw new IllegalArgumentException("Librarian's age must be 18 or above.");
        }
        System.out.println("Enter librarian's gender:");
        String gender = scanner.nextLine();
        Random random = new Random();
        int randomID = 0;
        boolean isUniqueID = false;
        while (!isUniqueID) {
            randomID = random.nextInt(1000);
            isUniqueID = true;
            for (int i = 0; i < librarians.size(); i++) {
                Librarian lib = librarians.get(i);
                if (lib.getEmployeeID() == randomID) {
                    isUniqueID = false;
                    break;
                }
            }
        }
        Librarian librarian = new Librarian(name, age, gender, randomID);
        librarians.add(librarian);
        System.out.println("Librarian added successfully.");
    }

    @Override
    public String check_information() {
        return "Name: " + getName() + ", Age: " + getAge() + ", Gender: " + getGender() + ", Employee ID: " + employeeID;
    }

    @Override
    public void searchBookByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < Book.getBooks().size(); i++) {
            Book book = Book.getBooks().get(i);
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    @Override
    public void searchBookByAuthor(String author) {
        boolean found = false;
        for (int i = 0; i < Book.getBooks().size(); i++) {
            Book book = Book.getBooks().get(i);
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Books by " + author + " not found.");
        }
    }

    @Override
    public void searchBookByGenre(String genre) {
        boolean found = false;
        for (int i = 0; i < Book.getBooks().size(); i++) {
            Book book = Book.getBooks().get(i);
            if (book.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(book.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Books in genre " + genre + " not found.");
        }
    }

    @Override
    public void add_user() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user's name:");
        String name = scanner.nextLine();
        System.out.println("Enter user's age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        if (age < 18) {
            throw new IllegalArgumentException("User's age must be 18 or above.");
        }
        System.out.println("Enter user's gender:");
        String gender = scanner.nextLine();
        Random random = new Random();
        int libraryCard = 0;
        boolean isUniqueLibraryCard = false;
        while (!isUniqueLibraryCard) {
            libraryCard = random.nextInt(1000);
            isUniqueLibraryCard = true;
            for (int i = 0; i < User.getUsers().size(); i++) {
                User user = User.getUsers().get(i);
                if (user.getLibraryCardNum() == libraryCard) {
                    isUniqueLibraryCard = false;
                    break;
                }
            }
        }
        User user = new User(name, age, gender, libraryCard);
        User.getUsers().add(user);
        System.out.println("User added successfully with library card number: " + libraryCard);
    }


    @Override
    public void addBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book's title:");
        String title = scanner.nextLine();
        System.out.println("Enter book's author:");
        String author = scanner.nextLine();
        System.out.println("Enter book's genre:");
        String genre = scanner.nextLine();
        System.out.println("Enter book's ISBN:");
        int isbn = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter book's availability (true/false):");
        boolean availability = scanner.nextBoolean();
        System.out.println("Enter book's reservation status (true/false):");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine();
        Book book = new Book(isbn, title, author, genre, availability, reserved);
        Book.getBooks().add(book);
        System.out.println("Book added successfully.");
    }
}

