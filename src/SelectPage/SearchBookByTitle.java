package SelectPage;

import Codes.Book;
import Codes.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;

public class SearchBookByTitle implements ActionListener {


    private JTextField textField1;
    private JButton searchButton;
    public JPanel MainPanel;


    private static LinkedList<Book> books = new LinkedList<Book>();

    public SearchBookByTitle() {
        MainPanel.setPreferredSize(new Dimension(400, 300));
        loadBooksFromFile("book.txt");

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

    public static void main(String[] args) {
        JFrame mainframe = new JFrame("SearchBookByTitle");
        mainframe.setContentPane(new SearchBookByTitle().MainPanel);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.pack();
        mainframe.setLocationRelativeTo(null);
        mainframe.setVisible(true);
    }

    private void createUIComponents() {
        searchButton = new JButton();
        searchButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == searchButton) {

            String desiredSearch = textField1.getText().trim();
            User user = new User();
            user.searchBookByTitle(desiredSearch);
        }
    }


        private void closeOriginalFrame() {
            Window originalFrame = SwingUtilities.getWindowAncestor(MainPanel);
            if (originalFrame != null) {
                originalFrame.dispose();
            }
        }
    }

