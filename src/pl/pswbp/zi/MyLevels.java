package pl.pswbp.zi;

import static pl.pswbp.zi.Saper.*;

class MyLevels {
    static void LevelEasy() {
        fieldWidth = 10;
        fieldHeight = 10;
        minesCount = 10;
        minesFound = 0;
        wrongGuess = 0;
        passedTime = 0;
        remainingTime = 30;
        clickCount = 0;
        isDuringGame = false;
        isGameLoaded = true;
        isWrong=false;

        passedTimeTimer.cancel();
        remainingTimeTimer.cancel();

        gametimelabel.setText("00:00:00");
        remainingtimelabel.setText("00:00:00");

        frame.setBounds(1, 1, fieldWidth * 50, fieldHeight * 50);

        for (int j = 0; j < fieldHeight; j++)
            for (int i = 0; i < fieldWidth; i++) {
                easyfieldButtons[i][j].setIcon(null);
                easyfieldButtons[i][j].setDisabledIcon(null);
                easyfieldButtons[i][j].setText("");
                easyfieldButtons[i][j].setBackground(null);
                easyfieldButtons[i][j].setEnabled(true);
            }
        allmineslabel.setText(Integer.toString(minesCount));
        remainigmineslabel.setText(Integer.toString(minesCount-minesFound));

        gamepanel.add(easygamepanel);

        easygamepanel.setVisible(true);
        mediumgamepanel.setVisible(false);
        hardgamepanel.setVisible(false);

        isEasyGame = true;
        isMediumGame = false;
        isHardGame = false;
    }

    static void LevelMedium(){
        fieldWidth = 20;
        fieldHeight = 20;
        minesCount = 40;
        minesFound = 0;
        wrongGuess = 0;
        passedTime = 0;
        remainingTime = 30;
        clickCount = 0;
        isDuringGame = false;
        isGameLoaded = true;

        passedTimeTimer.cancel();
        remainingTimeTimer.cancel();

        gametimelabel.setText("00:00:00");
        remainingtimelabel.setText("00:00:00");

        frame.setBounds(1, 1, fieldWidth * 40, fieldHeight * 36);

        for (int j = 0; j < fieldHeight; j++)
            for (int i = 0; i < fieldWidth; i++) {
                mediumfieldButtons[i][j].setIcon(null);
                mediumfieldButtons[i][j].setDisabledIcon(null);
                mediumfieldButtons[i][j].setText("");
                mediumfieldButtons[i][j].setBackground(null);
                mediumfieldButtons[i][j].setEnabled(true);
            }
        allmineslabel.setText(Integer.toString(minesCount));
        remainigmineslabel.setText(Integer.toString(minesCount-minesFound));

        gamepanel.add(mediumgamepanel);

        easygamepanel.setVisible(false);
        mediumgamepanel.setVisible(true);
        hardgamepanel.setVisible(false);

        isEasyGame = false;
        isMediumGame = true;
        isHardGame = false;
    }

    static void LevelHard(){
        fieldWidth = 30;
        fieldHeight = 30;
        minesCount = 200;
        minesFound = 0;
        wrongGuess = 0;
        passedTime = 0;
        remainingTime = 30;
        clickCount = 0;
        isDuringGame = false;
        isGameLoaded = true;

        passedTimeTimer.cancel();
        remainingTimeTimer.cancel();

        gametimelabel.setText("00:00:00");
        remainingtimelabel.setText("00:00:00");

        frame.setBounds(1, 1, 1366, 725);

        for (int j = 0; j < fieldHeight; j++)
            for (int i = 0; i < fieldWidth; i++) {
                hardfieldButtons[i][j].setIcon(null);
                hardfieldButtons[i][j].setDisabledIcon(null);
                hardfieldButtons[i][j].setText("");
                hardfieldButtons[i][j].setBackground(null);
                hardfieldButtons[i][j].setEnabled(true);
            }
        allmineslabel.setText(Integer.toString(minesCount));
        remainigmineslabel.setText(Integer.toString(minesCount-minesFound));

        gamepanel.add(hardgamepanel);

        easygamepanel.setVisible(false);
        mediumgamepanel.setVisible(false);
        hardgamepanel.setVisible(true);

        isEasyGame = false;
        isMediumGame = false;
        isHardGame = true;
    }
}
