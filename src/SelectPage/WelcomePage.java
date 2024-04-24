package SelectPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class WelcomePage implements ActionListener{
    public JPanel panel1;
    private JLabel WelcomeMessage;
    private JButton librarianButton;
    private JButton userButton;
    private JLabel imageLogo;
    private JLabel sitNReadLabel;





    public static void main(String[] args) {

        JFrame mainframe = new JFrame("Startup");
        mainframe.setContentPane(new WelcomePage().panel1);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainframe.pack();
        mainframe.setVisible(true);


    }



    private void createUIComponents() {

        imageLogo = new JLabel(new ImageIcon("src/SelectPage/images/book.png"));
        sitNReadLabel = new JLabel("SitNRead");
        Font font = new Font("Amio Trial", Font.ITALIC, 36);
        sitNReadLabel.setFont(font);

        WelcomeMessage = new JLabel("Welcome to SitNRead");
        WelcomeMessage.setFont(font);

        userButton = new JButton("User");
        userButton.addActionListener(this);

        librarianButton = new JButton("Librarian");
        librarianButton.addActionListener(this);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==userButton){
            UserLogin newuserlogin = new UserLogin();
            JFrame userFrame = new JFrame("User Login");
            userFrame.setContentPane(newuserlogin.panel2);
            userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            userFrame.pack();
            userFrame.setVisible(true);
            closeOriginalFrame();
        } else if(e.getSource()==librarianButton){
            LibrarianLogin newlibrarianlogin = new LibrarianLogin();
        }

    }

    private void closeOriginalFrame() {
        Window originalFrame = SwingUtilities.getWindowAncestor(panel1);
        if (originalFrame != null) {
            originalFrame.dispose();
        }
    }
}