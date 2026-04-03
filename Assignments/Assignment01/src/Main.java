import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Welcome Page");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Enter Name Here:");
        JTextField nameInput = new JTextField(15);
        JButton greetingButton = new JButton("Go To Greeting");
        JButton loginButton = new JButton("Go To Login");
        frame.add(nameLabel);
        frame.add(nameInput);
        frame.add(greetingButton);
        frame.add(loginButton);

        greeting(frame, nameInput, greetingButton);
        login(frame, loginButton);
        frame.setVisible(true);
    }

    /**
     * Creates a new greeting frame that returns a greeting with the name passed in
     * the parameter
     * 
     * @param frame     The frame that will create the new frame
     * @param textField The textfield containig the name of the user
     * @param button    The button that opens the greeting frame
     */
    public static void greeting(JFrame frame, JTextField textField, JButton button) {
        Greeter greeter = new Greeter(textField.getText());

        JFrame greetingFrame = new JFrame("Greeting Page");
        greetingFrame.setSize(300, 200);
        greetingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        greetingFrame.setLayout(new FlowLayout());

        JLabel greetingLabel = new JLabel("");
        greetingFrame.add(greetingLabel);

        button.addActionListener(e -> {
            String name = textField.getText();
            greeter.setName(name);
            greetingLabel.setText(greeter.getGreeting());

            greetingFrame.revalidate();
            greetingFrame.setVisible(true);
        });
    }

    /**
     * Creates a login frame that takes a username and passowrd and validates them and then opens a new window
     * @param frame  The frame that will create the new frame
     * @param button The button that opens the greeting frame
     */
    public static void login(JFrame frame, JButton button) {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(300, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new FlowLayout());

        button.addActionListener(e -> {
            loginFrame.setVisible(true);
        });

        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");
        JLabel resultLabel = new JLabel("");

        loginFrame.add(new JLabel("Username:"));
        loginFrame.add(usernameField);
        loginFrame.add(new JLabel("Password:"));
        loginFrame.add(passwordField);
        loginFrame.add(loginButton);
        loginFrame.add(resultLabel);

        User user = new User("admin", "1234");

        loginButton.addActionListener(e -> {
            String u = usernameField.getText();
            String p = new String(passwordField.getPassword());
            if (user.validate(u, p)) {
                resultLabel.setText("Login Successful");
                new CounterApp();
            } else {
                resultLabel.setText("Login Failed");
            }
        });
    }

}
