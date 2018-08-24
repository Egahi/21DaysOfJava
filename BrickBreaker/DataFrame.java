import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class DataFrame extends JFrame implements ActionListener {
    GridBagLayout gbl;
    GridBagConstraints gbc;
    JButton start, back;

    public DataFrame() {
        super("Data Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 750, 550);

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
        JTextField nameField = new JTextField(20);
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

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == start) {
            // begin game
        } else if (source == back) {
            MainFrame mf = new MainFrame();
            mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mf.setVisible(true);
            setVisible(false);
        }
    }
}