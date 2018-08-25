import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class TopScoreFrame extends JFrame implements ActionListener {
    GridBagLayout gbl;
    GridBagConstraints gbc;
    JButton back;
    JLabel firstLabel, score;

    Connection connect;
    PreparedStatement pstmt;
    ResultSet rs;

    public TopScoreFrame() {
        super("Top Scores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();

        // main panel
        JPanel allPanel = new JPanel();
        allPanel.setLayout(new BorderLayout());

        // north panel
        JPanel northPanel = new JPanel();
        JLabel topScoreLabel = new JLabel("Top Score");
        topScoreLabel.setForeground(Color.white);
        topScoreLabel.setFont(new Font("serif", Font.PLAIN, 50));
        northPanel.add(topScoreLabel);
        northPanel.setBackground(Color.black);
        allPanel.add(northPanel, BorderLayout.NORTH);

        // center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.black);
        centerPanel.setLayout(gbl);
        // add padding between components
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        score = new JLabel("0");
        score.setForeground(Color.white);
        score.setFont(new Font("serif", Font.PLAIN, 120));
        centerPanel.add(score, gbc);
        gbc.gridy = 1;
        JLabel firstLabel = new JLabel("Username");
        firstLabel.setForeground(Color.white);
        firstLabel.setFont(new Font("serif", Font.PLAIN, 24));
        centerPanel.add(firstLabel, gbc);
        gbc.gridy = 2;
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
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
        if (source == back) {
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
     * Extracts top scorer from database
     */
    public void displayTopScore() {
        String userName = "Egahi";
        String topScore = "0";
        firstLabel.setText(userName);
        score.setText(topScore);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/custom", "root", "gabriel2015");
            pstmt = connect.prepareStatement("SELECT score FROM brickbreakers WHERE (username) VALUES(?)");
            pstmt.setString(1, userName);
            pstmt.executeUpdate();
            connect.close();
            topScore = "";
            //topScoreField.setText(topScore);
             //JOptionPane.showMessageDialog(null, "Registered!", "Data Entry", JOptionPane.WARNING);
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
        } catch (Exception e) {
            System.out.println("Error1: " + e);
            //JOptionPane.showMessageDialog(null, "Cannot Record data!", "Data Entry", JOptionPane.WARNING);
        }
    }
}