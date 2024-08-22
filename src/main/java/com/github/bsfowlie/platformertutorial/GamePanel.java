package com.github.bsfowlie.platformertutorial;

import java.awt.*;
import javax.swing.*;

import com.github.bsfowlie.platformertutorial.inputs.KeyboardInputs;
import com.github.bsfowlie.platformertutorial.inputs.MouseInputs;

public class GamePanel extends JPanel {

  private final Game game;

  GamePanel(final Game game) {

    this.game = game;

    var keyboardInputs = new KeyboardInputs(this);
    addKeyListener(keyboardInputs);

    var mouseInputs = new MouseInputs(this);
    addMouseListener(mouseInputs);
    addMouseMotionListener(mouseInputs);

    setPanelSize();

    setFocusable(true);
  }

  private void setPanelSize() {

    var size = new Dimension(1280, 800);
    setPreferredSize(size);
  }

  @Override
  protected void paintComponent(final Graphics g) {

    super.paintComponent(g);

    game.render(g);
  }

   public Game getGame() {

    return game;
  }

}
