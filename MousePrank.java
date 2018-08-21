import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MousePrank extends JFrame implements ActionListener {
    public MousePrank() {
        super("Message");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 220);
        BorderLayout border = new BorderLayout();
        setLayout(border);
        JLabel message = new JLabel("Click Ok to close this program.");
        add(BorderLayout.NORTH, message);
        PrankPanel prank = new PrankPanel();
        prank.ok.addActionListener(this);
        add(BorderLayout.CENTER, prank);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        System.exit(0);
    }

    public Insets getInsets() {
        return new Insets(40, 10, 10, 10);
    }

    public static void main(String[] arguments) {
        new MousePrank();
    }
}

class PrankPanel extends JPanel implements MouseMotionListener {
    JButton ok = new JButton("OK");
    int buttonX, buttonY, mouseX, mouseY;
    int width, height;

    PrankPanel() {
        super();
        setLayout(null);
        addMouseMotionListener(this);
        buttonX = 110;
        buttonY = 110;
        ok.setBounds(new Rectangle(buttonX, buttonY, 70, 20));
        add(ok);
    }

    public void mouseMoved(MouseEvent event) {
        mouseX = event.getX();
        mouseY = event.getY();
        width = (int)getSize().getWidth();
        height = (int)getSize().getHeight();
        if (Math.abs((mouseX + 35) - buttonX) < 50) {
            buttonX = moveButton(mouseX, buttonX, width);
            repaint();
        }
        if (Math.abs((mouseY + 10) - buttonY) < 50) {
            buttonY = moveButton(mouseY, buttonY, height);
            repaint();
        }
    }

    public void mouseDragged(MouseEvent event) {
        // ignore this event
    }

    private int moveButton(int mouseAt, int buttonAt, int border) {
        if (buttonAt < mouseAt) {
            buttonAt--;
        } else {
            buttonAt++;
        }

        if (buttonAt > (border - 20)) {
            buttonAt = 10;
        }

        if (buttonAt < 0) {
            buttonAt = border - 80;
        }

        return buttonAt;
    }

    public void paintComponent(Graphics comp) {
        super.paintComponent(comp);
        ok.setBounds(buttonX, buttonY, 70, 20);
    }
}