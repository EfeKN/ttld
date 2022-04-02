package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.Game;

public class Menu extends GameScene implements SceneMethods{

      private BufferedImage img;
      private ArrayList<BufferedImage> sprites;
      private Random rand;  

      public Menu(Game game) {
            super(game);
            rand = new Random();
            importImg();
            loadSprites();
      }

      @Override
      public void render(Graphics g) {
            for(int i = 1; i <=36; i++) {
                  for(int j = 1; j <= 64; j++) {
                  g.drawImage(sprites.get(rand.nextInt(32)), (j*16)-16, (i*16)-16, null);
                  }
            }
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
}
