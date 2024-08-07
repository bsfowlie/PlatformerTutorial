package com.github.bsfowlie.platformertutorial;

public class Game {

  private final GamePanel gamePanel;

  private final GameWindow gameWindow;

  public Game() {

    gamePanel = new GamePanel();
    gameWindow = new GameWindow(gamePanel);
   }

}
