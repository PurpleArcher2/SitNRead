package SelectPage;

import Codes.Book;
import Codes.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;

public class BorrowBook implements ActionListener {
    private JTextField textField1;
    private JButton borrowButton;
    public JPanel MainPanel;

    private static LinkedList<Book> books = new LinkedList<Book>();

    public BorrowBook(){
        MainPanel.setPreferredSize(new Dimension(400, 300));
        loadBooksFromFile("book.txt");

    }

    public static void main(String[] args) {

        JFrame mainframe = new JFrame("Borrow Book");
        mainframe.setContentPane(new BorrowBook().MainPanel);
        mainframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainframe.pack();
        mainframe.setVisible(true);

    }

    private void createUIComponents() {

        borrowButton = new JButton();
        borrowButton.addActionListener(this);



    }

    private void loadBooksFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    int isbn = Integer.parseInt(parts[0].trim());
                    String title = parts[1].trim();
                    String author = parts[2].trim();
                    String genre = parts[3].trim();
                    boolean availability = Boolean.parseBoolean(parts[4].trim());
                    boolean reserved = Boolean.parseBoolean(parts[5].trim());
                    Book newBook = new Book(isbn, title, author, genre, availability, reserved);
                    books.add(newBook);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void updateBookAvailability(String title, boolean availability) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("book.txt"))) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    book.setAvailability(availability);
                }
                bw.write(book.getIsbn() + "," + book.getTitle() + "," + book.getAuthor() + "," +
                        book.getGenre() + "," + book.isAvailability() + "," + book.isReserved() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == borrowButton){


            String desiredTitle = textField1.getText().trim();
            User user = new User();
            user.borrowBook(desiredTitle);
            updateBookAvailability(desiredTitle, false);

        }

    }
}
