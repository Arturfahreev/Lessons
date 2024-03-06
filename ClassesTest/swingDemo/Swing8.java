package swingDemo;

import java.awt.BorderLayout; // подключаем BorderLayout
import javax.swing.*; // подключаем все средства java Swing

public class Swing8 { // класс с методом main()

    public static void main(String[] args) {
        JFrame frame = new JFrame("My First GUI");
        // добавляем панель
        JPanel buttonsPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null); // окно в центре экрана
        JButton start = new JButton("Старт");
        JButton stop = new JButton("Стоп");
        // добавляем кнопки на панель
        buttonsPanel.add(start);
        buttonsPanel.add(stop);
        // размещаем панель на Frame (верхняя часть)
        frame.getContentPane().add(BorderLayout.NORTH, buttonsPanel);
        frame.setVisible(true);
    }
}