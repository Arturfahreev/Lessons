package swingDemo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.Utilities;
import java.io.*;
import javax.swing.*;
import java.awt.BorderLayout; // подключаем BorderLayout

public class Swing7 implements ActionListener {

    JFrame jFrame;

    Swing7() {
        jFrame = new JFrame("Test window");
        JPanel jPanel = new JPanel();
        JPanel jPanel2 = new JPanel();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300, 300);
        jFrame.setLocationRelativeTo(null);
        //jFrame.setLayout(new BorderLayout());
        JButton jButton1 = new JButton("OK");
        JButton jButton2 = new JButton("Cancel");
        JButton jButton3 = new JButton("Left");
        JButton jButton4 = new JButton("Right");
        //jFrame.add(jButton);
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel2.add(jButton3);
        jPanel2.add(jButton4);
        //jFrame.add(jPanel);
        jFrame.getContentPane().add(BorderLayout.NORTH, jPanel);
        jFrame.getContentPane().add(BorderLayout.SOUTH, jPanel2);
        jFrame.setResizable(false);
        //jFrame.setLayout(new FlowLayout());

        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent e){

    }

    public static void main(String[] args) {


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new Swing7();
            }
        };

        SwingUtilities.invokeLater(runnable);
    }


}
