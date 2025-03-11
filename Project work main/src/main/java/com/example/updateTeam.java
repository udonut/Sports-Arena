package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class updateTeam extends JFrame implements ActionListener {
    
    JLabel teamLabel, choiceLabel, newLabel, messageLabel;
    JTextField teamName, newEntry;
    JButton saveButton, backButton;
    JComboBox comboBox;

    String[] team = {"Team hometown", "Number of players"};
    private String teamChoice; 
        
    public updateTeam() {

        teamLabel = new JLabel();
        teamLabel.setText("Enter the team name:");
        teamLabel.setBounds(30, 20, 300, 30);

        teamName = new JTextField();
        teamName.setBounds(200, 20, 200, 30);

        choiceLabel = new JLabel();
        choiceLabel.setText("Select the team attribute to update:");
        choiceLabel.setBounds(30, 70, 300, 30);

        comboBox = new JComboBox(team);
        comboBox.setBounds(290, 70, 150, 30);
        comboBox.addActionListener(this);
        comboBox.setEditable(false);

        newLabel = new JLabel();
        newLabel.setText("Enter the new value:");
        newLabel.setBounds(30, 120, 200, 30);

        newEntry = new JTextField();
        newEntry.setBounds(200, 120, 200, 30);
        newEntry.setVisible(true);

        messageLabel = new JLabel();
        messageLabel.setText("Team Updated Successfully!");
        messageLabel.setBounds(70, 200, 300, 30);
        messageLabel.setVisible(false);

        saveButton = new JButton("Save");
        saveButton.setBounds(150, 250, 100, 40);
        saveButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(150, 300, 100, 40);
        backButton.addActionListener(this);

        this.setTitle("Update Team");
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(teamLabel);
        this.add(teamName);
        this.add(choiceLabel);
        this.add(comboBox);
        this.add(newLabel);
        this.add(newEntry);
        this.add(saveButton);
        this.add(backButton);
        this.add(messageLabel);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            teamChoice = (String) comboBox.getSelectedItem();
        } else if (e.getSource() == saveButton) {
            String name = teamName.getText();
            String newString = newEntry.getText();   
            if (name.isEmpty() || newString.isEmpty()) {
                messageLabel.setVisible(true);
                messageLabel.setText("Please fill all the fields");
            } else {
                if (teamChoice.equals(team[0])) { //Choice is Hometown
                    String query = "UPDATE Teams SET hometown = ? WHERE team_name = ?";
                    Connection con = null;
                    PreparedStatement st = null;
                    try {
                        con = sqlCon.sqlCon();
                        con.setAutoCommit(false);
                        st = con.prepareStatement(query);
                                    st.setString(1, newString);
                                    st.setString(2, name);
                                st.execute();
                                System.out.println("Team Hometown updated to:" + newString);
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
                } else if (teamChoice.equals(team[1])) { //Choice is Player Count
                    int newNumber = Integer.parseInt(newString);
                    String query = "UPDATE Teams SET player_count = ? WHERE team_name = ?";
                    try (Connection con = sqlCon.sqlCon();
                            PreparedStatement st = con.prepareStatement(query)) {
                                st.setInt(1, newNumber);
                                st.setString(2, name);
                            st.execute();
                            System.out.println("Team's number of players updated to:" + newString);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                }
                messageLabel.setVisible(true);
                teamName.setEditable(false);
                newEntry.setEditable(false);
                comboBox.setEditable(false);
                saveButton.setEnabled(false);
                backButton.setText("Close");
                messageLabel.setVisible(true);
            }
        } else if (e.getSource() == backButton) {
            this.dispose();
        } 
    }
}

