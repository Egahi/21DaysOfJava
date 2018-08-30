import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SumSub extends JFrame implements ActionListener {
    JLabel firstNumLabel, secondNumLabel, resultLabel;
    JTextField firstTF, secondTF, resultTF;
    JButton addButton, subtractButton;

    public SumSub() {
        super("Sum or Subtract");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        firstNumLabel = new JLabel("X");
        secondNumLabel = new JLabel("Y");
        firstTF = new JTextField(5);
        secondTF = new JTextField(5);
        resultTF = new JTextField(5);
        resultTF.setEditable(false);
        resultLabel = new JLabel("Result");
        addButton = new JButton("Add numbers");
        addButton.addActionListener(this);
        subtractButton = new JButton("Subtract numbers");
        subtractButton.addActionListener(this);
        
        add(firstNumLabel);
        add(firstTF);
        add(secondNumLabel);
        add(secondTF);
        add(addButton);
        add(subtractButton);
        add(resultLabel);
        add(resultTF);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        float a = 0, b = 0, result = 0;
        
        try {
            a = Float.parseFloat(firstTF.getText());
            b = Float.parseFloat(secondTF.getText());
            if (source == addButton) {
                result = a + b;
            } else if (source == subtractButton) {
                result = a - b;
            }

            resultTF.setText("" + result);
        } catch(NumberFormatException nfe) {
            // ignore
        } finally {
            resultTF.setText("" + result);
        }
    }

    public static void main(String[] arguments) {
        SumSub ss = new SumSub();
    }
}