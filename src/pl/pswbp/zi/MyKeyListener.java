package pl.pswbp.zi;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static pl.pswbp.zi.MyGame.pauseGame;
import static pl.pswbp.zi.MyLevels.*;
import static pl.pswbp.zi.MyWindow.*;
import static pl.pswbp.zi.Saper.*;

class MyKeyListener extends KeyAdapter {

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        int button = e.getKeyCode();
        if (button == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } else
        if (button == KeyEvent.VK_S) {
            if (scoreFrame.isVisible()){
                scoreFrame.setVisible(false);
            } else scoreFrame.setVisible(true);
        } else
        if (button == KeyEvent.VK_F1) {
            if (helpFrame.isVisible()){
                helpFrame.setVisible(false);
            } else helpFrame.setVisible(true);
        } else
        if (button == KeyEvent.VK_F2) {
            if (easy.isSelected()) {
                MyLevels.LevelEasy();
            }
            else
            if (medium.isSelected()) {
                MyLevels.LevelMedium();
            }
            else
            if (hard.isSelected()) {
                MyLevels.LevelHard();
            }
        } else
        if (button == KeyEvent.VK_F3) {
            pauseGame();
        } else
        if (button == KeyEvent.VK_1) {
            easy.setSelected(true);
            LevelEasy();
        } else
        if (button == KeyEvent.VK_2) {
            medium.setSelected(true);
            LevelMedium();
        } else
        if (button == KeyEvent.VK_3) {
            hard.setSelected(true);
            LevelHard();
        }
    }
}
