package com.github.bsfowlie.platformertutorial;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.github.bsfowlie.platformertutorial.inputs.KeyboardInputs;
import com.github.bsfowlie.platformertutorial.inputs.MouseInputs;

public class GamePanel extends JPanel {

  public static final int SUB_IMAGE_WIDTH = 64;

  public static final int SUB_IMAGE_HEIGHT = 40;

  private double x;

  private double y;

  private BufferedImage image;

  GamePanel() {

    var keyboardInputs = new KeyboardInputs(this);
    addKeyListener(keyboardInputs);

    var mouseInputs = new MouseInputs(this);
    addMouseListener(mouseInputs);
    addMouseMotionListener(mouseInputs);

    setPanelSize();
    importImage();

    setFocusable(true);
  }

  private void importImage() {

    try (InputStream is = getClass().getResourceAsStream("/player_sprites.png")) {
      if (is != null) {
        image = ImageIO.read(is);
      } else {
        System.out.println("Can't find image");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void setPanelSize() {

    var size = new Dimension(1280, 800);
    setPreferredSize(size);
  }

  public void changeXDelta(final int value) {

    x += value;
  }

  public void changeYDelta(final int value) {

    y += value;
  }

  public void setRectangle(final int x, final int y) {

    this.x = x;
    this.y = y;
  }

  @Override
  protected void paintComponent(final Graphics g) {

    super.paintComponent(g);

    var imageCol = 1;
    var imageRow = 8;
    var subimage = image.getSubimage(
        imageCol * SUB_IMAGE_WIDTH,
        imageRow * SUB_IMAGE_HEIGHT,
        SUB_IMAGE_WIDTH,
        SUB_IMAGE_HEIGHT);
    g.drawImage(
        subimage,
        (int) x,
        (int) y,
        2 * SUB_IMAGE_WIDTH,
        2 * SUB_IMAGE_HEIGHT,
        null);
  }

}
