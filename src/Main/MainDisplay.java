package Main;

import Bingo.BingoClick;
import Bingo.BingoGame;
import Bingo.BingoNumbers;

import javax.swing.*;
import java.awt.*;

public class MainDisplay {
    public static JFrame window;

    public MainDisplay(){

        //create window JFrame
        window = new JFrame();
        window.setSize(1295, 715); //ขนาดหน้าต่าง
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setTitle("Bingo Days Game"); //ชื่อบนหัวหน้าต่าง
        window.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));  //ไอคอน
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //กดปิดwindow

        //begin with start screen
       // window.add(new StartScreen());
        JLabel mondayBackground = new JLabel();
        mondayBackground.setBounds(0, 0, 1295, 715);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("image/bgmon copy.jpg")); // เพิ่มBackground
        mondayBackground.setIcon(bgIcon);

       window.add(new BingoGame());



    }
}
