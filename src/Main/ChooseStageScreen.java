package Main;

import Bingo.BingoScore;
import Stage.MondayStage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.awt.Font;
import java.io.IOException;

public class ChooseStageScreen extends JPanel {
    public static JPanel chooseStageScreen;
    private JLabel chooseStageBackground;
    public static int numStage = 0;

    public void paint(Graphics g){
        repaint();
        Toolkit t = Toolkit.getDefaultToolkit(); //สร้าง Toolkit ไว้ import image
        Image bg = t.getImage("src/image/ChooseScreen copy.png");
        Image xbutton = t.getImage("src/image/closebutton.png");
        Image rebutton = t.getImage("src/image/returnbutton.png");
        Image mon = t.getImage("src/image/mon.png");
        Image tue = t.getImage("src/image/tue.png");
        Image wed = t.getImage("src/image/wed.png");
        Image thu = t.getImage("src/image/thu.png");
        Image fri = t.getImage("src/image/fri.png");
        Image sat = t.getImage("src/image/sat.png");
        Image sun = t.getImage("src/image/sun.png");


        g.drawImage(bg,0,0,1295,715,this);
        g.drawImage(xbutton,970, 600, 325, 99,this);
        g.drawImage(rebutton,0, 600, 325, 99,this);
        g.drawImage(tue,400, 130, 200, 248,this);
        g.drawImage(mon,150, 130, 200, 248,this);
        g.drawImage(tue,400, 130, 200, 248,this);
        g.drawImage(wed,650, 130, 200, 248,this);
        g.drawImage(thu,900, 130, 200, 248,this);
        g.drawImage(fri,300, 390, 200, 248,this);
        g.drawImage(sat,550, 390, 200, 248,this);
        g.drawImage(sun,800, 390, 200, 248,this);
/*
        //lock
        Image ll = t.getImage("src/image/lockIcon.png");
        Image lsat = t.getImage("src/image/lockIconsat.png");

        g.drawImage(ll,401,130,200,208,this); //tue
        g.drawImage(ll,649,130,210,213,this); //wed
        g.drawImage(ll,899,130,210,213,this); //thu
        g.drawImage(ll,300,393,210,213,this); //fri
        g.drawImage(ll,800,393,210,213,this); //sun
        g.drawImage(lsat,550,393,200,245,this); //sat
*/
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        Font font = new Font("Franxurter-w11D9.ttf", Font.PLAIN, 45);
        g2.setFont(font);

//        try{
//            Font font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("font/Franxurter-w11D9.ttf"));
//            font = font.deriveFont(Font.PLAIN, 100);
//            g2.setFont(font);
//        }
//        catch (Exception error){
//
//        }

        //prints message high score:
        String highScoreMessage = " "+ BingoScore.getHighScore();
        g2.drawString(highScoreMessage, 1148,65);

        //prints message NEXT UNLOCKED
        String nextUnlockMessage = " " + BingoScore.getNextUnlocked();
        g2.drawString(nextUnlockMessage, 460,65);

    }

    public ChooseStageScreen(){
        //Monday button
        createMondayButton();

        //Tuesday button
        createTuesdayButton();

        //Wednesday button
        createWednesdayButton();

        //Thursday button
        createThursdayButton();

        //Friday button
        createFridayButton();

        //Saturday button
        createSaturdayButton();

        //Sunday button
        createSundayButton();

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
                MainDisplay.window.add(new Message3Screen());
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

    }


