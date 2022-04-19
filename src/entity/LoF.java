package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.AlphaComposite;
import javax.imageio.ImageIO;

public class LoF {

      public BufferedImage sprite;

      public LoF() {
            loadAtlas("res/LoF2.png");
      }
      
      protected void loadAtlas(String sprite) {
            try {
                  this.sprite = ImageIO.read(new File(sprite));
            } catch (IOException e) {
                  e.printStackTrace();
            }
      }

      public void draw(Graphics g, int xCord, int yCord) {
            Graphics2D g2d = (Graphics2D) g;
            
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));

            g2d.drawImage(sprite, xCord, yCord, null);
      }
}
