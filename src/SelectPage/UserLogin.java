package SelectPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogin implements ActionListener {

    public JPanel panel2;
    private JPasswordField passwordField1;
    private JButton Back;
    private JButton logInButton;

    public UserLogin() {
        panel2.setPreferredSize(new Dimension(400, 300));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainframe = new JFrame("User Login");
            mainframe.setContentPane(new UserLogin().panel2);
            mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainframe.pack();
            mainframe.setLocationRelativeTo(null);
            mainframe.setVisible(true);
        });
    }

    private void createUIComponents() {
        Back = new JButton("BACK");
        Back.addActionListener(this);
        logInButton = new JButton("Log In");
        logInButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {
            WelcomePage newwelcomePage = new WelcomePage();
            JFrame userFrame = new JFrame("User Login");
            userFrame.setContentPane(newwelcomePage.panel1);
            userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            userFrame.pack();
            userFrame.setVisible(true);
            closeOriginalFrame();
        } else if (e.getSource() == logInButton) {
            try {


                int enteredLibraryCard = Integer.parseInt(new String(passwordField1.getPassword()));
                int correctLibraryCard = 2210152;


                if (enteredLibraryCard == correctLibraryCard) {
                    JFrame loggedInFrame = new JFrame("Logged In");
                    loggedInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    loggedInFrame.setPreferredSize(new Dimension(400, 300));
                    loggedInFrame.pack();
                    loggedInFrame.setLocationRelativeTo(null);
                    loggedInFrame.setVisible(true);
                    closeOriginalFrame();
                } else {
                    JOptionPane.showMessageDialog(panel2, "Incorrect UserCard number. Please try again.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel2, "Invalid UserCard number format. Please enter a valid integer.");
            }
        }
    }

    private void closeOriginalFrame() {
        Window originalFrame = SwingUtilities.getWindowAncestor(panel2);
        if (originalFrame != null) {
            originalFrame.dispose();
        }
    }
}