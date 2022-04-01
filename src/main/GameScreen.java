package main;

import java.util.Random;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameScreen extends JPanel implements Runnable {
    
    //private BufferedImage img;
    private ArrayList<BufferedImage> sprites;
    private Random rand;
    private long frames;
    private long lastTime;
    private double timePerFrame;
    private  long lastFrame;
    Thread gameThread;

    public GameScreen(BufferedImage img) {
        rand = new Random();
        sprites = new ArrayList<>();
        for(int i = 0; i < 8;i++) {
            for(int j = 0; j < 8; j++) {
                sprites.add(img.getSubimage((j*32), (i*32), 32, 32));
            }
        }
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 1; i <=18; i++) {
            for(int j = 1; j <= 32; j++) {
                g.drawImage(sprites.get(rand.nextInt(64)), (j*32)-32, (i*32)-32, null);
            }
        } 
        //callFPS();
    }

    public void loopGame() {
        if(System.nanoTime() - lastFrame >= timePerFrame) {
            lastFrame = System.nanoTime();
            repaint();
        }
    }

    public void callFPS() {
        frames++;
        if(System.currentTimeMillis() - lastTime >= 1000) {
            System.out.println("Frame per second " + frames);
            frames = 0;
            lastTime = System.currentTimeMillis();
        }
    }

    @Override
    public void run() {
        while(gameThread!=null) {
            update();
            repaint();
        }
        
    }

    public void update() {

    }

}
