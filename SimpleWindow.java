import javax.swing.JWindow;

public class SimpleWindow extends JWindow {
    public SimpleWindow() {
    super();
    setBounds(400, 300, 10, 10);
    setVisible(true);
    }

    public static void main(String[] arguments) {
    SimpleWindow sw = new SimpleWindow();
        for (int i = 10; i < 400; i++) {
            sw.setBounds(400 - (i/2), 300 - (i/2), i, i);
        }
    }
}