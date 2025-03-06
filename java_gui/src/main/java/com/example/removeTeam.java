package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class removeTeam extends JFrame implements ActionListener {

    JButton saveButton, cancelButton; 
    JLabel label, teamNameLabel, endMessageLabel;   
    JTextField teamName;


    public removeTeam() {

        label = new JLabel();
        label.setText("Remove Team:");
        label.setBounds(70, 50, 300, 30);

        teamNameLabel = new JLabel();
        teamNameLabel.setText("Team Name:");
        teamNameLabel.setBounds(70, 100, 100, 30);

        endMessageLabel = new JLabel();
        endMessageLabel.setText("Team removed Successfully!");
        endMessageLabel.setBounds(70, 150, 300, 30);

        teamName = new JTextField();
        teamName.setBounds(180, 100, 200, 30);
        teamName.setVisible(true);

        saveButton = new JButton("Save");
        saveButton.setBounds(150, 200, 100, 40);
        saveButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(150, 250, 100, 40);
        cancelButton.addActionListener(this);
        
        this.setTitle("Remove Team");
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(500, 500);
        this.add(label);
        this.add(teamNameLabel);
        this.add(teamName);
        this.add(saveButton);
        this.add(cancelButton);
        this.add(endMessageLabel);
        endMessageLabel.setVisible(false);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            System.out.println("Team removed");
            teamName.setEditable(false);
            saveButton.setEnabled(false);
            endMessageLabel.setVisible(true);
            cancelButton.setText("Close");   
        } else if (e.getSource() == cancelButton) {
            this.dispose();
        }
    }

}
