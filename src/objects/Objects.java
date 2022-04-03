package objects;

import java.awt.image.BufferedImage;

public class Objects {
      
      protected BufferedImage sprite;

      public Objects(BufferedImage sprite) {
            this.sprite = sprite;
      }

      public BufferedImage getSprite() {
            return sprite;
      } 
}
