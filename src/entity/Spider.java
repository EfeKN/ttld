package entity;

import java.awt.Graphics;
import java.util.ArrayList;

public class Spider extends Enemy {

      private int aniIndex;
      private int delay;
      private boolean die;

      public Spider() {
            die = false;
            loadAtlas("res/Spider.png");
            animations = new ArrayList<>();
            initAnimations();
            aniIndex = 0;
            delay = 30;
      }

      private void initAnimations() {
            for(int y=0; y<5; y++) {
                  for(int x=0; x<5; x++) {
                        animations.add(getSprite(x, y));
                  }
            }
      }

      public void draw(Graphics g,int xCord, int yCord) {
            if(die) 
            {
                  g.drawImage(animations.get(20), xCord, yCord, null);
            }
            else 
            {
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

      public boolean getDie() {
            return die;
      }

      public void setDie(boolean die) {
            this.die = die;
      }
      
}
