package pl.pswbp.zi;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyEvent;

import static pl.pswbp.zi.Saper.*;

class MyWindow {
    static JRadioButtonMenuItem easy, medium, hard;

    static void scoreBoardInitialize(){
        scoreFrame = new JFrame("Wyniki");
        scoreFrame.setSize(400,150);
        scoreFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        scoreFrame.setResizable(false);
        JLabel label1 = new JLabel("Najlepsze Wyniki");

        JPanel scoreFramePanel = new JPanel(new BorderLayout());

        JTabbedPane scoreTabbedPane = new JTabbedPane();

        JPanel scoreEasy = new JPanel(new GridBagLayout());
        scoreTabbedPane.addTab("Easy",scoreEasy);
        scoreTabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JPanel scoreMedium = new JPanel(new GridBagLayout());
        scoreTabbedPane.addTab("Medium",scoreMedium);
        scoreTabbedPane.setMnemonicAt(1, KeyEvent.VK_3);

        JPanel scoreHard = new JPanel(new GridBagLayout());
        scoreTabbedPane.addTab("Hard",scoreHard);
        scoreTabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;

        //--------------------------------------------

        JLabel easyScoreNr = new JLabel("Nr: ");
        JLabel easyScoreNr1 = new JLabel("1. ");
        JLabel easyScoreNr2 = new JLabel("2. ");
        JLabel easyScoreNr3 = new JLabel("3. ");

        JLabel easyScoreLabel = new JLabel("Score: ");
        easyScoreLabel1 = new JLabel("0");
        easyScoreLabel2 = new JLabel("0");
        easyScoreLabel3 = new JLabel("0");

        JLabel easyTimeLabel = new JLabel("Time: ");
        easyTimeLabel1 = new JLabel("0");
        easyTimeLabel2 = new JLabel("0");
        easyTimeLabel3 = new JLabel("0");

        //--------------------------------------------

        JLabel mediumScoreNr = new JLabel("Nr: ");
        JLabel mediumScoreNr1 = new JLabel("1. ");
        JLabel mediumScoreNr2 = new JLabel("2. ");
        JLabel mediumScoreNr3 = new JLabel("3. ");

        JLabel mediumScoreLabel = new JLabel("Score: ");
        mediumScoreLabel1 = new JLabel("0");
        mediumScoreLabel2 = new JLabel("0");
        mediumScoreLabel3 = new JLabel("0");

        JLabel mediumTimeLabel = new JLabel("Time: ");
        mediumTimeLabel1 = new JLabel("0");
        mediumTimeLabel2 = new JLabel("0");
        mediumTimeLabel3 = new JLabel("0");

        //---------------------------------------------

        JLabel hardScoreNr = new JLabel("Nr: ");
        JLabel hardScoreNr1 = new JLabel("1. ");
        JLabel hardScoreNr2 = new JLabel("2. ");
        JLabel hardScoreNr3 = new JLabel("3. ");

        JLabel hardScoreLabel = new JLabel("Score: ");
        hardScoreLabel1 = new JLabel("0");
        hardScoreLabel2 = new JLabel("0");
        hardScoreLabel3 = new JLabel("0");

        JLabel hardTimeLabel = new JLabel("Time: ");
        hardTimeLabel1 = new JLabel("0");
        hardTimeLabel2 = new JLabel("0");
        hardTimeLabel3 = new JLabel("0");

        //---------------------------------------
        c.gridx = 0;
        c.gridy = 0;
        scoreEasy.add(easyScoreNr, c);
        c.gridx = 1;
        scoreEasy.add(easyScoreLabel,c);
        c.gridx = 2;
        scoreEasy.add(easyTimeLabel,c);

        c.gridy = 1;
        c.gridx = 0;
        scoreEasy.add(easyScoreNr1,c);
        c.gridy = 1;
        c.gridx = 1;
        scoreEasy.add(easyScoreLabel1,c);
        c.gridy = 1;
        c.gridx = 2;
        scoreEasy.add(easyTimeLabel1,c);

        c.gridy = 2;
        c.gridx = 0;
        scoreEasy.add(easyScoreNr2,c);
        c.gridy = 2;
        c.gridx = 1;
        scoreEasy.add(easyScoreLabel2,c);
        c.gridy = 2;
        c.gridx = 2;
        scoreEasy.add(easyTimeLabel2,c);

        c.gridy = 3;
        c.gridx = 0;
        scoreEasy.add(easyScoreNr3,c);
        c.gridy = 3;
        c.gridx = 1;
        scoreEasy.add(easyScoreLabel3,c);
        c.gridy = 3;
        c.gridx = 2;
        scoreEasy.add(easyTimeLabel3,c);

        //---------------------------------
        c.gridx = 0;
        c.gridy = 0;
        scoreMedium.add(mediumScoreNr,c);
        c.gridx = 1;
        scoreMedium.add(mediumScoreLabel,c);
        c.gridx = 2;
        scoreMedium.add(mediumTimeLabel,c);

        c.gridy = 1;
        c.gridx = 0;
        scoreMedium.add(mediumScoreNr1,c);
        c.gridy = 1;
        c.gridx = 1;
        scoreMedium.add(mediumScoreLabel1,c);
        c.gridy = 1;
        c.gridx = 2;
        scoreMedium.add(mediumTimeLabel1,c);

        c.gridy = 2;
        c.gridx = 0;
        scoreMedium.add(mediumScoreNr2,c);
        c.gridy = 2;
        c.gridx = 1;
        scoreMedium.add(mediumScoreLabel2,c);
        c.gridy = 2;
        c.gridx = 2;
        scoreMedium.add(mediumTimeLabel2,c);

        c.gridy = 3;
        c.gridx = 0;
        scoreMedium.add(mediumScoreNr3,c);
        c.gridy = 3;
        c.gridx = 1;
        scoreMedium.add(mediumScoreLabel3,c);
        c.gridy = 3;
        c.gridx = 2;
        scoreMedium.add(mediumTimeLabel3,c);
        //----------------------------------
        c.gridx = 0;
        c.gridy = 0;
        scoreHard.add(hardScoreNr,c);
        c.gridx = 1;
        scoreHard.add(hardScoreLabel,c);
        c.gridx = 2;
        scoreHard.add(hardTimeLabel,c);

        c.gridy = 1;
        c.gridx = 0;
        scoreHard.add(hardScoreNr1,c);
        c.gridy = 1;
        c.gridx = 1;
        scoreHard.add(hardScoreLabel1,c);
        c.gridy = 1;
        c.gridx = 2;
        scoreHard.add(hardTimeLabel1,c);

        c.gridy = 2;
        c.gridx = 0;
        scoreHard.add(hardScoreNr2,c);
        c.gridy = 2;
        c.gridx = 1;
        scoreHard.add(hardScoreLabel2,c);
        c.gridy = 2;
        c.gridx = 2;
        scoreHard.add(hardTimeLabel2,c);

        c.gridy = 3;
        c.gridx = 0;
        scoreHard.add(hardScoreNr3,c);
        c.gridy = 3;
        c.gridx = 1;
        scoreHard.add(hardScoreLabel3,c);
        c.gridy = 3;
        c.gridx = 2;
        scoreHard.add(hardTimeLabel3,c);
        //---------------------------------

        scoreFramePanel.add(label1);

        scoreFrame.add(scoreFramePanel, BorderLayout.PAGE_START);
        scoreFrame.add(scoreTabbedPane, BorderLayout.CENTER);
    }

