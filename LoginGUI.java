import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class LoginGUI extends JFrame {
    private JLabel userLabel, passLabel, confirmLabel;
    private JTextField userField;
    private JPasswordField passField, confirmField;
    private JButton signUpButton, signInButton;
    private LoginData savedData;
    private boolean loggedIn;

    public LoginGUI() {
        super("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        userLabel = new JLabel("Username: ");
        userField = new JTextField(20);
        passLabel = new JLabel("Password: ");
        passField = new JPasswordField(20);
        confirmLabel = new JLabel("Confirm Password: ");
        confirmField = new JPasswordField(20);
        signUpButton = new JButton("Sign Up");
        signInButton = new JButton("Sign In");

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(confirmLabel);
        panel.add(confirmField);
        panel.add(signUpButton);
        panel.add(signInButton);

        getContentPane().add(panel);

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                String confirm = new String(confirmField.getPassword());
                if (password.equals(confirm)) {
                    // Save the data to a new class
                    savedData = new LoginData(username, password);
                    // Clear the fields
                    userField.setText("");
                    passField.setText("");
                    confirmField.setText("");
                    JOptionPane.showMessageDialog(LoginGUI.this, "Sign up successful!");
                } else {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        signInButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String username = userField.getText();
		        String password = new String(passField.getPassword());
		        if (savedData != null && savedData.getUsername().equals(username) && savedData.getPassword().equals(password)) {
		            // Clear the fields
		            userField.setText("");
		            passField.setText("");
		            confirmField.setText("");
		            JOptionPane.showMessageDialog(LoginGUI.this, "Login successful!");
		            // Set the loggedIn flag to true
		            loggedIn = true;
		            // Create a new instance of the OnlineTest class and display it
		            OnlineTest onlineTest = new OnlineTest("Online Test");
		            onlineTest.setVisible(true);
		            onlineTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		            onlineTest.setSize(800, 600);
		            onlineTest.setLocationRelativeTo(null);
		        } else {
		            JOptionPane.showMessageDialog(LoginGUI.this, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

        setVisible(true);
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}

class LoginData {
    private String username;
    private String password;

    public LoginData(String username, String password) {
        this.username = username;
        this.password = password;
        // Save the data to a file or database
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

