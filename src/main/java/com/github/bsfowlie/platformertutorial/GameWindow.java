package com.github.bsfowlie.platformertutorial;

import javax.swing.*;

public class GameWindow {

  private final JFrame jFrame;

  GameWindow(final GamePanel gamePanel) {

    jFrame = new JFrame();

    jFrame.setSize(400, 400);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.add(gamePanel);
    jFrame.setVisible(true);
  }

}
