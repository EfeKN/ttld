package main;

import javax.swing.JFrame;
import javax.swing.JSlider;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Game extends JFrame{

    private BufferedImage img;

    public Game() {

        importImg();

        setSize(1024,576);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        GameScreen gameScreen = new GameScreen(img);
        this.add(gameScreen);

    }

    private void importImg() {
        
        try {
            img = ImageIO.read(new File("ttld/res/txTileset.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        Game game = new Game();

    }

}