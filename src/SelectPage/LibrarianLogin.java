    package SelectPage;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import Codes.Librarian;
    import Codes.User;

    import java.io.*;
    import java.util.LinkedList;
    public class LibrarianLogin implements ActionListener {
        public JPanel panel3;
        private JPasswordField passwordField1;
        private JButton backButton;
        private JButton button2;
        private JTextField employeeIDField;

        public LibrarianLogin() {
            panel3.setPreferredSize(new Dimension(400, 300));
        }


        public static LinkedList<Librarian> readLibrariansFromFile(String fileName) {
            LinkedList<Librarian> librarians = new LinkedList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
                        String name = parts[0].trim();
                        int age = Integer.parseInt(parts[1].trim());
                        String gender = parts[2].trim();
                        int employeeID = Integer.parseInt(parts[3].trim());
                        librarians.add(new Librarian(name, age, gender, employeeID));
                    }
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
            return librarians;
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

                    int enterLibrarianCard = Integer.parseInt(new String(passwordField1.getPassword()));
                    String userFileName = "LibrarianDB.txt";
                    LinkedList<Librarian> librarians = readLibrariansFromFile(userFileName);
                    boolean found = false;


                    for(Librarian librarian : librarians){

                        if(librarian.getEmployeeID() == enterLibrarianCard){
                            found = true;

                            try(PrintWriter writer = new PrintWriter("LoggedInLibrarian.txt")){
                                writer.print(STR."\{librarian.getName()},\{librarian.getAge()},\{librarian.getGender()},\{librarian.getEmployeeID()}");

                            } catch (IOException ez)
                            {
                                ez.printStackTrace();
                            }

                            LibrarianAccess LAccess = new LibrarianAccess();
                            JFrame userFrame = new JFrame("User Login");
                            userFrame.setContentPane(LAccess.panel5);
                            userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            userFrame.pack();
                            userFrame.setVisible(true);
                            closeOriginalFrame();
                            break;
                        }

                    } if(!found){
                        JOptionPane.showMessageDialog(panel3, "Incorrect UserCard. Please try again.");
                    }
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel3, "Invalid UserCard number format. Please enter a valid integer.");
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