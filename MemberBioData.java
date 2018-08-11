import java.awt.*;
import javax.swing.*;
import  java.awt.event.*;

public class MemberBioData extends JFrame implements ActionListener {
    //JButton saveButton, clearButton, closeButton;
    JButton[] buttons;
    // JTextField firstNameField, lastNameField, departmentField, matricNumField;
    JTextField[] fields;
    // JLabel firstName, lastName, department, matricNum;
    JLabel[] labels;

    GridBagLayout gbl;
    GridBagConstraints gbc;

    public MemberBioData() {
        super();
        setTitle("Member Bio Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setBounds(100, 100, 600, 400);

/** First implementation    
        // create components
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
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

        // create  panel to hold components
        JPanel buttonPanel = new  JPanel();

        // add  components to panel
        buttonPanel.add(clearButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(closeButton);
        buttonPanel.add(firstName);
        buttonPanel.add(firstNameField);
        buttonPanel.add(lastName);
        buttonPanel.add(lastNameField);
        buttonPanel.add(department);
        buttonPanel.add(departmentField);
        buttonPanel.add(matricNum);
        buttonPanel.add(matricNumField);
        */

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
        
        // center panel
        centerPanel.setLayout(gbl);
        for (int i = 0, j = fields.length; i < j; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            centerPanel.add(fields[i], gbc);
        }
        centerPanel.setBackground(Color.GREEN);
        allPanel.add(centerPanel, BorderLayout.CENTER);
        
        // add parent to container
        add(allPanel);

        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == buttons[2]) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        MemberBioData member = new MemberBioData();
    }
}