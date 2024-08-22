package com.github.bsfowlie.platformertutorial.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.github.bsfowlie.platformertutorial.GamePanel;

public class MouseInputs implements MouseListener, MouseMotionListener {

  private final GamePanel gamePanel;

  public MouseInputs(final GamePanel gamePanel) {

    this.gamePanel = gamePanel;
  }

  @Override
  public void mouseClicked(final MouseEvent e) {

    if (e.getButton() == MouseEvent.BUTTON1) {
      gamePanel.getGame().getPlayer().setAttacking(true);
    }
  }

  @Override
  public void mousePressed(final MouseEvent e) {

  }

  @Override
  public void mouseReleased(final MouseEvent e) {

  }

  @Override
  public void mouseEntered(final MouseEvent e) {

  }

  @Override
  public void mouseExited(final MouseEvent e) {

  }

  @Override
  public void mouseDragged(final MouseEvent e) {

  }

  @Override
  public void mouseMoved(final MouseEvent e) {

  }

}
