package org.newoffshore;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Auto Test Tool");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton runBtn = new JButton("Run Selenium Test");
        runBtn.setBounds(100, 50, 200, 40);

        JTextArea result = new JTextArea();
        result.setBounds(50, 110, 300, 80);

        frame.add(runBtn);
        frame.add(result);

        frame.setVisible(true);
    }
}