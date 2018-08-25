import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class MemberBioData extends JFrame implements ActionListener {
    //JButton saveButton, clearButton, closeButton;
    JButton[] buttons;
    // JTextField firstNameField, lastNameField, departmentField, matricNumField;
    JTextField[] fields;
    // JLabel firstName, lastName, department, matricNum;
    JLabel[] labels;

    GridBagLayout gbl;
    GridBagConstraints gbc;

    Connection connect;
    PreparedStatement pstmt;
    ResultSet rs;

    public MemberBioData() {
        super();
        setTitle("Member Bio Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setBounds(100, 100, 600, 400);

        // buttons
        String[] buttonText = {"Save", "Clear", "Close"};
        buttons = new JButton[3];
        for (int i = 0, j =  buttonText.length; i < j; i++) {
            // create buttons
            buttons[i] = new JButton(buttonText[i]);
            buttons[i].addActionListener(this);
        }
        
        // labels
        String[] labelText = {"First Name", "Last Name", "Department", "Matriculation Number"};
        labels = new JLabel[4];
        for (int i = 0, j =  labelText.length; i < j; i++) {
            // create labels
            labels[i] = new JLabel(labelText[i]);
        }

        // text fields
        int[] fieldsLength = {15, 15, 20, 10};
        fields = new JTextField[4];
        for (int i = 0, j =  fieldsLength.length; i < j; i++) {
            // create fields
            fields[i] = new JTextField(fieldsLength[i]);
            // fields[i].addActionListener(this);
        }        

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();

        // create panels
        JPanel allPanel = new JPanel();
        allPanel.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel southPanel =  new JPanel();

        // north panel
        //northPanel.setLayout(gbl);
        northPanel.setBackground(Color.CYAN);
        allPanel.add(northPanel, BorderLayout.NORTH);
        
        // center panel
        centerPanel.setLayout(gbl);
        for (int i = 0, j = fields.length; i < j; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            centerPanel.add(labels[i], gbc);
            gbc.gridx++;
            centerPanel.add(fields[i], gbc);
            gbc.gridx--;
        }
        centerPanel.setBackground(Color.CYAN);
        allPanel.add(centerPanel, BorderLayout.CENTER);

        // south panel
        for (int i = 0, j = buttons.length; i < j; i++) {
            gbc.gridx = i;
            gbc.gridy = 0;
            southPanel.add(buttons[i], gbc);
            southPanel.add(buttons[i], gbc);
        }
        southPanel.setBackground(Color.GREEN);
        allPanel.add(southPanel, BorderLayout.SOUTH);
        
        // add parent to container
        add(allPanel);

        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == buttons[2]) {
            // close application
            System.exit(0);
        } else if (source == buttons[1]) {
            // clear all fields
            for (int i = 0, j = fields.length; i < j; i++) {
                fields[i].setText("");
            }
        } else if (source == buttons[0]) {
            // save data to file
            saveData();
        }
    }

    public void saveData() {
        String firstMemberName = fields[0].getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "put username here", "put password here");
            pstmt = connect.prepareStatement("INSERT INTO membertable(firstname) VALUES(?)");
            pstmt.setString(1, firstMemberName);
            pstmt.executeUpdate();
            connect.close();
            //JOptionPane.showMessageDialog(null, "Member Inserted Successfully!", "Data Entry", JOptionPane.WARNING);
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
        } catch (Exception e) {
            System.out.println("Error1: " + e);
            //JOptionPane.showMessageDialog(null, "Cannot Record data!", "Data Entry", JOptionPane.WARNING);
        }
    }

    public static void main(String[] args) {
        MemberBioData member = new MemberBioData();
    }
}