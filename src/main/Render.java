package main;

import java.awt.Graphics;
import java.io.IOException;

public class Render {
      
      private Game game;

      public Render(Game game) {
            this.game = game;
      }

      public void render(Graphics g) throws IOException {
            switch(GameStates.gameState) {
                  case MENU:
                        game.getMenu().render(g);
                        break;
                  case PLAYING:
                        game.getPlaying().render(g);
                        break;
                  case SETTINGS:
                        game.getSettings().render(g);
                        break;
            }
      }

            //Importing res files

}
