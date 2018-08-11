import java.awt.*;
import javax.swing.*;

public class MemberBioData extends JWindow {
    public MemberBioData() {
        super();
        // setTitle("Member Bio Data");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setBounds(100, 100, 600, 400);
        getContentPane().setBackground(Color.BLACK);

        JButton saveButton = new JButton("Save");
        JButton openButton = new JButton("Open");
        JButton closeButton = new JButton("Close");

        JPanel buttonPanel = new  JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(openButton);
        buttonPanel.add(closeButton);

        add(buttonPanel);

        setVisible(true);
        
    }

    public static void main(String[] args) {
        MemberBioData member = new MemberBioData();
    }
}