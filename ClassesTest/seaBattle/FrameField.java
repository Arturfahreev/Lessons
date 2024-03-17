package seaBattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Random;

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

/**
 SettingsFrame
 */

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

/**
 ColorCheckFrame
 */

class ColorCheckFrame extends JFrame implements KeyListener {

    ImageIcon imageIcon;
    ImageIcon imageIconEnemy;
    JLabel label;
    JLabel labelEnemy;
    JLabel shotLabel;
    //int countShots = 0;
    int yShot;
    boolean startGameFlag = false;

    ColorCheckFrame() {

        this.setTitle("Check Color");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(800, 800);
        this.setLayout(null);
        //this.setBackground(Color.BLUE);
        //this.getContentPane().setBackground(Color.BLUE);
        this.addKeyListener(this);
        this.getDefaultCloseOperation();

        label = new JLabel();
        imageIcon = new ImageIcon("ShipPirate.png");
        label.setBounds(400, 400, 256, 256);
        //label.setBackground(Color.BLUE);
        //label.setOpaque(true);
        label.setIcon(imageIcon);

        labelEnemy = new JLabel();
        imageIconEnemy = new ImageIcon("EnemyShip.png");
        labelEnemy.setBounds(300, 0, 256, 256);
        //label.setBackground(Color.BLUE);
        //label.setOpaque(true);
        labelEnemy.setIcon(imageIconEnemy);

        shotLabel = new JLabel();
        shotLabel.setBounds(300, 256, 27, 67);
        shotLabel.setBackground(Color.WHITE);
        yShot = 256;

        shotLabel.setIcon(new ImageIcon("Torpedo.png"));


        this.getContentPane().setBackground(FrameField.colorOfBackground);
        this.add(label);
        this.add(labelEnemy);
        this.add(shotLabel);


        this.setVisible(false);


    }

    public void startGame () {
        startGameFlag = true;
        Thread newThread = new Thread() {
            public void run() {
                while (startGameFlag != false) {
                    enemyMoving();
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e); 
                    }
                }
            }
        };
        newThread.start();


    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (startGameFlag == false) {
            startGame();
        }
        switch (e.getKeyChar()) {
            case 'a' : label.setLocation(label.getX() - 20, label.getY());
            //enemyMoving();
                break;
            case 'd' : label.setLocation(label.getX() + 20,  label.getY());
             //   enemyMoving();
                break;
            case 'w' : label.setLocation(label.getX(), label.getY() - 20);
            //    enemyMoving();
                break;
            case 's' : label.setLocation(label.getX(),  label.getY() + 20);
            //    enemyMoving();
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


        Random rn = new Random();
        int maximum = 40;
        int minimum = - 40;
        int random = rn.nextInt(maximum - minimum + 1) + minimum;

//        int random;
//        random = (int) ((Math.random() * 40) - 10);

        int x = labelEnemy.getX();
        if (x > this.getWidth() || x < 0) {
            x = (int)(this.getWidth() / 2);
        }

        labelEnemy.setLocation(x + random, labelEnemy.getY());
        shot(x + random, labelEnemy.getY());

//        countShots++;
//        if (countShots % 10 == 0) {
//            shot(x + random, labelEnemy.getY());
//        }


//        for (int i = 0; i < 10; i++) {
//            random = (int) ((Math.random() * 20) - 10);
//            labelEnemy.setLocation(labelEnemy.getX() + random, labelEnemy.getY());
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }

    public void shot(int x, int y) {
        if (shotLabel.isOpaque() == false) {
            shotLabel.setOpaque(true);
        }

        if (yShot < 800) {
            shotLabel.setLocation(x, yShot);
            yShot = yShot + 25;

        } else {
            yShot = 256;
            shotLabel.setLocation(x, yShot);

        }

//        for (int i = 0; i < 10; i++) {
//            y1 += 50;
//            shotLabel.setLocation(x1, y1);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }

//        while (y != this.getHeight()) {
//            shotLabel.setLocation(x, y + 30);
//        }



    }
}
