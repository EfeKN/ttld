package main;

//import java.util.Random;
import javax.swing.JPanel;
import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.util.ArrayList;

public class GameScreen extends JPanel {
    
    private Game game;
    
    private Dimension size;

    public GameScreen(Game game) {
        this.game = game;
            
        //sprites = new ArrayList<>();
        setPanelSize(); //inhibits hiding pixels
    }

    private void setPanelSize() {
        size = new Dimension(1024,576);
        setSize(size);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.getRender().render(g); 
    }

    

}
