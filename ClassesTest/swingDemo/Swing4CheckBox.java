package swingDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Написать приложение в окне которого будут три флажка, изменения нажатия которых будут отображаться ниже под ними.
 */

public class Swing4CheckBox implements ItemListener {
    JFrame jFrame;
    JLabel jLabelChange;
    JLabel jLabelResult;
    JCheckBox jCheckBoxAlfa;
    JCheckBox jCheckBoxBeta;
    JCheckBox jCheckBoxGamma;

    Swing4CheckBox() {
        jFrame = new JFrame("CheckBox testing");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(240, 120);
        jFrame.setVisible(true);
        jFrame.setLayout(new FlowLayout());

        jLabelChange = new JLabel("");
        jLabelResult = new JLabel("");

        jCheckBoxAlfa = new JCheckBox("Alfa");
        jCheckBoxBeta = new JCheckBox("Beta");
        jCheckBoxGamma = new JCheckBox("Gamma");
        jCheckBoxAlfa.addItemListener(this);
        jCheckBoxBeta.addItemListener(this);
        jCheckBoxGamma.addItemListener(this);

        jFrame.add(jCheckBoxAlfa);
        jFrame.add(jCheckBoxBeta);
        jFrame.add(jCheckBoxGamma);
        jFrame.add(jLabelChange);
        jFrame.add(jLabelResult);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        Object object = e.getItem();
        JCheckBox item;
        if (object instanceof JCheckBox) {
            item = (JCheckBox)object;
        } else return;

        if (item.isSelected()) {
            jLabelChange.setText(item.getText() + " was selected");
        } else {
            jLabelChange.setText(item.getText() + " was reset");
        }

        String result = "";

        if (jCheckBoxAlfa.isSelected()) {
            result += "Alfa ";
        }

        if (jCheckBoxBeta.isSelected()) {
            result += "Beta ";
        }

        if (jCheckBoxGamma.isSelected()) {
            result += "Gamma ";
        }

        jLabelResult.setText("This checkboxes are selected: " + result);

    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new Swing4CheckBox();
            }
        };
        SwingUtilities.invokeLater(runnable);
    }
}
