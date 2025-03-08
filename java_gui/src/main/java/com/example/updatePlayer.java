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

public class updatePlayer extends JFrame implements ActionListener {

    JLabel playerLabel, choiceLabel, newLabel, messageLabel;
    JTextField playerName, newEntry;
    JButton saveButton, backButton;
    JComboBox comboBox;

    String[] player = { "Name", "Address", "Sport", "Phone number", "Player type" };
    private String choice;

    public updatePlayer() {
        
        playerLabel = new JLabel();
        playerLabel.setText("Enter the player name:");
        playerLabel.setBounds(30, 20, 300, 30);

        playerName = new JTextField();
        playerName.setBounds(200, 20, 200, 30);

        choiceLabel = new JLabel();
        choiceLabel.setText("Select the player attribute to update:");
        choiceLabel.setBounds(30, 70, 300, 30);

        comboBox = new JComboBox(player);
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
        messageLabel.setText("Player Info Updated Successfully!");
        messageLabel.setBounds(70, 175, 300, 30);
        messageLabel.setVisible(false);

        saveButton = new JButton("Save");
        saveButton.setBounds(150, 250, 100, 40);
        saveButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(150, 300, 100, 40);
        backButton.addActionListener(this);

        this.setTitle("Update Player");
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(playerLabel);
        this.add(playerName);
        this.add(choiceLabel);
        this.add(comboBox);
        this.add(newLabel);
        this.add(newEntry);
        this.add(messageLabel);
        this.add(saveButton);
        this.add(backButton);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            choice = (String) comboBox.getSelectedItem();
            if (choice.equals(player[4])) {
                messageLabel.setVisible(true);
                messageLabel.setText("Type only 'single' or 'team' in the new value field");
            }
        } else if (e.getSource() == saveButton) {
            String name = playerName.getText();
            String newString = newEntry.getText();   
            if (name.isEmpty() || newString.isEmpty()) {
                messageLabel.setVisible(true);
                messageLabel.setText("Please fill all the fields");
            } else {
                if (choice.equals(player[0])) { //Choice is Name
                    String query = "UPDATE Players SET player_name = ? WHERE player_name = ?";
                    Connection con = null;
                    PreparedStatement st = null;
                    try {
                        con = sqlCon.sqlCon();
                        con.setAutoCommit(false);
                        st = con.prepareStatement(query);
                            st.setString(1, newString);
                            st.setString(2, name);
                        st.execute();
                        System.out.println("Player name updated to:" + newString);
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
                } else if (choice.equals(player[1])) { //Choice is Address
                    String query = "UPDATE Players SET player_address = ? WHERE player_name = ?";
                    try (Connection con = sqlCon.sqlCon();
                        PreparedStatement st = con.prepareStatement(query)) {
                            st.setString(1, newString);
                            st.setString(2, name);
                        st.execute();
                        System.out.println("Player address updated to:" + newString);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (choice.equals(player[2])) { //Choice is Sport
                    String query = "UPDATE Players SET sport_type = ? WHERE player_name = ?";
                    try (Connection con = sqlCon.sqlCon();
                        PreparedStatement st = con.prepareStatement(query)) {
                            st.setString(1, newString);
                            st.setString(2, name);
                        st.execute();
                        System.out.println("Player sport updated to:" + newString);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (choice.equals(player[3])) { //Choice is Phone number
                    String query = "UPDATE Players SET phone_number = ? WHERE player_name = ?";
                    try (Connection con = sqlCon.sqlCon();
                        PreparedStatement st = con.prepareStatement(query)) {
                            st.setString(1, newString);
                            st.setString(2, name);
                        st.execute();
                        System.out.println("Player phone number updated to:" + newString);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (choice.equals(player[4])) { //Choice is Player type
                    String query = "UPDATE Players SET player_type = ? WHERE player_name = ?";
                    try (Connection con = sqlCon.sqlCon();
                        PreparedStatement st = con.prepareStatement(query)) {
                            st.setString(1, newString);
                            st.setString(2, name);
                        st.execute();
                        System.out.println("Player type updated to:" + newString);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                messageLabel.setVisible(true);
                playerName.setEditable(false);
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
