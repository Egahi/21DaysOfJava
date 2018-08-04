import java.awt.*;
import javax.swing.*;

public class MemberBioData extends JFrame {
    public MemberBioData() {
        setTitle("Member Bio Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
    }

    public static void main(String[] args) {
        MemberBioData member = new MemberBioData();
    }
}