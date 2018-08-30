import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class BioData extends JFrame implements ActionListener {
    String[] textFieldLabels = {"Name", "Number", "Email", 
            "Contact address", "Permanent address", "Occupation"};
    JButton[] buttons;
    JButton searchButton;
    JTextField[] textFields;
    JTextField result, searchField;
    JTextArea commentsArea;
    JLabel[] labels;
    JPanel centerPanel, southPanel;
    JComboBox searchParameter;

    GridBagLayout gbl;
    GridBagConstraints gbc;
    CardLayout dataCard, buttonsCard;

    Connection connect;
    PreparedStatement pstmt;

    public BioData() {
        super("Bio Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 950, 550);
        dataCard = new CardLayout();
        buttonsCard = new CardLayout();

        // parent panel
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        centerPanel = new JPanel();
        JPanel currentCenterPanel = new JPanel();
        JPanel dataPanel = new JPanel();
        JPanel membersPanel = new JPanel();
        JPanel northPanel = new JPanel();
        southPanel = new JPanel();
        JPanel fullButtonPanel = new JPanel();
        JPanel fewButtonPanel = new JPanel();

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();

        // north panel
        ImageIcon headerImage = new ImageIcon("images/bio_data.jpg");
        JLabel headerLabel = new JLabel(headerImage);
        northPanel.add(headerLabel);
        parentPanel.add(northPanel, BorderLayout.NORTH);

        // center panel
        // get data entries
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
        JLabel searchLabel = new JLabel("Search by");
        searchParameter = new JComboBox();
        for (int i = 0, j = textFieldLabels.length; i < j; i++) {
            searchParameter.addItem(textFieldLabels[i]);
        }
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        searchField = new JTextField(20);
        result = new JTextField(20);
        result.setEditable(false);
        membersPanel.setLayout(new FlowLayout());
        membersPanel.add(searchLabel);
        membersPanel.add(searchParameter);
        membersPanel.add(searchField);
        membersPanel.add(searchButton);
        membersPanel.add(result);

        centerPanel.setLayout(dataCard);
        centerPanel.add(currentCenterPanel, "data panel");
        centerPanel.add(membersPanel, "members panel");

        // add center panel to parent panel
        parentPanel.add(centerPanel, BorderLayout.CENTER);
        
        // south panel
        fullButtonPanel.setBackground(Color.blue);
        fewButtonPanel.setBackground(Color.blue);
        String[] buttonLabel = {"Register", "View Members", "Clear", "back", "Close"};
        buttons = new JButton[buttonLabel.length];
        for (int i = 0, j = buttons.length; i < j; i++) {
            buttons[i] = new JButton(buttonLabel[i]);
            buttons[i].addActionListener(this);

            // skip back button
            if (i != 3) {
                fullButtonPanel.add(buttons[i]);
            }
        }
        // add back and close buttons to this panel
        fewButtonPanel.add(buttons[3]);
        //fewButtonPanel.add(buttons[4]);
        southPanel.setLayout(buttonsCard);
        southPanel.add(fullButtonPanel, "full buttons");
        southPanel.add(fewButtonPanel, "few buttons");

        // paint register button green
        buttons[0].setBackground(Color.green);
        // paint close button red
        buttons[4].setBackground(Color.red);

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
        } else if (source == buttons[1]) {
            displayMembers();
        } else if (source == buttons[2]) {
            clearEntries();
        } else if (source == buttons[3]) {
            diplayDataPage();
        } else if (source == searchButton) {
            searchDataBase();
        } else if (source == buttons[4]) {
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

    public void displayMembers() {
        dataCard.show(centerPanel, "members panel");
        buttonsCard.show(southPanel, "few buttons");
    }

    public void diplayDataPage() {
        dataCard.show(centerPanel, "data panel");
        buttonsCard.show(southPanel, "full buttons");
    }

    public void searchDataBase() {
        String searchParam = searchParameter.getSelectedItem().toString();
        String sp = searchField.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/custom", "root", "gabriel2015");

            if (searchParam == textFieldLabels[0]) {
                pstmt = connect.prepareStatement("SELECT * FROM membertable WHERE name = " + sp);
                //pstmt.setString(1, sp);
            } else if (searchParam == textFieldLabels[1]) {
                pstmt = connect.prepareStatement("SELECT * FROM membertable WHERE number = " + sp);
            } else if (searchParam == textFieldLabels[2]) {
                pstmt = connect.prepareStatement("SELECT * FROM membertable WHERE email = " + sp);
            } else if (searchParam == textFieldLabels[3]) {
                pstmt = connect.prepareStatement("SELECT * FROM membertable WHERE contact_address = " + sp);
            } else if (searchParam == textFieldLabels[4]) {
                pstmt = connect.prepareStatement("SELECT * FROM membertable WHERE permanent_address = " + sp);
            } else if (searchParam == textFieldLabels[5]) {
                pstmt = connect.prepareStatement("SELECT * FROM membertable WHERE occupation = " + sp);
            }
           
            connect.close();
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            JOptionPane.showMessageDialog(null, "Member not found!", "Data Recovery", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error1: " + e);
            JOptionPane.showMessageDialog(null, "Member not found!", "Data Recovery", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main (String[] args) {
        BioData bd = new BioData();
    }
}