package pl.pswbp.zi;

import javax.swing.*;

class MyButton extends JButton {
    private final int fieldX;
    private final int fieldY;

    MyButton(int x, int y){
        super();
        fieldX=x;
        fieldY=y;
    }

    int getFieldX(){
        return fieldX;
    }

    int getFieldY(){
        return fieldY;
    }

}
