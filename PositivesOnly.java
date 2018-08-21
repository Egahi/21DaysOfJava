import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PositivesOnly extends JFrame implements FocusListener {
    JLabel tl;
    JTextField tf1, tf2;

    public PositivesOnly() {
        super("Positives Numbers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        setLayout(flow);
        tl = new JLabel("Number");
        tf1 = new JTextField(5);
        tf2 = new JTextField(5);
        tf1.addFocusListener(this);
        tf2.setEditable(false);
        add(tl);
        add(tf1);
        add(tf2);
        setVisible(true);
    }

    public void focusGained(FocusEvent event) {
        try {
            float value = Float.parseFloat(tf1.getText());
            
            if (value < 0) {
                value *= -1;
            }
            
            tf2.setText("" + value);
        } catch (NumberFormatException nfe) {
            tf2.setText("");
        }
    }

    public void focusLost(FocusEvent event) {
        focusGained(event);
    }

    public static void main(String[] arguments) {
        PositivesOnly po = new PositivesOnly();
    }
}