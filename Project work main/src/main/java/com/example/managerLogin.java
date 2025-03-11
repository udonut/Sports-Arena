package com.example;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class managerLogin extends JFrame implements ActionListener {
    
    JButton saveButton, cancelButton;
    ArrayList<String> managerDetails = new ArrayList<String>();  
    JLabel label, labelName, labelNumber, labelCoach, labelEmail, messageLabel;   
    JTextField name, number, coachName, email;

    public managerLogin() {

        label = new JLabel();
        label.setText("Enter your details for Login:");
        label.setBounds(70, 50, 300, 30);

        labelName = new JLabel();
        labelName.setText("Name:");
        labelName.setBounds(70, 100, 100, 30);

        labelNumber = new JLabel();
        labelNumber.setText("Phone Number:");
        labelNumber.setBounds(70, 150, 100, 30);

        labelCoach = new JLabel();
        labelCoach.setText("Coach Name:");
        labelCoach.setBounds(70, 200, 100, 30);

        labelEmail = new JLabel();
        labelEmail.setText("Email:");
        labelEmail.setBounds(70, 250, 100, 30);
        
        name = new JTextField();
        name.setBounds(180, 100, 200, 30);
        name.setVisible(true);

        number = new JTextField();
        number.setPreferredSize( new Dimension( 200, 24 ) );
        number.setBounds(180, 150, 200, 30);
        number.setVisible(true);

        coachName = new JTextField();
        coachName.setBounds(180, 200, 200, 30);
        coachName.setVisible(true);

        email = new JTextField();
        email.setBounds(180, 250, 200, 30);
        email.setVisible(true);

        saveButton = new JButton("Save");
        saveButton.setBounds(125, 300, 100, 40);
        saveButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(2750, 300, 100, 40);
        cancelButton.addActionListener(this);

        messageLabel = new JLabel();
        messageLabel.setText("Your Info As A Manager Was Added Successfully!");
        messageLabel.setBounds(70, 350, 300, 30);

        this.setTitle("Add Your Own Manager Info");
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(labelName);
        this.add(labelNumber);
        this.add(labelEmail);
        this.add(label);
        this.add(name);
        this.add(number);
        this.add(email);
        this.add(saveButton);
        this.add(cancelButton);
        this.add(messageLabel);
        this.add(labelCoach);
        this.add(coachName);
        messageLabel.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String mName = name.getText();
            String mNumber = number.getText();
            String cName = coachName.getText(); 
            String eMail = email.getText();        
            if (mName.isEmpty() || mNumber.isEmpty() || cName.isEmpty() || eMail.isEmpty()) {
                messageLabel.setVisible(true);
                messageLabel.setText("Please fill all the fields");
            } else {
                String query = "INSERT INTO Managers (manager_name, phone_number, coach_name, email) VALUES (?, ?, ?, ?)";
                Connection con = null;
                PreparedStatement st = null;
                try {
                    con = sqlCon.sqlCon();
                    con.setAutoCommit(false);
                    st = con.prepareStatement(query);
                        st.setString(1, mName);
                        st.setString(2, mNumber);
                        st.setString(3, cName);
                        st.setString(4, eMail);
                    st.execute();
                    System.out.println("Manager Info Added");
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
                System.out.println("Your Manager Info Added");
                name.setEditable(false);
                number.setEditable(false);
                email.setEditable(false);
                saveButton.setEnabled(false);
                messageLabel.setVisible(true);
                cancelButton.setText("Close");
            }
        } else if (e.getSource() == cancelButton) {
            this.dispose();
        }
    }

}
