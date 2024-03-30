
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.security.KeyStore;
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

    //coordinates for snake
    final int x[] =new int[GAME_UNITS];
    final int y[] =new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;

    //coordinates of apples, will appear randomly when snake eats an apple
    int appleX;
    int appleY;
    char direction = 'R'; // R-L,U-D

    boolean running =false;
    Timer timer;
    Random random;

    GamePanel(){
        //constructor
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }


    public void startGame(){
        newApple(); //triggers the creation of an apple in the game
        running = true;
        timer = new Timer(DELAY,this); //this, because we are listening the ActionListener interface
        timer.start();
    }

    public void paintComponent(Graphics g){
    super.paintComponent(g);
    draw(g);
    }

    public void draw(Graphics g){

        for(int i=0 ; i<SCREEN_HEIGHT/UNIT_SIZE ; i++){
            g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT);
            g.drawLine(0,i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
        }

    g.setColor(Color.red);
    g.fillOval(appleX,appleY,UNIT_SIZE,UNIT_SIZE);
    }

    public void newApple(){
        appleX=random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleX=random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
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
