package org.daergaoth.ui.elements;


import javax.swing.*;
import java.awt.*;

public class MyTextArea extends JTextArea {

    public void setupDefaultPanel() {
//        this.setSize(1300,320);
        this.setEditable(true);
        this.setAutoscrolls(true);
//        this.setBackground(Color.gray);
//        this.setBackground(new Color(0x0F3153));
//        this.setForeground(new Color(0x00FF00));
        this.setBackground(new Color(0x00FF00));
        this.setForeground(new Color(0x0F3153));
        this.setFont(new Font("MV Boli", Font.PLAIN, 19));
    }
}