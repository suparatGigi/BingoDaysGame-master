package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JPanel {

    public StartScreen() {

        //create start button
        JButton startButton = new JButton();
        startButton.setBounds(490, 350,319,90);
        startButton.setBackground(null);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startButton.setToolTipText("LET'S GET START");

        ImageIcon startButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/startbutton_new.png")); // เพิ่มรูปปุ่ม
        startButton.setIcon(startButtonIcon);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainDisplay.window.getContentPane().removeAll();
                MainDisplay.window.add(new InputNameScreen());
                MainDisplay.window.validate();
            }
        });

        //create how to play Button
        JButton howToPlayButton = new JButton();
        howToPlayButton.setBounds(420, 450, 447,94);
        howToPlayButton.setBackground(null);
        howToPlayButton.setContentAreaFilled(false);
        howToPlayButton.setFocusPainted(false);
        howToPlayButton.setBorderPainted(false);
        howToPlayButton.setToolTipText("HOW TO PLAY");

        ImageIcon howToPlayButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/howtoplaybutton_new.png")); // เพิ่มรูปปุ่ม
        howToPlayButton.setIcon(howToPlayButtonIcon);

        howToPlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainDisplay.window.getContentPane().removeAll();
                MainDisplay.window.add(new HowToPlayScreen());
                MainDisplay.window.validate();
            }
        });

        //create exit button
        JButton exitButton = new JButton();
        exitButton.setBounds(490, 554, 319,90);
        exitButton.setBackground(null);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.setBorderPainted(false);
        exitButton.setToolTipText("CLOSE");

        ImageIcon exitButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/exitbutton.png")); // เพิ่มรูปปุ่ม
        exitButton.setIcon(exitButtonIcon);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainDisplay.window.dispose();
            }
        });

        MainDisplay.window.add(exitButton);
        MainDisplay.window.add(startButton);
        MainDisplay.window.add(howToPlayButton);

    }
    public void paint(Graphics g){
        repaint();
        Toolkit t = Toolkit.getDefaultToolkit(); //สร้าง Toolkit ไว้ import image
        Image i = t.getImage("src/image/StartScreen.png");
        Image sb = t.getImage("src/image/startbutton_new.png");
        Image hb = t.getImage("src/image/howtoplaybutton_new.png");
        Image xb = t.getImage("src/image/exitbutton.png");

        g.drawImage(i,0,0,1295,715,this);
        g.drawImage(sb,490, 350,319,90,this);
        g.drawImage(hb,420, 450, 447,94,this);
        g.drawImage(xb,490, 554,319,90,this);

    }
}