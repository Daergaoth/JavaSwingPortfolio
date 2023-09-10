package org.daergaoth.ui.elements;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    public void setupDefaultPanel(Color backgroundColor, int x, int y, int width, int height) {
        this.setBackground(backgroundColor);
        this.setBounds(x, y, width, height);//this needed if the parent layout manager is null
//        this.setLayout(new BorderLayout());
        this.setLayout(null);
    }

    public void setupTextField(int x, int y, int width, int height) {
        //JLabel label = new JLabel();
//        this.setText(text);
//        this.setVerticalTextPosition(JLabel.BOTTOM);
//        this.setHorizontalTextPosition(JLabel.CENTER);
        //MyFrame myFrame = new MyFrame();


//        ImageIcon image1 = new ImageIcon(iconPath);
//        Border border = BorderFactory.createLineBorder(Color.green, 3);
        //frame.add(image.getImage());
//        this.setIcon(image1);
//        this.setHorizontalTextPosition(JLabel.LEFT);//Useless if parent layout manager is null
//        this.setVerticalTextPosition(JLabel.CENTER);//Useless if parent layout manager is null
        this.setForeground(new Color(0x00FF00));
        this.setFont(new Font("MV Boli", Font.PLAIN, 20));
        //label.setIconTextGap(-100);
//        this.setBackground(Color.gray);
        this.setBackground(new Color(0x123456));
        this.setOpaque(true);
        //label.setBorder(border);
//        this.setVerticalAlignment(JLabel.CENTER);
//        this.setHorizontalAlignment(JLabel.LEFT);
        this.setBounds(x, y, width, height); //this needed if the parent layout manager is null
    }
}
