import javax.swing.*;

public class FormatFrame extends JFrame {
    JRadioButton[] teams = new JRadioButton[4];
    String[] formats = {"Atom", "RSS 0.92", "RSS 1.0", "RSS 2.0"};
    JComboBox formatBox = new JComboBox();

    public FormatFrame() {
        super("Choose an Output Format");
        setSize(320, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // create radio buttons
        // create drop down list items
        for (int i = 0, j = formats.length; i < j; i++) {
            teams[i] = new JRadioButton(formats[i]);
            formatBox.addItem(formats[i]);
        }
        
        JPanel panel = new JPanel();
        JLabel chooseLabel = new JLabel(
            "Choose an Output format for syndicated  news items.");
        panel.add(chooseLabel);
        ButtonGroup group = new ButtonGroup();

        // add radio buttons in a group
        // add buttons to the panel
        for (int i = 0, j = teams.length; i < j; i++) {
            group.add(teams[i]);
            panel.add(teams[i]);
        }


        JLabel formatLabel = new JLabel("Output formats");
        panel.add(formatLabel);
        panel.add(formatBox);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] arguments) {
        FormatFrame ff = new FormatFrame();
    }
}