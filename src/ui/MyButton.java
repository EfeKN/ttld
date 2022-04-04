package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MyButton {
      
      private int x,y,width,height;
      private String text;
      private Rectangle bounds;

      private boolean mouseOver, mousePressed;

      public MyButton(String text,int x, int y, int width, int height) {
            this.text = text;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            initBounds();
      }

      private void initBounds() {
            this.bounds = new Rectangle(x,y,width,height);
      }

      public void draw(Graphics g) {

            //Body
            drawBody(g);

            //Border
            drawBorder(g);

            //Text
            drawText(g);

      }

      public void resetBooleans() {
            this.mouseOver = false;
            this.mousePressed = false;
      }

      private void drawBorder(Graphics g) {
            if(mousePressed) 
            {
                  g.setColor(Color.black);
                  g.drawRect(x, y, width, height);
                  g.drawRect(x+1, y+1, width-2, height-2);
                  g.drawRect(x+2, y+2, width-4, height-4);
            }
            else 
            {
                  g.setColor(Color.BLACK);
                  g.drawRect(x, y, width, height);
            }
      }

      private void drawBody(Graphics g) {
            g.setColor(Color.WHITE);
            if(mouseOver) 
            {
                  g.setColor(Color.gray);
            }
            g.fillRect(x, y, width, height);
      }

      private void drawText(Graphics g) {
            int w = g.getFontMetrics().stringWidth(text);
            int h = g.getFontMetrics().getHeight();
            g.drawString(text, x  + width/2 - w/2, y + height/2 + h/2);
      }

      public Rectangle getBounds() {
            return bounds;
      }

      public void setMouseOver(boolean mouseOver) {
            this.mouseOver = mouseOver;
      }

      public void setMOusePressed(boolean mousePressed) {
            this.mousePressed = mousePressed;
      }
}
