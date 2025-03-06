package com.example;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class managerLogin extends JFrame implements ActionListener {
    
    JButton saveButton, cancelButton;
    ArrayList<String> managerDetails = new ArrayList<String>();  
    JLabel label, labelName, labelNumber, labelEmail, messageLabel;   
    JTextField name, number, email;

    public managerLogin() {

        label = new JLabel();
        label.setText("Enter your details for Login:");
        label.setBounds(70, 50, 300, 30);

        labelName = new JLabel();
        labelName.setText("Name:");
        labelName.setBounds(70, 100, 100, 30);

        labelNumber = new JLabel();
        labelNumber.setText("Phone Number:");
        labelNumber.setBounds(70, 150, 100, 30);

        labelEmail = new JLabel();
        labelEmail.setText("Email:");
        labelEmail.setBounds(70, 200, 100, 30);

        
        name = new JTextField();
        name.setBounds(180, 100, 200, 30);
        name.setVisible(true);

        number = new JTextField();
        number.setPreferredSize( new Dimension( 200, 24 ) );
        number.setBounds(180, 150, 200, 30);
        number.setVisible(true);

        email = new JTextField();
        email.setBounds(180, 200, 200, 30);
        email.setVisible(true);

        saveButton = new JButton("Save");
        saveButton.setBounds(150, 250, 100, 40);
        saveButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(150, 300, 100, 40);
        cancelButton.addActionListener(this);

        messageLabel = new JLabel();
        messageLabel.setText("Your Info As A Manager Was Added Successfully!");
        messageLabel.setBounds(70, 350, 300, 30);

        this.setTitle("Add Your Own Manager Info");
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(labelName);
        this.add(labelNumber);
        this.add(labelEmail);
        this.add(label);
        this.add(name);
        this.add(number);
        this.add(email);
        this.add(saveButton);
        this.add(cancelButton);
        this.add(messageLabel);
        messageLabel.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            System.out.println("Your Manager Info Added");
            name.setEditable(false);
            number.setEditable(false);
            email.setEditable(false);
            saveButton.setEnabled(false);
            messageLabel.setVisible(true);
            cancelButton.setText("Close");
        } else if (e.getSource() == cancelButton) {
            this.dispose();
        }
    }

}
