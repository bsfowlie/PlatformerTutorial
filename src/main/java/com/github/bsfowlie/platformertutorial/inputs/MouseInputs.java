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

    System.out.println("mouse clicked");
  }

  @Override
  public void mousePressed(final MouseEvent e) {

    System.out.println("mouse pressed");
  }

  @Override
  public void mouseReleased(final MouseEvent e) {

    System.out.println("mouse released");
  }

  @Override
  public void mouseEntered(final MouseEvent e) {

    System.out.println("mouse entered");
  }

  @Override
  public void mouseExited(final MouseEvent e) {

    System.out.println("mouse exited");
  }

  @Override
  public void mouseDragged(final MouseEvent e) {

    System.out.println("mouse dragged");
  }

  @Override
  public void mouseMoved(final MouseEvent e) {

    System.out.println("mouse moved");
  }

}
