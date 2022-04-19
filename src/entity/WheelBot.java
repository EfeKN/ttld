package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class WheelBot extends Enemy {

      private int aniIndex;
      private int delay;
      private boolean die;
      private BufferedImage charge;
      private BufferedImage shoot;
      public static final int RUN=0,CHARGE=1,SHOOT=2;
      private int condition;

      public WheelBot(int condition) {
            setCondition(condition);
            die = false;
            loadAtlas("res/move with FX.png");
            animations = new ArrayList<>();
            
            aniIndex = 0;
            delay = 10;
            try {
                  this.charge = ImageIO.read(new File("res/charge.png"));
                  this.shoot = ImageIO.read(new File("res/shoot with FX.png"));
            } catch (IOException e) {
                  e.printStackTrace();
            }
            initAnimations();
            
      }

      @Override
      public BufferedImage getSprite(int x, int y) {
            return atlas.getSubimage((x*26), (y*26), 26, 26);
      }

      public BufferedImage getSprite(int x, int y, BufferedImage sprite) {
            return sprite.getSubimage((x*26), (y*26), 26, 26);
      }

      private void initAnimations() {

            //Shoot
            animations.add(getSprite(0, 0));
            animations.add(getSprite(1, 0));
            animations.add(getSprite(0, 1));
            animations.add(getSprite(1, 1));
            animations.add(getSprite(0, 2));
            animations.add(getSprite(1, 2));
            animations.add(getSprite(0, 3));
            animations.add(getSprite(1, 3));
            animations.add(getSprite(0, 4));
            animations.add(getSprite(1, 4));
            animations.add(getSprite(0, 5));
            animations.add(getSprite(1, 5));
            animations.add(getSprite(0, 6));
            animations.add(getSprite(1, 6));
            animations.add(getSprite(0, 7));
            animations.add(getSprite(1, 7));

            //Charge
            animations.add(getSprite(0, 0, charge)); //8
            animations.add(getSprite(1, 0, charge)); //9
            animations.add(getSprite(0, 1, charge)); //10
            animations.add(getSprite(1, 1, charge)); //11
            animations.add(getSprite(0, 2, charge)); //12
            animations.add(getSprite(1, 2, charge)); //13
            animations.add(getSprite(0, 3, charge)); //14
            animations.add(getSprite(1, 3, charge)); //15

            //Shoot
            animations.add(getSprite(0, 0, shoot)); //16
            animations.add(getSprite(1, 0, shoot)); //17
            animations.add(getSprite(0, 1, shoot)); //18
            animations.add(getSprite(1, 1, shoot)); //19
            animations.add(getSprite(0, 2, shoot)); //20
            animations.add(getSprite(1, 2, shoot)); //21
            animations.add(getSprite(0, 3, shoot)); //22
            animations.add(getSprite(1, 3, shoot)); //23
            
      }

      public void setCondition(int condition) {
            this.condition = condition;
      }

      public void draw(Graphics g,int xCord, int yCord) {
            if(die) 
            {
                  g.drawImage(animations.get(0), xCord, yCord, null);
            }
            else if(condition==RUN)
            {
                  if(aniIndex<=delay)
                  {
                        g.drawImage(animations.get(0), xCord, yCord, null);
                        g.drawImage(animations.get(1), xCord+26, yCord, null);
                  }
                  else if(aniIndex<=2*delay)
                  {
                        g.drawImage(animations.get(2), xCord, yCord, null);
                        g.drawImage(animations.get(3), xCord+26, yCord, null);
                  }
                  else if(aniIndex<=3*delay)
                  {
                        g.drawImage(animations.get(4), xCord, yCord, null);
                        g.drawImage(animations.get(5), xCord+26, yCord, null);
                  }
                  else if(aniIndex<=4*delay)
                  {
                        g.drawImage(animations.get(6), xCord, yCord, null);
                        g.drawImage(animations.get(7), xCord+26, yCord, null);
                  }
                  else if(aniIndex<=5*delay)
                  {
                        g.drawImage(animations.get(8), xCord, yCord, null);
                        g.drawImage(animations.get(9), xCord+26, yCord, null);
                  }
                  else if(aniIndex<=6*delay)
                  {
                        g.drawImage(animations.get(10), xCord, yCord, null);
                        g.drawImage(animations.get(11), xCord+26, yCord, null);
                  }
                  else if(aniIndex<=7*delay)
                  {
                        g.drawImage(animations.get(12), xCord, yCord, null);
                        g.drawImage(animations.get(13), xCord+26, yCord, null);
                  }
                  else if(aniIndex<=8*delay)
                  {
                        g.drawImage(animations.get(14), xCord, yCord, null);
                        g.drawImage(animations.get(15), xCord+26, yCord, null);
                  }
                  else {
                        g.drawImage(animations.get(0), xCord, yCord, null);
                        g.drawImage(animations.get(1), xCord+26, yCord, null);
                        aniIndex = -1;
                  }
                  aniIndex++;
            }
            else if(condition==CHARGE) 
            {
                  
                  if(aniIndex<=delay)
                  {
                        g.drawImage(animations.get(16), xCord, yCord, null);
                        g.drawImage(animations.get(17), xCord+26, yCord, null);
                  }
                  else if(aniIndex<=2*delay)
                  {
                        g.drawImage(animations.get(18), xCord, yCord, null);
                        g.drawImage(animations.get(19), xCord+26, yCord, null);
                  }
                  else if(aniIndex<=3*delay)
                  {
                        g.drawImage(animations.get(20), xCord, yCord, null);
                        g.drawImage(animations.get(21), xCord+26, yCord, null);
                  }
                  else if(aniIndex<=4*delay)
                  {
                        g.drawImage(animations.get(22), xCord, yCord, null);
                        g.drawImage(animations.get(23), xCord+26, yCord, null);
                  }
                  else {
                        g.drawImage(animations.get(16), xCord, yCord, null);
                        g.drawImage(animations.get(17), xCord+26, yCord, null);
                        setCondition(SHOOT);
                        aniIndex = -1;
                  }
                  aniIndex++;
            }
            else if(condition==SHOOT) 
            {
                  
                  if(aniIndex<=delay)
                  {
                        g.drawImage(animations.get(24), xCord, yCord, null);
                        g.drawImage(animations.get(25), xCord+26, yCord, null);
                  }
                  else if(aniIndex<=2*delay)
                  {
                        g.drawImage(animations.get(26), xCord, yCord, null);
                        g.drawImage(animations.get(27), xCord+26, yCord, null);
                  }
                  else if(aniIndex<=3*delay)
                  {
                        g.drawImage(animations.get(28), xCord, yCord, null);
                        g.drawImage(animations.get(29), xCord+26, yCord, null);
                  }
                  else if(aniIndex<=4*delay)
                  {
                        g.drawImage(animations.get(30), xCord, yCord, null);
                        g.drawImage(animations.get(31), xCord+26, yCord, null);
                  }
                  else {
                        g.drawImage(animations.get(24), xCord, yCord, null);
                        g.drawImage(animations.get(25), xCord+26, yCord, null);
                        setCondition(CHARGE);
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
