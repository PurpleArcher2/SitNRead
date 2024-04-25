package SelectPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianLogin implements ActionListener {
    public JPanel panel3;
    private JPasswordField passwordField1;
    private JButton backButton;
    private JButton button2;
    private JTextField employeeIDField;

    public LibrarianLogin() {
        panel3.setPreferredSize(new Dimension(400, 300));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainframe = new JFrame("Librarian Login");
            mainframe.setContentPane(new LibrarianLogin().panel3);
            mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainframe.pack();
            mainframe.setLocationRelativeTo(null);
            mainframe.setVisible(true);
        });
    }

    private void createUIComponents() {
        backButton = new JButton("BACK");
        backButton.addActionListener(this);
        button2 = new JButton("Log In");
        button2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            WelcomePage newWelcomePage = new WelcomePage();
            JFrame librarianFrame = new JFrame("Librarian Login");
            librarianFrame.setContentPane(newWelcomePage.panel1);
            librarianFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            librarianFrame.pack();
            librarianFrame.setVisible(true);
            closeOriginalFrame();
        } else if (e.getSource() == button2) {

            try {
                int employeeID = Integer.parseInt(employeeIDField.getText());


                try {
                    int enteredPassword = Integer.parseInt(new String(passwordField1.getPassword()));
                    int correctPassword = 1234;


                    if (enteredPassword == correctPassword) {
                        JFrame loggedInFrame = new JFrame("Librarian Logged In");
                        loggedInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        loggedInFrame.setPreferredSize(new Dimension(400, 300));
                        loggedInFrame.pack();
                        loggedInFrame.setLocationRelativeTo(null);
                        loggedInFrame.setVisible(true);
                        closeOriginalFrame();
                    } else {
                        JOptionPane.showMessageDialog(panel3, "Incorrect LibrarianCard. Please try again.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel3, "Invalid password format. Please enter a valid integer.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel3, "Invalid employee ID format. Please enter a valid integer.");
            }
        }
    }

    private void closeOriginalFrame() {
        Window originalFrame = SwingUtilities.getWindowAncestor(panel3);
        if (originalFrame != null) {
            originalFrame.dispose();
        }
    }
}