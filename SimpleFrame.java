import java.swing.JFrame;

public class SimpleFrame extends JFrame {
    public SimpleFrame() {
        super("Simple Frame");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] arguments) {
        SimpleFrame sf = new SimpleFrame();
    }
}