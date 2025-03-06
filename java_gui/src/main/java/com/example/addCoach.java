package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class addCoach extends JFrame implements ActionListener {

    JLabel label, NameLabel, numberLabel, teamLabel, playerLabel, messageLabel;
    JTextField coachName, coachNumber, teamName, playerName;
    JButton saveButton, cancelButton;

    public addCoach() {

        label = new JLabel();
        label.setText("Add your info as Coach:");
        label.setBounds(70, 50, 300, 30);

        NameLabel = new JLabel();
        NameLabel.setText("Your Name:");
        NameLabel.setBounds(70, 100, 100, 30);

        numberLabel = new JLabel();
        numberLabel.setText("Phone Number:");
        numberLabel.setBounds(70, 150, 100, 30);

        teamLabel = new JLabel();
        teamLabel.setText("Team Name:");
        teamLabel.setBounds(70, 200, 100, 30);

        playerLabel = new JLabel();
        playerLabel.setText("Player Name:");
        playerLabel.setBounds(70, 250, 100, 30);

        messageLabel = new JLabel();
        messageLabel.setText("Your Info As A Coach Was Added Successfully!");
        messageLabel.setBounds(70, 300, 300, 30);

        coachName = new JTextField();
        coachName.setBounds(180, 100, 200, 30);
        coachName.setVisible(true);

        coachNumber = new JTextField();
        coachNumber.setBounds(180, 150, 200, 30);
        coachNumber.setVisible(true);

        teamName = new JTextField();
        teamName.setBounds(180, 200, 200, 30);
        teamName.setVisible(true);

        playerName = new JTextField();
        playerName.setBounds(180, 250, 200, 30);
        playerName.setVisible(true);

        saveButton = new JButton("Save");
        saveButton.setBounds(150, 350, 100, 40);
        saveButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(150, 400, 100, 40);
        cancelButton.addActionListener(this);

        this.setTitle("Add Your Coach Info");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.pack();
        this.setSize(500, 500);
        this.add(label);
        this.add(NameLabel);
        this.add(numberLabel);
        this.add(teamLabel);
        this.add(playerLabel);
        this.add(coachName);
        this.add(coachNumber);
        this.add(teamName);
        this.add(playerName);
        this.add(saveButton);
        this.add(cancelButton);
        this.add(messageLabel);
        messageLabel.setVisible(false);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            System.out.println("Your Coach Info Added");
            coachName.setEditable(false);
            coachNumber.setEditable(false);
            teamName.setEditable(false);
            playerName.setEditable(false);
            saveButton.setEnabled(false);
            messageLabel.setVisible(true);
            cancelButton.setText("Close");
        } else if (e.getSource() == cancelButton) {
            this.dispose();
        }
        
    }

}
