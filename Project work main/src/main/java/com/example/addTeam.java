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

//  Class to add a team

public class addTeam extends JFrame implements ActionListener {

    JLabel label, teamNameLabel, hometownLabel, countLabel, SuccessMessage;
    JTextField teamName, hometown, count;
    JButton saveButton, cancelButton;


    public addTeam() {

        label = new JLabel();
        label.setText("Add Team:");
        label.setBounds(70, 50, 300, 30);

        teamNameLabel = new JLabel();
        teamNameLabel.setText("Team Name:");
        teamNameLabel.setBounds(70, 100, 100, 30);

        hometownLabel = new JLabel();
        hometownLabel.setText("Hometown:");
        hometownLabel.setBounds(70, 150, 100, 30);

        countLabel = new JLabel();
        countLabel.setText("Count:");
        countLabel.setBounds(70, 200, 100, 30);
        
        SuccessMessage = new JLabel();
        SuccessMessage.setText("Team added successfully!");
        SuccessMessage.setBounds(70, 250, 300, 30);
        SuccessMessage.setVisible(false);

        teamName = new JTextField();
        teamName.setBounds(180, 100, 200, 30);
        teamName.setVisible(true);

        hometown = new JTextField();
        hometown.setBounds(180, 150, 200, 30);
        hometown.setVisible(true);

        count = new JTextField();
        count.setBounds(180, 200, 200, 30);
        count.setVisible(true);

        saveButton = new JButton("Save");
        saveButton.setBounds(150, 300, 100, 40);
        saveButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(150, 350, 100, 40);
        cancelButton.addActionListener(this);

        this.setTitle("Add Team");
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(500, 500);
        this.add(label);
        this.add(teamNameLabel);
        this.add(teamName);
        this.add(hometownLabel);
        this.add(hometown);
        this.add(countLabel);
        this.add(count);
        this.add(saveButton);
        this.add(cancelButton);
        this.add(SuccessMessage);
        this.setVisible(true);
        


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String name = teamName.getText();
            String town = hometown.getText();
            String pCount = count.getText();         
            if (name.isEmpty() || town.isEmpty() || pCount.isEmpty()) {
                SuccessMessage.setVisible(true);
                SuccessMessage.setText("Please fill all the fields");
            } else {
                int playerCount = Integer.parseInt(pCount);
                String query = "INSERT INTO Teams (team_name, hometown, player_count) VALUES (?, ?, ?)";
                Connection con = null;
                PreparedStatement st = null;
                try {
                    con = sqlCon.sqlCon();
                    con.setAutoCommit(false);
                    st = con.prepareStatement(query);
                        st.setString(1, name);
                        st.setString(2, town);
                        st.setInt(3, playerCount);
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
            System.out.println("Team added");
            teamName.setEditable(false);
            hometown.setEditable(false);
            count.setEditable(false);
            saveButton.setEnabled(false);
            SuccessMessage.setVisible(true);
                cancelButton.setText("Close");
            }
        } else if (e.getSource() == cancelButton) {
            this.dispose();
        }
    }
}
