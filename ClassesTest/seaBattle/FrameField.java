package seaBattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class FrameField extends JFrame implements ActionListener {

    SettingsFrame settingsFrame = new SettingsFrame();
    JFileChooser fileChooser = new JFileChooser();
    static ColorCheckFrame colorCheckFrame = new ColorCheckFrame();
    static Color colorOfBackground;

    JFrame frame;
    JMenuBar menuBar;
    JMenu gameMenu;
    JMenu helpMenu;
    JMenu exitMenu;
    JMenuItem startGameItem;
    JMenuItem settingsGameItem;
    JMenuItem restartGameItem;
    JMenuItem openFileGameItem;
    JMenuItem aboutHelpItem;
    JMenuItem exitItem;
    JButton buttonStartGame;
    JLabel label1;
    //public static boolean settingsFrameFlag;

    FrameField() {
        this.setTitle("Sea battle");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());

        menuBar = new JMenuBar();
        gameMenu = new JMenu("Game");
        helpMenu = new JMenu("Help");
        exitMenu = new JMenu("Exit");

        menuBar.add(gameMenu);
        menuBar.add(helpMenu);
        menuBar.add(exitMenu);

        startGameItem = new JMenuItem("Start Game");
        settingsGameItem = new JMenuItem("Settings");
        restartGameItem = new JMenuItem("Restart Game");
        openFileGameItem = new JMenuItem("Open File");
        aboutHelpItem = new JMenuItem("About Game");
        exitItem = new JMenuItem("Exit game");

        startGameItem.addActionListener(this);
        settingsGameItem.addActionListener(this);
        restartGameItem.addActionListener(this);
        aboutHelpItem.addActionListener(this);
        exitItem.addActionListener(this);
        openFileGameItem.addActionListener(this);


        gameMenu.add(startGameItem);
        gameMenu.add(settingsGameItem);
        gameMenu.add(restartGameItem);
        gameMenu.add(openFileGameItem);
        helpMenu.add(aboutHelpItem);
        exitMenu.add(exitItem);

        buttonStartGame = new JButton("START GAME");
        buttonStartGame.addActionListener(this);
        buttonStartGame.setVisible(false);


        this.setJMenuBar(menuBar);
        this.add(buttonStartGame);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startGameItem) {
            buttonStartGame.setVisible(true);
        }
        if (e.getSource() == settingsGameItem) {
//            if (FrameField.settingsFrameFlag == false) {
//                new SettingsFrame();
//                //FrameField.settingsFrameFlag = true;
//            }
            settingsFrame.setVisible(true);
        }
        if (e.getSource() == restartGameItem) {

        }

        if (e.getSource() == openFileGameItem) {
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            }
        }

    }

    public static void main(String[] args) {
        new FrameField();
    }
}

class SettingsFrame extends JFrame implements ActionListener {
    JLabel jLabel;
    JButton buttonColor;
    JButton buttonCheckColor;

    SettingsFrame() {
        this.setTitle("Settings");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(200, 200);
        this.setLayout(new FlowLayout());

        jLabel = new JLabel("Here your settings: ");
        this.add(jLabel);

        buttonColor = new JButton("Color of background");
        buttonCheckColor = new JButton("Check color");

        buttonColor.addActionListener(this);
        buttonCheckColor.addActionListener(this);

        this.add(buttonColor);
        this.add(buttonCheckColor);
        this.setVisible(false);

        //FrameField.settingsFrameFlag = true;
//        int defaultCloseOperation = this.getDefaultCloseOperation();
//        if (defaultCloseOperation == 1) {
//            FrameField.settingsFrameFlag = false;
//        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonColor) {
            FrameField.colorOfBackground = JColorChooser.showDialog(null, "Choose color", Color.BLACK);
            FrameField.colorCheckFrame.getContentPane().setBackground(FrameField.colorOfBackground);
        }

        if (e.getSource() == buttonCheckColor) {
            FrameField.colorCheckFrame.setVisible(true);
        }

    }
}

class ColorCheckFrame extends JFrame implements KeyListener {

    ImageIcon imageIcon;
    ImageIcon imageIconEnemy;
    JLabel label;
    JLabel labelEnemy;

    ColorCheckFrame() {

        this.setTitle("Check Color");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(800, 800);
        this.setLayout(null);
        //this.getContentPane().setBackground(Color.BLUE);
        this.addKeyListener(this);

        label = new JLabel();
        imageIcon = new ImageIcon("ShipPirate.png");
        label.setBounds(400, 400, 256, 256);
        //label.setBackground(Color.BLUE);
        //label.setOpaque(true);
        label.setIcon(imageIcon);

        labelEnemy = new JLabel();
        imageIconEnemy = new ImageIcon("EnemyShip.png");
        labelEnemy.setBounds(0, 0, 310, 310);
        //label.setBackground(Color.BLUE);
        //label.setOpaque(true);
        labelEnemy.setIcon(imageIconEnemy);


        this.getContentPane().setBackground(FrameField.colorOfBackground);
        this.add(label);
        this.add(labelEnemy);

        this.setVisible(false);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a' : label.setLocation(label.getX() - 20, label.getY());
            enemyMoving();
                break;
            case 'd' : label.setLocation(label.getX() + 20,  label.getY());
                break;
            case 'w' : label.setLocation(label.getX(), label.getY() - 20);
                break;
            case 's' : label.setLocation(label.getX(),  label.getY() + 20);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void enemyMoving () {
        int random;

        for (int i = 0; i < 10; i++) {
            random = (int) (Math.random() * 20);
            labelEnemy.setLocation(labelEnemy.getX() + random, labelEnemy.getY() + random);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
