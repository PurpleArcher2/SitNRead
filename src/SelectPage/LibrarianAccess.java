package SelectPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LibrarianAccess implements ActionListener {
    public JPanel panel5;
    private JButton addLibrarianButton;
    private JButton addUserButton;
    private JButton checkInfoButton;
    private JButton searchBookByTitleButton;
    private JButton searchBookByAuthorButton;
    private JButton searchBookByGenreButton;
    private JButton borrowBookButton;
    private JButton returnBookButton;
    private JButton reserveBookButton;
    private JButton LOGOUTButton;
    private JLabel LibrarianImage;


    public LibrarianAccess(){

        panel5.setPreferredSize(new Dimension(400, 300));

    }

    public static void main(String[] args) {

        JFrame mainframe = new JFrame("Startup");
        mainframe.setContentPane(new LibrarianAccess().panel5);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainframe.pack();
        mainframe.setVisible(true);
    }

    private void createUIComponents() {
        ImageIcon icon1 = new ImageIcon("src/SelectPage/images/librarian.jpg");
        Image image2 = icon1.getImage();
        int width = 100;
        int height = 100;
        Image scaledImage = image2.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        LibrarianImage = new JLabel(scaledIcon);

        addLibrarianButton = new JButton("Add Librarian");
        addLibrarianButton.addActionListener(this);

        addUserButton = new JButton("Add User");
        addUserButton.addActionListener(this);

        checkInfoButton = new JButton("Check info");
        checkInfoButton.addActionListener(this);

        searchBookByTitleButton = new JButton("Search by Title");
        searchBookByTitleButton.addActionListener(this);

        searchBookByAuthorButton = new JButton("Search By Autho");
        searchBookByAuthorButton.addActionListener(this);

        searchBookByGenreButton = new JButton("Search by Genre");
        searchBookByGenreButton.addActionListener(this);

        borrowBookButton = new JButton("borrow book");
        borrowBookButton.addActionListener(this);

        returnBookButton = new JButton("Return book");
        returnBookButton.addActionListener(this);

        reserveBookButton = new JButton("Reserve book");
        reserveBookButton.addActionListener(this);

        LOGOUTButton = new JButton("LOG OUT");
        LOGOUTButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == LOGOUTButton){

            LibrarianLogin LibrarianLogin1= new LibrarianLogin();
            JFrame userFrame = new JFrame("User Login");
            userFrame.setContentPane(LibrarianLogin1.panel3);
            userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            userFrame.pack();
            userFrame.setVisible(true);
            File name = new File("LoggedInLibrarian.txt");
            if(name.exists()){
                name.delete();
            }
            closeOriginalFrame();

        } else if (e.getSource() == addLibrarianButton){

            AddLibrarian adl = new AddLibrarian();
            JFrame userFrame = new JFrame("User Login");
            userFrame.setContentPane(adl.MainPanel1);
            userFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            userFrame.pack();
            userFrame.setVisible(true);

        } else if(e.getSource() == addUserButton){

            AddUser adu = new AddUser();
            JFrame userFrame = new JFrame("User Login");
            userFrame.setContentPane(adu.MainPanel2);
            userFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            userFrame.pack();
            userFrame.setVisible(true);

        } else if (e.getSource() == checkInfoButton){

            if (e.getSource() == checkInfoButton) {

                try (BufferedReader br = new BufferedReader(new FileReader("LoggedInLibrarian.txt"))) {
                    String userData = br.readLine();
                    if (userData != null) {
                        JOptionPane.showMessageDialog(panel5, userData, "User Information", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(panel5, "No user data found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(panel5, "User data file not found.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(panel5, "Error reading user data.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }


        } else if (e.getSource() == searchBookByTitleButton){

            SearchBookByTitle sbt = new SearchBookByTitle();
            JFrame userFrame = new JFrame();
            userFrame.setContentPane(sbt.MainPanel);
            userFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            userFrame.pack();
            userFrame.setVisible(true);

        }else if (e.getSource() == searchBookByAuthorButton) {

            SearchBookByAuthor sbaa = new SearchBookByAuthor();
            JFrame userFrame2 = new JFrame();
            userFrame2.setContentPane(sbaa.MainPanel2);
            userFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            userFrame2.pack();
            userFrame2.setVisible(true);


        } else if (e.getSource() == searchBookByGenreButton) {

            SearchUserByGenre sbg = new SearchUserByGenre();
            JFrame userFram3 = new JFrame();
            userFram3.setContentPane(sbg.MainPanel3);
            userFram3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            userFram3.pack();
            userFram3.setVisible(true);

        } else if(e.getSource() == borrowBookButton){

            BorrowBook bb = new BorrowBook();
            JFrame frame = new JFrame();
            frame.setContentPane(bb.MainPanel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);


        }


    }


    private void closeOriginalFrame() {
        Window originalFrame = SwingUtilities.getWindowAncestor(panel5);
        if (originalFrame != null) {
            originalFrame.dispose();
        }
    }
}
