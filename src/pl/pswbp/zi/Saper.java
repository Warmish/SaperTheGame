package pl.pswbp.zi;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;

public class Saper {
    static JFrame frame;
    static JFrame scoreFrame;
    static JFrame helpFrame;
    static JPanel gamepanel;
    static JPanel easygamepanel;
    static JPanel mediumgamepanel;
    static JPanel hardgamepanel;

    static MyButton[][] easyfieldButtons;
    static MyButton[][] mediumfieldButtons;
    static MyButton[][] hardfieldButtons; // buttons representing field

    static JLabel gametimelabel;
    static JLabel allmineslabel;
    static JLabel remainigmineslabel;
    static JLabel remainingtimelabel;
    static JLabel easyScoreLabel1, easyScoreLabel2, easyScoreLabel3;
    static JLabel easyTimeLabel1, easyTimeLabel2, easyTimeLabel3;
    static JLabel mediumScoreLabel1, mediumScoreLabel2, mediumScoreLabel3;
    static JLabel mediumTimeLabel1, mediumTimeLabel2, mediumTimeLabel3;
    static JLabel hardScoreLabel1, hardScoreLabel2, hardScoreLabel3;
    static JLabel hardTimeLabel1, hardTimeLabel2, hardTimeLabel3;

    static Timer passedTimeTimer, remainingTimeTimer;

    static boolean isWrong = false;
    static boolean isEasyGame = false;
    static boolean isMediumGame = false;
    static boolean isHardGame = false;
    static boolean isDuringGame = false;
    static boolean isGameLoaded = false;
    static boolean isPaused = false;

    static int clickCount = 0;
    static int max;
    static int[][] field; // represents mine field with values
    static int minesFound = 0; // number of found mines
    static int passedTime = 0,remainingTime = 30;
    static int fieldWidth = 10;
    static int fieldHeight = 10;
    static int minesCount = 10;
    static int wrongGuess = 0;

    static ImageIcon imageNumber;

