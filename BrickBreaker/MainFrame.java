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
        setBounds(250, 250, 250, 250);

        quickGame = new JButton("Quick Game");
        topScores = new JButton("Top Scores");
        exit = new JButton("Exit");
    
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
        
        add(allPanel);
        setVisible(true);
    }
 
    public static void main(String[] arguments) {
        MainFrame mf = new MainFrame();
    }
}