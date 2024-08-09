package com.github.bsfowlie.platformertutorial.inputs;

import static com.github.bsfowlie.platformertutorial.utils.Constants.Direction.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.github.bsfowlie.platformertutorial.GamePanel;

public class KeyboardInputs implements KeyListener {

  private final GamePanel gamePanel;

  public KeyboardInputs(final GamePanel gamePanel) {

    this.gamePanel = gamePanel;
  }

  @Override
  public void keyTyped(final KeyEvent e) {

  }

  @Override
  public void keyPressed(final KeyEvent e) {

    switch (e.getKeyCode()) {
      case KeyEvent.VK_W:
      case KeyEvent.VK_UP:
        gamePanel.setDirection(UP);
        break;
      case KeyEvent.VK_A:
      case KeyEvent.VK_LEFT:
        gamePanel.setDirection(LEFT);
        break;
      case KeyEvent.VK_S:
      case KeyEvent.VK_DOWN:
        gamePanel.setDirection(DOWN);
        break;
      case KeyEvent.VK_D:
      case KeyEvent.VK_RIGHT:
        gamePanel.setDirection(RIGHT);
        break;
      default:
        break;
    }
  }

  @Override
  public void keyReleased(final KeyEvent e) {

    switch (e.getKeyCode()) {
      case KeyEvent.VK_W:
      case KeyEvent.VK_UP:
      case KeyEvent.VK_A:
      case KeyEvent.VK_LEFT:
      case KeyEvent.VK_S:
      case KeyEvent.VK_DOWN:
      case KeyEvent.VK_D:
      case KeyEvent.VK_RIGHT:
        gamePanel.setMoving(false);
        break;
      default:
        break;
    }
  }

}
