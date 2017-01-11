package pl.pswbp.zi;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

import static pl.pswbp.zi.Saper.*;

class MyTimer {
    static void PassedTimeTimer(){
        passedTimeTimer = new Timer();
        passedTimeTimer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                int godziny = passedTime/3600;
                int minuty = (passedTime - 3600 * godziny)/60;
                int sekundy = passedTime - 3600 * godziny - 60 * minuty;

                String strgodziny, strminuty, strsekundy;

                if (godziny < 10) strgodziny = "0"+Integer.toString(godziny); else strgodziny = Integer.toString(godziny);
                if (minuty < 10) strminuty = "0"+Integer.toString(minuty); else strminuty = Integer.toString(minuty);
                if (sekundy < 10) strsekundy = "0"+Integer.toString(sekundy); else strsekundy = Integer.toString(sekundy);
                passedTime++;

                gametimelabel.setText(strgodziny+":"+strminuty+":"+strsekundy);
            }
        },0,1000);
    }

    static void RemainingTimeTimer(){
        remainingTimeTimer = new Timer();
        remainingTimeTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                remainingTime--;

                int godziny = remainingTime/3600;
                int minuty = (remainingTime - 3600 * godziny)/60;
                int sekundy = remainingTime - 3600 * godziny - 60 * minuty;

                String strgodziny, strminuty, strsekundy;

                if (godziny < 10) strgodziny = "0"+Integer.toString(godziny); else strgodziny = Integer.toString(godziny);
                if (minuty < 10) strminuty = "0"+Integer.toString(minuty); else strminuty = Integer.toString(minuty);
                if (sekundy < 10) strsekundy = "0"+Integer.toString(sekundy); else strsekundy = Integer.toString(sekundy);

                remainingtimelabel.setText(strgodziny+":"+strminuty+":"+strsekundy);

                if (remainingTime <=0){
                    JOptionPane.showMessageDialog(frame, "Time Passed!");
                    MyGame.endGame();
                }
            }
        }, 0, 1000);
    }

}
