import javax.swing.*;

public class ButtonFrame  extends JFrame {
    JButton load = new JButton("Load");
    JButton save = new JButton("Save");
    JButton unsubscribe = new JButton("Unsubscribe");
    ImageIcon photosIcon = new ImageIcon("sunset_over_ocean.jpg");
    JButton photos = new JButton("Photos", photosIcon);

    public ButtonFrame() {
        super("Button Frame");
        // setSize(140, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(load);
        panel.add(save);
        panel.add(unsubscribe);
        panel.add(photos);
        add(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] arguments) {
        ButtonFrame bf = new ButtonFrame();
    }
}