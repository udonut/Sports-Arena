package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class managerMenu extends JFrame implements ActionListener {
    
    JLabel label, showRecord;
    JButton eventButton, viewTeams, viewArenas, viewCoaches, addEvent, removeEvent, backButton;
    JButton viewManagers, addManager;
    String record = new String(); 
        
    public managerMenu() {

        label = new JLabel();
        label.setText("Choose your option:");
        label.setBounds(70, 20, 300, 30);

        showRecord = new JLabel();
        showRecord.setText(record);
        showRecord.setBounds(70, 300, 300, 30);
        setVisible(false);

        eventButton = new JButton("View Events");
        eventButton.setBounds(30, 70, 125, 40);
        eventButton.addActionListener(this);

        addEvent = new JButton("Add Event");
        addEvent.setBounds(30, 120, 125, 40);
        addEvent.addActionListener(this);

        removeEvent = new JButton("Remove Event");
        removeEvent.setBounds(30, 170, 125, 40);
        removeEvent.addActionListener(this);

        viewTeams = new JButton("View Teams");
        viewTeams.setBounds(180, 70, 125, 40);
        viewTeams.addActionListener(this);

        viewArenas = new JButton("View Arenas");
        viewArenas.setBounds(180, 120, 125, 40);
        viewArenas.addActionListener(this);

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
        this.add(addEvent);
        this.add(removeEvent);
        this.add(backButton);
        this.add(showRecord);
        this.add(viewCoaches);
        this.add(viewManagers);
        this.add(addManager);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == eventButton) {
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
        } else if (e.getSource() == viewCoaches) {
            showRecord.setVisible(true);
            record = "Coaches";
            showRecord.setText(record);
        } else if (e.getSource() == addEvent) {
            System.out.println("Add Event");
            new addEvent();
        } else if (e.getSource() == removeEvent) {
            System.out.println("Remove Event");
            new removeEvent();
        } else if (e.getSource() == viewManagers) {
            showRecord.setVisible(true);
            record = "Managers";
            showRecord.setText(record);
        } else if (e.getSource() == addManager) {
            System.out.println("Add Manager");
            new managerLogin();
        } else if (e.getSource() == backButton) {
            System.out.println("Go Back");
            this.dispose();
            new startPage();
        }
    }
}