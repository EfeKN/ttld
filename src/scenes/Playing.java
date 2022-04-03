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
            obstacleManager.createLampPost(g,13,14);
            obstacleManager.createLampPost(g,17,14);
            obstacleManager.createDestroyedLampPost(g,21,14);
            obstacleManager.createLampPost(g,25,14);
            obstacleManager.createLampPost(g,29,14);
            obstacleManager.createDestroyedLampPost(g,33,14);

            obstacleManager.createDestroyedCar(g, 0, 0, "blue");
            obstacleManager.createRock(g, 20, 20,0);
            obstacleManager.createRock(g, 21, 20,1);
            obstacleManager.createRock(g, 22, 20,2);
            obstacleManager.createRock(g, 23, 20,3);
            obstacleManager.createRock(g, 24, 20,4);
            obstacleManager.createRock(g, 25, 20,5);
	}
      
}
