package com.example;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class myFrame extends JFrame implements ActionListener {
    
    JButton button;

    public myFrame() {

        JPanel panel = new JPanel();
        panel.setBackground(Color.red);
        panel.setBounds(0, 0, 250, 250);

        button = new JButton("Click me");
        button.setBounds(100, 100, 100, 50);
        button.addActionListener(this);

        this.setTitle("Our title");
        this.pack();
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(750, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //this.add(panel);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("Button clicked");
        }
    }

}
