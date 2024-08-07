package com.github.bsfowlie.platformertutorial;

public class Game implements Runnable {

  public static final long MILLIS_PER_SEC = 1_000L;
  public static final double NANOS_PER_SEC = 1_000_000_000D;
  public static final double FRAMES_PER_SEC = 120D;

  private final GamePanel gamePanel;

  public Game() {

    gamePanel = new GamePanel();
    new GameWindow(gamePanel);
    gamePanel.requestFocus();
    startGameLoop();
   }

  private void startGameLoop() {

    Thread gameThread = new Thread(this);
    gameThread.start();
  }

  @Override
  public void run() {

    double timePerFrame = NANOS_PER_SEC / FRAMES_PER_SEC;
    long lastFrame = System.nanoTime();

    int frames = 0;
    long lastCheck = System.currentTimeMillis();

    while (true) {

      final long now = System.nanoTime();

      if (now - lastFrame >= timePerFrame) {
        gamePanel.repaint();
        lastFrame = now;
        frames++;
      }

      if (System.currentTimeMillis() - lastCheck >= MILLIS_PER_SEC) {
        System.out.println("FPS: " + frames);
        lastCheck = System.currentTimeMillis();
        frames = 0;
      }

    }
  }

}
