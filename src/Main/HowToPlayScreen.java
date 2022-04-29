package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToPlayScreen extends JPanel {

    public HowToPlayScreen(){

      //create close button
        JButton closeButton = new JButton();
        closeButton.setBounds(1180, 4, 90, 88);
        closeButton.setBackground(null);
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setToolTipText("CLOSE");

        ImageIcon closeButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/Xbutton.png")); // เพิ่มรูปปุ่ม
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

    }
    public void paint(Graphics g){
        repaint();
        Toolkit t= Toolkit.getDefaultToolkit();
        Image i =t.getImage("src/image/Bg2.png");
        Image xb=t.getImage("src/image/Xbutton.png");

        g.drawImage(i,0,0,this);
        g.drawImage(xb,1180, 4, 90, 88,this);

    }
}

