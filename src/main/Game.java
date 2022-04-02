package main;

import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Game extends JFrame implements Runnable{

    private BufferedImage img;
    private BufferedImage img2; 
    private Thread gameThread;
    //private int updates;
    //private long lastTimeUPS;

    final double FPS = 120.0;
    final double UPS = 60.0;

    public Game() {

        importImg();

        setSize(1024,576);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        GameScreen gameScreen = new GameScreen(img,img2);
        this.add(gameScreen);

    }

    //Importing res files

    private void importImg() {
        
        try {
            img = ImageIO.read(new File("ttld/res/txTileset.png"));
            img2 = ImageIO.read(new File("ttld/res/txProps.png"));
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
    /** 
    private void callUPS() {
        if(System.currentTimeMillis() - lastTimeUPS >=1000)
        {
            System.out.println("Updates: " + updates);
            updates = 0;
            lastTimeUPS = System.currentTimeMillis();
        }
    }
    */
    @Override
    public void run() {
        int frames = 0; //FPS limiter
        int updates = 0;

        long lastTimeCheck = System.currentTimeMillis() ;
        long lastFrame = System.nanoTime(); //FPS limiter
        long lastUpdate = System.nanoTime();

        double timePerFrame = 1000000000.0/FPS; //FPS limiter
        double timePerUpdate = 1000000000.0/UPS; //FPS limiter

        while(true) {
            //Render
            if(System.nanoTime() - lastFrame >= timePerFrame) {
                lastFrame = System.nanoTime();
                repaint(); 
                frames++;
            }
            //Update
            if(System.nanoTime() - lastUpdate >= timePerUpdate) {
                lastUpdate = System.nanoTime();
                updates++;
            }
            //checking FPS and UPS
            if(System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS : " + frames + " | UPS : " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }
}