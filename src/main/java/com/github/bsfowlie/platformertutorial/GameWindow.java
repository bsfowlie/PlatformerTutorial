package com.github.bsfowlie.platformertutorial;

import javax.swing.*;

public class GameWindow {

  GameWindow(final GamePanel gamePanel) {

    var jFrame = new JFrame();

    jFrame.setSize(400, 400);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setLocationRelativeTo(null);
    jFrame.add(gamePanel);
    jFrame.setVisible(true);
  }

}
