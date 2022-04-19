package helpz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadSave {
      
      public static BufferedImage getSpriteAtlas() {
            BufferedImage img = null;
            try {
                  img = ImageIO.read(new File("res/tileset_compressed.png"));
                  } catch (IOException e) {
                  e.printStackTrace();
                  }
            return img;
      }

      public static BufferedImage getObjectSpriteAtlas() {
            BufferedImage img = null;
            try {
                  img = ImageIO.read(new File("res/obstacles-and-objects.png"));
                  } catch (IOException e) {
                  e.printStackTrace();
                  }
            return img;
      }

}
