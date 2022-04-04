package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

public class Settings extends GameScene implements SceneMethods{

      public Settings(Game game) {
            super(game);
      }

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
            g.fillRect(0, 0, 1000, 500);
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
