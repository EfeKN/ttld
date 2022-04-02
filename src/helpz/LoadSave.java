package helpz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {
      
      public static BufferedImage getSpriteAtlas() {
            BufferedImage img = null;
            //InputStream is = LoadSave.class.getClassLoader().getResourceAsStream("res/tileset_compressed.png");
            try {
                  img = ImageIO.read(new File("res/tileset_compressed.png"));
                  } catch (IOException e) {
                  e.printStackTrace();
                  }
            return img;
      }

}
