package org.daergaoth.ui.elements;

import org.daergaoth.staticPackage.StaticObjects;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public void setupDefaultFrame() {
        this.setTitle("File Checker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(1344, 720);
        this.setVisible(true);

        ImageIcon image = new ImageIcon(StaticObjects.LOGOICON);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(0x123456));


//        this.pack();//Should be called after components are all added
    }
}
