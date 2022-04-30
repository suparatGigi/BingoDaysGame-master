package Bingo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BingoNumbers extends JComponent {
    public static ArrayList<Integer> numbers = new ArrayList<Integer>();

    public BingoNumbers() {}

    /**
     * Checks if <code>value</code> already exists in the ArrayList
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
     * Creates a unique number from 1-75 and puts it into the ArrayList
     */
    public void generateNumber() {
        boolean exit = false;
        Random generator = new Random();

        while (!exit && numbers.size() != 75) {
            int newNumber = generator.nextInt(75) + 1;  //1 - 75
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
        int bigFont = 80;
        Font font = new Font("SansSerif", Font.PLAIN, fontSize);
        g2.setFont(font);

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
