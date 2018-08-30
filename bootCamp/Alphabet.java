import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Alphabet extends JFrame {
    JButton a = new JButton("Alibi");
    JButton b = new JButton("Burglar");
    JButton c = new JButton("Corpse");
    JButton d = new JButton("Deadbeat");
    JButton e = new JButton("Evidence");
    JButton f = new JButton("Fugitive");

    public Alphabet() {
        super("Alphabet");
        setSize(360, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout lm = new FlowLayout(FlowLayout.LEFT);
        setLayout(lm);
        add(a);
        add(b);
        add(c);
        add(d);
        add(e);
        add(f);
        setVisible(true);
    }

    public static void main(String[] arguments) {
        Alphabet frame = new Alphabet();
    }
}