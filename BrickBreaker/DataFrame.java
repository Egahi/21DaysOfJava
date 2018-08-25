import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class DataFrame extends JFrame implements ActionListener {
    GridBagLayout gbl;
    GridBagConstraints gbc;
    JButton start, back;
    JTextField nameField;

    Connection connect;
    PreparedStatement pstmt;
    ResultSet rs;

    public DataFrame() {
        super("Data Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(50, 50, 750, 550);

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();

        // main panel
        JPanel allPanel = new JPanel();
        allPanel.setLayout(new BorderLayout());

        // center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.black);
        centerPanel.setLayout(gbl);
        gbc.gridx = 0;
        gbc.gridy = 0;
        // add padding between components
        gbc.insets = new Insets(10, 10, 10, 10);
        JLabel nameLabel = new JLabel("Username");
        nameLabel.setForeground(Color.white);
        nameField = new JTextField(20);
        nameField.setBackground(Color.black);
        nameField.setForeground(Color.white);
        centerPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(nameField, gbc);
        start = new JButton("Start");
        start.setBackground(Color.black);
        start.setForeground(Color.white);
        start.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(start, gbc);
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        gbc.gridx = 2;
        centerPanel.add(back, gbc);
        allPanel.add(centerPanel, BorderLayout.CENTER);

        // south panel
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.black);
        JLabel credit = new JLabel("(C) Egahi S. O.");
        southPanel.add(credit);
        allPanel.add(southPanel, BorderLayout.SOUTH);
        
        add(allPanel);
        setVisible(true);
    }

    /**
     * sets the location size of the frame
     *  to the updated values due to resize by user
     * @param p is the current location (top left coordinates) and
     * @param r is the current frame size (width and height)
     */
    public void setBoundsParameters(Point p, Rectangle r) {
        setBounds(p.x, p.y, r.width, r.height);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == start) {
            saveData();
            // display game frame
        } else if (source == back) {
            Rectangle r = getBounds();
            Point p = getLocation();

            // display main frame
            MainFrame mf = new MainFrame();
            mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mf.setBoundsParameters(p, r);
            mf.setVisible(true);

            // hide data frame
            setVisible(false);
        }
    }

    /**
     * saves regisetered users to a database
     */
    public void saveData() {
        String userName = nameField.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/custom", "root", "gabriel2015");
            pstmt = connect.prepareStatement("INSERT INTO brickbreakers(username) VALUES(?)");
            pstmt.setString(1, userName);
            pstmt.executeUpdate();
            connect.close();
            // JOptionPane.showMessageDialog(null, "Registered!", "Data Entry", JOptionPane.WARNING);
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
            System.out.println(sqle.getMessage());
        } 
        catch (Exception e) {
            System.out.println("Error1: " + e);
            //JOptionPane.showMessageDialog(null, "Cannot Record data!", "Data Entry", JOptionPane.WARNING);
        }
    }
}