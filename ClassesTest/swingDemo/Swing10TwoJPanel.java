package swingDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Programs shoes frame with buttons and change color when push them
 */

public class Swing10TwoJPanel extends JFrame implements ActionListener {

    static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JLabel label = new JLabel();
    private java.util.List<JButton> listOfButtons = new ArrayList<>();

    public Swing10TwoJPanel() {
        this.setSize((int) (screen.width * 0.6), (int)(screen.height * 0.75));
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        panel1.setBounds(0, 0, (int) (this.getWidth() * 0.2), (int) (this.getHeight() - 20));
        panel2.setBounds((int) (this.getWidth() * 0.2), 0, (int) (this.getWidth() * 0.8), this.getHeight() - 20);

        panel1.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
        panel2.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
        panel1.setLayout(new GridLayout(16, 1, 0, 5));
        panel2.setLayout(null);

        label.setBounds(0, 0, panel2.getWidth(), panel2.getHeight());
        label.setLayout(new FlowLayout());
        label.setOpaque(true);
        label.setFont(new Font(null, Font.BOLD, 30));
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        //label.setHorizontalTextPosition(JLabel.CENTER);
        label.setText("This is Label");

        panel2.add(label);

        setListOfButtons();
        this.add(panel1);
        this.add(panel2);

        this.setVisible(true);
    }

    public void setListOfButtons() {
        JButton button;
        for (int i = 1; i < 17; i++) {
            button = new JButton();
            button.setText("Task " + i);
            button.addActionListener(this);
            button.setOpaque(true);
            panel1.add(button);
            listOfButtons.add(button);
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new Swing10TwoJPanel();
            }
        };
        SwingUtilities.invokeLater(runnable);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : listOfButtons) {
            if (e. getSource() == button) {
                if (listOfButtons.indexOf(button) % 2 == 1) {
                    label.setBackground(Color.PINK);
                    button.setBackground(Color.PINK);
                    label.setText("This is Label " + button.getText());
                }
                if (listOfButtons.indexOf(button) % 2 == 0) {
                    label.setBackground(new Color(30, 150, 30));
                    button.setBackground(Color.GREEN);
                    label.setText("This is Label " + button.getText());


                }
            }
        }

    }
}
