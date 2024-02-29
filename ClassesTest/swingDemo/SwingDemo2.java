package swingDemo;
/**
 * Создать окно с двумя кнопками, которые при нажатии меняют текст
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SwingDemo2 implements ActionListener {

    JLabel jLabel;
    JFrame jFrame;

    SwingDemo2() {
        jFrame = new JFrame("Choose button");
        jFrame.setSize(320, 180);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout());
//        jFrame.setJMenuBar(new JMenuBar());

        JButton jButtonReleased = new JButton("Release");
        JButton jButtonPushed = new JButton("Push");
        JButton jButtonCancel = new JButton("Cancel");
        jButtonReleased.addActionListener(this);
        jButtonPushed.addActionListener(this);
        jButtonCancel.addActionListener(this);

        jFrame.add(jButtonPushed);
        jFrame.add(jButtonReleased);
        jFrame.add(jButtonCancel);

        jLabel = new JLabel("Push a button");
        jFrame.add(jLabel);

        jFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Release")) {
            jLabel.setText("Button Released");
            JButton newButton = new JButton("NewButton " + (int)(Math.random() * 10));
            newButton.addActionListener(new NewActionListener());
            jFrame.add(newButton);
        }
        if (e.getActionCommand().equals("Push")) {
            jLabel.setText("Button pushed");
        }
        if (e.getActionCommand().equals("Cancel")) {
            jLabel.setText("Button canceled");
        }

    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new SwingDemo2();
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    private class NewActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jLabel.setText(e.getActionCommand() + "!!!");
        }
    }
}
