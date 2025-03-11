package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class startPage extends JFrame implements ActionListener {

    JComboBox comboBox;
    private String userRole;
    JLabel label;
    String[] roles = {"Manager", "Coach", "Audience"};
    JFrame frame;
    JButton button;

    startPage() {
        frame = new JFrame();
        this.setTitle("Start Page");
        this.pack();
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel();
        label.setText("Select your role");
        label.setBounds(70, 50, 100, 30);

        comboBox = new JComboBox(roles);
        comboBox.setBounds(170, 50, 100, 30);
        comboBox.setEditable(false);

        button = new JButton("Submit");
        button.setBounds(150, 100, 100, 40);
        button.addActionListener(this);

        comboBox.addActionListener(this);
        this.add(label);
        this.add(comboBox);
        this.add(button);
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            userRole = (String) comboBox.getSelectedItem();
        } else if (e.getSource() == button) {
            this.dispose();
            System.out.println(userRole);
            if (userRole.equals(roles[0])) {
                System.out.println("Manager selected");
                new managerMenu();
            } else if (userRole.equals(roles[1])) {
                System.out.println("Coach selected");
                new coachMenu();
            } else if (userRole.equals(roles[2])) {
                System.out.println("Audience selected");
                new audienceMenu();
            }
            
        }
        
    }
    
}
