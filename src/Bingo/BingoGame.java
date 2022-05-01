package Bingo;

import Main.ChooseStageScreen;
import Main.LoseScreen;
import Main.WinScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BingoGame extends JFrame{

    private JButton reset;
    private JButton bingo;
    private JButton nextNum;
    private JButton start;
    private JButton stop;
    private Container layout;

    private BingoNumbers bingoNumbers;
    private BingoClick clickGrid;

    private MouseListener mouseListener;
    private ActionListener timer;
    private ActionListener buttonListener;
    private final int DELAY;
    private boolean startGame = false;
    public static boolean winner = false;

    public static JPanel panel;

    public BingoGame() {
        setSize(1295, 715); //ขนาดหน้าต่าง
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Bingo Days Game"); //ชื่อบนหัวหน้าต่าง

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

        layout = this.getContentPane();
        layout.add(panel, "South"); //set position of button
        setVisible(true);

        mouseListener = new MouseClickListener();
        timer = new MyTimer();
        DELAY = 2500;
        Timer t = new Timer(DELAY, timer);
        t.start();

        clickGrid = new BingoClick();

        bingoNumbers = new BingoNumbers();

        add(clickGrid);
        setVisible(true);
        clickGrid.addMouseListener(mouseListener);

        add(bingoNumbers);
        setVisible(true);

    }

    //the timer
    class MyTimer implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (startGame && !winner) {
                bingoNumbers.generateNumber();
                clickGrid.isCalled();
                bingoNumbers.repaint();
            }
        }
    }

    //The Mouse listener
    class MouseClickListener implements MouseListener {
        public void mousePressed(MouseEvent event) {
            int x = event.getX();
            int y = event.getY();
            clickGrid.highlightSquare(x, y);
        }

        public void mouseReleased(MouseEvent event) {}

        public void mouseClicked (MouseEvent event) {}

        public void mouseEntered(MouseEvent event) {}

        public void mouseExited(MouseEvent event) {}
    }

    //the button listener
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Object source = event.getSource();
            if (source == reset) { //resets the boards and the bingo number callings
                clickGrid.initializeGrid();
                clickGrid.hightlightfree();
                bingoNumbers.numbers.clear();
                winner = false;
            } else if (source == bingo) { //checks if the human grid has won
                if (!winner) {
                    if (clickGrid.checkWin()) {
                        winner = true;
                        if (ChooseStageScreen.numStage == 1 )   BingoScore.highScore += 20;
                        else if (ChooseStageScreen.numStage == 2 )  BingoScore.highScore += 30;
                        else if (ChooseStageScreen.numStage == 3 )  BingoScore.highScore += 40;
                        else if (ChooseStageScreen.numStage == 4 )  BingoScore.highScore += 50;
                        else if (ChooseStageScreen.numStage == 5 )  BingoScore.highScore += 60;
                        else if (ChooseStageScreen.numStage == 6 )  BingoScore.highScore += 70;
                        else if (ChooseStageScreen.numStage == 7 )  BingoScore.highScore += 80;
                        if(winner) {
                            getContentPane().removeAll();
                            add(new WinScreen());
                            validate();
                        }

                    } else {
                        if(winner == false) {
                            getContentPane().removeAll();
                            add(new LoseScreen());
                            validate();
                        }
                    }
                    clickGrid.initializeGrid();
                    clickGrid.hightlightfree();
                    bingoNumbers.numbers.clear();
                    winner = false;
                }
            } else if (source == nextNum) { //calls the next bingo number and checks for winner
                if (!winner) {
                    bingoNumbers.generateNumber();
                    clickGrid.isCalled();

                }
            } else if (source == start) { //starts the game
                startGame = true;
            } else if (source == stop) { //stops/pauses the game
                startGame = false;
            }
            clickGrid.repaint();
            bingoNumbers.repaint();
            layout.repaint();
        }
    }
}

