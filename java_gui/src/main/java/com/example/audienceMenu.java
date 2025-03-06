package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class audienceMenu extends JFrame implements ActionListener {

    JLabel label, showRecord;
    JButton viewEvents, viewTeams, viewArenas, backButton, viewStaff, buyTicket;
    String record = new String(); 

    public audienceMenu() {

        label = new JLabel();
        label.setText("Choose your option:");
        label.setBounds(70, 20, 300, 30);
        label.setVisible(true);

        showRecord = new JLabel();
        showRecord.setText(record);
        showRecord.setBounds(70, 300, 300, 30);
        showRecord.setVisible(false);

        viewEvents = new JButton("View Events");
        viewEvents.setBounds(30, 70, 125, 40);
        viewEvents.addActionListener(this);

        viewTeams = new JButton("View Teams");
        viewTeams.setBounds(30, 120, 125, 40);
        viewTeams.addActionListener(this);

        viewArenas = new JButton("View Arenas");
        viewArenas.setBounds(180, 70, 125, 40);
        viewArenas.addActionListener(this);

        viewStaff = new JButton("View Staff");
        viewStaff.setBounds(180, 120, 125, 40);
        viewStaff.addActionListener(this);

        buyTicket = new JButton("Buy Ticket");
        buyTicket.setBounds(330, 70, 125, 40);
        buyTicket.addActionListener(this);

        backButton = new JButton("Back to start page");
        backButton.setBounds(300, 250, 150, 40);
        backButton.addActionListener(this);

        this.setTitle("Manager Menu");
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(label);
        this.add(viewEvents);
        this.add(viewTeams);
        this.add(viewArenas);
        this.add(viewStaff);
        this.add(backButton);
        this.add(showRecord);
        this.add(buyTicket);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewEvents) {
            showRecord.setVisible(true);
            record = "Events";
            showRecord.setText(record);
        } else if (e.getSource() == viewTeams) {
            showRecord.setVisible(true);
            record = "Teams";
            showRecord.setText(record);
        } else if (e.getSource() == viewArenas) {
            showRecord.setVisible(true);
            record = "Arenas";
            showRecord.setText(record);
        } else if (e.getSource() == viewStaff) {
            showRecord.setVisible(true);
            record = "Staff";
            showRecord.setText(record);
        } else if (e.getSource() == buyTicket) {
            new buyTicket();
        } else if (e.getSource() == backButton) {
            this.dispose();
            new startPage();
        }    
    }

}
