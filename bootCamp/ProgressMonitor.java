import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class ProgressMonitor extends JFrame {
    JProgressBar current;
    JTextArea out;
    JButton find;
    Thread runner;
    int num = 0;
    JLabel tl;
    JTextField tf;

    public ProgressMonitor() {
        super("Progress Monitor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(205, 68);
        setLayout(new FlowLayout());
        current = new JProgressBar(0, 2000);
        current.setValue(0);
        current.setStringPainted(true);

        tl = new JLabel("Progress");
        tf = new JTextField();

        add(current);
        add(tl);
        add(tf);
    }

    public void iterate() {
        while (num < 2000) {
            current.setValue(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            num += 95;
            tf.setText("" + num);
        }
    }

    public static void main(String[] arguments) {
        ProgressMonitor frame =  new ProgressMonitor();
        frame.pack();
        frame.setVisible(true);
        frame.iterate();
    }
}