package com.github.bsfowlie.platformertutorial;

import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel {

  GamePanel() {

  }

  @Override
  protected void paintComponent(final Graphics g) {

    super.paintComponent(g);
    g.fillRect(100,100,200,50);
  }

}
