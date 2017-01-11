package pl.pswbp.zi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static pl.pswbp.zi.MyGame.startGame;
import static pl.pswbp.zi.Saper.*;

class MyButtonListener extends MouseAdapter {
    private boolean click;

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        click = true;
        clickCount++;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        if (click) {
            int button = e.getButton();
            if (button == MouseEvent.BUTTON1) {  //action for left click
                if (!isDuringGame && isGameLoaded) {
                    startGame();
                }
                if (isDuringGame)
                showField((MyButton) e.getSource());
            }
            else
            if (button == MouseEvent.BUTTON3) {  // action for right click
                if (!isDuringGame && isGameLoaded) {
                    startGame();
                }
                if (isDuringGame)
                setGuess((MyButton) e.getSource());
            }
            else if (button == MouseEvent.BUTTON2)  // action for middle click
                if (isDuringGame) cheat();
        }
        click = false;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        click = false;
    }

}
