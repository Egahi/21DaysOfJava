import java.awt.*;
import javax.swing.*;
import  java.awt.event.*;

public class MemberBioData extends JWindow implements ActionListener {
    JButton closeButton;
    JTextField firstNameField, lastNameField, departmentField, matricNumField;
    JLabel firstName, lastName, department, matricNum;

    public MemberBioData() {
        super();
        // setTitle("Member Bio Data");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setBounds(100, 100, 600, 400);
    
        // create buttons
        JButton saveButton = new JButton("Save");
        JButton openButton = new JButton("Open");
        closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        firstNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        departmentField = new JTextField(20);
        matricNumField = new JTextField(10);
        firstName = new JLabel("First Name");
        lastName = new JLabel("Last Name");
        department = new JLabel("Department");
        matricNum =  new JLabel("Matriculation Number");

        // create  panel to hold features
        JPanel buttonPanel = new  JPanel();

        // add  features to panel
        buttonPanel.add(saveButton);
        buttonPanel.add(openButton);
        buttonPanel.add(closeButton);
        buttonPanel.add(firstName);
        buttonPanel.add(firstNameField);
        buttonPanel.add(lastName);
        buttonPanel.add(lastNameField);
        buttonPanel.add(department);
        buttonPanel.add(departmentField);
        buttonPanel.add(matricNum);
        buttonPanel.add(matricNumField);

        buttonPanel.setBackground(Color.BLUE);

        // add panel to window
        add(buttonPanel);

        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == closeButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        MemberBioData member = new MemberBioData();
    }
}