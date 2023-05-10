import javax.swing.*;

public class Main extends JFrame{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bike Race");
        frame.setSize(500,700);
//        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        GraphicsPart graphic = new GraphicsPart();
        frame.add(graphic);
        frame.addKeyListener(graphic);
    }
}