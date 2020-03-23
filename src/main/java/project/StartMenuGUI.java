package project;

import javax.swing.*;
import java.awt.*;

public class StartMenuGUI extends JFrame {
    private JButton original = new JButton("open original");
    private JButton noise = new JButton("open image with noise");
    private JButton filter = new JButton("open image after filter");
    private JButton contour = new JButton("open image with contour");
    private JButton transformation = new JButton("open image after transformation");

    public StartMenuGUI(String title) throws HeadlessException {
        super(title);
        setLayout(new GridLayout());
        add(original);
        original.addActionListener(new ButtonEventListener());
        add(noise);
        noise.addActionListener(new ButtonEventListener());
        add(filter);
        filter.addActionListener(new ButtonEventListener());
        add(contour);
        contour.addActionListener(new ButtonEventListener());
        add(transformation);
        transformation.addActionListener(new ButtonEventListener());
    }
}
