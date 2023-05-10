package Main;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel {
    private JLabel gameOverLabel;

    public GameOverPanel()
    {
        gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setFont(new Font("Arial",Font.BOLD,40));
        add(gameOverLabel);
    }

}
