package SelectPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import Codes.Librarian;
import Codes.User;
import java.io.*;

public class UserLogin implements ActionListener {

    public JPanel panel2;
    private JPasswordField passwordField1;
    private JButton Back;
    private JButton logInButton;

    public UserLogin() {
        panel2.setPreferredSize(new Dimension(400, 300));
    }


    public static LinkedList<User> readUsersFromFile(String fileName) {
        LinkedList<User> users = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) { // Ensure correct format
                    String name = parts[0].trim();
                    int age = Integer.parseInt(parts[1].trim());
                    String gender = parts[2].trim();
                    int libraryCardNum = Integer.parseInt(parts[3].trim());
                    users.add(new User(name, age, gender, libraryCardNum));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return users;
    }

//    public static void writeUsersToFile(String fileName, LinkedList<User> users) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
//            oos.writeObject(users);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainframe = new JFrame("User Login");
            mainframe.setContentPane(new UserLogin().panel2);
            mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainframe.pack();
            mainframe.setLocationRelativeTo(null);
            mainframe.setVisible(true);

//            LinkedList<User> users = new LinkedList<>();
//            users.add(new User("John", 25, "Male", 12345));
//            users.add(new User("Alice", 30, "Female", 54321));
//
//            // Example: Write users to file
//            String userFileName = "UserDB.txt";
//            writeUsersToFile(userFileName, users);
        });
    }

//    Function that reads the User from file



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


                int enterUserCard = Integer.parseInt(new String(passwordField1.getPassword()));
                String userFileName = "UserDB.txt";
                LinkedList<User> users = readUsersFromFile(userFileName);
                boolean found = false;

                for(User user : users){

                    if(user.getLibraryCardNum() == enterUserCard){
                        found = true;
                        UserAccess userLogin = new UserAccess();
                        JFrame userFrame = new JFrame("User Login");
                        userFrame.setContentPane(userLogin.panel4);
                        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        userFrame.pack();
                        userFrame.setVisible(true);
                        closeOriginalFrame();
                        break;
                        
                    }
                }
                if(!found){
                    JOptionPane.showMessageDialog(panel2, "Incorrect UserCard. Please try again.");
                }
            }catch (NumberFormatException ex) {
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


