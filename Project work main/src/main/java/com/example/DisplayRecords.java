package com.example;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;


// All the classes that are used to view different records are constructed here
public class DisplayRecords { 
    public static void displayManagers(DefaultTableModel tableModel) { // display all the managers
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {con = sqlCon.sqlCon();
            con.setAutoCommit(false);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Managers");
            tableModel.setColumnCount(0);
            tableModel.addColumn("Manager's name");
            tableModel.addColumn("Phone number");
            tableModel.addColumn("Coach's name");
            tableModel.addColumn("Email");
            tableModel.setRowCount(0);
            while (rs.next()) {
                tableModel.addRow(new Object[] {
                    rs.getString("manager_name"),
                    rs.getString("phone_number"),
                    rs.getString("coach_name"),
                    rs.getString("email")
                });
            }
            con.commit();
        } catch (SQLException se) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void displayCoaches(DefaultTableModel tableModel) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {con = sqlCon.sqlCon();
            con.setAutoCommit(false);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Coach");
            tableModel.setColumnCount(0);
            tableModel.addColumn("Coach name");
            tableModel.addColumn("Phone number");
            tableModel.addColumn("Team name");
            tableModel.addColumn("Player name");
            tableModel.setRowCount(0);
            while (rs.next()) {
                tableModel.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                });
            }
            con.commit();
        } catch (SQLException se) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void displayTeams(DefaultTableModel tableModel) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {con = sqlCon.sqlCon();
            con.setAutoCommit(false);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Teams");
            tableModel.setColumnCount(0);
            tableModel.addColumn("Team name");
            tableModel.addColumn("Hometown");
            tableModel.addColumn("Number of players");
            tableModel.setRowCount(0);
            while (rs.next()) {
                tableModel.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3)
                });
            }
            con.commit();
        } catch (SQLException se) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void displayArenas(DefaultTableModel tableModel) { // Display all the arenas
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {con = sqlCon.sqlCon();
            con.setAutoCommit(false);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Arena");
            tableModel.setColumnCount(0);
            tableModel.addColumn("Arena name");
            tableModel.addColumn("Capacity");
            tableModel.addColumn("Location");
            tableModel.addColumn("Phone number");
            tableModel.setRowCount(0);
            while (rs.next()) {
                tableModel.addRow(new Object[] {
                    rs.getString(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4)
                });
            }
            con.commit();
        } catch (SQLException se) {
            if (con != null) {
                try {
                    con.rollback(); // Rollback transaction on error
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void displayEvents(DefaultTableModel tableModel) { // Display all the games
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {con = sqlCon.sqlCon();
            con.setAutoCommit(false);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Event");
            tableModel.setColumnCount(0);
            tableModel.addColumn("Event name");
            tableModel.addColumn("Arena name");
            tableModel.addColumn("Manager's name");
            tableModel.addColumn("Ticket ID");
            tableModel.setRowCount(0);
            while (rs.next()) {
                tableModel.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                });
            }
            con.commit();
        } catch (SQLException se) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void displayStaff(DefaultTableModel tableModel) { // Display all staff members
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {con = sqlCon.sqlCon();
            con.setAutoCommit(false);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Staff");
            tableModel.setColumnCount(0);
            tableModel.addColumn("Staff name");
            tableModel.addColumn("Staff role");
            tableModel.addColumn("Phone number");
            tableModel.addColumn("Arena name");
            tableModel.setRowCount(0);
            while (rs.next()) {
                tableModel.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                });
            }
            con.commit();
        } catch (SQLException se) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void displayPlayers(DefaultTableModel tableModel) { // Display all players
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {con = sqlCon.sqlCon();
            con.setAutoCommit(false);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Players");
            tableModel.setColumnCount(0);
            tableModel.addColumn("Player name");
            tableModel.addColumn("Player address");
            tableModel.addColumn("Sport type");
            tableModel.addColumn("Phone number");
            tableModel.addColumn("Player type");
            tableModel.setRowCount(0);
            while (rs.next()) {
                tableModel.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                });
            }
            con.commit();
        } catch (SQLException se) {
            if (con != null) {
                try {
                    con.rollback(); 
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void displaySponsors(DefaultTableModel tableModel) { // Display all the sponsors
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {con = sqlCon.sqlCon();
            con.setAutoCommit(false);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Sponsors");
            tableModel.setColumnCount(0);
            tableModel.addColumn("Sponsor name");
            tableModel.addColumn("Contact info");
            tableModel.addColumn("Amount");
            tableModel.setRowCount(0);
            while (rs.next()) {
                tableModel.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                });
            }
            con.commit();
        } catch (SQLException se) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void displayAudience(DefaultTableModel tableModel) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {con = sqlCon.sqlCon();
            con.setAutoCommit(false);
            st = con.createStatement(); 
            rs = st.executeQuery("SELECT * FROM Ticket");

            tableModel.setColumnCount(0);
            tableModel.addColumn("Ticket ID");
            tableModel.addColumn("Name");
            tableModel.addColumn("Ticket price");
            tableModel.addColumn("Event");
            tableModel.addColumn("Seat number");
            tableModel.setRowCount(0);

            while (rs.next()) {
                tableModel.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                });
            }
            con.commit();
        } catch (SQLException se) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


