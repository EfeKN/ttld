package entity;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public abstract class Enemy {
      protected BufferedImage atlas;
      protected ArrayList<BufferedImage> animations;
      protected void loadAtlas(String atlas) {
            try {
                  this.atlas = ImageIO.read(new File(atlas));
            } catch (IOException e) {
                  e.printStackTrace();
            }
      }

      protected BufferedImage getSprite(int xCord, int yCord) {
            return atlas.getSubimage((xCord*16), (yCord*16), 16, 16);
      }
}
