import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class TopScorePane extends JPanel implements ActionListener {
    GridBagLayout gbl;
    GridBagConstraints gbc;
    JButton back;
    JLabel firstLabel, score;
    JPanel allPanel;

    Connection connect;
    PreparedStatement pstmt;
    ResultSet rs;

    public TopScorePane() {

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();

        // main panel
        allPanel = new JPanel();
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
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == back) {
            // set Main pane
        } 
    }
}