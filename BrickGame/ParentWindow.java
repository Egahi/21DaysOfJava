import javax.swing.*;

public class ParentWindow extends JWindow {
    public ParentWindow() {
        super("Brick Breaker");
        setBounds(420, 420);
        setVisible(true);
    }

    public static void main(String[] arguments) {
        ParentWindow pw = new ParentWindow();
    }
}