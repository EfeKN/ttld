package managers;

import objects.Obstacles;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Graphics;
import helpz.LoadSave;

public class ObstacleManager {
      public BufferedImage atlas;
      public ArrayList<Obstacles> obstacles;

      public ObstacleManager() {
            obstacles = new ArrayList<>();
            loadAtlas();
            createObstacles();
      }

      private void createObstacles() {
            for(int i=1; i <=16; i++) {
                  for(int j=1; j <=16; j++) {
                        obstacles.add(new Obstacles(getSprite(j, i)));
                  }
            }
      }

      private void loadAtlas() {
            atlas = LoadSave.getObjectSpriteAtlas();
      }

      public BufferedImage getSprite(int id) {
            return obstacles.get(id).getSprite();
      }

      private BufferedImage getSprite(int xCord, int yCord) {
            return atlas.getSubimage((xCord*16)-16, (yCord*16)-16, 16, 16);
      }

      public void createLampPost(Graphics g, int xCord, int yCord) {
            int x = xCord*16;
            int y = yCord*16;
            g.drawImage(getSprite(0), x, y, null);
            g.drawImage(getSprite(1), x+16, y, null);
            g.drawImage(getSprite(16), x, y+16, null);
            g.drawImage(getSprite(17), x+16, y+16, null);
            g.drawImage(getSprite(32), x, y+32, null);
            g.drawImage(getSprite(33), x+16, y+32, null);
      }

      public void createDestroyedLampPost(Graphics g, int xCord, int yCord) {
            int x = xCord*16;
            int y = yCord*16;
            g.drawImage(getSprite(2), x, y, null);
            g.drawImage(getSprite(3), x+16, y, null);
            g.drawImage(getSprite(18), x, y+16, null);
            g.drawImage(getSprite(19), x+16, y+16, null);
            g.drawImage(getSprite(34), x, y+32, null);
            g.drawImage(getSprite(35), x+16, y+32, null);
      }
}
