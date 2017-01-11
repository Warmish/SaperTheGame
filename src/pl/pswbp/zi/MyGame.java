package pl.pswbp.zi;

import javax.swing.*;
import java.awt.*;

import static pl.pswbp.zi.MyTimer.*;
import static pl.pswbp.zi.Saper.*;

class MyGame {

    static int countScore(int minesFound, int passedTime, int clickCount){
        int score = 0;
        if (isEasyGame){
            score = 1000*minesFound - 10*(passedTime/30) - clickCount - 500*wrongGuess;
        } else
        if (isMediumGame){
            score = 5*(1000*minesFound - 10*(passedTime/30) - clickCount - 500*wrongGuess);
        } else
        if (isHardGame){
            score = 10*(1000*minesFound - 10*(passedTime/30) - clickCount - 500*wrongGuess);
        }
        return score;
    }

    static void updateScoreBoard(){
        int score = countScore(minesFound,passedTime,clickCount);
        String time = gametimelabel.getText();

        if (isEasyGame){
            int scorenr1 = Integer.parseInt(easyScoreLabel1.getText());
            int scorenr2 = Integer.parseInt(easyScoreLabel2.getText());
            int scorenr3 = Integer.parseInt(easyScoreLabel3.getText());

            String timenr1 = easyTimeLabel1.getText();
            String timenr2 = easyTimeLabel2.getText();

            if (score > scorenr1){
                easyScoreLabel3.setText(Integer.toString(scorenr2));
                easyTimeLabel3.setText(timenr2);

                easyScoreLabel2.setText(Integer.toString(scorenr1));
                easyTimeLabel2.setText(timenr1);

                easyScoreLabel1.setText(Integer.toString(score));
                easyTimeLabel1.setText(time);
            }else
            if (score > scorenr2 && score < scorenr1){
                easyScoreLabel3.setText(Integer.toString(scorenr2));
                easyTimeLabel3.setText(timenr2);

                easyScoreLabel2.setText(Integer.toString(score));
                easyTimeLabel2.setText(time);
            }else
            if (score > scorenr3 && score < scorenr2){
                easyScoreLabel3.setText(Integer.toString(score));
                easyTimeLabel3.setText(time);
            }
        } else
        if (isMediumGame){
            int scorenr1 = Integer.parseInt(mediumScoreLabel1.getText());
            int scorenr2 = Integer.parseInt(mediumScoreLabel2.getText());
            int scorenr3 = Integer.parseInt(mediumScoreLabel3.getText());

            String timenr1 = mediumTimeLabel1.getText();
            String timenr2 = mediumTimeLabel2.getText();

            if (score > scorenr1){
                mediumScoreLabel3.setText(Integer.toString(scorenr2));
                mediumTimeLabel3.setText(timenr2);

                mediumScoreLabel2.setText(Integer.toString(scorenr1));
                mediumTimeLabel2.setText(timenr1);

                mediumScoreLabel1.setText(Integer.toString(score));
                mediumTimeLabel1.setText(time);
            }else
            if (score > scorenr2 && score < scorenr1){
                mediumScoreLabel3.setText(Integer.toString(scorenr2));
                mediumTimeLabel3.setText(timenr2);

                mediumScoreLabel2.setText(Integer.toString(score));
                mediumTimeLabel2.setText(time);
            }else
            if (score > scorenr3 && score < scorenr2){
                mediumScoreLabel3.setText(Integer.toString(score));
                mediumTimeLabel3.setText(time);
            }
        } else
        if (isHardGame){
            int scorenr1 = Integer.parseInt(hardScoreLabel1.getText());
            int scorenr2 = Integer.parseInt(hardScoreLabel2.getText());
            int scorenr3 = Integer.parseInt(hardScoreLabel3.getText());

            String timenr1 = hardTimeLabel1.getText();
            String timenr2 = hardTimeLabel2.getText();

            if (score > scorenr1){
                hardScoreLabel3.setText(Integer.toString(scorenr2));
                hardTimeLabel3.setText(timenr2);

                hardScoreLabel2.setText(Integer.toString(scorenr1));
                hardTimeLabel2.setText(timenr1);

                hardScoreLabel1.setText(Integer.toString(score));
                hardTimeLabel1.setText(time);
            }else
            if (score > scorenr2 && score < scorenr1){
                hardScoreLabel3.setText(Integer.toString(scorenr2));
                hardTimeLabel3.setText(timenr2);

                hardScoreLabel2.setText(Integer.toString(score));
                hardTimeLabel2.setText(time);
            }else
            if (score > scorenr3 && score < scorenr2){
                hardScoreLabel3.setText(Integer.toString(score));
                hardTimeLabel3.setText(time);
            }
        }

    }

    static void startGame(){
        MyTimer.PassedTimeTimer();
        MyTimer.RemainingTimeTimer();
        generateField();
        isDuringGame = true;
    }

