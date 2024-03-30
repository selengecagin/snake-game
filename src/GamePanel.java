
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
        if(running){
            g.setColor(Color.red);
            g.fillOval(appleX,appleY,UNIT_SIZE,UNIT_SIZE);


            for(int i=0; i<bodyParts;i++){
                if(i==0){
                    g.setColor(Color.green);
                    g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
                }else {
                    g.setColor(new Color(45,180,0));
                    g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
                }
            }
        }else{
            gameOver(g);
        }
    }

    public void newApple(){
        appleX=random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY=random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }

    public void move(){
        //itarete through all body parts of the snake
        for(int i = bodyParts;i>0;i--){
            x[i]=x[i-1];
            y[i]=y[i-1];
        }

        switch(direction){
            case 'U':
                y[0]=y[0]-UNIT_SIZE;
                break;
            case 'D':
                y[0]=y[0]+UNIT_SIZE;
                break;
            case 'L':
                x[0]=x[0]-UNIT_SIZE;
                break;
            case 'R':
                x[0]=x[0]+UNIT_SIZE;
                break;
        }
    }

    public void checkApple(){
    if((x[0]== appleX)&&(y[0]==appleY)){
    bodyParts++;
    applesEaten++;
    newApple();
}

    }
    public void checkCollisions(){
        //checks if head collides with body
    for(int i = bodyParts; i>0;i--){
        if((x[0] == x[i])&&(y[0]==y[i])){
            running=false;
            }
        }
        //check if head touches left border
        if(x[0]<0){
            running=false;
        }
        //check if head touches right border
        if(x[0]>SCREEN_WIDTH){
            running=false;
        }
        //check if head touches top border
        if(y[0]<0){
            running=false;
        }
        //check if head touches bottom border
        if(y[0]>SCREEN_HEIGHT){
            running=false;
        }
        if(!running){
            timer.stop();
        }
    }

    public void gameOver(Graphics g){
        //Game over text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over",(SCREEN_WIDTH-metrics.stringWidth("Game Over"))/2,SCREEN_HEIGHT/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction != 'R'){
                        direction ='L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction ='R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D'){
                        direction ='U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction ='D';
                    }
                    break;
            }

        }
    }


}
