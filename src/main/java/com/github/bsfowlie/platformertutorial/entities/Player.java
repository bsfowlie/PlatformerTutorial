package com.github.bsfowlie.platformertutorial.entities;

import static com.github.bsfowlie.platformertutorial.utils.Constants.Player.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Player extends Entity {

  public static final int SUB_IMAGE_WIDTH = 64;

  public static final int SUB_IMAGE_HEIGHT = 40;

  public static final int ANI_SPEED = 30;

  public static final int PLAYER_SPEED = 1;

  private BufferedImage[][] animations;

  private boolean moving = false;

  private boolean attacking = false;

  private boolean left;

  private boolean right;

  private boolean up;

  private boolean down;

  private int playerAction = IDLE;

  private int aniTick;

  private int aniIndex;

  public Player(final float x, final float y) {

    super(x, y);
    loadAnimations();
  }

  private void loadAnimations() {

    animations = new BufferedImage[9][];
    animations[IDLE] = new BufferedImage[5];
    animations[RUNNING] = new BufferedImage[6];
    animations[JUMP] = new BufferedImage[3];
    animations[FALLING] = new BufferedImage[PLAYER_SPEED];
    animations[GROUND] = new BufferedImage[2];
    animations[HIT] = new BufferedImage[4];
    animations[ATTACK_1] = new BufferedImage[3];
    animations[ATTACK_JUMP_1] = new BufferedImage[3];
    animations[ATTACK_JUMP_2] = new BufferedImage[3];

    try (InputStream is = getClass().getResourceAsStream("/player_sprites.png")) {
      if (is != null) {
        var image = ImageIO.read(is);

        for (int row = 0; row < animations.length; row++) {
          for (int col = 0; col < animations[row].length; col++) {
            animations[row][col] =
                image.getSubimage(col * SUB_IMAGE_WIDTH, row * SUB_IMAGE_HEIGHT, SUB_IMAGE_WIDTH, SUB_IMAGE_HEIGHT);
          }
        }
      } else {
        throw new IllegalStateException("Can't find image");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void update() {

    updatePos();
    setAnimation();
    updateAnimationTick();
  }

  private void updatePos() {

    moving = false;
    if (left && !right) {
      x -= PLAYER_SPEED;
      moving = true;
    } else if (right && !left) {
      x += PLAYER_SPEED;
      moving = true;
    }

    if (up && !down) {
      y -= PLAYER_SPEED;
      moving = true;
    } else if (down && !up) {
      y += PLAYER_SPEED;
      moving = true;
    }
  }

  private void setAnimation() {

    final var startAni = playerAction;
    if (moving) {
      playerAction = RUNNING;
    } else {
      playerAction = IDLE;
    }

    if (attacking) {
      playerAction = ATTACK_1;
    }

    if (startAni != playerAction) {
      resetAniTick();
    }
  }

  private void resetAniTick() {

    aniTick = 0;
    aniIndex = 0;
  }

  private void updateAnimationTick() {

    aniTick++;
    if (aniTick >= ANI_SPEED) {
      aniTick = 0;
      aniIndex++;
      if (aniIndex >= animations[playerAction].length) {
        aniIndex = 0;
        attacking = false;
      }
    }
  }

  public void render(final Graphics g) {

    g.drawImage(
        animations[playerAction][aniIndex],
        (int) x,
        (int) y,
        2 * SUB_IMAGE_WIDTH,
        2 * SUB_IMAGE_HEIGHT,
        null);
  }

   public void setAttacking(final boolean attacking) {

    this.attacking = attacking;
  }

  public void setLeft(final boolean left) {

    this.left = left;
  }

  public void setRight(final boolean right) {

    this.right = right;
  }

  public void setUp(final boolean up) {

    this.up = up;
  }

  public void setDown(final boolean down) {

    this.down = down;
  }

   public void resetDirBooleans() {

    left = false;
    right = false;
    up = false;
    down = false;
  }

}
