package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class updatePlayer extends JFrame implements ActionListener {

    JLabel playerLabel, choiceLabel, newLabel, messageLabel;
    JTextField playerName, newEntry;
    JButton saveButton, backButton;
    JComboBox comboBox;

    String[] player = { "Name", "Address", "Sport", "Phone number", "Player type" };
    private String choice;

    public updatePlayer() {
        
        playerLabel = new JLabel();
        playerLabel.setText("Enter the player name:");
        playerLabel.setBounds(30, 20, 300, 30);

        playerName = new JTextField();
        playerName.setBounds(200, 20, 200, 30);

        choiceLabel = new JLabel();
        choiceLabel.setText("Select the player attribute to update:");
        choiceLabel.setBounds(30, 70, 300, 30);

        comboBox = new JComboBox(player);
        comboBox.setBounds(290, 70, 150, 30);
        comboBox.addActionListener(this);
        comboBox.setEditable(false);

        newLabel = new JLabel();
        newLabel.setText("Enter the new value:");
        newLabel.setBounds(30, 120, 200, 30);

        newEntry = new JTextField();
        newEntry.setBounds(200, 120, 200, 30);
        newEntry.setVisible(true);

        messageLabel = new JLabel();
        messageLabel.setText("Player Info Updated Successfully!");
        messageLabel.setBounds(70, 200, 300, 30);
        messageLabel.setVisible(false);

        saveButton = new JButton("Save");
        saveButton.setBounds(150, 250, 100, 40);
        saveButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(150, 300, 100, 40);
        backButton.addActionListener(this);

        this.setTitle("Update Player");
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(playerLabel);
        this.add(playerName);
        this.add(choiceLabel);
        this.add(comboBox);
        this.add(newLabel);
        this.add(newEntry);
        this.add(messageLabel);
        this.add(saveButton);
        this.add(backButton);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            choice = (String) comboBox.getSelectedItem();
        } else if (e.getSource() == saveButton) {
            if (choice.equals(player[0])) {
                System.out.println("Team name:" + choice);
            } else if (choice.equals(player[1])) {
                System.out.println("Team hometown:" + choice);
            } else if (choice.equals(player[2])) {
                System.out.println("Number of players:" + choice);
            }
            messageLabel.setVisible(true);
            playerName.setEditable(false);
            newEntry.setEditable(false);
            comboBox.setEditable(false);
            saveButton.setEnabled(false);
            backButton.setText("Close");
            messageLabel.setVisible(true);
        } else if (e.getSource() == backButton) {
            this.dispose();
        }     
    
    }

}
