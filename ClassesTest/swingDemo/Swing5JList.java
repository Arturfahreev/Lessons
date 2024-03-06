package swingDemo;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Создать окно с отображением список строк и выводить строку выбора
 */


public class Swing5JList implements ListSelectionListener {

    JLabel jLabel;
    JList<String> jList;
    JScrollPane jScrollPane;
    String[] names = new String[] {
            "Tom", "Bob", "John", "Katy", "Rust"
    };

    Swing5JList() {
        JFrame jFrame = new JFrame("Choose names");
        jFrame.setSize(200, 160);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout());
        jFrame.setVisible(true);

        jList = new JList<>(names);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.addListSelectionListener(this);

        JScrollPane jScrollPane = new JScrollPane(jList);
        jScrollPane.setPreferredSize(new Dimension(120, 90));

        jLabel = new JLabel("Choose the name: ");

        jFrame.add(jScrollPane);
        jFrame.add(jLabel);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int index = jList.getSelectedIndex();
        if (index != -1) {
            jLabel.setText("Current selection: " + names[index]);
        } else {
            jLabel.setText("Choose the name");
        }

    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        new Swing5JList();
                    }
                };
        SwingUtilities.invokeLater(runnable);

    }


}
