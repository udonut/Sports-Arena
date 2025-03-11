package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class audienceMenu extends JFrame implements ActionListener {

    JLabel label, showRecord;
    JButton viewEvents, viewTeams, viewArenas, viewSponsors, backButton, viewStaff, buyTicket;
    String record = new String();
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    JTable table; 

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

        viewSponsors = new JButton("View Sponsors");
        viewSponsors.setBounds(330, 70, 125, 40);
        viewSponsors.addActionListener(this);

        buyTicket = new JButton("Buy Ticket");
        buyTicket.setBounds(330, 120, 125, 40);
        buyTicket.addActionListener(this);

        backButton = new JButton("Back to start page");
        backButton.setBounds(300, 300, 150, 40);
        backButton.addActionListener(this);

        tableModel = new DefaultTableModel();

        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 180, 400, 100);

        this.setTitle("Audience Menu");
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
        this.add(scrollPane);
        this.add(viewSponsors);
        scrollPane.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewEvents) {
            DisplayRecords.displayEvents(tableModel);
            scrollPane.setVisible(true);
        } else if (e.getSource() == viewTeams) {
            DisplayRecords.displayTeams(tableModel);
            scrollPane.setVisible(true);
        } else if (e.getSource() == viewArenas) {
            DisplayRecords.displayArenas(tableModel);
            scrollPane.setVisible(true);
        } else if (e.getSource() == viewStaff) {
            DisplayRecords.displayStaff(tableModel);
            scrollPane.setVisible(true);
        } else if (e.getSource() == viewSponsors) {
            DisplayRecords.displaySponsors(tableModel);
            scrollPane.setVisible(true);
        } else if (e.getSource() == buyTicket) {
            new buyTicket();
        } else if (e.getSource() == backButton) {
            this.dispose();
            new startPage();
        }    
    }

}
