import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        super("Break Breaker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 250, 250, 250);
        setVisible(true);
    }
 
    public static void main(String[] arguments) {
        MainFrame mf = new MainFrame();
    }
}