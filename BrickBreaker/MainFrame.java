import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener{
    JButton play, topScores, exit;
    GridBagLayout gbl;
    GridBagConstraints gbc;

    public MainFrame() {
        super("Break Breaker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // buttons
        play = new JButton("Play");
        play.setBackground(Color.black);
        play.setForeground(Color.white);
        play.addActionListener(this);
        topScores = new JButton("Top Scores");
        topScores.setBackground(Color.black);
        topScores.setForeground(Color.white);
        topScores.addActionListener(this);
        exit = new JButton("Exit");
        exit.setBackground(Color.black);
        exit.setForeground(Color.white);
        exit.addActionListener(this);
    
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();

        // main panel
        JPanel allPanel = new JPanel();
        allPanel.setLayout(new BorderLayout());
        
        // north panel
        JPanel northPanel = new JPanel();
        JLabel title = new JLabel("BRICK BREAKER!");
        title.setFont(new Font("serif", Font.PLAIN, 80));
        title.setForeground(Color.white);
        northPanel.add(title);
        northPanel.setBackground(Color.black);
        allPanel.add(northPanel, BorderLayout.NORTH);

        // center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.black);
        centerPanel.setLayout(gbl);
        // add padding between buttons
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(play, gbc);
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
        // current size of frame
        Rectangle r = getBounds();
        // current location of frame
        Point p = getLocation();

        if (source == exit) {
            System.exit(0);
        } else if (source == topScores) {    
            // display topscoreframe
            TopScoreFrame tsf = new TopScoreFrame();
            tsf.setBoundsParameters(p, r);
            tsf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tsf.setVisible(true);
            
            // hide main frame
            setVisible(false);
        } else if (source == play) {
            // display dataframe
            DataFrame df = new DataFrame();
            df.setBoundsParameters(p, r);
            df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            df.setVisible(true);

            // hide main frame
            setVisible(false);
        }
    }
 
    public static void main(String[] arguments) {
        MainFrame mf = new MainFrame();
        Point p = new Point(50, 50);
        Rectangle r = new Rectangle(750, 550);
        mf.setBoundsParameters(p, r);
    }
}