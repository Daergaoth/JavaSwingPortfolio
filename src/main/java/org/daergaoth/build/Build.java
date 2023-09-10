package org.daergaoth.build;

import org.daergaoth.staticPackage.StaticObjects;
import org.daergaoth.ui.elements.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Build {
    private static MyTextArea keywordTextArea;
    private static MyTextArea rootFolderTextArea;
    private static JComboBox<String> comboBox;
    private static MyPanel comboBoxContainer;
    private static MyTextArea resultTextArea;
    private static final List<String> results = new ArrayList<>();

    //Only to speed up development
    public static String defaultKeyword = "";
    //Only to speed up development
    public static String defaultRootFolder = "";

    public static void build() {

        try {
            MyFrame frame = new MyFrame();
            swingSetup(frame);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void swingSetup(MyFrame frame) {

        MyButton myButtonOne = new MyButton();
        myButtonOne.setupDefaultButton(1215, 600, 100, 30, "Search");
        frame.add(myButtonOne);
        myButtonOne.addActionListener(e -> {
            boolean searchCanBeExecuted = true;
            if (Objects.isNull(keywordTextArea.getText()) || keywordTextArea.getText().length() == 0) {
                keywordTextArea.setForeground(Color.red);
                keywordTextArea.setText("Please add keyword here!");
                searchCanBeExecuted = false;
            }

            if (Objects.isNull(rootFolderTextArea.getText()) || rootFolderTextArea.getText().length() == 0) {
                rootFolderTextArea.setForeground(Color.red);
                rootFolderTextArea.setText("Please add root folder path here!");
                searchCanBeExecuted = false;
            }

            if (Objects.isNull(comboBox.getSelectedItem()) || !(comboBox.getSelectedItem() instanceof String) || ((String) comboBox.getSelectedItem()).length() == 0) {
                comboBoxContainer.setBackground(Color.red);
                searchCanBeExecuted = false;
            }
            if (searchCanBeExecuted) {
                results.clear();
                processFile(new File(rootFolderTextArea.getText()));
                if (results.size() > 0) {
                    StringBuilder resultStringBuilder = new StringBuilder();
                    resultStringBuilder.append("Results\n\n");
                    for (String finding : results) {
                        resultStringBuilder.append("\t- ");
                        resultStringBuilder.append(finding);
                        resultStringBuilder.append("\n");
                    }
                    resultTextArea.setText(resultStringBuilder.toString());
                } else {
                    resultTextArea.setText("No file found");
                }
            }
        });

        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File(StaticObjects.LOGOICON));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (Objects.nonNull(myPicture)) {
            MyLabel picLabel = new MyLabel();
            picLabel.setupTextField(20, 20, 120, 120);
            Image image = new ImageIcon(myPicture).getImage();
            Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(newimg);
            picLabel.setIcon(imageIcon);
            frame.add(picLabel);
        }


        MyLabel keywordLabelLabel = new MyLabel();
        keywordLabelLabel.setupTextField(200, 50, 200, 30);
        keywordLabelLabel.setText("Keyword:");
        frame.add(keywordLabelLabel);

        MyLabel keywordTextareaLabel = new MyLabel();
        keywordTextareaLabel.setupTextField(400, 50, 800, 30);
        keywordTextArea = new MyTextArea();
        keywordTextArea.setupDefaultPanel();
        keywordTextArea.setSize(800, 30);
        if (defaultKeyword.length() > 0) {
            keywordTextArea.setText(defaultKeyword);
        }
        keywordTextareaLabel.add(keywordTextArea);
        frame.add(keywordTextareaLabel);

        MyLabel rootFolderLabelLabel = new MyLabel();
        rootFolderLabelLabel.setupTextField(200, 100, 200, 30);
        rootFolderLabelLabel.setText("Root folder:");
        frame.add(rootFolderLabelLabel);

        MyLabel rootFolderLabel = new MyLabel();
        rootFolderLabel.setupTextField(400, 100, 800, 30);
        rootFolderTextArea = new MyTextArea();
        rootFolderTextArea.setupDefaultPanel();
        rootFolderTextArea.setSize(800, 30);
        if (defaultRootFolder.length() > 0) {
            rootFolderTextArea.setText(defaultRootFolder);
        }
        rootFolderLabel.add(rootFolderTextArea);
        frame.add(rootFolderLabel);

        MyLabel selectExtensionLabel = new MyLabel();
        selectExtensionLabel.setupTextField(200, 150, 200, 30);
        selectExtensionLabel.setText("Extension:");
        frame.add(selectExtensionLabel);

        comboBoxContainer = new MyPanel();
        comboBoxContainer.setLayout(null); // added code
        comboBoxContainer.setupTextField(395, 145, 810, 40);
        String[] choices = {".java", ".html", ".ts", ".js", ".txt", ".xml"};
        comboBox = new JComboBox<String>(choices);
        comboBox.setBounds(5, 5, 800, 30);
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
        comboBox.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        comboBoxContainer.add(comboBox);
        frame.add(comboBoxContainer);

        MyLabel resultLabel = new MyLabel();
        resultLabel.setupTextField(200, 200, 1000, 450);
        resultLabel.setBackground(new Color(0x0F3153));
        resultTextArea = new MyTextArea();
        resultTextArea.setupDefaultPanel();
        resultTextArea.setEditable(true);
        resultTextArea.setSize(1000, 450);
        resultTextArea.setText("\t- Provide keyword you wish to search for in files\n\t- Provide the path of the root folder, from where the search will start\n\t- Select the file extension you wish to check");
//        resultLabel.add(resultTextArea);
        JScrollPane scroll = new JScrollPane(resultTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(0, 0, 1000, 450);
        resultLabel.add(scroll);
        frame.add(resultLabel);


        frame.setupDefaultFrame();
        frame.revalidate();
    }

    private static void processFile(File currentFile) {
        if (currentFile.exists()) {
            if (currentFile.isDirectory()) {
                resultTextArea.setText("Currently checking: " + currentFile.getAbsolutePath());
                File[] files = currentFile.listFiles();
                if (Objects.nonNull(files)) {
                    for (File child : files) {
                        processFile(child);
                    }
                }
            } else if (currentFile.isFile()) {
                boolean shouldICheckFile = Objects.nonNull(comboBox.getSelectedItem()) && currentFile.getName().contains((String) comboBox.getSelectedItem());
                boolean fileAlreadyMatch = false;
                if (shouldICheckFile) {
                    try (BufferedReader br = new BufferedReader(new FileReader(currentFile))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            if (line.toLowerCase().contains(keywordTextArea.getText().toLowerCase()) && !fileAlreadyMatch) {
                                results.add(currentFile.getAbsolutePath());
                                System.out.println(currentFile.getAbsolutePath());
                                fileAlreadyMatch = true;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}