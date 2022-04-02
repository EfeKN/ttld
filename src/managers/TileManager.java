package managers;

import objects.Tile;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TileManager {
      
      public BufferedImage atlas;
      public ArrayList<Tile> tiles;

      public TileManager() {
            tiles = new ArrayList<>();
            loadAtlas();
            createTiles();
      }

      private void createTiles() {
            for(int i=1; i <=14; i++) {
                  for(int j=1; j <=16; j++) {
                        tiles.add(new Tile(getSprite(j, i)));
                  }
            }
      }

      private void loadAtlas() {

      }

      public BufferedImage getSprite(int id) {
            return tiles.get(id).getSprite();
      }

      private BufferedImage getSprite(int xCord, int yCord) {
            return atlas.getSubimage((xCord*16)-16, (yCord*16)-16, 16, 16);
      }
}
