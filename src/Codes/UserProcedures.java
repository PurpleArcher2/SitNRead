package Codes;

public interface UserProcedures {

    void searchBookByTitle(String title);
    void searchBookByAuthor(String name);
    void searchBookByGenre(String genre);
    void borrowBook(String title);
    void returnBook(String title);
    void reserveBook(String title);

}