    /* values in field:
     * 0-8 - how many mines in area
     * -1 - mine
     * -2 - known mine
     * -3 - wrong guess
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Saper window = new Saper();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private Saper() {
        MyWindow.windowInitialize();
        MyWindow.gameInitialize();
        MyWindow.scoreBoardInitialize();
        MyWindow.helpBoardInitialize();
    }

    private static int random(int max){
        Saper.max = max;
        Random rand = new Random();
        return rand.nextInt(max);
    }

    static void generateField(){
        // 1. create tables
        field = new int[fieldWidth][fieldHeight];
        // 2. place mines
        int i = minesCount;
        while (i > 0){
            int x = random(fieldWidth);
            int y = random(fieldHeight);
            if (canPutTheMine(x,y)){
                field[x][y] = -1;
                i--; // decrementing counter only when mine was placed
            }
        }
        // 3. count surrounding mines
        for (i=0; i<fieldWidth; i++)
            for (int j=0; j<fieldHeight; j++)
                if (field[i][j]!=-1)
                    field[i][j]=countMines(i,j);
    }

    static void showField(MyButton button){
        int x = button.getFieldX();
        int y = button.getFieldY();
        if (field[x][y]!=-2 && field[x][y]!=-3){
            if (field[x][y]==-1){
                if (clickCount <= 1) {
                    generateField();
                    showField(button);
                }
                else {
                    MyGame.endGame();
                    JOptionPane.showMessageDialog(frame, "Game over!");
                }
            }
            else{
                button.setEnabled(false);
                //button.setText(Integer.toString(field[x][y]));
                button.setIcon(setNumbersToImage(field[x][y]));
                if (field[x][y]==0)
                    showZeros(x,y); // show all surrounding zeros if we clicked on 0
            }
        }
    }

    static void setGuess(MyButton button){
        int x = button.getFieldX();
        int y = button.getFieldY();
        if (button.isEnabled()){
            if (field[x][y]==-1){
                // actions when under button there is a mine
                field[x][y]=-2; // change into known mine
                button.setText("");
                button.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(Saper.class.getResource("/images/20x20/flag.png"))));
                button.setDisabledIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(Saper.class.getResource("/images/20x20/flag.png"))));
                minesFound++; // inc counter of found mines
                remainingTime=remainingTime+10;
                remainigmineslabel.setText(Integer.toString(minesCount-minesFound));
                if (minesFound==minesCount && !isWrong){
                    // every mine is found
                    MyGame.endGame();
                    MyGame.updateScoreBoard();
                    JOptionPane.showMessageDialog(frame, "You've won!");
                }
            }
            else if (field[x][y]==-2){
                // actions when we change known mine into empty button
                field[x][y]=-1;
                button.setText("");
                button.setIcon(null);
                button.setDisabledIcon(null);
                minesFound--;
                remainigmineslabel.setText(Integer.toString(minesCount-minesFound));
            }
            else if (field[x][y]==-3){
                // actions when we change wrong guess into empty button
                field[x][y]=countMines(x,y); // restoring mine count
                isWrong=false;
                button.setText("");
                button.setIcon(null);
                button.setDisabledIcon(null);
                minesFound--;
                wrongGuess--;
                remainigmineslabel.setText(Integer.toString(minesCount-minesFound));
                if (minesFound==minesCount && !isWrong){
                    // every mine is found
                    MyGame.endGame();
                    MyGame.updateScoreBoard();
                    JOptionPane.showMessageDialog(frame, "You've won!");
                }
            }
            else {
                // actions when under button there is a number
                field[x][y]=-3;
                button.setText("");
                button.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(Saper.class.getResource("/images/20x20/flag.png"))));
                button.setDisabledIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(Saper.class.getResource("/images/20x20/flag.png"))));
                isWrong=true;
                remainingTime=remainingTime-10;
                minesFound++;
                wrongGuess++;
                remainigmineslabel.setText(Integer.toString(minesCount-minesFound));
            }
        }
    }

    static int countMines(int x, int y){
        int mines=0;
        for (int i=x-1; i<=x+1; i++)
            if (i>=0 && i<fieldWidth) // there is no sense running into another loop if i is lower than 0 or higher than fieldWidth
                for (int j=y-1; j<=y+1; j++)
                    if (j>=0 && j<fieldHeight) // checking if our point is on field
                        if (i!=x || j!=y) // checking if we aren't in place for which we are counting mines
                            if (field[i][j]==-1 || field[i][j]==-2)
                                mines++; // incrementing number of mines if there's mine or known mine
        return mines;
    }

    private static boolean canPutTheMine(int x, int y){
        // check if there is a mine
        if (field[x][y]==-1)
            return false;
        // check if field is surrounded by mines
        if (!minesCheck(x,y))
            return false;
        // check for surrounding fields, if we won't make them surrounded by mines
        for (int i=x-1; i<=x+1; i++)
            if (i>=0 && i<fieldWidth)
                for (int j=y-1; j<=y+1; j++)
                    if (j>=0 && j<fieldHeight)
                        if (i!=x || j!=y){
                            field[x][y]=-1; // temporarily set the mine
                            if (!minesCheck(i,j)){
                                field[x][y]=0; // set the value back
                                return false;
                            }
                            field[x][y]=0;
                        }
        // for every other situation, we return true
        return true;
    }

    private static boolean minesCheck(int x, int y){
        // situation 1: cell surrounded by mines
        if (countMines(x,y)==8)
            return false;
        // situation 2: cell in a corner surrounded by mines
        if ((x==0 || x==fieldWidth-1) && (y==0 || y==fieldHeight-1))
            if (countMines(x,y)==3)
                return false;
        // situation 3: cell is by the border and surrounded by mines
        if (x==0 || x==fieldWidth-1 || y==0 || y==fieldHeight-1)
            if (countMines(x,y)==5)
                return false;
        return true;
    }

    private static void showZeros(int x, int y){
        // 1. check if we're on "zero"
        if (field[x][y]==0)
            // 2. checking surrounding fields, loops and conditions similar to those in counting mines
            for (int i=x-1; i<=x+1; i++)
                if (i>=0 && i<fieldWidth)
                    for (int j=y-1; j<=y+1; j++)
                        if (j>=0 && j<fieldHeight)
                            if (i!=x || j!=y) {
                                if (field[i][j] != -3) {
                                    if (isEasyGame) {
                                        //easyfieldButtons[i][j].setText(Integer.toString(field[i][j]));
                                        easyfieldButtons[i][j].setIcon(setNumbersToImage(field[i][j]));
                                        // 4. if button wasn't disabled earlier, we need to do disable it and do a recursive call
                                        if (easyfieldButtons[i][j].isEnabled()) {
                                            easyfieldButtons[i][j].setEnabled(false);
                                            showZeros(i, j);
                                        }
                                    } else if (isMediumGame) {
                                        //mediumfieldButtons[i][j].setText(Integer.toString(field[i][j]));
                                        mediumfieldButtons[i][j].setIcon(setNumbersToImage(field[i][j]));
                                        // 4. if button wasn't disabled earlier, we need to do disable it and do a recursive call
                                        if (mediumfieldButtons[i][j].isEnabled()) {
                                            mediumfieldButtons[i][j].setEnabled(false);
                                            showZeros(i, j);
                                        }
                                    } else if (isHardGame) {
                                        //hardfieldButtons[i][j].setText(Integer.toString(field[i][j]));
                                        hardfieldButtons[i][j].setIcon(setNumbersToImage(field[i][j]));
                                        // 4. if button wasn't disabled earlier, we need to do disable it and do a recursive call
                                        if (hardfieldButtons[i][j].isEnabled()) {
                                            hardfieldButtons[i][j].setEnabled(false);
                                            showZeros(i, j);
                                        }
                                    }
                                }
                            }
    }

    static ImageIcon setNumbersToImage(int number){
        switch (number) {
            case 0:
                imageNumber = null;
                break;
            case 1:
                imageNumber = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Saper.class.getResource("/images/20x20/11.png")));
                break;
            case 2:
                imageNumber = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Saper.class.getResource("/images/20x20/22.png")));
                break;
            case 3:
                imageNumber = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Saper.class.getResource("/images/20x20/33.png")));
                break;
            case 4:
                imageNumber = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Saper.class.getResource("/images/20x20/44.png")));
                break;
            case 5:
                imageNumber = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Saper.class.getResource("/images/20x20/55.png")));
                break;
            case 6:
                imageNumber = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Saper.class.getResource("/images/20x20/66.png")));
                break;
            case 7:
                imageNumber = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Saper.class.getResource("/images/20x20/77.png")));
                break;
            case 8:
                imageNumber = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Saper.class.getResource("/images/20x20/88.png")));
                break;
        }
        return imageNumber;
    }

    static void cheat(){
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
                    //easyfieldButtons[i][j].setText(easyfieldButtons[i][j].getFieldX()+","+easyfieldButtons[i][j].getFieldY());
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
                    //mediumfieldButtons[i][j].setText(mediumfieldButtons[i][j].getFieldX()+","+mediumfieldButtons[i][j].getFieldY());
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
                    //hardfieldButtons[i][j].setText(hardfieldButtons[i][j].getFieldX()+","+hardfieldButtons[i][j].getFieldY());
                }
            }
    }
}
