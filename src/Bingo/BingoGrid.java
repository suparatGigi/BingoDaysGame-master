package Bingo;

import javax.swing.*;
import java.util.ArrayList;


public class BingoGrid extends JComponent {
    protected BingoSquare[][] grid;
    protected ArrayList<Integer> bingoGridNumbers;
    protected final int SQUARE_SIZE = 80;
    protected final int LENGTH = 4;
    protected final int WIDTH = 4;
    public int indentX; //set position of grid
    public int indentY;


    public BingoGrid() {
        grid = new BingoSquare[WIDTH][LENGTH]; //create bingo square 4x4 = 16 rectangle
        bingoGridNumbers = new ArrayList<>();
    }

    /**
     * Checks if the value created is already in the array
     *
     * @param value the number to check
     * @return true if the value is in the array
     */
    public boolean isFound(int value, int r, int c) {
        for (int row = 0; row < r; row++) {
            for (int col = 0; col <= c; col++) {
                if (value == grid[row][col].getValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Creates the Bingo.BingoSquare objects onto the grid and assigns them a value
     */
    public void initializeGrid() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = new BingoSquare(col * SQUARE_SIZE + indentX, row * SQUARE_SIZE + indentY, SQUARE_SIZE, SQUARE_SIZE);
                int value = grid[row][col].createNum(col + 1);
                while (isFound(value, row, col))
                    value = grid[row][col].createNum(col + 1);
            }
        }
    }

    /**
     * Checks if the grid has won according to the rules of Bingo
     * return true if grid has won
     */
    public boolean checkWin() {
        int winningNumber = 4;
        int count;

        //checks the rows
        for (int row = 0; row < grid.length; row++) {
            count = 0;
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col].getStatus()) {
                    grid[row][col].setIsWinner(true);
                    count++;
                }
                if (count == winningNumber) {
                    return true;
                }
            }
            this.removeIsWinnerMark();
        }

        //checks the columns
        for (int col = 0; col < grid[0].length; col++) {
            count = 0;
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col].getStatus()) {
                    grid[row][col].setIsWinner(true);
                    count++;
                }
                if (count == winningNumber) {
                    return true;
                }
            }
            this.removeIsWinnerMark();
        }

        //check diagonal from top-left to bottom-right ex.(0,0),(1,1),(2,2),(3,3)
        count = 0;
        for (int index = 0; index < grid.length; index++) {
            BingoSquare square = grid[index][index];
            if (square.getStatus()) {
                square.setIsWinner(true);
                count++;
            }
            if (count == winningNumber) {
                return true;
            }
        }
        this.removeIsWinnerMark();

        //check diagonal from bottom-left to top-right ex.(3,0),(2,2),(1,3),(0,3)
        count = 0;
        for (int index = grid.length - 1; index >= 0; index--) {
            BingoSquare square = grid[index][(grid.length - 1) - index];
            if (square.getStatus()) {
                square.setIsWinner(true);
                count++;
            }
            if (count == winningNumber) {
                return true;
            }
        }
        this.removeIsWinnerMark();

        //check 4 corner
        count = 0;
        //0,0
        BingoSquare square1 = grid[0][0];
        if (square1.getStatus()) {
            square1.setIsWinner(true);
            count++;
        }
        if (count == winningNumber) {
            return true;
        }
        this.removeIsWinnerMark();

        //0,3
        BingoSquare square2 = grid[0][3];
        if (square2.getStatus()) {
            square2.setIsWinner(true);
            count++;
        }
        if (count == winningNumber) {
            return true;
        }
        this.removeIsWinnerMark();

        //3,0
        BingoSquare square3 = grid[3][0];
        if (square3.getStatus()) {
            square3.setIsWinner(true);
            count++;
        }
        if (count == winningNumber) {
            return true;
        }
        this.removeIsWinnerMark();

        //3,3
        BingoSquare square4 = grid[3][3];
        if (square4.getStatus()) {
            square4.setIsWinner(true);
            count++;
        }
        if (count == winningNumber) {
            return true;
        }
        this.removeIsWinnerMark();
        return false;
    }

    public void removeIsWinnerMark() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col].setIsWinner(false);
            }
        }
    }

}


