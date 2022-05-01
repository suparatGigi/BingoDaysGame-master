package Bingo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BingoClick extends BingoGrid{

    public static ArrayList<Integer> numbers = new ArrayList<Integer>();
    public BingoClick() {
        super();

        indentX = 485;
        indentY = 240;
        initializeGrid();

    }

    /**
     * Highlights the square if it is clicked
     */
    public void highlightSquare(int x, int y) {
        for (int row = 0; row < WIDTH; row++) {
            for (int col = 0; col < LENGTH; col++) {
                BingoSquare square = grid[row][col];
                if (row == 2 && col == 2) {}
                else if (square.contains(x, y)) {
                    if (square.getIsClicked()) {
                        square.setIsClicked(false);
                    } else {
                        square.setIsClicked(true);
                    }
                    break;
                }
            }
        }
        repaint();
    }

    /**
     * Checks if a number in the grid has been called
     * if it has been called, set the status for that Bingo.BingoSquare to be true
     */
    public void isCalled() {
        for (int x : BingoNumbers.numbers) {
            for (int row = 0; row < WIDTH; row++) {
                for (int col = 0; col < LENGTH; col++) {
                    if (x == grid[row][col].getValue()) {
                        grid[row][col].setStatus(true);
                    }
                }
            }
        }
    }

    /**
     * Draws the grid
     * @param g the graphics component
     */
    public void paintComponent(Graphics g) {

        Toolkit t = Toolkit.getDefaultToolkit(); //สร้าง Toolkit ไว้ import image
        Image i = t.getImage("src/image/StartScreen.png");
        g.drawImage(i,0,0,1295,715,this);

        Graphics2D g2 = (Graphics2D) g;

        //font anti-aliasing
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int fontSize = 45; //font for everything else
        Font font = new Font("SansSerif", Font.PLAIN, fontSize);

        g2.setFont(font);

        //draws the board
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {
                BingoSquare square = grid[row][col];

                g2.draw(square);

                //highlights the square if it is clicked
                if (square.getIsClicked() ) {
                    g2.setColor(Color.YELLOW);
                    g2.fill(square);
                    g2.setColor(Color.BLACK);
                    g2.draw(square);
                }

                //highlights the square if it is part of the winning sequence
                if (square.getIsWinner()) {
                    g2.setColor(Color.GREEN);
                    g2.fill(square);
                    g2.setColor(Color.BLACK);
                    g2.draw(square);
                }

                //freebie
                if (row == 2 && col == 2) {
                } else {
                    int value = grid[row][col].getValue();
                    int xCoord = (int) square.getX() + (SQUARE_SIZE / 4);
                    int yCoord = (int) square.getY() + (SQUARE_SIZE / 2) + (SQUARE_SIZE / 8);
                    if (value < 10)
                        g2.drawString(" " + value + "", xCoord, yCoord);
                    else
                        g2.drawString(value + "", xCoord, yCoord);
                }
            }
        }

        //prints meseage high score
        String highScoreMessage = " " + BingoScore.getHighScore();
        g2.drawString(highScoreMessage, 1120,68);

        //prints message if grid has won
        g2.setColor(Color.RED);
        g2.drawString(winnerMessage, 70, 300);

        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);


        int bigFont = 80;

        String call = "Calling: ";
        g2.drawString(call, 70, 225);
        if (!numbers.isEmpty()) {
            int number = numbers.get(numbers.size() - 1);
            int xCoord = 240;
            int yCoord = 230;
            g2.setFont(new Font("SansSerif", Font.BOLD, bigFont));
            if (number <= 15) {
                g2.drawString("D-" + number, xCoord, yCoord);
            } else if (number <= 30) {
                g2.drawString("A-" + number, xCoord, yCoord);
            } else if (number <= 45) {
                g2.drawString("Y-" + number, xCoord, yCoord);
            } else if (number <= 60) {
                g2.drawString("S-" + number, xCoord, yCoord);
            }
        }


    }
}
