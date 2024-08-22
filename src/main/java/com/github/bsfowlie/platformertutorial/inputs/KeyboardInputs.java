package com.github.bsfowlie.platformertutorial.inputs;

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
        gamePanel.getGame().getPlayer().setUp(true);
        break;
      case KeyEvent.VK_A:
      case KeyEvent.VK_LEFT:
        gamePanel.getGame().getPlayer().setLeft(true);
        break;
      case KeyEvent.VK_S:
      case KeyEvent.VK_DOWN:
        gamePanel.getGame().getPlayer().setDown(true);
        break;
      case KeyEvent.VK_D:
      case KeyEvent.VK_RIGHT:
        gamePanel.getGame().getPlayer().setRight(true);
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
        gamePanel.getGame().getPlayer().setUp(false);
        break;
      case KeyEvent.VK_A:
      case KeyEvent.VK_LEFT:
      gamePanel.getGame().getPlayer().setLeft(false);
      break;
      case KeyEvent.VK_S:
      case KeyEvent.VK_DOWN:
      gamePanel.getGame().getPlayer().setDown(false);
      break;
      case KeyEvent.VK_D:
      case KeyEvent.VK_RIGHT:
      gamePanel.getGame().getPlayer().setRight(false);
      break;
      default:
        break;
    }
  }

}
