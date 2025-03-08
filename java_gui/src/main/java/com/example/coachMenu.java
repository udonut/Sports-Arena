package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class coachMenu extends JFrame implements ActionListener {

    JFrame frame;
    JLabel label, showRecord;
    JButton viewCoaches, addCoach, viewEvents, backButton;
    JButton viewPlayers, addPlayer, updatePlayer, removePlayer;
    JButton viewTeams, addTeam, updateTeam, removeTeam;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    JTable table; 

    String record = new String(); 
        
    public coachMenu() {

        label = new JLabel();
        label.setText("Choose your option:");
        label.setBounds(70, 20, 300, 30);

        showRecord = new JLabel();
        showRecord.setText(record);
        showRecord.setBounds(70, 300, 300, 30);
        setVisible(false);

        viewCoaches = new JButton("View Coaches");
        viewCoaches.setBounds(30, 120, 125, 40);
        viewCoaches.addActionListener(this);

        viewEvents = new JButton("View Events");
        viewEvents.setBounds(30, 70, 125, 40);
        viewEvents.addActionListener(this);

        addCoach = new JButton("Add Coach");
        addCoach.setBounds(30, 170, 125, 40);
        addCoach.addActionListener(this);

        //Team menu
        viewTeams = new JButton("View Teams");
        viewTeams.setBounds(180, 70, 125, 40);
        viewTeams.addActionListener(this);

        addTeam = new JButton("Add Team");
        addTeam.setBounds(180, 120, 125, 40);
        addTeam.addActionListener(this);

        updateTeam = new JButton("Update Team");
        updateTeam.setBounds(180, 170, 125, 40);
        updateTeam.addActionListener(this);

        //Player menu
        viewPlayers = new JButton("View Players");
        viewPlayers.setBounds(330, 70, 125, 40);
        viewPlayers.addActionListener(this);

        addPlayer = new JButton("Add Player");
        addPlayer.setBounds(330, 120, 125, 40);
        addPlayer.addActionListener(this);

        updatePlayer = new JButton("Update Player");
        updatePlayer.setBounds(330, 170, 125, 40);
        updatePlayer.addActionListener(this);

        backButton = new JButton("Back to start page");
        backButton.setBounds(300, 400, 150, 40);
        backButton.addActionListener(this);

        tableModel = new DefaultTableModel();

        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 270, 400, 100);


        this.setTitle("Coach Menu");
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(label);
        this.add(viewEvents);
        this.add(viewCoaches);
        this.add(addCoach);
        this.add(viewTeams);
        this.add(addTeam);
        this.add(updateTeam);
        this.add(viewPlayers);
        this.add(addPlayer);
        this.add(updatePlayer);
        this.add(backButton);
        this.add(showRecord);
        this.add(scrollPane);
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
        } else if (e.getSource() == addTeam) {
            System.out.println("Add Team");
            new addTeam();
        } else if (e.getSource() == updateTeam) {
            System.out.println("Update Team");
            new updateTeam();
        } else if (e.getSource() == viewCoaches) {
            DisplayRecords.displayCoaches(tableModel);
            scrollPane.setVisible(true);
        } else if (e.getSource() == addCoach) {
            System.out.println("Add Coach");
            new addCoach();
        } else if (e.getSource() == viewPlayers) {
            DisplayRecords.displayPlayers(tableModel);
            scrollPane.setVisible(true);
        } else if (e.getSource() == addPlayer) {
            System.out.println("Add Player");
            new addPlayer();
        } else if (e.getSource() == updatePlayer) {
            System.out.println("Update Player");
            new updatePlayer();
        } else if (e.getSource() == backButton) {
            System.out.println("Go Back");
            this.dispose();
            new startPage();
        } 
    }

}
