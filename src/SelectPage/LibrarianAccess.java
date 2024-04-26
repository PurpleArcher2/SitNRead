package SelectPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            closeOriginalFrame();

        }


    }


    private void closeOriginalFrame() {
        Window originalFrame = SwingUtilities.getWindowAncestor(panel5);
        if (originalFrame != null) {
            originalFrame.dispose();
        }
    }
}
