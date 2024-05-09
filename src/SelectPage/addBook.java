package SelectPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class addBook implements ActionListener {
    public JPanel MainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton submitButton;
    private JButton backButton;


    public addBook(){
        MainPanel.setPreferredSize(new Dimension(900, 300));
    }

    public static void main(String[] args) {
        JFrame mainframe = new JFrame("Add book");
        mainframe.setContentPane(new addBook().MainPanel);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainframe.pack();
        mainframe.setVisible(true);
    }


    private void createUIComponents() {

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        backButton = new JButton("back");
        backButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == backButton){
            LibrarianAccess lac = new LibrarianAccess();
            JFrame userFrame = new JFrame("User Login");
            userFrame.setContentPane(lac.panel5);
            userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            userFrame.pack();
            userFrame.setVisible(true);
            closeOriginalFrame();
        } else if(e.getSource() == submitButton){

            String id = textField1.getText();
            String title = textField2.getText();
            String author = textField3.getText();
            String genre = textField4.getText();
            String filePath = "book.txt";


            try (FileWriter fw = new FileWriter(filePath, true);
                 PrintWriter pw = new PrintWriter(fw)) {
                pw.println(STR."\{id},\{title},\{author},\{genre},true,false");
                JOptionPane.showMessageDialog(MainPanel, "Book added successfully!");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(MainPanel, "Failed to add book!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }


    }

    private void closeOriginalFrame() {
        Window originalFrame = SwingUtilities.getWindowAncestor(MainPanel);
        if (originalFrame != null) {
            originalFrame.dispose();
        }
    }
}
