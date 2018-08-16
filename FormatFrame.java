import javax.swing.*;

public class FormatFrame extends JFrame {
    JRadioButton[] teams = new JRadioButton[4];

    public FormatFrame() {
        super("Choose an Output Format");
        setSize(320, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teams[0] = new JRadioButton("Atom");
        teams[1] = new JRadioButton("RSS 0.92");
        teams[2] = new JRadioButton("RSS 1.0");
        teams[3] = new JRadioButton("RSS 2.0", true);
        JPanel panel = new JPanel();
        JLabel chooseLabel = new JLabel(
            "Choose an Output format for syndicated  news items.");
        panel.add(chooseLabel);
        ButtonGroup group = new ButtonGroup();
        for (int i = 0, j = teams.length; i < j; i++) {
            group.add(teams[i]);
            panel.add(teams[i]);
        }
        add(panel);
        setVisible(true);
    }

    public static void main(String[] arguments) {
        FormatFrame ff = new FormatFrame();
    }
}