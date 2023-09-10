package org.daergaoth.ui.elements;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    private String buttonId;

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    public void setupDefaultButton(int x, int y, int width, int height, String text) {
        this.setBounds(x, y, width, height);
        this.setText(text);
        this.setFocusable(false);
        /*ImageIcon image = new ImageIcon("src/main/resources/logo.png");
        this.setIcon(image);*/
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);
//        this.setFont(new Font("Comic Sans", Font.BOLD, 25));
        this.setFont(new Font("MV Boli", Font.PLAIN, 20));
        //this.setForeground(Color.cyan);
        this.setForeground(new Color(0x00FF00));
        this.setBackground(new Color(0x123456));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setEnabled(true);
    }
}
