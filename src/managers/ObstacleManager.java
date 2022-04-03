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

      public void createDestroyedCar(Graphics g, int xCord, int yCord, String color, int direction) {
            int i = 0;
            if(color.equals("blue"))
            {
                  i = 8;
            }
            int x = xCord*16;
            int y = yCord*16;
            g.drawImage(getSprite(128+i+2*direction), x, y, null);
            g.drawImage(getSprite(129+i+2*direction), x+16, y, null);
            g.drawImage(getSprite(144+i+2*direction), x, y+16, null);
            g.drawImage(getSprite(145+i+2*direction), x+16, y+16, null);
      }

      public void createRock(Graphics g, int xCord, int yCord, int rockType) {
            if(rockType<0||rockType>4)
            {
                  rockType = 0;
            }
            int x = xCord*16;
            int y = yCord*16;
            g.drawImage(getSprite(64 + rockType), x, y, null);
      }

      public void createBrick(Graphics g, int xCord, int yCord, int brickType) {
            if(brickType<0||brickType>=4)
            {
                  brickType = 0;
            }
            int x = xCord*16;
            int y = yCord*16;
            g.drawImage(getSprite(84 + brickType), x, y, null);
      }

      public void createBarrel(Graphics g, int xCord, int yCord, int barrelType) {
            if(barrelType<0||barrelType>1)
            {
                  barrelType = 0;
            }
            g.drawImage(getSprite(48+barrelType), xCord*16, yCord*16, null);
      }

}
