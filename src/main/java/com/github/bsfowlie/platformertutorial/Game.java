package com.github.bsfowlie.platformertutorial;

public class Game {

  public Game() {

    var gamePanel = new GamePanel();
    new GameWindow(gamePanel);
    gamePanel.requestFocus();
   }

}
