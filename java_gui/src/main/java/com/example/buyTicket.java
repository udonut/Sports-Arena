package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class buyTicket extends JFrame implements ActionListener {

    JLabel label, ticketLabel, ownerLabel, eventLabel, seatLabel, messageLabel;
    JTextField ticketNumber, ownerName, eventName, seatNumber;
    JButton saveButton, cancelButton;

    public buyTicket() {

        label = new JLabel();
        label.setText("Buy your ticket here (only 1 ticket per person):");
        label.setBounds(70, 50, 300, 30);

        ticketLabel = new JLabel();
        ticketLabel.setText("Event's ticket ID:");
        ticketLabel.setBounds(70, 100, 100, 30);

        ticketNumber = new JTextField();
        ticketNumber.setBounds(180, 100, 200, 30);
        ticketNumber.setVisible(true);

        ownerLabel = new JLabel();
        ownerLabel.setText("Your Name:");
        ownerLabel.setBounds(70, 150, 100, 30);

        ownerName = new JTextField();
        ownerName.setBounds(180, 150, 200, 30);
        ownerName.setVisible(true);

        eventLabel = new JLabel();
        eventLabel.setText("Event Name:");
        eventLabel.setBounds(70, 200, 100, 30);

        eventName = new JTextField();
        eventName.setBounds(180, 200, 200, 30);
        eventName.setVisible(true);

        seatLabel = new JLabel();
        seatLabel.setText("Seat Row Number(1-25):");
        seatLabel.setBounds(70, 250, 100, 30);

        seatNumber = new JTextField();
        seatNumber.setBounds(180, 250, 200, 30);
        seatNumber.setVisible(true);

        saveButton = new JButton("Save");
        saveButton.setBounds(150, 350, 100, 40);
        saveButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(300, 350, 100, 40);
        cancelButton.addActionListener(this);

        messageLabel = new JLabel();
        messageLabel.setText("Your Ticket Was Bought Successfully. The ticket price is 10e." );
        messageLabel.setBounds(50, 300, 600, 30);
        messageLabel.setVisible(false);

        this.setTitle("Buy Your Ticket");
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(label);
        this.add(ticketLabel);
        this.add(ownerLabel);
        this.add(eventLabel);
        this.add(seatLabel);
        this.add(ticketNumber);
        this.add(ownerName);
        this.add(eventName);
        this.add(seatNumber);
        this.add(saveButton);
        this.add(cancelButton);
        this.add(messageLabel);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            ticketNumber.setEnabled(false);
            ownerName.setEnabled(false);
            eventName.setEnabled(false);
            seatNumber.setEnabled(false);
            saveButton.setEnabled(false);
            cancelButton.setText("Close");
            messageLabel.setVisible(true);
        } else if (e.getSource() == cancelButton) {
            this.dispose();
        }    
    }

}
