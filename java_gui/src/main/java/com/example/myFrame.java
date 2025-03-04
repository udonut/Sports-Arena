package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class myFrame extends JFrame {
    
    
        

    public myFrame() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        panel.setLayout(new GridLayout(20, 20));
        
        this.add(panel, BorderLayout.CENTER);
        this.setResizable(false);
        this.setSize(420, 420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Our title");
        this.pack();
        this.setVisible(true);
    }

}
