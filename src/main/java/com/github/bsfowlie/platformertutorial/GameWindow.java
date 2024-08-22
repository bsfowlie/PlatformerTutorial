package com.github.bsfowlie.platformertutorial;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.*;

public class GameWindow {

  GameWindow(final GamePanel gamePanel) {

    var jFrame = new JFrame();

    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setLocationRelativeTo(null);
    jFrame.add(gamePanel);
    jFrame.setResizable(false);
    jFrame.pack();
    jFrame.setVisible(true);
    jFrame.addWindowFocusListener(new WindowFocusListener() {

      @Override
      public void windowGainedFocus(final WindowEvent e) {

      }

      @Override
      public void windowLostFocus(final WindowEvent e) {

        gamePanel.getGame().windowFocusLost();
      }
    });
  }

}
