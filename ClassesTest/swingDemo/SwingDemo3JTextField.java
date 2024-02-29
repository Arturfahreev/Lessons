package swingDemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Создать окно в котором вводишь строку и получаешь по нажатию кнопку обратную стронку.
 * Если нажимаешь Enter, то просто выводится текущая строка.
 */


public class SwingDemo3JTextField implements ActionListener {

    JFrame jFrame;
    JButton jButton;
    JTextField jTextField;
    JLabel jLabelMain, jLabelContent;

    SwingDemo3JTextField() {
        jFrame = new JFrame("Reverse text");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(240, 120);
        jFrame.setLayout(new FlowLayout());
        jFrame.setVisible(true);

        jLabelMain = new JLabel("Enter the text: ");
        jLabelContent = new JLabel("");

        jButton = new JButton("To reverse!");
        jTextField = new JTextField(10);
        jTextField.setActionCommand("jTextField");
        jButton.setActionCommand("jButton");

        jButton.addActionListener(this);
        jTextField.addActionListener(this);

        jFrame.add(jLabelMain);
        jFrame.add(jTextField);
        jFrame.add(jButton);
        jFrame.add(jLabelContent);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("jButton")) {
            String originStr = jTextField.getText();
            String resultStr = "";
            for (int i = originStr.length() - 1; i >=0; i--) {
                resultStr += originStr.charAt(i);
            }
            jTextField.setText(resultStr);

        } if (e.getActionCommand().equals("jTextField")) {
            jLabelContent.setText("You entered: " + jTextField.getText());
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new SwingDemo3JTextField();
            }
        };
        SwingUtilities.invokeLater(runnable);
    }
}
