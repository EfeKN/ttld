package entity;

import java.awt.Graphics;
import java.util.ArrayList;

public class Turret extends Friendly {

      private int aniIndex;
      private int delay;
      int balance;

      public Turret() {
            //die = false;
            loadAtlas("res/1.png");
            animations = new ArrayList<>();
            initAnimations();
            aniIndex = 0;
            delay = 90;
            balance = 10;
      }

      private void initAnimations() {
            animations.add(getSprite(3, 3));
            animations.add(getSprite(4, 3));
            animations.add(getSprite(5, 3));
            animations.add(getSprite(3, 4));
            animations.add(getSprite(4, 4));
            animations.add(getSprite(5, 4));
            animations.add(getSprite(13, 3));
            animations.add(getSprite(14, 3));
            animations.add(getSprite(13, 4));
            animations.add(getSprite(14, 4));
      }

      public void draw(Graphics g, int Xcord, int yCord) {

            if(aniIndex<=delay)
            {
                  g.drawImage(animations.get(0), Xcord, yCord, null);
                  g.drawImage(animations.get(1), Xcord+16, yCord, null);    
                  g.drawImage(animations.get(2), Xcord+32, yCord, null);
                  g.drawImage(animations.get(3), Xcord, yCord+16, null);
                  g.drawImage(animations.get(4), Xcord+16, yCord+16, null);
                  g.drawImage(animations.get(5), Xcord+32, yCord+16, null);
            }
            else if(aniIndex<=2*delay)
            {
                  g.drawImage(animations.get(6), Xcord+balance, yCord, null);
                  g.drawImage(animations.get(7), Xcord+16+balance, yCord, null);
                  g.drawImage(animations.get(8), Xcord+balance, yCord+16, null);
                  g.drawImage(animations.get(9), Xcord+16+balance, yCord+16, null);
            }
            else {
                  g.drawImage(animations.get(0), Xcord, yCord, null);
                  g.drawImage(animations.get(1), Xcord+16, yCord, null);    
                  g.drawImage(animations.get(2), Xcord+32, yCord, null);
                  g.drawImage(animations.get(3), Xcord, yCord+16, null);
                  g.drawImage(animations.get(4), Xcord+16, yCord+16, null);
                  g.drawImage(animations.get(5), Xcord+32, yCord+16, null);
                  aniIndex = -1;
            }
            aniIndex++;
            
            
      }
}
