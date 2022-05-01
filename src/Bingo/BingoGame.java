package Bingo;

import Main.*;
import Stage.MondayStage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BingoGame extends JPanel {

    public static final int WIDTH = 1295;
    public static final int LENGTH = 715;

    public static JButton reset;
    public static JButton bingo;
    public static JButton nextNum;
    public static JButton start;
    public static JButton stop;
    public Container layout;
    public Container boxLayout;

    private ActionListener buttonListener;
    public static BingoNumbers bingoNumbers;
    public static BingoClick clickGrid;


    public static boolean startGame = false;
    public static boolean winner = false;

    public static JPanel panel;

    public BingoGame() {

        //create panel for container button
        panel = new JPanel();
        //panel.setBackground(new Color(0,0,0,0));

        //JButtons
        reset = new JButton();
        bingo = new JButton();
        nextNum = new JButton();
        start = new JButton();
        stop = new JButton();

        //add JButtons to the panel
        ImageIcon buttonIcon;

        //start
        panel.add(start);
        start.setBounds(0, 0, 230, 66);
        start.setBackground(null);
        start.setContentAreaFilled(false);
        start.setFocusPainted(false);
        start.setBorderPainted(false);

        buttonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/startbingo.png")); // เพิ่มรูปปุ่ม
        start.setIcon(buttonIcon);

        //stop
        panel.add(stop);
        stop.setBounds(0, 0, 230, 66);
        stop.setBackground(null);
        stop.setContentAreaFilled(false);
        stop.setFocusPainted(false);
        stop.setBorderPainted(false);

        buttonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/pause.png")); // เพิ่มรูปปุ่ม
        stop.setIcon(buttonIcon);

        //bingo
        panel.add(bingo);
        bingo.setBounds(500, 0, 230, 66);
        bingo.setBackground(null);
        bingo.setContentAreaFilled(false);
        bingo.setFocusPainted(false);
        bingo.setBorderPainted(false);

        buttonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/bingo_new.png")); // เพิ่มรูปปุ่ม
        bingo.setIcon(buttonIcon);

        //reset
        panel.add(reset);
        reset.setBounds(200, 0, 230, 66);
        reset.setBackground(null);
        reset.setContentAreaFilled(false);
        reset.setFocusPainted(false);
        reset.setBorderPainted(false);

        buttonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/reset.png")); // เพิ่มรูปปุ่ม
        reset.setIcon(buttonIcon);

        //random
        panel.add(nextNum);
        nextNum.setBounds(800, 0, 230, 66);
        nextNum.setBackground(null);
        nextNum.setContentAreaFilled(false);
        nextNum.setFocusPainted(false);
        nextNum.setBorderPainted(false);

        buttonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/ramdom_new.png")); // เพิ่มรูปปุ่ม
        nextNum.setIcon(buttonIcon);

        //creates tooltips for buttons
        reset.setToolTipText("Resets the game");
        bingo.setToolTipText("I have bingo!");
        nextNum.setToolTipText("Call next number");
        start.setToolTipText("Starts/resumes the game");
        stop.setToolTipText("Stops/pauses the game");

        //adds ActionListeners to buttons
        buttonListener = new ButtonListener();
        reset.addActionListener(buttonListener);
        bingo.addActionListener(buttonListener);
        nextNum.addActionListener(buttonListener);
        start.addActionListener(buttonListener);
        stop.addActionListener(buttonListener);

        MainDisplay.window.add(panel, "South");
    }

    //the button listener
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Object source = event.getSource();
            if (source == reset) { //resets the boards and the bingo number callings
                clickGrid.initializeGrid();
                bingoNumbers.numbers.clear();
                winner = false;
            } else if (source == bingo) { //checks if the human grid has won
                if (!winner) {
                    if (clickGrid.checkWin()) {
                        clickGrid.setWinnerMessage("BINGO");
                        winner = true;
                        if (ChooseStageScreen.numStage == 1) BingoScore.highScore += 20;
                        else if (ChooseStageScreen.numStage == 2) BingoScore.highScore += 30;
                        else if (ChooseStageScreen.numStage == 3) BingoScore.highScore += 40;
                        else if (ChooseStageScreen.numStage == 4) BingoScore.highScore += 50;
                        else if (ChooseStageScreen.numStage == 5) BingoScore.highScore += 60;
                        else if (ChooseStageScreen.numStage == 6) BingoScore.highScore += 70;
                        else if (ChooseStageScreen.numStage == 7) BingoScore.highScore += 80;
                        if (winner == true) {
                            MainDisplay.window.getContentPane().removeAll();
                            MainDisplay.window.add(new WinScreen());
                            MainDisplay.window.validate();
                        }
                    } else {
                        clickGrid.setWinnerMessage("Sorry, you haven't gotten bingo.");
                        if (winner == false) {
                            MainDisplay.window.getContentPane().removeAll();
                            MainDisplay.window.add(new LoseScreen());
                            MainDisplay.window.validate();
                        }
                    }
                }
            } else if (source == nextNum) { //calls the next bingo number and checks for winner
                if (!winner) {
                    bingoNumbers.generateNumber();
                    clickGrid.setWinnerMessage("");
                    clickGrid.isCalled();

                }
            } else if (source == start) { //starts the game
                startGame = true;
            } else if (source == stop) { //stops/pauses the game
                startGame = false;
            }
            clickGrid.repaint();
            bingoNumbers.repaint();
//        layout.repaint();
        }

    }
}

