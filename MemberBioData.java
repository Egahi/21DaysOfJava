import java.awt.*;
import javax.swing.*;
import  java.awt.event.*;

public class MemberBioData extends JWindow implements ActionListener {
    JButton closeButton;

    public MemberBioData() {
        super();
        // setTitle("Member Bio Data");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setBounds(100, 100, 600, 400);
    
        // create buttons
        JButton saveButton = new JButton("Save");
        JButton openButton = new JButton("Open");
        closeButton = new JButton("Close");
        closeButton.addActionListener(this);

        // create  panel for buttons
        JPanel buttonPanel = new  JPanel();

        // add  buttons to panel
        buttonPanel.add(saveButton);
        buttonPanel.add(openButton);
        buttonPanel.add(closeButton);

        buttonPanel.setBackground(Color.BLUE);

        // add panel to window
        add(buttonPanel);

        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == closeButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        MemberBioData member = new MemberBioData();
    }
}