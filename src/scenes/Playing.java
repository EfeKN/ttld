package scenes;

import java.awt.Graphics;

import helpz.LevelBuild;
import main.Game;
import managers.*;

public class Playing extends GameScene implements SceneMethods{

      private int[][] lvl;
      private TileManager tileManager;
      private ObstacleManager obstacleManager;

      public Playing(Game game) {
            super(game);
            lvl = LevelBuild.getLevelData();
            tileManager = new TileManager();
            obstacleManager = new ObstacleManager();
      }

	@Override
	public void render(Graphics g) {
		
            for(int y = 0; y < lvl.length; y++) {
                  for(int x = 0; x < lvl[y].length; x++) {
                        int id = lvl[y][x];
                        g.drawImage(tileManager.getSprite(id),x*16,y*16,null);
                  }
            }
            obstacleManager.creatLampPost(g,13,14);
            obstacleManager.creatLampPost(g,17,14);
            obstacleManager.creatLampPost(g,21,14);
            obstacleManager.creatLampPost(g,25,14);
            obstacleManager.creatLampPost(g,29,14);
            obstacleManager.creatLampPost(g,33,14);
	}
      
}
