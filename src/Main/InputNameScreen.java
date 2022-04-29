package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.MainDisplay.window;

public class InputNameScreen  extends JPanel{

    private JPanel inputNameScreen;


    public InputNameScreen(){

        this.inputNameScreen = new JPanel();

        //create box for enter name
        JTextField txtName = new JTextField();
        txtName.setSelectedTextColor(Color.black);
        txtName.setBounds(656, 350, 250, 50);

        //crate set name button
        JButton setButton = new JButton();
        setButton.setBounds(550, 450, 200, 89);
        setButton.setBackground(null);
        setButton.setContentAreaFilled(false);
        setButton.setFocusPainted(false);
        setButton.setBorderPainted(false);
        ImageIcon setbuttonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/setButton copy.png")); // เพิ่มรูปปุ่ม
        setButton.setIcon(setbuttonIcon);
        setButton.setToolTipText("SET YOUR NAME");

        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.getContentPane().removeAll();
                //MainDisplay.window.add(new Stage.MondayStage());
                MainDisplay.window.add(new ChooseStageScreen());
                window.validate();
            }
        });



        setButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(inputNameScreen, "Hi, WELCOME " + txtName.getText() + " to The Bingo Days.", "Hi", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        MainDisplay.window.add(txtName);
        MainDisplay.window.add(setButton);
    }

    public void paint(Graphics g) {
        repaint();
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage("src/image/screen_InputName copy.png");
        Image sb = t.getImage("src/image/setButton copy.png");

        g.drawImage(i, 0, 0, this);
        g.drawImage(sb, 550, 450, 200, 89, this);
    }
}
