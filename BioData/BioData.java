import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;

public class BioData extends JFrame implements ActionListener {
    String[] textFieldLabels = {"Name", "Number", "Email", 
            "Contact address", "Permanent address", "Occupation"};
    JButton[] buttons;
    JButton searchButton;
    JTextField[] textFields;
    JTextField searchField;
    JTextArea commentsArea;
    JLabel[] labels;
    JPanel centerPanel, southPanel, queryPanel;
    JComboBox searchParameter;
    DefaultTableModel model;
    
    GridBagLayout gbl;
    GridBagConstraints gbc;
    CardLayout registrationCard, buttonsCard;

    Connection connect;
    PreparedStatement pstmt;
    ResultSet rs;

    public BioData() {
        super("Bio Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 950, 550);
        registrationCard = new CardLayout();
        buttonsCard = new CardLayout();

        // parent panel
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        centerPanel = new JPanel();
        JPanel registrationPanel = new JPanel();
        JPanel partialRegistrationPanel = new JPanel();
        queryPanel = new JPanel();
        JPanel northPanel = new JPanel();
        southPanel = new JPanel();
        JPanel controlButtonsPanel = new JPanel();
        JPanel backButtonPanel = new JPanel();

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();

        // north panel
        ImageIcon headerImage = new ImageIcon("images/bio_data.jpg");
        JLabel headerLabel = new JLabel(headerImage);
        northPanel.add(headerLabel);
        parentPanel.add(northPanel, BorderLayout.NORTH);

        // center panel
        labels = new JLabel[textFieldLabels.length];
        textFields = new JTextField[textFieldLabels.length];
        
        // arrange data labels and fields on partialRegistrationPanel using gridbag layout
        partialRegistrationPanel.setLayout(gbl);
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
            partialRegistrationPanel.add(labels[i], gbc);
            gbc.gridx ++;
            textFields[i] = new JTextField(30);
            partialRegistrationPanel.add(textFields[i], gbc);
            gbc.gridx--;
        }
        registrationPanel.setLayout(new FlowLayout());
        registrationPanel.add(partialRegistrationPanel);
        
        commentsArea = new JTextArea(5, 15);
        commentsArea.setLineWrap(true);
        commentsArea.setWrapStyleWord(true);
        JScrollPane commentsScroll = new JScrollPane(commentsArea, 
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JLabel commentsLabel = new JLabel("Comments");
        registrationPanel.add(commentsLabel);
        registrationPanel.add(commentsScroll);

        JLabel searchLabel = new JLabel("Search by");
        searchParameter = new JComboBox();
        for (int i = 0, j = textFieldLabels.length; i < j; i++) {
            searchParameter.addItem(textFieldLabels[i]);
        }
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        searchField = new JTextField(20);
        JPanel membersPane = new JPanel();
        membersPane.setLayout(new FlowLayout());
        membersPane.add(searchLabel);
        membersPane.add(searchParameter);
        membersPane.add(searchField);
        membersPane.add(searchButton);
        queryPanel.setLayout(new BorderLayout());
        queryPanel.add(membersPane, BorderLayout.NORTH);
        centerPanel.setLayout(registrationCard);
        centerPanel.add(registrationPanel, "registration panel");
        centerPanel.add(queryPanel, "query panel");

        parentPanel.add(centerPanel, BorderLayout.CENTER);
        
        // south panel
        controlButtonsPanel.setBackground(Color.blue);
        backButtonPanel.setBackground(Color.blue);
        String[] buttonLabel = {"Register", "View Members", "Clear", "back", "Close"};
        buttons = new JButton[buttonLabel.length];
        for (int i = 0, j = buttons.length; i < j; i++) {
            buttons[i] = new JButton(buttonLabel[i]);
            buttons[i].addActionListener(this);

            // skip back button
            if (i != 3) {
                controlButtonsPanel.add(buttons[i]);
            }
        }
        // add back button to this panel
        backButtonPanel.add(buttons[3]);

        southPanel.setLayout(buttonsCard);
        southPanel.add(controlButtonsPanel, "control buttons");
        southPanel.add(backButtonPanel, "back button");

        // paint register button green
        buttons[0].setBackground(Color.green);
        // paint close button red
        buttons[4].setBackground(Color.red);

        parentPanel.add(southPanel, BorderLayout.SOUTH);

        add(parentPanel);
        setVisible(true);
    }

    /**
     * adds functionality to all buttons
     * @param event is the button clicked
     */
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == buttons[0]) {
            registerMembers();
            clearEntries();
        } else if (source == buttons[1]) {
            displaySearchPage();
        } else if (source == buttons[2]) {
            clearEntries();
        } else if (source == buttons[3]) {
            diplayRegistrationPage();
        } else if (source == searchButton) {
            searchDataBase();
        } else if (source == buttons[4]) {
            // close application
            System.exit(0);
        }
    }

    /**
     * stores member data in the database
     */
    public void registerMembers() {
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

            // success
            JOptionPane.showMessageDialog(null, "Member Inserted Successfully!", "Data Entry", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            JOptionPane.showMessageDialog(null, "Cannot Record Data!", "Data Entry", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error1: " + e);
            JOptionPane.showMessageDialog(null, "Cannot Record data!", "Data Entry", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * clears entries in input fields
     */
    public void clearEntries() {
        // clear entries in all fields
        for (int i = 0, j = textFields.length; i < j; i++) {
            textFields[i].setText("");
        }

        // clear comments area
        commentsArea.setText("");

        // clear search parameter
        searchField.setText("");
    }

    public void displaySearchPage() {
        registrationCard.show(centerPanel, "query panel");
        buttonsCard.show(southPanel, "back button");
    }

    public void diplayRegistrationPage() {
        registrationCard.show(centerPanel, "registration panel");
        buttonsCard.show(southPanel, "control buttons");
    }

    /**
     * reterieves member data from the database and displays the information in a table
     */
    public void searchDataBase() {
        String searchParameter = searchParameter.getSelectedItem().toString();
        String sp = searchField.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/custom", "root", "gabriel2015");

            if (searchParameter == textFieldLabels[0]) {
                pstmt = connect.prepareStatement("SELECT * FROM membertable WHERE name LIKE CONCAT('%',?,'%')");
            } else if (searchParameter == textFieldLabels[1]) {
                pstmt = connect.prepareStatement("SELECT * FROM membertable WHERE number = ?");
            } else if (searchParameter == textFieldLabels[2]) {
                pstmt = connect.prepareStatement("SELECT * FROM membertable WHERE email LIKE CONCAT('%',?,'%')");
            } else if (searchParameter == textFieldLabels[3]) {
                pstmt = connect.prepareStatement("SELECT * FROM membertable WHERE contact_address LIKE CONCAT('%',?,'%')");
            } else if (searchParameter == textFieldLabels[4]) {
                pstmt = connect.prepareStatement("SELECT * FROM membertable WHERE permanent_address LIKE CONCAT('%',?,'%')");
            } else if (searchParameter == textFieldLabels[5]) {
                pstmt = connect.prepareStatement("SELECT * FROM membertable WHERE occupation LIKE CONCAT('%',?,'%')");
            }
           
            pstmt.setString(1, sp);
            rs = pstmt.executeQuery();

            // get number of rows in search result
            int rowCount = 0;
            if (rs.last()) {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }

            Object[][] rowData = new Object[rowCount][8];
            Object[] columnNames = {"S/No", textFieldLabels[0], textFieldLabels[1],
                textFieldLabels[2], textFieldLabels[3], textFieldLabels[4],
                textFieldLabels[5], "Comments"};
            
            if (rs.next()) {
                rs.beforeFirst();
                for(int i = 0; rs.next(); i++) {
                    rowData[i][0] = i + 1;
                    rowData[i][1] = rs.getString("name");
                    rowData[i][2] = rs.getString("number");
                    rowData[i][3] = rs.getString("email");
                    rowData[i][4] = rs.getString("contact_address");
                    rowData[i][5] = rs.getString("permanent_address");
                    rowData[i][6] = rs.getString("occupation");
                    rowData[i][7] = rs.getString("comments");
                }

                if (model != null) {
                    // clear previous search result
                    model.setRowCount(0);
                }

                model = new DefaultTableModel(rowData, columnNames);
                JTable table = new JTable(model);
                table.getColumnModel().getColumn(1).setCellRenderer(new WordWrapCellRenderer());
                table.getColumnModel().getColumn(2).setCellRenderer(new WordWrapCellRenderer());
                table.getColumnModel().getColumn(3).setCellRenderer(new WordWrapCellRenderer());
                table.getColumnModel().getColumn(4).setCellRenderer(new WordWrapCellRenderer());
                table.getColumnModel().getColumn(5).setCellRenderer(new WordWrapCellRenderer());
                table.getColumnModel().getColumn(6).setCellRenderer(new WordWrapCellRenderer());
                table.getColumnModel().getColumn(7).setCellRenderer(new WordWrapCellRenderer());
                JScrollPane tableScroll = new JScrollPane(table,
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                queryPanel.add(tableScroll, BorderLayout.CENTER);
                centerPanel.add(queryPanel, "query panel");
                registrationCard.show(centerPanel, "query panel");
            } else {
                // member not in database
                JOptionPane.showMessageDialog(null, "Member Not Found", "Data Recovery", JOptionPane.WARNING_MESSAGE);
            }

            // success
            connect.close();
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            JOptionPane.showMessageDialog(null, "Error Try Again", "Data Recovery", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error1: " + e);
            JOptionPane.showMessageDialog(null, "Error Try Again", "Data Recovery", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        BioData bd = new BioData();
    }
}

class WordWrapCellRenderer extends JTextArea implements TableCellRenderer {
    WordWrapCellRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
        if (table.getRowHeight(row) != getPreferredSize().height) {
            table.setRowHeight(row, getPreferredSize().height);
        }
        return this;
    }
}