package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Render {
      
      private GameScreen gameScreen;
      private BufferedImage img;
      private ArrayList<BufferedImage> sprites;
      private Random rand;

      public Render(GameScreen gameScreen) {
            this.gameScreen = gameScreen;
            rand = new Random();
            importImg();
            sprites = new ArrayList<>();
            loadSprites();
      }

      public void render(Graphics g) {
            switch(GameStates.gameState) {
                  case MENU:
                        for(int i = 1; i <=18; i++) {
                              for(int j = 1; j <= 32; j++) {
                              g.drawImage(sprites.get(rand.nextInt(64)), (j*32)-32, (i*32)-32, null);
                              }
                        }
                        break;
                  case PLAYING:
                        break;
                  case SETTINGS:
                        break;
            }
      }

            //Importing res files

      private void importImg() {
            
            try {
            img = ImageIO.read(new File("res/tileset_compressed.png"));
            } catch (IOException e) {
            e.printStackTrace();
            }
      }


      private void loadSprites() {
            for(int i = 0; i < 8;i++) {
                for(int j = 0; j < 8; j++) {
                    sprites.add(img.getSubimage((j*32), (i*32), 32, 32));
                }
            }
        }
}
