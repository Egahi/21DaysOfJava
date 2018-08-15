import javax.swing.*;

public class Authenticator extends javax.swing.JFrame {
    JTextField username = new  JTextField(15);
    JPasswordField password = new JPasswordField(15);
    JTextArea comments = new  JTextArea(4, 15);
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Cancel");

    public Authenticator() {
        super("Account Information");
        setSize(300, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JLabel commentsLabel = new JLabel("Comments: ");
        comments.setLineWrap(true);
        password.setEchoChar('*');
        panel.add(usernameLabel);
        panel.add(username);
        panel.add(passwordLabel);
        panel.add(password);
        panel.add(commentsLabel);
        panel.add(comments);
        panel.add(ok);
        panel.add(cancel);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] arguments) {
        Authenticator auth = new Authenticator();
    }
}