    static void endGame(){

        passedTimeTimer.cancel();
        remainingTimeTimer.cancel();

        isDuringGame = false;
        isGameLoaded = false;

        for (int i=0; i<fieldWidth; i++)
            for (int j=0; j<fieldHeight; j++){
                int fieldNumber = field[i][j];
                if (isEasyGame) {
                    if (fieldNumber == -1) {
                        easyfieldButtons[i][j].setText(null);
                        easyfieldButtons[i][j].setIcon(null);
                        easyfieldButtons[i][j].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/bomb.png"))));
                        easyfieldButtons[i][j].setDisabledIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/bomb.png"))));
                        easyfieldButtons[i][j].setBackground(Color.RED);
                    }else
                    if (fieldNumber == -2) {
                        easyfieldButtons[i][j].setText(null);
                        easyfieldButtons[i][j].setIcon(null);
                        easyfieldButtons[i][j].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/flag.png"))));
                        easyfieldButtons[i][j].setDisabledIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/flag.png"))));
                        easyfieldButtons[i][j].setBackground(Color.GREEN);
                    }else
                    if (fieldNumber == -3) {
                        easyfieldButtons[i][j].setText(null);
                        easyfieldButtons[i][j].setIcon(null);
                        easyfieldButtons[i][j].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/flag.png"))));
                        easyfieldButtons[i][j].setDisabledIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/flag.png"))));
                        easyfieldButtons[i][j].setBackground(Color.BLUE);
                    } else easyfieldButtons[i][j].setIcon(setNumbersToImage(field[i][j]));
                    if (easyfieldButtons[i][j].isEnabled()) {
                        easyfieldButtons[i][j].setEnabled(false);
                    }
                }
                else
                if (isMediumGame) {
                    if (fieldNumber == -1) {
                        mediumfieldButtons[i][j].setText(null);
                        mediumfieldButtons[i][j].setIcon(null);
                        mediumfieldButtons[i][j].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/bomb.png"))));
                        mediumfieldButtons[i][j].setDisabledIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/bomb.png"))));
                        mediumfieldButtons[i][j].setBackground(Color.RED);
                    }else
                    if (fieldNumber == -2) {
                        mediumfieldButtons[i][j].setText(null);
                        mediumfieldButtons[i][j].setIcon(null);
                        mediumfieldButtons[i][j].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/flag.png"))));
                        mediumfieldButtons[i][j].setDisabledIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/flag.png"))));
                        mediumfieldButtons[i][j].setBackground(Color.GREEN);
                    }else
                    if (fieldNumber == -3) {
                        mediumfieldButtons[i][j].setText(null);
                        mediumfieldButtons[i][j].setIcon(null);
                        mediumfieldButtons[i][j].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/flag.png"))));
                        mediumfieldButtons[i][j].setDisabledIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/flag.png"))));
                        mediumfieldButtons[i][j].setBackground(Color.BLUE);
                    } else mediumfieldButtons[i][j].setIcon(setNumbersToImage(field[i][j]));
                    if (mediumfieldButtons[i][j].isEnabled()) {
                        mediumfieldButtons[i][j].setEnabled(false);
                    }
                }
                else
                if (isHardGame) {
                    if (fieldNumber == -1) {
                        hardfieldButtons[i][j].setText(null);
                        hardfieldButtons[i][j].setIcon(null);
                        hardfieldButtons[i][j].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/bomb.png"))));
                        hardfieldButtons[i][j].setDisabledIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/bomb.png"))));
                        hardfieldButtons[i][j].setBackground(Color.RED);
                    }else
                    if (fieldNumber == -2) {
                        hardfieldButtons[i][j].setText(null);
                        hardfieldButtons[i][j].setIcon(null);
                        hardfieldButtons[i][j].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/flag.png"))));
                        hardfieldButtons[i][j].setDisabledIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/flag.png"))));
                        hardfieldButtons[i][j].setBackground(Color.GREEN);
                    }else
                    if (fieldNumber == -3) {
                        hardfieldButtons[i][j].setText(null);
                        hardfieldButtons[i][j].setIcon(null);
                        hardfieldButtons[i][j].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/flag.png"))));
                        hardfieldButtons[i][j].setDisabledIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyGame.class.getResource("/images/20x20/flag.png"))));
                        hardfieldButtons[i][j].setBackground(Color.BLUE);
                    } else hardfieldButtons[i][j].setIcon(setNumbersToImage(field[i][j]));
                    if (hardfieldButtons[i][j].isEnabled()) {
                        hardfieldButtons[i][j].setEnabled(false);
                    }
                }
            }
    }

    static void pauseGame(){
        if (!isPaused) {
            frame.setEnabled(false);
            passedTimeTimer.cancel();
            remainingTimeTimer.cancel();
            isPaused = true;
        }

        Object[] options = {"Yes, please", "No, thanks"};
        int n = JOptionPane.showOptionDialog(frame,
                "Would you like to continue",
                "Pause",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        switch (n) {
            case 0:
                frame.setEnabled(true);
                frame.setState(Frame.ICONIFIED);
                frame.setState(JFrame.NORMAL);
                isPaused = false;
                PassedTimeTimer();
                RemainingTimeTimer();
                break;
            case 1:
                pauseGame();
                break;
            case -1:
                pauseGame();
        }
    }
}
