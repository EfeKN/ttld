package main;

import scenes.*;
//import input.*;
import javax.swing.JFrame;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import javax.imageio.ImageIO;

public class Game extends JFrame implements Runnable{

    private GameScreen gameScreen;

    private Thread gameThread;
    
    final double FPS = 120.0;
    final double UPS = 60.0;

    private Render render;
    private Menu menu;
    private Playing playing;
    private Settings settings;

    public Game() {
        setSize(1024,576);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initClasses();  
        this.add(gameScreen);
        pack();
    }

    private void initClasses() {
        render = new Render(this);
        gameScreen = new GameScreen(this);
        menu = new Menu(this);
        playing = new Playing(this);
        settings = new Settings(this);
    }
    //try the game here
    public static void main(String[] args) { 
        Game game = new Game();
        game.gameScreen.initInputs();
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

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis() ;

        double timePerFrame = 1000000000.0/FPS; //FPS limiter
        double timePerUpdate = 1000000000.0/UPS; //FPS limiter

        long now; //FPS limiter
        //Graphical output and information
        while(true) {
            now = System.nanoTime();
            //Render
            if(now - lastFrame >= timePerFrame) {
                lastFrame = now;
                repaint(); 
                frames++;
            }
            //Update
            if(now - lastUpdate >= timePerUpdate) { 
                lastUpdate = now;
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

    //Getters and Setters

    public Render getRender() {
        return render;
    }

    public Menu getMenu() {
        return menu;
    }

    public Playing getPlaying() {
        return playing;
    }

    public Settings getSettings() {
        return settings;
    }
}