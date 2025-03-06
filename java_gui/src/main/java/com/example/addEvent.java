package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class addEvent extends JFrame implements ActionListener {

    JButton saveButton, cancelButton; 
    JLabel label, eventNameLabel, eventTypeText, arenaNameLabel, managerNameLabel, ticketNumber, messageLabel;   
    JTextField eventName, eventType, arenaName, managerName, ticketId;

    public addEvent() {

        label = new JLabel();
        label.setText("Add Event:");
        label.setBounds(70, 50, 300, 30);

        messageLabel = new JLabel();
        messageLabel.setText("Event added successfully!");
        messageLabel.setBounds(70, 350, 300, 30);
        messageLabel.setVisible(false);

        eventNameLabel = new JLabel();
        eventNameLabel.setText("Event Name:");
        eventNameLabel.setBounds(70, 100, 100, 30);

        eventTypeText = new JLabel();
        eventTypeText.setText("Event Type:");
        eventTypeText.setBounds(70, 150, 100, 30);

        arenaNameLabel = new JLabel();
        arenaNameLabel.setText("Arena Name:");
        arenaNameLabel.setBounds(70, 200, 100, 30);

        managerNameLabel = new JLabel();
        managerNameLabel.setText("Manager Name:");
        managerNameLabel.setBounds(70, 250, 100, 30);

        ticketNumber = new JLabel();
        ticketNumber.setText("Ticket ID:");
        ticketNumber.setBounds(70, 300, 100, 30);

        
        eventName = new JTextField();
        eventName.setBounds(180, 100, 200, 30);
        eventName.setVisible(true);

        eventType = new JTextField();
        eventType.setBounds(180, 150, 200, 30);
        eventType.setVisible(true);

        arenaName = new JTextField();
        arenaName.setBounds(180, 200, 200, 30);
        arenaName.setVisible(true);

        managerName = new JTextField();
        managerName.setBounds(180, 250, 200, 30);
        managerName.setVisible(true);

        ticketId = new JTextField();
        ticketId.setBounds(180, 300, 200, 30);
        ticketId.setVisible(true);

        saveButton = new JButton("Submit");
        saveButton.setBounds(75, 400, 100, 40);
        saveButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 400, 100, 40);
        cancelButton.addActionListener(this);

        this.setTitle("Manager Login");
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(eventNameLabel);
        this.add(arenaNameLabel);
        this.add(managerNameLabel);
        this.add(label);
        this.add(eventName);
        this.add(arenaName);
        this.add(managerName);
        this.add(eventTypeText);
        this.add(saveButton);
        this.add(cancelButton);
        this.add(eventType);
        this.add(ticketNumber);
        this.add(ticketId);
        this.add(messageLabel);

    } 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            System.out.println("Event added");
            messageLabel.setVisible(true);
            cancelButton.setText("Close");
            saveButton.setEnabled(false);
            eventName.setEnabled(false);
            eventType.setEnabled(false);
            arenaName.setEnabled(false);
            managerName.setEnabled(false);
            ticketId.setEnabled(false);

        } else if (e.getSource() == cancelButton) {
            this.dispose();

        }
    }


}
