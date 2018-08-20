import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ProgressMonitor extends JFrame {
    JProgressBar current;
    JTextArea out;
    JButton find;
    Thread runner;
    int num = 0;

    public ProgressMonitor() {
        super("Progress Monitor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(205, 68);
        setLayout(new FlowLayout());
        current = new JProgressBar(0, 2000);
        current.setValue(0);
        current.setStringPainted(true);
        add(current);
    }

    public void iterate() {
        while (num < 2000) {
            current.setValue(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                num += 95;
            }
        }
    }

    public static void main(String[] arguments) {
        ProgressMonitor frame =  new ProgressMonitor();
        frame.setVisible(true);
        frame.iterate();
    }
}