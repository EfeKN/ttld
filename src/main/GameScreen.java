package main;

import java.util.Random;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameScreen extends JPanel {
    
    //private BufferedImage img;
    private ArrayList<BufferedImage> sprites;
    private Random rand;

    public GameScreen(BufferedImage img) {
        rand = new Random();
        sprites = new ArrayList<>();
        for(int i = 0; i < 8;i++) {
            for(int j = 0; j < 8; j++) {
                sprites.add(img.getSubimage((j*32), (i*32), 32, 32));
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 1; i <=18; i++) {
            for(int j = 1; j <= 32; j++) {
                g.drawImage(sprites.get(rand.nextInt(64)), (j*32)-32, (i*32)-32, null);
            }
        }
        g.drawImage(sprites.get(sprites.size()-1), (4*32)-32, (4*32)-32, null); 
    }

    

}
