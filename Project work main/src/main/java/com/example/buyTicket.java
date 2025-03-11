package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//  Class to buy a ticket

public class buyTicket extends JFrame implements ActionListener {

    JLabel label, ticketLabel, ownerLabel, eventLabel, seatLabel, messageLabel;
    JTextField ticketID, ownerName, seatNumber;
    JButton saveButton, cancelButton;
    JComboBox comboBox;
    String[] eventName = {};
    ArrayList<String> events = new ArrayList<>(); 
    private String choice;

    public buyTicket() {

        label = new JLabel();
        label.setText("Buy your ticket here (only 1 ticket per person):");
        label.setBounds(70, 50, 300, 30);

        ticketLabel = new JLabel();
        ticketLabel.setText("Ticket ID:");
        ticketLabel.setBounds(40, 100, 100, 30);

        ticketID = new JTextField();
        ticketID.setBounds(200, 100, 200, 30);
        ticketID.setVisible(true);
        
        eventLabel = new JLabel();
        eventLabel.setText("Event Name:");
        eventLabel.setBounds(40, 150, 100, 30);        

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = sqlCon.sqlCon();
            con.setAutoCommit(false);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Event");
            while (rs.next()) {
                events.add(rs.getString("event_name"));
            }
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
        eventName = events.toArray(eventName);

        comboBox = new JComboBox(eventName);
        comboBox.setBounds(200, 150, 250, 30);
        comboBox.addActionListener(this);

        ownerLabel = new JLabel();
        ownerLabel.setText("Your Name:");
        ownerLabel.setBounds(40, 200, 100, 30);

        ownerName = new JTextField();
        ownerName.setBounds(200, 200, 200, 30);
        ownerName.setVisible(true);

        seatLabel = new JLabel();
        seatLabel.setText("Seat Row Number(1-25):");
        seatLabel.setBounds(40, 250, 200, 30);

        seatNumber = new JTextField();
        seatNumber.setBounds(200, 250, 200, 30);
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
        this.add(ticketID);
        this.add(comboBox);
        this.add(ownerLabel);
        this.add(eventLabel);
        this.add(seatLabel);
        this.add(ownerName);
        this.add(seatNumber);
        this.add(saveButton);
        this.add(cancelButton);
        this.add(messageLabel);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            choice = (String) comboBox.getSelectedItem();
        } else if (e.getSource() == saveButton) {
            String tID = ticketID.getText();
            String oName = ownerName.getText();
            String sNumber = seatNumber.getText();         
            if (tID.isEmpty() || oName.isEmpty() || sNumber.isEmpty()) {
                messageLabel.setVisible(true);
                messageLabel.setText("Please fill all the fields");
            } else {
                int TicketIDNumber = Integer.parseInt(tID);
                int seatRow = Integer.parseInt(sNumber);
                String query = "INSERT INTO Ticket (ticket_id, ticket_owner, price, event_name, seat_number) VALUES (?, ?, ?, ?, ?)";
                Connection con = null;
                PreparedStatement st = null;
                try {
                    con = sqlCon.sqlCon();
                    con.setAutoCommit(false);
                    st = con.prepareStatement(query);
                        st.setInt(1, TicketIDNumber);
                        st.setString(2, oName);
                        st.setFloat(3, 10.00f);
                        st.setString(4, choice);
                        st.setInt(5, seatRow);
                    st.execute();
                    System.out.println("Team Info Added");
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
            comboBox.setEnabled(false);
            ticketID.setEnabled(false);
            ownerName.setEnabled(false);
            seatNumber.setEnabled(false);
            saveButton.setEnabled(false);
            cancelButton.setText("Close");
            messageLabel.setVisible(true);
            }
        } else if (e.getSource() == cancelButton) {
            this.dispose();
        }    
    }

}
