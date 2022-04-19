package main;
import input.*;
//import java.util.Random;
import javax.swing.JPanel;
import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.util.ArrayList;
import java.io.IOException;

public class GameScreen extends JPanel {
    
    private Game game;

    private MyMouseListener myMouseListener;
    private KeyboardListener myKeyboardListener;

    private Dimension size;

    public GameScreen(Game game) {
        this.game = game;
        initInputs();
        //sprites = new ArrayList<>();
        setPanelSize(); //inhibits hiding pixels
    }

    public void initInputs() {
        myKeyboardListener = new KeyboardListener();
        myMouseListener = new MyMouseListener(game);

        addKeyListener(myKeyboardListener);
        addMouseMotionListener(myMouseListener);
        addMouseListener(myMouseListener);

        requestFocus(); 
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
        try {
            game.getRender().render(g);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    

}
