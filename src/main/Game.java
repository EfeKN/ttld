package main;

import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Game extends JFrame implements Runnable{

    private BufferedImage img; 

    private Thread gameThread;
    final double FPS = 120.0;
    final double UPS = 60.0;

    public Game() {

        importImg();

        setSize(1024,576);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        GameScreen gameScreen = new GameScreen(img);
        this.add(gameScreen);

    }

    //Importing res files

    private void importImg() {
        
        try {
            img = ImageIO.read(new File("res/tileset_compressed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //try the game here

    public static void main(String[] args) { 
        Game game = new Game();
        game.start();
    }

    // FPS limiter

    private void start() {
        gameThread = new Thread(this) {};
        gameThread.start();
    }

    //This part I don't understand it limits the frame rate to 120FPS but I have no idea how it works or why it divides different numbers
    @Override
    public void run() {
        int frames = 0; //FPS limiter
        int updates = 0;

        long lastTimeCheck = System.currentTimeMillis() ;
        long now = System.nanoTime(); //FPS limiter

        double timePerFrame = 1000000000.0/FPS; //FPS limiter
        double timePerUpdate = 1000000000.0/UPS; //FPS limiter
        //Graphical output and information
        while(true) {
            //Render
            if(System.nanoTime() - now >= timePerFrame) {
                now = System.nanoTime();
                repaint(); 
                frames++;
            }
            //Update
            if(System.nanoTime() - now >= timePerUpdate) { 
                now = System.nanoTime();
                updates++;
            }
            //checking FPS and UPS
            if(System.currentTimeMillis() - lastTimeCheck >= 1000) { //ensures 1 second has passed
                System.out.println("FPS : " + frames + " | UPS : " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }
}