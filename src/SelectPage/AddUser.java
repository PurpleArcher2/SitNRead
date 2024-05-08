package SelectPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class AddUser implements ActionListener {
    public JPanel MainPanel2;
    private JButton submitButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton backButton;

    public AddUser(){

        MainPanel2.setPreferredSize(new Dimension(900, 300));

    }
    public static void main(String[] args) {

        JFrame mainframe = new JFrame("Startup");
        mainframe.setContentPane(new AddUser().MainPanel2);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainframe.pack();
        mainframe.setVisible(true);

    }

    private void createUIComponents() {
        backButton = new JButton("Back");
        backButton.addActionListener(this);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {

            LibrarianAccess lac = new LibrarianAccess();
            JFrame userFrame = new JFrame("Librarian Login");
            userFrame.setContentPane(lac.panel5);
            userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            userFrame.pack();
            userFrame.setVisible(true);
            closeOriginalFrame();

        } else if (e.getSource() == submitButton){

            String name = textField1.getText().trim();
            String ageStr = textField2.getText().trim();
            String gender = textField3.getText().trim();
            String idStr = textField4.getText().trim();
            if (!isValidName(name)) {
                JOptionPane.showMessageDialog(null, "Invalid name. Name cannot contain numbers.");
                return;
            }

            int age;
            try {
                age = Integer.parseInt(ageStr);
                if (age < 0 || age >= 110) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid age. Age must be a positive integer.");
                return;
            }

            if (!isValidGender(gender)) {
                JOptionPane.showMessageDialog(null, "Invalid gender. Gender must be 'Male' or 'Female'.");
                return;
            }

            int id;
            try {
                id = Integer.parseInt(idStr);
                if (id < 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid ID. ID must be a positive integer.");
                return;
            }


            writeToFile(STR."\{name},\{age},\{gender},\{id}", "UserDB.txt");


            JOptionPane.showMessageDialog(null, "Librarian added successfully!");

        }
    }

    private void closeOriginalFrame() {
        Window originalFrame = SwingUtilities.getWindowAncestor(MainPanel2);
        if (originalFrame != null) {
            originalFrame.dispose();
        }
    }

    private void writeToFile(String data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(STR."\{data}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean isValidName(String name) {
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidGender(String gender) {
        return gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female");
    }
}
