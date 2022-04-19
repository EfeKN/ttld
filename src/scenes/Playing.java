package scenes;

import java.awt.Graphics;

import entity.LoF;
import entity.Scarab;
import entity.Spider;
import entity.Turret;
import entity.WheelBot;
import helpz.LevelBuild;
import main.Game;
import managers.*;

public class Playing extends GameScene implements SceneMethods{

      private int[][] lvl;
      private TileManager tileManager;
      private ObstacleManager obstacleManager;
      private Turret t;
      private WheelBot wb1,wb2,wb3;
      private LoF lof;

      //sample
      private Spider sp;
      private Scarab sc; 
      int x,y,z;

      public Playing(Game game) {
            super(game);
            lvl = LevelBuild.getLevelData();
            tileManager = new TileManager();
            obstacleManager = new ObstacleManager();

            //sample
            sp = new Spider();
            sc = new Scarab();
            t = new Turret();
            lof = new LoF();
            wb1 = new WheelBot(WheelBot.RUN);
            wb2 = new WheelBot(WheelBot.CHARGE);
            wb3 = new WheelBot(WheelBot.SHOOT);
            x=31;
            y=31;
            z=0;
      }

	@Override
	public void render(Graphics g) {
		
            for(int y = 0; y < lvl.length; y++) {
                  for(int x = 0; x < lvl[y].length; x++) {
                        int id = lvl[y][x];
                        g.drawImage(tileManager.getSprite(id),x*16,y*16,null);
                  }
            }
            

            //Sample bricks
            obstacleManager.createBrick(g, 15, 0, 0);
            obstacleManager.createBrick(g, 16, 0, 1);
            obstacleManager.createBrick(g, 12, 0, 2);
            obstacleManager.createBrick(g, 13, 0, 3);
            obstacleManager.createBrick(g, 14, 0, 4);

            //Lamp posts
            obstacleManager.createLampPost(g,13,14);
            obstacleManager.createLampPost(g,20,20);
            obstacleManager.createLampPost(g,17,14);
            obstacleManager.createDestroyedLampPost(g,21,14);
            obstacleManager.createLampPost(g,25,14);
            obstacleManager.createLampPost(g,29,14);
            obstacleManager.createDestroyedLampPost(g,33,14);

            //Sample cars
            obstacleManager.createDestroyedCar(g, 0, 0, "blue",0);
            obstacleManager.createDestroyedCar(g, 0, 1, "blue",1);
            obstacleManager.createDestroyedCar(g, 0, 2, "blue",3);
            obstacleManager.createDestroyedCar(g, 0, 3, "blue",2);
            obstacleManager.createDestroyedCar(g, 0, 4, "red",0);
            obstacleManager.createDestroyedCar(g, 0, 5, "red",1);
            obstacleManager.createDestroyedCar(g, 0, 6, "red",2);
            obstacleManager.createDestroyedCar(g, 0, 7, "red",3);

            //Sample rocks
            obstacleManager.createRock(g, 20, 20,0);
            obstacleManager.createRock(g, 21, 20,1);
            obstacleManager.createRock(g, 22, 20,2);
            obstacleManager.createRock(g, 23, 20,3);
            obstacleManager.createRock(g, 24, 20,4);
            obstacleManager.createRock(g, 25, 20,5);
            obstacleManager.createRock(g, 26, 20,6);
            obstacleManager.createRock(g, 27, 20,7);

            //Sample barrels
            obstacleManager.createBarrel(g, 50, 35, 0);
            obstacleManager.createBarrel(g, 51, 35, 1);
            obstacleManager.createBarrel(g, 52, 35, 2);
            
            //Sample turret

            t.draw(g, 40, 40);
            
            wb2.draw(g, 500, 80);
            g.drawRect(500, 100, 50, 50);
            //t.draw(g, 500, 100);

            //Sample spider
            sp.draw(g, x, y);
            sc.draw(g, x, y+720);
            wb1.draw(g, 500, y+=1);
            wb2.draw(g, 500, 500);
            wb3.draw(g, 600, 500);
            z++;
            if(z==2)
            {
                  y--;
                  x++;
                  z=0;
            }
            else if(x==super.getGame().getWidth()) {
                  x=0;
            }
            else if(y==super.getGame().getHeight()) {
                  y=0;
            }
            
            lof.draw(g, 500, 100);
      }

      @Override
      public void mouseClicked(int x, int y) {
            
            
      }

      @Override
      public void mouseMoved(int x, int y) {
      
            
      }

      @Override
      public void mousePressed(int x, int y) {
            
      }

      @Override
      public void mouseReleased(int x, int y) {
            
            
      }
      
}
