package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


//Frame showing the menu for the manager

public class managerMenu extends JFrame implements ActionListener {
    
    JLabel label, showRecord;
    JButton eventButton, viewTeams, viewArenas, viewCoaches, addEvent, viewSponsors, backButton;
    JButton viewManagers, addManager, viewAudience;
    String record = new String(); 
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    JTable table;
        
    public managerMenu() {

        label = new JLabel();
        label.setText("Choose your option:");
        label.setBounds(70, 20, 300, 30);

        showRecord = new JLabel();
        showRecord.setText(record);
        showRecord.setBounds(70, 230, 500, 30);
        setVisible(false);

        eventButton = new JButton("View Events");
        eventButton.setBounds(30, 70, 125, 40);
        eventButton.addActionListener(this);

        addEvent = new JButton("Add Event");
        addEvent.setBounds(30, 120, 125, 40);
        addEvent.addActionListener(this);

        viewSponsors = new JButton("View Sponsors");
        viewSponsors.setBounds(30, 170, 125, 40);
        viewSponsors.addActionListener(this);

        viewTeams = new JButton("View Teams");
        viewTeams.setBounds(180, 70, 125, 40);
        viewTeams.addActionListener(this);

        viewArenas = new JButton("View Arenas");
        viewArenas.setBounds(180, 120, 125, 40);
        viewArenas.addActionListener(this);

        viewAudience = new JButton("View Audience");
        viewAudience.setBounds(180, 170, 125, 40);
        viewAudience.addActionListener(this);

        viewCoaches = new JButton("View Coaches");
        viewCoaches.setBounds(330, 70, 125, 40);
        viewCoaches.addActionListener(this);

        viewManagers = new JButton("View Managers");
        viewManagers.setBounds(330, 120, 125, 40);
        viewManagers.addActionListener(this);

        addManager = new JButton("Add your info");
        addManager.setBounds(330, 170, 125, 40);
        addManager.addActionListener(this);

        backButton = new JButton("Back to start page");
        backButton.setBounds(300, 350, 150, 40);
        backButton.addActionListener(this);

        tableModel = new DefaultTableModel();

        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 230, 400, 100);

        this.setTitle("Manager Menu");
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(label);
        this.add(eventButton);
        this.add(viewTeams);
        this.add(viewArenas);
        this.add(viewAudience);
        this.add(addEvent);
        this.add(viewSponsors);
        this.add(backButton);
        this.add(showRecord);
        this.add(viewCoaches);
        this.add(viewManagers);
        this.add(addManager);
        this.add(scrollPane);
        scrollPane.setVisible(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == eventButton) {
            DisplayRecords.displayEvents(tableModel);
            scrollPane.setVisible(true);
        } else if (e.getSource() == viewTeams) {
            DisplayRecords.displayTeams(tableModel);
            scrollPane.setVisible(true);
        } else if (e.getSource() == viewArenas) {
            DisplayRecords.displayArenas(tableModel);
            scrollPane.setVisible(true);
        } else if (e.getSource() == viewAudience) {
            DisplayRecords.displayAudience(tableModel);
            scrollPane.setVisible(true);
        } else if (e.getSource() == viewCoaches) {
            DisplayRecords.displayCoaches(tableModel);
            scrollPane.setVisible(true);
        } else if (e.getSource() == addEvent) {
            System.out.println("Add Event");
            new addEvent();
        } else if (e.getSource() == viewSponsors) {
            DisplayRecords.displaySponsors(tableModel);
            scrollPane.setVisible(true);
            System.out.println("Sponsors showed");
        } else if (e.getSource() == viewManagers) {
            scrollPane.setVisible(true);
            DisplayRecords.displayManagers(tableModel);
        } else if (e.getSource() == addManager) {
            System.out.println("Add Manager");
            new managerLogin();
        } else if (e.getSource() == backButton) {
            System.out.println("Go Back");
            this.dispose();
            new startPage();
        }
    }


    public static void main(String[] args) {
        new managerMenu();
    }


}