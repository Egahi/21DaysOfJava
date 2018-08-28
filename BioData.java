import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql;

public class BioData extends JFrame implements ActionListener {
    JButton[] buttons;
    JTextField[] textFields;
    JLabel[] labels;

    GridBagLayout gbl;
    GridBagConstraints gbc;

    public BioData() {
        super("Bio Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 750, 550);

        // parent panel
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();

        // north panel
        Image headerImage = new Image("bio_data.jpg");
        JLabel headerLabel = new JLabel(headerImage);
        northPanel.add(headerLabel);
        parentPanel.add(northPanel, BorderLayout.NORTH);

        // south panel
        String[] buttonLabel = {"Register", "Clear", "View Members", "Close"};
        buttons = new JButton[4];
        for (int i = 0, j = buttons.length; i < j; i++) {
            buttons[i] = new JButton(buttonLabel[i]);
            buttons[i].addActionListener(this);
            southPanel.add(buttons[i]);
        }
        parentPanel.add(southPanel, BorderLayout.SOUTH);

        add(parentPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        switch (source) {
            case buttons[0]:
                // Register Member
            case buttons[1]:
                // Clear fields
            case buttons[2]:
                // view Members
            case buttons[3]:
                System.exit(0);
        }
    }
}