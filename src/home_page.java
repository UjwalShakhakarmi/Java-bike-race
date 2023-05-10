import javax.swing.*;
import java.awt.*;

public class home_page extends JPanel {

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,500,700);
        g.setFont(new Font("Arail",Font.BOLD,48));
        g.setColor(Color.RED);
        g.drawString("Bike Race",WIDTH/2 -150,HEIGHT/2);
        g.setColor(Color.RED);
        g.fillRect(150,500,100,50);

    }
}
