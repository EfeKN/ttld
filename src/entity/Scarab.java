package entity;

import java.util.ArrayList;
import java.awt.Graphics;

public class Scarab extends Enemy {

      private int aniIndex;
      private int delay;

      public Scarab() {
            loadAtlas("res/Scarab.png");
            animations = new ArrayList<>();
            initAnimations();
            aniIndex = 0;
            delay = 10;
      }

      private void initAnimations() {
            for(int y=0; y<5; y++) {
                  for(int x=0; x<5; x++) {
                        animations.add(getSprite(x, y));
                  }
            }
      }

      public void draw(Graphics g,int xCord, int yCord) {
            if(aniIndex<=delay)
            {
                  g.drawImage(animations.get(5), xCord, yCord, null);
            }
            else if(aniIndex<=2*delay)
            {
                  g.drawImage(animations.get(6), xCord, yCord, null);
            }
            else if(aniIndex<=3*delay)
            {
                  g.drawImage(animations.get(7), xCord, yCord, null);
            }
            else if(aniIndex<=4*delay)
            {
                  g.drawImage(animations.get(8), xCord, yCord, null);
            }
            else {
                  g.drawImage(animations.get(8), xCord, yCord, null);
                  aniIndex = -1;
            }
            aniIndex++;
      }
      
}
