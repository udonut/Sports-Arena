package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class addPlayer extends JFrame implements ActionListener {

    JLabel label, nameLabel, addressLabel, sportLabel, numberLabel, typeLabel, messageLabel;
    JTextField nameText, addressText, sportType, numberText, playerType;
    JButton saveButton, cancelButton;

    public addPlayer() {
        
        label = new JLabel();
        label.setText("Add a new player:");
        label.setBounds(70, 20, 300, 30);

        nameLabel = new JLabel();
        nameLabel.setText("Name:");
        nameLabel.setBounds(70, 70, 300, 30);

        nameText = new JTextField();
        nameText.setBounds(70, 100, 300, 30);

        addressLabel = new JLabel();
        addressLabel.setText("Address:");
        addressLabel.setBounds(70, 130, 300, 30);

        addressText = new JTextField();
        addressText.setBounds(70, 160, 300, 30);

        sportLabel = new JLabel();
        sportLabel.setText("Sport:");
        sportLabel.setBounds(70, 190, 300, 30);

        sportType = new JTextField();
        sportType.setBounds(70, 220, 300, 30);

        numberLabel = new JLabel();
        numberLabel.setText("Phone Number:");
        numberLabel.setBounds(70, 250, 300, 30);

        numberText = new JTextField();
        numberText.setBounds(70, 280, 300, 30);

        typeLabel = new JLabel();
        typeLabel.setText("Player Type:");
        typeLabel.setBounds(70, 310, 300, 30);

        playerType = new JTextField();
        playerType.setBounds(70, 340, 300, 30);

        messageLabel = new JLabel();
        messageLabel.setText("Player added successfully!");
        messageLabel.setBounds(70, 370, 300, 30);
        messageLabel.setVisible(false);

        saveButton = new JButton("Add Player");
        saveButton.setBounds(70, 400, 125, 40);
        saveButton.addActionListener(this);

        cancelButton = new JButton("cancel");
        cancelButton.setBounds(250, 400, 150, 40);
        cancelButton.addActionListener(this);

        this.setTitle("Add Player");
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(500, 500);

        this.add(label);
        this.add(nameLabel);
        this.add(nameText);
        this.add(addressLabel);
        this.add(addressText);
        this.add(sportLabel);
        this.add(sportType);
        this.add(numberLabel);
        this.add(numberText);
        this.add(typeLabel);
        this.add(playerType);
        this.add(messageLabel);
        this.add(saveButton);
        this.add(cancelButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {   
            String name = nameText.getText();
            String address = addressText.getText();
            String sport = sportType.getText();
            String strNumber = numberText.getText();
            String type = playerType.getText();         
            if (name.isEmpty() || address.isEmpty() || sport.isEmpty() || strNumber.isEmpty() || type.isEmpty()) {
                messageLabel.setVisible(true);
                messageLabel.setText("Please fill all the fields");
            } else {
                int number = Integer.parseInt(strNumber);
                nameText.setEnabled(false);
                addressText.setEnabled(false);
                sportType.setEnabled(false);
                numberText.setEnabled(false);
                playerType.setEnabled(false);
                messageLabel.setVisible(true);
                saveButton.setEnabled(false);
                cancelButton.setText("close");
                messageLabel.setText("Player added successfully");
            }
            System.out.println(name + "," + address + "," + sport + "," + strNumber + "," + type);
        } else if (e.getSource() == cancelButton) {
            this.dispose();

        }
    }
}
