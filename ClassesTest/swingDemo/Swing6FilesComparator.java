package swingDemo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.Utilities;
import java.io.*;

public class Swing6FilesComparator implements ActionListener {

    JLabel jLabelFile1;
    JLabel jLabelFile2;
    JLabel jLabelResult;
    JButton jButton;
    JTextField jTextField1;
    JTextField jTextField2;

    Swing6FilesComparator () {

        JFrame jFrame = new JFrame("Files Comparator");
        jFrame.setLayout(new FlowLayout());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(200, 190);
        jFrame.setVisible(true);

        jLabelFile1 = new JLabel("First File: ");
        jLabelFile2 = new JLabel("Second File: ");
        jLabelResult = new JLabel("");

        jTextField1 = new JTextField(14);
        jTextField2 = new JTextField(14);

        jTextField1.setActionCommand("File1");
        jTextField2.setActionCommand("File2");

        jButton = new JButton("To compare");
        jButton.addActionListener(this);

        jFrame.add(jLabelFile1);
        jFrame.add(jTextField1);
        jFrame.add(jLabelFile2);
        jFrame.add(jTextField2);
        jFrame.add(jButton);
        jFrame.add(jLabelResult);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try (FileInputStream fileInputStream1 = new FileInputStream(jTextField1.getText());
             FileInputStream fileInputStream2 = new FileInputStream(jTextField2.getText())) {
            int i = 0;
            int j = 0;

            if (jTextField1.getText().equals("")) {
                jLabelResult.setText("First file is absent");
                return;
            }

            if (jTextField2.getText().equals("")) {
                jLabelResult.setText("Second file is absent");
                return;
            }

            do {
                i = fileInputStream1.read();
                j = fileInputStream2.read();
                if (i != j) break;

            } while ((i != -1) && (j != -1));

            if (i != j) {
                jLabelResult.setText("Files are different");
            }
            if (i == j) {
                jLabelResult.setText("Files are same");
            }
        } catch (IOException ex) {
            jLabelResult.setText("Files no found");
        }
    }


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new Swing6FilesComparator();
            }
        };

        SwingUtilities.invokeLater(runnable);
    }


}
