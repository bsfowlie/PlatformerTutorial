package com.github.bsfowlie.platformertutorial;

public class Game implements Runnable {

  public static final long MILLIS_PER_SEC = 1_000L;
  public static final double NANOS_PER_SEC = 1_000_000_000D;
  public static final double FRAMES_PER_SEC = 120D;
  public static final int UPDATES_PER_SEC = 200;

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

  public void update() {

    gamePanel.updateGame();
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

}
