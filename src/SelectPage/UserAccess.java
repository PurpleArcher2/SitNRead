package SelectPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserAccess implements ActionListener {


    public JPanel panel4;
    private JButton checkInfoButton;
    private JButton searchBookByTitleButton;
    private JButton serachBookByAuthorButton;
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

        LOGOUTButton = new JButton("LOG OUT");
        LOGOUTButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == LOGOUTButton){

            UserLogin userLogin = new UserLogin();
            JFrame userFrame = new JFrame("User Login");
            userFrame.setContentPane(userLogin.panel2);
            userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            userFrame.pack();
            userFrame.setVisible(true);
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
