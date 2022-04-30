package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Message3Screen extends JPanel {
    public Message3Screen() {

        //add message sound
        DisplayRunner.currentMusic = DisplayRunner.Message3Music;
        DisplayRunner.playMessage(DisplayRunner.currentMusic);

        //create awesome button
        JButton goodButton = new JButton();
        goodButton.setBounds(490, 450, 319, 90);
        goodButton.setBackground(null);
        goodButton.setContentAreaFilled(false);
        goodButton.setFocusPainted(false);
        goodButton.setBorderPainted(false);
        goodButton.setToolTipText("GOOD");

        ImageIcon goodButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/goodbutton.png")); // เพิ่มรูปปุ่ม
        goodButton.setIcon(goodButtonIcon);

        goodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainDisplay.window.getContentPane().removeAll();
                MainDisplay.window.add(new ChooseStageScreen());
                MainDisplay.window.validate();
            }
        });

        //crate return button
        JButton returnButton = new JButton();
        returnButton.setBounds(0, 600, 325, 99);
        returnButton.setBackground(null);
        returnButton.setContentAreaFilled(false);
        returnButton.setFocusPainted(false);
        returnButton.setBorderPainted(false);
        returnButton.setToolTipText("RETURN");

        ImageIcon returnButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/returnbutton.png")); // เพิ่มรูปปุ่ม
        returnButton.setIcon(returnButtonIcon);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainDisplay.window.getContentPane().removeAll();
                MainDisplay.window.add(new Message2Screen());
                MainDisplay.window.validate();
            }
        });

        //crate close button
        JButton closeButton = new JButton();
        closeButton.setBounds(970, 600, 325, 99);
        closeButton.setBackground(null);
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setToolTipText("CLOSE");

        ImageIcon closeButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/closebutton.png")); // เพิ่มรูปปุ่ม
        closeButton.setIcon(closeButtonIcon);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainDisplay.window.getContentPane().removeAll();
                MainDisplay.window.add(new StartScreen());
                MainDisplay.window.validate();
            }
        });

        MainDisplay.window.add(closeButton);
        MainDisplay.window.add(returnButton);
        MainDisplay.window.add(goodButton);
    }

    @Override
    public void paint(Graphics g) {
        repaint();
        Toolkit t = Toolkit.getDefaultToolkit(); //สร้าง Toolkit ไว้ import image
        Image i = t.getImage("src/image/Message3.png");
        Image gb = t.getImage("src/image/goodbutton.png");
        Image xbutton = t.getImage("src/image/closebutton.png");
        Image rebutton = t.getImage("src/image/returnbutton.png");

        g.drawImage(i,0,0,1295,715,this);
        g.drawImage(gb,490, 450,319,90,this);
        g.drawImage(xbutton,970, 600, 325, 99,this);
        g.drawImage(rebutton,0, 600, 325, 99,this);
    }
}
