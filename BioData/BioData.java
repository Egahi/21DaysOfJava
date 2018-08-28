import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class BioData extends JFrame implements ActionListener {
    JButton[] buttons;
    JTextField[] textFields;
    JTextArea commentsArea;
    JLabel[] labels;

    GridBagLayout gbl;
    GridBagConstraints gbc;
    CardLayout cardLayout;

    Connection connect;
    PreparedStatement pstmt;

    public BioData() {
        super("Bio Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 950, 550);
        cardLayout = new CardLayout();

        // parent panel
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        JPanel currentCenterPanel = new JPanel();
        JPanel dataPanel = new JPanel();
        JPanel membersPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();

        // north panel
        ImageIcon headerImage = new ImageIcon("bio_data.jpg");
        JLabel headerLabel = new JLabel(headerImage);
        northPanel.add(headerLabel);
        parentPanel.add(northPanel, BorderLayout.NORTH);

        // center panel
        // get data entries
        String[] textFieldLabels = {"Name", "Number", "Email", 
            "Contact address", "Permanent Home address", "Occupation"};
        labels = new JLabel[textFieldLabels.length];
        textFields = new JTextField[textFieldLabels.length];
        
        // arrange data labels and fields on datapanel using gridbag layout
        dataPanel.setLayout(gbl);
        gbc.insets = new Insets(5, 5, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        for (int i = 0, j = textFields.length; i < j; i++) {
            // arrange data label and fields in 2 colums
            if (i % 3 == 0) {
                gbc.gridx += 3;
            }
            gbc.gridy = i % (j / 2);
            
            labels[i] = new JLabel(textFieldLabels[i]);
            dataPanel.add(labels[i], gbc);
            gbc.gridx ++;
            textFields[i] = new JTextField(30);
            dataPanel.add(textFields[i], gbc);
            gbc.gridx--;
        }
        // use flow layout for for current center panel
        currentCenterPanel.setLayout(new FlowLayout());

        // add data panel to current center panel
        currentCenterPanel.add(dataPanel);
        
        // add text area with scroll bars for comments
        commentsArea = new JTextArea(5, 15);
        commentsArea.setLineWrap(true);
        commentsArea.setWrapStyleWord(true);
        JScrollPane commentsScroll = new JScrollPane(commentsArea, 
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            JLabel commentsLabel = new JLabel("Comments");
        currentCenterPanel.add(commentsLabel);
        currentCenterPanel.add(commentsScroll);

        // display data in database
        JTextField searchField = new JTextField();
        JLabel searchLabel = new JLabel("Search by Name");
        JButton searchButton = new JButton("Search");
        membersPanel.setLayout(new FlowLayout());
        membersPanel.add(searchLabel);
        membersPanel.add(searchField);
        membersPanel.add(searchButton);

        centerPanel.setLayout(cardLayout);
        centerPanel.add(currentCenterPanel, "data panel");
        centerPanel.add(membersPanel, "member panel");

        // add center panel to parent panel
        parentPanel.add(centerPanel, BorderLayout.CENTER);
        
        // south panel
        southPanel.setBackground(Color.blue);
        String[] buttonLabel = {"Register", "View Members", "Clear", "Close"};
        buttons = new JButton[buttonLabel.length];
        for (int i = 0, j = buttons.length; i < j; i++) {
            buttons[i] = new JButton(buttonLabel[i]);
            buttons[i].addActionListener(this);
            southPanel.add(buttons[i]);
        }
        // paint register button green
        buttons[0].setBackground(Color.green);
        // paint close button red
        buttons[3].setBackground(Color.red);
        parentPanel.add(southPanel, BorderLayout.SOUTH);

        add(parentPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == buttons[0]) {
            // register members
            saveData();
            clearEntries();
        } else if (source == buttons[2]) {
            clearEntries();
        } else if (source == buttons[2]) {
            // view members
        } else if (source == buttons[3]) {
            // close application
            System.exit(0);
        }
    }

    public void saveData() {
        // read entries from all fields
        String[] inputData = new String[textFields.length];
        for (int i = 0, j = textFields.length; i < j; i++) {
            inputData[i] = textFields[i].getText();
        }
        String comments = commentsArea.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/custom", "root", "gabriel2015");
            pstmt = connect.prepareStatement("INSERT INTO membertable" + 
                "(name, number, email, contact_address, permanent_address, occupation, comments) VALUES(?,?,?,?,?,?,?)");
            for (int i = 0, j = textFields.length; i < j; i++) {
                pstmt.setString(i + 1, inputData[i]);
            }
            pstmt.setString(7, comments);
            pstmt.executeUpdate();
            connect.close();
            JOptionPane.showMessageDialog(null, "Member Inserted Successfully!", "Data Entry", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            JOptionPane.showMessageDialog(null, "Cannot Record Data!", "Data Entry", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error1: " + e);
            JOptionPane.showMessageDialog(null, "Cannot Record data!", "Data Entry", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void clearEntries() {
        // clear entries in all fields
        for (int i = 0, j = textFields.length; i < j; i++) {
            textFields[i].setText("");
        }

        // clear comments area
        commentsArea.setText("");
    }

    public static void main (String[] args) {
        BioData bd = new BioData();
    }
}