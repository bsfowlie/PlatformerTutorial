package com.github.bsfowlie.platformertutorial;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

import com.github.bsfowlie.platformertutorial.inputs.KeyboardInputs;
import com.github.bsfowlie.platformertutorial.inputs.MouseInputs;

public class GamePanel extends JPanel {

  private final Random random;

  private float xDelta = 100f;
  private float yDelta = 100f;

  private float xDir = 0.03f;
  private float yDir = 0.03f;

  private int frames = 0;
  private long lastCheck = 0;

  private Color color;

  GamePanel() {

    random = new Random();
    color = getRandomColor();

    var keyboardInputs = new KeyboardInputs(this);
    addKeyListener(keyboardInputs);

    var mouseInputs = new MouseInputs(this);
    addMouseListener(mouseInputs);
    addMouseMotionListener(mouseInputs);

    setFocusable(true);
  }

  public void changeXDelta(int value) {
    xDelta += value;
  }

  public void changeYDelta(int value) {
    yDelta += value;
  }

  public void setRectangle(int x, int y) {
    xDelta = x;
    yDelta = y;
  }

  @Override
  protected void paintComponent(final Graphics g) {

    super.paintComponent(g);

    updateRectangle();

    g.setColor(color);
    g.fillRect((int) xDelta, (int) yDelta, 200, 50);

    frames++;
    if (System.currentTimeMillis() - lastCheck >= 1_000) {
      lastCheck = System.currentTimeMillis();
      System.out.println("FPS: " + frames);
      frames = 0;
    }

    repaint();
  }

  private void updateRectangle() {

    xDelta += xDir;
    if (xDelta > 175) {
      xDir = -xDir;
      xDelta = 175;
      color = getRandomColor();
    }
    if (xDelta < 0) {
      xDir = -xDir;
      xDelta = 0;
      color = getRandomColor();
    }

    yDelta += yDir;
    if (yDelta > 325) {
      yDir = -yDir;
      yDelta = 325;
      color = getRandomColor();
    }
    if (yDelta < 0) {
      yDir = -yDir;
      yDelta = 0;
      color = getRandomColor();
    }
  }

  private Color getRandomColor() {

    final int r = random.nextInt(255);
    final int g = random.nextInt(255);
    final int b = random.nextInt(255);

    return new Color(r, g, b);
  }

}
