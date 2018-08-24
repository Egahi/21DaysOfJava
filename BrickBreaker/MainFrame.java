import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ImageIcon backgroundImage;
    public MainFrame() {
        super("Break Breaker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 250, 250, 250);

        JPanel pane = new JPanel();
        pane.setBackground(Color.black);
        add(pane);
        setVisible(true);
    }
 
    public static void main(String[] arguments) {
        MainFrame mf = new MainFrame();
    }
}