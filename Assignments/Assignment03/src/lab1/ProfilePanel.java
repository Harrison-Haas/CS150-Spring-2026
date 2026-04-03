package lab1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProfilePanel extends JPanel {

    private Profile profile;
    private BufferedImage icon;

    public ProfilePanel(Profile profile) {
        this.profile = profile;
        this.icon = loadIcon("Default_pfp.jpg");
        this.setPreferredSize(new Dimension(300, 100));
        this.setBackground(backgroundColor());
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public BufferedImage loadIcon(String pathname) {
        try {
            return ImageIO.read(new File(pathname));
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Paints the panel with a name, age, major, and a profile image
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Name: " + profile.getName(), 70, 30);
        g.drawString("Age: " + profile.getAge(), 70, 50);
        g.drawString("Major: " + profile.getMajor(), 70, 70);
        g.drawImage(icon, 0, 18, 60, 60, null);
    }

    /**
     * Sets the background color based on the age of the panel's profile
     * @return A color
     */
    public Color backgroundColor() {
        int n = profile.getAge();
        double min = 0;
        double max = 50;
        double scale = (min + n) / (max - min);
        while (scale > 50) {
            scale = scale % 50;
        }
        float hue = (float) scale;
        float sat = .75f;
        float bri = 1f;
        Color c = Color.getHSBColor(hue, sat, bri);
        return c;
    }


}
