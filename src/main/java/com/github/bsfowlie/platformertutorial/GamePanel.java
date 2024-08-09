package com.github.bsfowlie.platformertutorial;

import static com.github.bsfowlie.platformertutorial.utils.Constants.Direction.*;
import static com.github.bsfowlie.platformertutorial.utils.Constants.Player.*;

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

  private BufferedImage[][] animations;

  private int aniTick;

  private int aniIndex;

  private final int aniSpeed = 15;

  private int playerAction = IDLE;

  private int playerDir = -1;

  private boolean moving = false;

  GamePanel() {

    var keyboardInputs = new KeyboardInputs(this);
    addKeyListener(keyboardInputs);

    var mouseInputs = new MouseInputs(this);
    addMouseListener(mouseInputs);
    addMouseMotionListener(mouseInputs);

    setPanelSize();
    importImage();
    loadAnimations();

    setFocusable(true);
  }

  private void loadAnimations() {

    animations = new BufferedImage[9][];
    animations[IDLE] = new BufferedImage[5];
    animations[RUNNING] = new BufferedImage[6];
    animations[JUMP] = new BufferedImage[3];
    animations[FALLING] = new BufferedImage[1];
    animations[GROUND] = new BufferedImage[2];
    animations[HIT] = new BufferedImage[4];
    animations[ATTACK_1] = new BufferedImage[3];
    animations[ATTACK_JUMP_1] = new BufferedImage[3];
    animations[ATTACK_JUMP_2] = new BufferedImage[3];
    for (int row = 0; row < animations.length; row++) {
      for (int col = 0; col < animations[row].length; col++) {
        animations[row][col] =
            image.getSubimage(col * SUB_IMAGE_WIDTH, row * SUB_IMAGE_HEIGHT, SUB_IMAGE_WIDTH, SUB_IMAGE_HEIGHT);
      }
    }
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

  public void setDirection(final int direction) {

    playerDir = direction;
    moving = true;
  }

  public void setMoving(final boolean moving) {

    this.moving = moving;
  }

  @Override
  protected void paintComponent(final Graphics g) {

    super.paintComponent(g);

    setAnimation();
    updatePos();
    updateAnimationTick();

    g.drawImage(
        animations[1][aniIndex],
        (int) x,
        (int) y,
        2 * SUB_IMAGE_WIDTH,
        2 * SUB_IMAGE_HEIGHT,
        null);
  }

  private void setAnimation() {

    if (moving) {
      playerAction = RUNNING;
    } else {
      playerAction = IDLE;
    }
  }

  private void updatePos() {

    if (moving) {
      switch (playerDir) {
        case LEFT:
          x -= 5;
          break;
        case UP:
          y -= 5;
          break;
        case RIGHT:
          x += 5;
          break;
        case DOWN:
          y += 5;
          break;
        default:
          break;
      }
    }
  }

  private void updateAnimationTick() {

    aniTick++;
    if (aniTick >= aniSpeed) {
      aniTick = 0;
      aniIndex++;
      if (aniIndex >= animations[playerAction].length) {
        aniIndex = 0;
      }
    }
  }

}
