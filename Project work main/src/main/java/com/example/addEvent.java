package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//  Class to add an event

public class addEvent extends JFrame implements ActionListener {

    JButton saveButton, cancelButton; 
    JLabel label, eventNameLabel, arenaNameLabel, managerNameLabel, ticketNumber, messageLabel;   
    JTextField eventName, arenaName, managerName, ticketId;

    public addEvent() {

        label = new JLabel();
        label.setText("Add Event:");
        label.setBounds(70, 50, 300, 30);

        messageLabel = new JLabel();
        messageLabel.setText("Event added successfully!");
        messageLabel.setBounds(70, 300, 300, 30);
        messageLabel.setVisible(false);

        eventNameLabel = new JLabel();
        eventNameLabel.setText("Event Name:");
        eventNameLabel.setBounds(70, 100, 100, 30);

        arenaNameLabel = new JLabel();
        arenaNameLabel.setText("Arena Name:");
        arenaNameLabel.setBounds(70, 150, 100, 30);

        managerNameLabel = new JLabel();
        managerNameLabel.setText("Manager Name:");
        managerNameLabel.setBounds(70, 200, 100, 30);

        ticketNumber = new JLabel();
        ticketNumber.setText("Ticket ID:");
        ticketNumber.setBounds(70, 250, 100, 30);

        
        eventName = new JTextField();
        eventName.setBounds(180, 100, 200, 30);
        eventName.setVisible(true);

        arenaName = new JTextField();
        arenaName.setBounds(180, 150, 200, 30);
        arenaName.setVisible(true);

        managerName = new JTextField();
        managerName.setBounds(180, 200, 200, 30);
        managerName.setVisible(true);

        ticketId = new JTextField();
        ticketId.setBounds(180, 250, 200, 30);
        ticketId.setVisible(true);

        saveButton = new JButton("Submit");
        saveButton.setBounds(75, 350, 100, 40);
        saveButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 350, 100, 40);
        cancelButton.addActionListener(this);

        this.setTitle("Add Event Page");
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
        this.add(saveButton);
        this.add(cancelButton);
        this.add(ticketNumber);
        this.add(ticketId);
        this.add(messageLabel);

    } 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String name = eventName.getText();
            String aName = arenaName.getText();
            String mName = managerName.getText();
            String tID = ticketId.getText();    
            if (name.isEmpty() || aName.isEmpty() || mName.isEmpty() || tID.isEmpty()) {
                messageLabel.setVisible(true);
                messageLabel.setText("Please fill all the fields");
            } else {
                int ticket = Integer.parseInt(tID);
                String query = "INSERT INTO Event (event_name, arena_name, manager_name, ticket_id)  VALUES (?, ?, ?, ?)";
                Connection con = null;
                PreparedStatement st = null;
                try {
                    con = sqlCon.sqlCon();
                    con.setAutoCommit(false);
                    st = con.prepareStatement(query);
                        st.setString(1, name);
                        st.setString(2, aName);
                        st.setString(3, mName);
                        st.setInt(4, ticket);
                    st.execute();
                    System.out.println("Event Info Added");
                    con.commit();
                } catch (SQLException se) {
                    if (con != null) {
                        try {
                            con.rollback();
                        } catch (SQLException ee) {
                            ee.printStackTrace();
                        }
                    }
                }
                System.out.println("Event added");
                messageLabel.setVisible(true);
                cancelButton.setText("Close");
                saveButton.setEnabled(false);
                eventName.setEnabled(false);
                arenaName.setEnabled(false);
                managerName.setEnabled(false);
                ticketId.setEnabled(false);
            }
        } else if (e.getSource() == cancelButton) {
            this.dispose();

        }
    }
 
}
