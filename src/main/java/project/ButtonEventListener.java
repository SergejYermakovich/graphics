package project;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ButtonEventListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button = (JButton) actionEvent.getSource();
        if (button.getText().equals("open image with noise")) {
            File file = new File("src/main/resources/AFTER_NOISE.bmp");
            try {
                BufferedImage image = ImageIO.read(file);
                JOptionPane.showMessageDialog(null, "header:" + image.getProperty("header"));
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (button.getText().equals("open image after filter")) {
            File file = new File("src/main/resources/AFTER_FILTER.bmp");
            try {
                BufferedImage image = ImageIO.read(file);
                JOptionPane.showMessageDialog(null, "header:" + image.getProperty("header"));
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (button.getText().equals("open image with contour")) {
            File file = new File("src/main/resources/CONTOUR.bmp");
            try {
                BufferedImage image = ImageIO.read(file);
                JOptionPane.showMessageDialog(null, "header:" + image.getProperty("header"));
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (button.getText().equals("open image after transformation")) {
            File file = new File("src/main/resources/TRANSFORM.bmp");
            try {
                BufferedImage image = ImageIO.read(file);
                JOptionPane.showMessageDialog(null, "header:" + image.getProperty("header"));
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
