import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MBD extends JFrame implements ActionListener {
    //JButton saveButton, clearButton, closeButton;
    JButton[] buttons;

    private JLabel nameLabel = new JLabel("Name: ",
        SwingConstants.RIGHT);
    private JTextField name;
    private JLabel urlLabel = new JLabel("URL: ",
        SwingConstants.RIGHT);
    private JTextField url;
    private JLabel typeLabel = new JLabel("Type: ",
        SwingConstants.RIGHT);
    private JTextField type;

    GridBagLayout gbl;
    GridBagConstraints gbc;

    public MBD() {
        super();
        setTitle("Portfolio Site Informatin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setBounds(100, 100, 600, 400);

        // buttons
        String[] buttonText = {"Save", "Clear", "Close"};
        buttons = new JButton[3];
        for (int i = 0, j =  buttonText.length; i < j; i++) {
            // create buttons
            buttons[i] = new JButton(buttonText[i]);
            buttons[i].addActionListener(this);
        }   

        // site name
        String response1 = JOptionPane.showInputDialog(null,
            "Enter the site name:");
        name = new JTextField(response1, 20);

        // Site address
        String response2 = JOptionPane.showInputDialog(null,
            "Enter the site address:");
        url = new JTextField(response2, 20);

        // site type
        String[] choices = {"Personal", "Commercial", "Unknown"};
        int response3 = JOptionPane.showOptionDialog(null,
            "What type of site is it?",
            "Site type",
            0,
            JOptionPane.QUESTION_MESSAGE,
            null,
            choices,
            choices[0]);
        type = new JTextField(choices[response3], 20);

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();

        // create panels
        JPanel allPanel = new JPanel();
        allPanel.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel southPanel =  new JPanel();

        // north panel
        //northPanel.setLayout(gbl);
        northPanel.setBackground(Color.CYAN);
        allPanel.add(northPanel, BorderLayout.NORTH);
        
        // center panel
        centerPanel.setLayout(gbl);
        //setLayout(new GridLayout(3, 2));
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(name, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(urlLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(url, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(typeLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(type, gbc);
        centerPanel.setBackground(Color.CYAN);
        allPanel.add(centerPanel, BorderLayout.CENTER);

        // south panel
        for (int i = 0, j = buttons.length; i < j; i++) {
            gbc.gridx = i;
            gbc.gridy = 0;
            southPanel.add(buttons[i], gbc);
            southPanel.add(buttons[i], gbc);
        }
        southPanel.setBackground(Color.GREEN);
        allPanel.add(southPanel, BorderLayout.SOUTH);
        
        // add parent to container
        add(allPanel);

        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == buttons[2]) {
            System.exit(0);
        } else if (source == buttons[1]) {
            name.setText("");
            url.setText("");
            type.setText("");
        }
    }

    public static void main(String[] args) {
        MBD member = new MBD();
    }
}