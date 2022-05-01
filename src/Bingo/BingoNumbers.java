package Bingo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BingoNumbers extends JComponent {
    public static ArrayList<Integer> numbers = new ArrayList<Integer>();

    public BingoNumbers() {}

    /**
     * Checks if value already exists in the ArrayList
     */
    public boolean isFound(int value)
    {
        for (int x : numbers) {
            if (value == (int) x)
                return true;
        }
        return false;
    }

    /**
     * Creates a unique number from 1-60 and puts it into the ArrayList
     */
    public void generateNumber() {
        boolean exit = false;
        Random generator = new Random();

        while (!exit && numbers.size() != 60) {
            int newNumber = generator.nextInt(60) + 1;  //1 - 60
            if (!isFound(newNumber)) {
                numbers.add(newNumber);
                exit = true;
            }
        }
    }

    /**
     * Displays the numbers
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //font anti-aliasing
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int fontSize = 45;
        int bigFont = 70;
        Font font = new Font("SansSerif", Font.PLAIN, fontSize);
        g2.setFont(font);



        //Calling number
        if (!numbers.isEmpty()) {
            int number = numbers.get(numbers.size() - 1);
            int xCoord = 165;
            int yCoord = 468;
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
