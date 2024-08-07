package com.github.bsfowlie.platformertutorial;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

import com.github.bsfowlie.platformertutorial.inputs.KeyboardInputs;
import com.github.bsfowlie.platformertutorial.inputs.MouseInputs;

public class GamePanel extends JPanel {

  private final Random random;

  private final List<MyRect> rects = new LinkedList<>();

  private final MyRect myRect;

  GamePanel() {

    random = new Random();

    var keyboardInputs = new KeyboardInputs(this);
    addKeyListener(keyboardInputs);

    var mouseInputs = new MouseInputs(this);
    addMouseListener(mouseInputs);
    addMouseMotionListener(mouseInputs);

    myRect = new MyRect(100, 100, 200, 50);
    rects.add(myRect);

    setFocusable(true);
  }

  public void changeXDelta(final int value) {

    myRect.changeX(value);
  }

  public void changeYDelta(final int value) {

    myRect.changeY(value);
  }

  public void setRectangle(final int x, final int y) {

    myRect.setPos(x, y);
  }

  public void spawnRect(final int x, final int y) {

    rects.addFirst(new MyRect(x, y));
  }

  @Override
  protected void paintComponent(final Graphics g) {

    super.paintComponent(g);

    var bounds = this.getBounds();
    for (final MyRect rect : rects) {
      rect.updateRect(bounds);
      rect.draw(g);
    }
  }

  private class MyRect {

    private final int w;
    private final int h;

    private double x;
    private double y;

    private double xDir;
    private double yDir;

    private Color color;

    private MyRect(final int x, final int y) {

      this(x, y, random.nextInt(50) + 25, random.nextInt(50) + 25);
    }

    private MyRect(final int x, final int y, final int w, final int h) {

      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      color = newColor();
      xDir = random.nextDouble(2) - 1;
      yDir = random.nextDouble(2) - 1;
    }

    private Color newColor() {

      final int r = random.nextInt(255);
      final int g = random.nextInt(255);
      final int b = random.nextInt(255);

      return new Color(r, g, b);
    }

    private void changeX(final int value) {

      x += value;
    }

    private void changeY(final int value) {

      y += value;
    }

    private void setPos(final int x, final int y) {

      this.x = x;
      this.y = y;
    }

    private void updateRect(final Rectangle bounds) {

      x += xDir;
      if (x > bounds.getWidth() - w) {
        xDir = -xDir;
        x = (int) (bounds.getWidth() - w);
        color = newColor();
      }
      if (x < 0) {
        xDir = -xDir;
        x = 0;
        color = newColor();
      }

      y += yDir;
      if (y > bounds.getHeight() - h) {
        yDir = -yDir;
        y = (int) (bounds.getHeight() - h);
        color = newColor();
      }
      if (y < 0) {
        yDir = -yDir;
        y = 0;
        color = newColor();
      }
    }

    private void draw(Graphics g) {

      g.setColor(color);
      g.fillRect((int) x, (int) y, w, h);
    }
  }
}
