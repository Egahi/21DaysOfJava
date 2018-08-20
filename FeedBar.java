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

        // prepare user interface
        JTextArea edit =  new JTextArea(8, 40);
        JScrollPane scroll = new JScrollPane(edit);
        BorderLayout bord = new  BorderLayout();
        setLayout(bord);
        add("North", bar);
        add("Center", scroll);
        setJMenuBar(menuBar);
        pack();
        setVisible(true);
    }

    public static void main(String[] arguments) {
        FeedBar frame =  new FeedBar();
    }
}