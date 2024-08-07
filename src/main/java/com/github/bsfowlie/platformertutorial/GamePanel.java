package com.github.bsfowlie.platformertutorial;

import java.awt.*;
import javax.swing.*;

import com.github.bsfowlie.platformertutorial.inputs.KeyboardInputs;
import com.github.bsfowlie.platformertutorial.inputs.MouseInputs;

public class GamePanel extends JPanel {

  private int xDelta = 100;
  private int yDelta = 100;

  GamePanel() {

    var keyboardInputs = new KeyboardInputs(this);
    addKeyListener(keyboardInputs);

    var mouseInputs = new MouseInputs(this);
    addMouseListener(mouseInputs);
    addMouseMotionListener(mouseInputs);

    setFocusable(true);
  }

  public void changeXDelta(int value) {
    xDelta += value;
    repaint();
  }

  public void changeYDelta(int value) {
    yDelta += value;
    repaint();
  }

  public void setRectangle(int x, int y) {
    xDelta = x;
    yDelta = y;
    repaint();
  }

  @Override
  protected void paintComponent(final Graphics g) {

    super.paintComponent(g);
    g.fillRect(xDelta, yDelta, 200, 50);
  }

}
