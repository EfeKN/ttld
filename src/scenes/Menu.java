package scenes;

import static main.GameStates.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.Game;
import ui.MyButton;

public class Menu extends GameScene implements SceneMethods{

      private BufferedImage img;
      private ArrayList<BufferedImage> sprites;
      
      private MyButton bPlaying, bSettings, bQuit;

      public Menu(Game game) {
            super(game);
            importImg();
            loadSprites();
            initButtons();
      }

      private void initButtons() {
            int w = 150;
            int h = 50;
            int d = 20;
            bPlaying = new MyButton("Play", getGame().getWidth()/2-w/2, 100, w, h);
            bSettings = new MyButton("Settings", getGame().getWidth()/2-w/2, 100 + h + d, w, h);
            bQuit = new MyButton("Quit", getGame().getWidth()/2-w/2, 100 + 2*h + 2*d, w, h);
      }

      @Override
      public void render(Graphics g) {
            drawButtons(g);
      } 

      private void drawButtons(Graphics g) {
            bPlaying.draw(g);
            bSettings.draw(g);
            bQuit.draw(g);
      }

      private void importImg() {
            
            try {
            img = ImageIO.read(new File("res/tileset_compressed.png"));
            } catch (IOException e) {
            e.printStackTrace();
            }
      }


      private void loadSprites() {
            sprites = new ArrayList<>();
            for(int i = 0; i < 8;i++) {
                for(int j = 0; j < 8; j++) {
                    sprites.add(img.getSubimage((j*32), (i*32), 32, 32));
                }
            }
      }

	@Override
	public void mouseClicked(int x, int y) {
		
            if(bPlaying.getBounds().contains(x,y))
            {
                  setGameState(PLAYING);
            }
		
	}

	public void mouseMoved(int x, int y) {
            bPlaying.setMouseOver(false);
            if(bPlaying.getBounds().contains(x,y))
            {
                  bPlaying.setMouseOver(true);
            }
	}

	@Override
	public void mousePressed(int x, int y) {
            if(bPlaying.getBounds().contains(x,y))
            {
                  bPlaying.setMOusePressed(true);
            }
		
	}

	@Override
	public void mouseReleased(int x, int y) {
		bPlaying.resetBooleans();
	}
}
