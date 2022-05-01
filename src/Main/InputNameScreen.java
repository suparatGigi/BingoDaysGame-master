package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.MainDisplay.window;

public class InputNameScreen  extends JPanel{
    private JPanel inputNameScreen;

    public InputNameScreen(){

        inputNameScreen = new JPanel();

        //create box for enter name
        JTextField txtName = new JTextField();
        txtName.setSelectedTextColor(Color.magenta);
        txtName.setBounds(690, 340, 250, 50);

        //create set name button
        JButton setButton = new JButton();
        setButton.setBounds(490, 470, 319,90);
        setButton.setBackground(null);
        setButton.setContentAreaFilled(false);
        setButton.setFocusPainted(false);
        setButton.setBorderPainted(false);
        setButton.setToolTipText("SET YOUR NAME");

        ImageIcon setbuttonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/setbutton_new.png")); // เพิ่มรูปปุ่ม
        setButton.setIcon(setbuttonIcon);

        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.getContentPane().removeAll();
                MainDisplay.window.add(new Message1Screen());
                window.validate();
            }
        });

        setButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(inputNameScreen, "Hi, WELCOME " + txtName.getText() + " to The Bingo Days.", "Hi", JOptionPane.INFORMATION_MESSAGE);
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

        window.add(txtName);
        window.add(setButton);
    }

    public void paint(Graphics g) {
        repaint();
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage("src/image/InputNameScreen_new.png");
        Image sb = t.getImage("src/image/setbutton_new.png");
        Image xbutton = t.getImage("src/image/closebutton.png");

        g.drawImage(i, 0, 0, 1295,715,this);
        g.drawImage(sb, 490, 470, 319,90, this);
        g.drawImage(xbutton,970, 600, 325, 99,this);

    }




}