    public void createMondayButton() {
        //create button
        JButton mondayButton = new JButton();
        mondayButton.setBounds(150, 130, 200, 248);
        mondayButton.setBackground(null);
        mondayButton.setContentAreaFilled(false);
        mondayButton.setFocusPainted(false);
        mondayButton.setBorderPainted(false);
        mondayButton.setToolTipText("MONDAY");

        ImageIcon mondayButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/mon.png")); // เพิ่มรูปปุ่ม
        mondayButton.setIcon(mondayButtonIcon);

        mondayButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    numStage = 1;
                    MainDisplay.window.add(new MondayStage());
                    MainDisplay.window.validate();
                }
            });
        MainDisplay.window.add(mondayButton);

    }

        public void createTuesdayButton() {
            //create button
            JButton tuesdayButton = new JButton();
            tuesdayButton.setBounds(400, 130, 200, 248);
            tuesdayButton.setBackground(null);
            tuesdayButton.setContentAreaFilled(false);
            tuesdayButton.setFocusPainted(false);
            tuesdayButton.setBorderPainted(false);
            tuesdayButton.setToolTipText("TUESDAY");

            ImageIcon tuesdayButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/tue.png")); // เพิ่มรูปปุ่ม
            tuesdayButton.setIcon(tuesdayButtonIcon);

            //lock button
//            JLabel lockbutton = new JLabel();
//            lockbutton.setBounds(401,130,200,208);
//            ImageIcon lockIcon = new ImageIcon(getClass().getClassLoader().getResource("image/lockIcon.png"));
//            lockbutton.setIcon(lockIcon);
//            MainDisplay.window.add(lockbutton);

            if(BingoScore.getHighScore() >= 20) {
                //MainDisplay.window.remove(lockbutton);
                //MainDisplay.window.remove(ll);
                tuesdayButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        numStage = 2;
                        //MainDisplay.window.getContentPane().removeAll();
                        MainDisplay.window.add(new Stage.TuesdayStage());
                        MainDisplay.window.validate();
                    }
                });
            }
            MainDisplay.window.add(tuesdayButton);
        }

    public void createWednesdayButton() {
        //create button
        JButton wednesdayButton = new JButton();
        wednesdayButton.setBounds(650, 130, 200, 248);
        wednesdayButton.setBackground(null);
        wednesdayButton.setContentAreaFilled(false);
        wednesdayButton.setFocusPainted(false);
        wednesdayButton.setBorderPainted(false);
        wednesdayButton.setToolTipText("WEDNESDAY");

        ImageIcon wednesdayButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/wed.png")); // เพิ่มรูปปุ่ม
        wednesdayButton.setIcon(wednesdayButtonIcon);

        //lock button
//        JLabel lockbutton = new JLabel();
//        lockbutton.setBounds(649,130,210,213);
//        ImageIcon lockIcon = new ImageIcon(getClass().getClassLoader().getResource("image/lockIcon.png"));
//        lockbutton.setIcon(lockIcon);
//        MainDisplay.window.add(lockbutton);

        if(BingoScore.getHighScore() >= 60) {
            //MainDisplay.window.remove(lockbutton);
            wednesdayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    numStage = 3;
                    //MainDisplay.window.getContentPane().removeAll();
                    MainDisplay.window.add(new Stage.WednesdayStage());
                    MainDisplay.window.validate();
                }
            });
        }
        MainDisplay.window.add(wednesdayButton);
    }

    public void createThursdayButton() {
        //create button
        JButton thursdayButton = new JButton();
        thursdayButton.setBounds(900, 130, 200, 248);
        thursdayButton.setBackground(null);
        thursdayButton.setContentAreaFilled(false);
        thursdayButton.setFocusPainted(false);
        thursdayButton.setBorderPainted(false);
        thursdayButton.setToolTipText("THURSDAY");

        ImageIcon thursdayButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/thu.png")); // เพิ่มรูปปุ่ม
        thursdayButton.setIcon(thursdayButtonIcon);

        //lock button
//        JLabel lockbutton = new JLabel();
//        lockbutton.setBounds(899,130,210,213);
//        ImageIcon lockIcon = new ImageIcon(getClass().getClassLoader().getResource("image/lockIcon.png"));
//        lockbutton.setIcon(lockIcon);
//        MainDisplay.window.add(lockbutton);

        if(BingoScore.getHighScore() >= 110) {
            //MainDisplay.window.remove(lockbutton);
            thursdayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    numStage = 4;
                    //MainDisplay.window.getContentPane().removeAll();
                    MainDisplay.window.add(new Stage.ThursdayStage());
                    MainDisplay.window.validate();
                }
            });
        }
        MainDisplay.window.add(thursdayButton);
    }

    public void createFridayButton() {
        //create button
        JButton fridayButton = new JButton();
        fridayButton.setBounds(300, 390, 200, 248);
        fridayButton.setBackground(null);
        fridayButton.setContentAreaFilled(false);
        fridayButton.setFocusPainted(false);
        fridayButton.setBorderPainted(false);
        fridayButton.setToolTipText("FRIDAY");

        ImageIcon fridayButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/fri.png")); // เพิ่มรูปปุ่ม
        fridayButton.setIcon(fridayButtonIcon);

        //lock button
//        JLabel lockbutton = new JLabel();
//        lockbutton.setBounds(300,393,210,213);
//        ImageIcon lockIcon = new ImageIcon(getClass().getClassLoader().getResource("image/lockIcon.png"));
//        lockbutton.setIcon(lockIcon);
//        MainDisplay.window.add(lockbutton);

        if(BingoScore.getHighScore() >= 200) {
            //MainDisplay.window.remove(lockbutton);
            fridayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    numStage = 5;
                    //MainDisplay.window.getContentPane().removeAll();
                    MainDisplay.window.add(new Stage.FridayStage());
                    MainDisplay.window.validate();
                }
            });
        }
        MainDisplay.window.add(fridayButton);
    }

    public void createSaturdayButton() {
        //create button
        JButton saturdayButton = new JButton();
        saturdayButton.setBounds(550, 390, 200, 248);
        saturdayButton.setBackground(null);
        saturdayButton.setContentAreaFilled(false);
        saturdayButton.setFocusPainted(false);
        saturdayButton.setBorderPainted(false);
        saturdayButton.setToolTipText("SATURDAY");

        ImageIcon saturdayButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/sat.png")); // เพิ่มรูปปุ่ม
        saturdayButton.setIcon(saturdayButtonIcon);

        //lock button
//        JLabel lockbutton = new JLabel();
//        lockbutton.setBounds(550,393,200,245);
//        ImageIcon lockIcon = new ImageIcon(getClass().getClassLoader().getResource("image/lockIconsat.png"));
//        lockbutton.setIcon(lockIcon);
//        MainDisplay.window.add(lockbutton);

        if(BingoScore.getHighScore() >= 300) {
            //MainDisplay.window.remove(lockbutton);
            saturdayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    numStage = 6;
                    //MainDisplay.window.getContentPane().removeAll();
                    MainDisplay.window.add(new Stage.SaturdayStage());
                    MainDisplay.window.validate();
                }
            });
        }
        MainDisplay.window.add(saturdayButton);

    }

    public void createSundayButton() {
        //create button
        JButton sundayButton = new JButton();
        sundayButton.setBounds(800, 390, 200, 248);
        sundayButton.setBackground(null);
        sundayButton.setContentAreaFilled(false);
        sundayButton.setFocusPainted(false);
        sundayButton.setBorderPainted(false);
        sundayButton.setToolTipText("SUNDAY");

        ImageIcon sundayButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/sun.png")); // เพิ่มรูปปุ่ม
        sundayButton.setIcon(sundayButtonIcon);

        //lock button
//        JLabel lockbutton = new JLabel();
//        lockbutton.setBounds(800,393,210,213);
//        ImageIcon lockIcon = new ImageIcon(getClass().getClassLoader().getResource("image/lockIcon.png"));
//        lockbutton.setIcon(lockIcon);
//        MainDisplay.window.add(lockbutton);

        if(BingoScore.getHighScore() >= 400) {
            //MainDisplay.window.remove(lockbutton);
            sundayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    numStage = 7;
                    //MainDisplay.window.getContentPane().removeAll();
                    MainDisplay.window.add(new Stage.SundayStage());
                    MainDisplay.window.validate();
                }
            });
        }
        MainDisplay.window.add(sundayButton);

    }

}

