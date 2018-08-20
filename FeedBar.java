import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FeedBar extends JFrame {
    public FeedBar() {
        super("FeedBar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // create buttons
        JButton load = new JButton("Load");
        JButton save = new JButton("Save");
        JButton subscribe =  new JButton("Subscribe");

        // add buttons to scroll bar
        JToolBar bar  = new  JToolBar();
        bar.add(load);
        bar.add(save);
        bar.add(subscribe);

        // create menu
        JMenuItem j1 = new JMenuItem("Load");
        JMenuItem j2 = new JMenuItem("Save");
        JMenuItem j3 = new JMenuItem("Subscribe");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Feeds");
        menu.add(j1);
        menu.add(j2);
        menu.addSeparator();
        menu.add(j3);
        menuBar.add(menu);

        // create tabbed panels
        JPanel mainSettings = new JPanel();
        JPanel advancedSettings = new JPanel();
        JPanel privacySettings = new JPanel();
        JPanel emailSettings = new JPanel();
        JPanel securitySettings = new JPanel();
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Main", mainSettings);
        tabs.addTab("Advanced", advancedSettings);
        tabs.addTab("Privacy", privacySettings);
        tabs.addTab("E-mail", emailSettings);
        tabs.addTab("Security", securitySettings);

        // prepare user interface
        JTextArea edit =  new JTextArea(8, 40);
        JScrollPane scroll = new JScrollPane(edit);
        BorderLayout bord = new  BorderLayout();
        setLayout(bord);
        add("North", bar);
        add("North", tabs);
        add("Center", scroll);
        setJMenuBar(menuBar);
        pack();
        setVisible(true);
    }

    public static void main(String[] arguments) {
        FeedBar frame =  new FeedBar();
    }
}