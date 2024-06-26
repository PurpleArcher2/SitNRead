package SelectPage;

import Codes.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class UserAccess implements ActionListener {


    public JPanel panel4;
    private JButton checkInfoButton;
    private JButton searchBookByTitleButton;
    private JButton searchBookByAuthorButton;
    private JButton searchBookByGenreButton;
    private JButton reserveBookButton;
    private JButton borrowBookButton;
    private JButton returnBookButton;
    private JLabel userLogo;
    private JButton LOGOUTButton;


    public UserAccess() {
        panel4.setPreferredSize(new Dimension(400, 300));
    }

    public static void main(String[] args) {
        JFrame mainframe = new JFrame("Startup");
        mainframe.setContentPane(new UserAccess().panel4);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainframe.pack();
        mainframe.setVisible(true);
    }


    private void createUIComponents() {

        ImageIcon icon = new ImageIcon("src/SelectPage/images/userIcon.jpg");
        Image image = icon.getImage();
        int width = 100;
        int height = 100;
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        userLogo = new JLabel(scaledIcon);



        checkInfoButton = new JButton("Check Information");
        checkInfoButton.addActionListener(this);

        searchBookByTitleButton = new JButton("Search Book Title");
        searchBookByTitleButton.addActionListener(this);

        searchBookByAuthorButton = new JButton("Search Book by Author");
        searchBookByAuthorButton.addActionListener(this);

        searchBookByGenreButton = new JButton("Serach book by Genre");
        searchBookByGenreButton.addActionListener(this);

        reserveBookButton = new JButton("Reserve Book");
        reserveBookButton.addActionListener(this);

        borrowBookButton = new JButton("Borrow Book");
        borrowBookButton.addActionListener(this);

        returnBookButton = new JButton("Return Book");
        returnBookButton.addActionListener(this);


        LOGOUTButton = new JButton("LOG OUT");
        LOGOUTButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == checkInfoButton) {

            try (BufferedReader br = new BufferedReader(new FileReader("LoggedInUser.txt"))) {
                String userData = br.readLine();
                if (userData != null) {
                    JOptionPane.showMessageDialog(panel4, userData, "User Information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panel4, "No user data found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(panel4, "User data file not found.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(panel4, "Error reading user data.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == searchBookByTitleButton) {

            SearchBookByTitle sbt = new SearchBookByTitle();
            JFrame userFrame = new JFrame();
            userFrame.setContentPane(sbt.MainPanel);
            userFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            userFrame.pack();
            userFrame.setVisible(true);



        } else if (e.getSource() == searchBookByAuthorButton) {

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


        } else if (e.getSource() == reserveBookButton) {

            ReserveBook rb = new ReserveBook();
            JFrame frame = new JFrame();
            frame.setContentPane(rb.MainPanel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            frame.pack();


        } else if (e.getSource() == borrowBookButton) {

            BorrowBook bb = new BorrowBook();
            JFrame frame = new JFrame();
            frame.setContentPane(bb.MainPanel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            frame.pack();


        } else if (e.getSource() == returnBookButton) {
            ReturnBook rb = new ReturnBook();
            JFrame frame = new JFrame();
            frame.setContentPane(rb.MainPanel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        } else if (e.getSource() == LOGOUTButton) {
            UserLogin userLogin = new UserLogin();
            JFrame userFrame = new JFrame("User Login");
            userFrame.setContentPane(userLogin.panel2);
            userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            userFrame.pack();
            userFrame.setVisible(true);
            File name = new File("LoggedInUser.txt");
            if(name.exists()){
                name.delete();
            }
            closeOriginalFrame();
        }
    }



    private void closeOriginalFrame() {
        Window originalFrame = SwingUtilities.getWindowAncestor(panel4);
        if (originalFrame != null) {
            originalFrame.dispose();
        }
    }
}
