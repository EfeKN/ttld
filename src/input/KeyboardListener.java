package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GameStates;

import static main.GameStates.*;

public class KeyboardListener implements KeyListener{

      @Override
      public void keyTyped(KeyEvent e) {
            
      }

      @Override
      public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_A)
            {
                  System.out.println("A is pressed");
            }
            else if(e.getKeyCode() == KeyEvent.VK_B)
            {
                  System.out.println("B is pressed");
            }
            else if(e.getKeyCode() == KeyEvent.VK_S)
            {
                  GameStates.gameState = PLAYING;
            }
            else if(e.getKeyCode() == KeyEvent.VK_D)
            {
                  GameStates.gameState = SETTINGS;
            }
            
      }

      @Override
      public void keyReleased(KeyEvent e) {
            
            
      }
      
}
