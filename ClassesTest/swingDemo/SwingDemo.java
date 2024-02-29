package swingDemo;

import javax.swing.*;

/**
 * Создать простое окно приложения с надписью внутри
 */
public class SwingDemo {

    SwingDemo() {
        JFrame frame = new JFrame("Test window");
        frame.setSize(275, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JLabel label = new JLabel("Test label");
        frame.add(label);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        };

        SwingUtilities.invokeLater(runnable);
    }

}
