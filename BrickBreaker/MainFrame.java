import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MainFrame extends JFrame {
    JButton quickGame, topScores, exit;
    GridBagLayout gbl;
    GridBagConstraints gbc;

    public MainFrame() {
        super("Break Breaker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 250, 350, 350);

        quickGame = new JButton("Quick Game");
        quickGame.setBackground(Color.black);
        quickGame.setForeground(Color.white);
        topScores = new JButton("Top Scores");
        topScores.setBackground(Color.black);
        topScores.setForeground(Color.white);
        exit = new JButton("Exit");
        exit.setBackground(Color.black);
        exit.setForeground(Color.white);
    
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
        // add padding between buttons
        gbc.insets = new Insets(10, 10, 10, 10);
        centerPanel.add(quickGame, gbc);
        gbc.gridx = 1;
        centerPanel.add(topScores, gbc);
        gbc.gridx = 2;
        centerPanel.add(exit, gbc);
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
 
    public static void main(String[] arguments) {
        MainFrame mf = new MainFrame();
    }
}