    static void windowInitialize(){
        frame = new JFrame("Saper ");
        frame.setSize(500,500);
        JPanel scorepanel = new JPanel(new GridLayout(1, 5));
        gamepanel = new JPanel(new BorderLayout());
        easygamepanel = new JPanel(new GridLayout(10, 10,1,1));
        mediumgamepanel = new JPanel(new GridLayout(20, 20,1,1));
        hardgamepanel = new JPanel(new GridLayout(30, 30,1,1));

        Border etched = BorderFactory.createEtchedBorder();
        Border compound = BorderFactory.createCompoundBorder(etched,etched);
        Border gametime = BorderFactory.createTitledBorder(compound, "Czas Gry");
        Border allmines = BorderFactory.createTitledBorder(compound, "Ile min");
        Border remainingtime = BorderFactory.createTitledBorder(compound, "P czas");
        Border remainingmines = BorderFactory.createTitledBorder(compound, "P Miny");

        JPanel scorep1 = new JPanel();
        JPanel scorep2 = new JPanel();
        JPanel scorep3 = new JPanel();
        JPanel scorep4 = new JPanel();
        JPanel scorep5 = new JPanel();

        scorep1.setBorder(gametime);
        scorep2.setBorder(allmines);
        scorep4.setBorder(remainingmines);
        scorep5.setBorder(remainingtime);

        gametimelabel = new JLabel("00:00:00");
        remainingtimelabel = new JLabel("00:00:00");
        allmineslabel = new JLabel("0");
        remainigmineslabel = new JLabel("0");

        scorep1.add(gametimelabel);
        scorep2.add(allmineslabel);
        JButton reset = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MyWindow.class.getResource("/images/pig.gif"))));
        reset.setFocusable(false);
        reset.addActionListener(e -> {
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
        });
        scorep3.add(reset);
        scorep4.add(remainigmineslabel);
        scorep5.add(remainingtimelabel);

        scorepanel.add(scorep1);
        scorepanel.add(scorep2);
        scorepanel.add(scorep3);
        scorepanel.add(scorep4);
        scorepanel.add(scorep5);

        frame.add(scorepanel, BorderLayout.PAGE_START);
        frame.add(gamepanel, BorderLayout.CENTER);

        frame.setJMenuBar(MenuBar());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        frame.addKeyListener(new MyKeyListener());
    }

    static void gameInitialize(){
        frame.setBounds(1, 1, fieldWidth * 50, fieldHeight * 50);
        easyfieldButtons = new MyButton[10][10];
        mediumfieldButtons = new MyButton[20][20];
        hardfieldButtons = new MyButton[30][30];

        isGameLoaded = true;

        for (int j = 0; j < 10; j++)
            for (int i = 0; i < 10; i++) {
                easyfieldButtons[i][j] = new MyButton(i, j);
                easyfieldButtons[i][j].addMouseListener(new MyButtonListener());
                easyfieldButtons[i][j].setText(null);
                easyfieldButtons[i][j].setIcon(null);
                easyfieldButtons[i][j].setDisabledIcon(null);
                easyfieldButtons[i][j].setFocusable(false);
                easygamepanel.add(easyfieldButtons[i][j]);
            }

        for (int j = 0; j < 20; j++)
            for (int i = 0; i < 20; i++) {
                mediumfieldButtons[i][j] = new MyButton(i, j);
                mediumfieldButtons[i][j].addMouseListener(new MyButtonListener());
                mediumfieldButtons[i][j].setText(null);
                mediumfieldButtons[i][j].setIcon(null);
                mediumfieldButtons[i][j].setDisabledIcon(null);
                mediumfieldButtons[i][j].setFocusable(false);
                mediumgamepanel.add(mediumfieldButtons[i][j]);
            }

        for (int j = 0; j < 30; j++)
            for (int i = 0; i < 30; i++) {
                hardfieldButtons[i][j] = new MyButton(i, j);
                hardfieldButtons[i][j].addMouseListener(new MyButtonListener());
                hardfieldButtons[i][j].setText(null);
                hardfieldButtons[i][j].setIcon(null);
                hardfieldButtons[i][j].setDisabledIcon(null);
                hardfieldButtons[i][j].setFocusable(false);
                hardgamepanel.add(hardfieldButtons[i][j]);
            }

        allmineslabel.setText(Integer.toString(minesCount));
        remainigmineslabel.setText(Integer.toString(minesCount-minesFound));

        gamepanel.add(easygamepanel);
        easygamepanel.setVisible(true);

        MyTimer.PassedTimeTimer();
        MyTimer.RemainingTimeTimer();
        passedTimeTimer.cancel();
        remainingTimeTimer.cancel();

        isEasyGame = true;
        isMediumGame = false;
        isHardGame = false;
    }

    static void helpBoardInitialize(){
        JPanel middlePanel = new JPanel (new BorderLayout());
        middlePanel.setBorder(new TitledBorder(new EtchedBorder(), "Game Help" ));

        JTextPane display = new JTextPane();

        display.setEditable(false);
        JScrollPane scroll = new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        display.setText("Po odpaleniu gry dostajemy planszę pełną przycisków, " +
                "gdzie pod niektórymi z nich znajdują się miny. " +
                "Po naciśnięciu przycisku, pod którym nic nie było, " +
                "dostaniemy informację ile min znajduje się wokół. " +
                "Na podstawie takiej informacji, " +
                "musimy zgadnąć gdzie znajdują się miny. " +
                "Gdy odgadniemy wszystkie pozycje, " +
                "gra kończy się zwycięstwem. W przeciwnym wypadku, " +
                "gdy klikniemy na polu pod którym kryje się mina, przegrywamy. " +
                "Poziomy trudności zmieniamy odpowiednią pozycją w menu. " +
                "Dla każdego poziomu trudności (od łatwego do trudnego)," +
                " zwiększa (lub zmniejsza) się pole rozgrywki oraz ilość min do zabezpieczenia, " +
                "i przelicznik punktów. Dla poziomu łatwego jest to 10x10 w tym 10 min, " +
                "poziomu średniego 20x20 w tym 40 min, i poziomu trudnego 40x40 w tym 100 min. " +
                "Do naliczania punktów będą brane następujące rzeczy: " +
                "\n•Ilość zabezpieczonych min (+1000 pkt za każdą zabezpieczoną minę) " +
                "\n•Ilość błędnie zabezpieczonych min (-500 pkt za błąd) " +
                "\n•Liczba kliknięć (-1 pkt za każde kliknięcie) " +
                "\n•Czas rozgrywki (-10 pkt za każde 30 sekund) " +
                "\n•Poziom trudności (zdobyte pkt pomnożone w zależności od poziomu: Łatwy – 1x, Średni – 5x, Trudny – 10x) " +
                "\n•Czas na zabezpieczenie miny wynosi 30 sekund, (+30 sekund za każdą zabezpieczoną minę)");

        middlePanel.add(scroll);

        helpFrame = new JFrame("Pomoc");
        helpFrame.setSize(600,400);
        helpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        helpFrame.setResizable(false);
        helpFrame.add(middlePanel, BorderLayout.CENTER);
        helpFrame.setLocationRelativeTo(null);
    }

    private static JMenuBar MenuBar() {
        JMenuBar menu = new JMenuBar();
        JMenu game = new JMenu("Gra");
        JMenu settings = new JMenu("Ustawienia");
        JMenu help = new JMenu("Pomoc");
        menu.add(game); menu.add(settings); menu.add(help);
        JMenuItem newgame = new JMenuItem("Nowa");
        JMenuItem score = new JMenuItem("Wyniki");
        JMenuItem exit = new JMenuItem("Zamknij");
        game.add(newgame); game.add(score); game.add(exit);
        ButtonGroup levels = new ButtonGroup();
        easy = new JRadioButtonMenuItem("Latwy");
        medium = new JRadioButtonMenuItem("Sredni");
        hard = new JRadioButtonMenuItem("Trudny");
        levels.add(easy); levels.add(medium); levels.add(hard);
        settings.add(easy); settings.add(medium); settings.add(hard);
        easy.setSelected(true);
        JMenuItem autor = new JMenuItem("Autor");
        JMenuItem helpview = new JMenuItem("Wyswietl Pomoc");
        help.add(autor);
        help.add(helpview);

        autor.addActionListener(e -> JOptionPane.showMessageDialog(null, "Program wykonal "+ "Rafal Parafiniuk"));

        helpview.addActionListener(e -> helpFrame.setVisible(true));

        score.addActionListener(e -> scoreFrame.setVisible(true));

        exit.setMnemonic('x');
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, Event.ALT_MASK));
        exit.addActionListener(e -> System.exit(0));
        newgame.addActionListener(e -> {
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
        });
        easy.addActionListener(e -> MyLevels.LevelEasy());
        medium.addActionListener(e -> MyLevels.LevelMedium());
        hard.addActionListener(e -> MyLevels.LevelHard());

        return menu;
    }

}
