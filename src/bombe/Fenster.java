package bombe;

import utils.PlaySound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenster extends JFrame {
    private JButton bBombe;
    private JPanel pMain;
    private JLabel pPictureBombe;
    private JLabel lWarning;
    private JPanel pText;
    private JPanel pPicture;
    private JPanel pButton;

    public Fenster (){
        super();
        bBombe.addActionListener(new ActionListener() {
            int bombeZaehler = 10;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (--bombeZaehler == 0) {
                    PlaySound.playSound("sound.wav");
                    JOptionPane.showMessageDialog(null, "Bumm!");
                    bombeZaehler = 11;
                } else if (bombeZaehler == 3) {
                    pMain.setBackground(Color.red);
                } else if (bombeZaehler == 2) {
                    pText.setBackground(Color.red);
                    pButton.setBackground(Color.red);
                    bBombe.setForeground(Color.red);
                } else if (bombeZaehler == 1) {
                    pPicture.setBackground(Color.red);
                } else if (bombeZaehler == 10) {
                    pMain.setBackground(Color.getHSBColor(0,0,1));
                    pText.setBackground(Color.getHSBColor(0,0,1));
                    pPicture.setBackground(Color.getHSBColor(0,0,1));
                    pButton.setBackground(Color.getHSBColor(0,0,1));
                    bBombe.setBackground(Color.getHSBColor(0,0,1));
                }
                bBombe.setText(bombeZaehler + " Sekunden");
            }
        });
        add(pMain);

        setSize(800,600);
        setTitle("Marius' Bombe!");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Fenster();
    }
}