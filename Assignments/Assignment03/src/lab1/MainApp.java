package lab1;
import java.awt.FlowLayout;
import javax.swing.*;

public class MainApp {

    public static void main(String[] args){
        JFrame frame = new JFrame("Profile Card");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        Profile profile = new Profile("Harrison Haas",18,"Statistics and Applied Mathematics");
        ProfilePanel panel = new ProfilePanel(profile);

        panel.backgroundColor();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
