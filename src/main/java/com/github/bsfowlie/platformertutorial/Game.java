package com.github.bsfowlie.platformertutorial;

import java.awt.*;

import com.github.bsfowlie.platformertutorial.entities.Player;

public class Game implements Runnable {

  public static final long MILLIS_PER_SEC = 1_000L;
  public static final double NANOS_PER_SEC = 1_000_000_000D;
  public static final double FRAMES_PER_SEC = 120D;
  public static final int UPDATES_PER_SEC = 200;

  private final GamePanel gamePanel;

  private Player player;

  public Game() {

    initClasses();
    gamePanel = new GamePanel(this);
    new GameWindow(gamePanel);
    gamePanel.requestFocus();
    startGameLoop();
   }

  private void initClasses() {

    player = new Player(200, 200);
  }

  private void startGameLoop() {

    Thread gameThread = new Thread(this);
    gameThread.start();
  }

  public void update() {

    player.update();
  }

  public void render(final Graphics g) {

    player.render(g);
  }

  @Override
  public void run() {

    double timePerFrame = NANOS_PER_SEC / FRAMES_PER_SEC;
    double timePerUpdate = NANOS_PER_SEC / UPDATES_PER_SEC;
    long previousTime = System.nanoTime();
    long lastCheck = System.currentTimeMillis();

    int frames = 0;
    int updates = 0;

    double deltaU = 0;
    double deltaF = 0;

    while (true) {

      final long currentTime = System.nanoTime();

      deltaU += (currentTime - previousTime) / timePerUpdate;
      deltaF += (currentTime - previousTime) / timePerFrame;
      previousTime = currentTime;

      if (deltaU >= 1) {
        update();
        updates++;
        deltaU--;
      }
      if (deltaF >= 1) {
        gamePanel.repaint();
        frames++;
        deltaF--;
      }

      if (System.currentTimeMillis() - lastCheck >= MILLIS_PER_SEC) {
        System.out.println("FPS: " + frames + " | UPS: " + updates);
        lastCheck = System.currentTimeMillis();
        frames = 0;
        updates = 0;
      }

    }
  }

   public Player getPlayer() {

    return player;
  }

   public void windowFocusLost() {

    player.resetDirBooleans();
  }

}
