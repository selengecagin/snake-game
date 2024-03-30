
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {
    //screen dimensions
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT=600;
    //item sizes
    static final int UNIT_SIZE = 25;
    //the total number of game units
    static final int GAME_UNITS =(SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    //delay parameter will be used for controlling game speed or animations
    static final int DELAY= 75;

    GamePanel(){
        //constructor
    }

    public void startGame(){
    }

    public void paintComponent(Graphics g){

    }

    public void draw(Graphics g){

    }
    public void move(){

    }

    public void checkApple(){

    }

    public void checkCollisions(){

    }

    public void gameOver(Graphics g){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e){

        }
    }


}
