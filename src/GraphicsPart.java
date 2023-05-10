import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;


public class GraphicsPart extends JPanel implements KeyListener ,ActionListener {
    private int space;
    private int speed;

    private int move = 20;
    private int WIDTH= 500;
    private int Height = 700;
    private Rectangle bike;
    private Random rand;
    private int width=50;
    private int height=125;
    private boolean gameOver = false;
    private int count =1;
    //we need to add many another cars soo
    private ArrayList <Rectangle> traffic;
    Timer t;
    GraphicsPart()
    {

        t = new Timer(20,this);
        rand = new Random();
        traffic = new ArrayList <Rectangle>();
        bike = new Rectangle(WIDTH/2-100,Height-180,50,125);
        space = 300;
        speed = 2;
        Addtraffic(true);
        Addtraffic(true);
        Addtraffic(true);
        Addtraffic(true);

        t.start();

    }
    public void Addtraffic(boolean first)
    {
        int positionx = rand.nextInt()%2;
        int x = 0;
        int y = 0;
        //trafiic ko width ra height
        int Width = width;
        int Height = height;
        if(positionx == 0)
        {
            x = WIDTH/2-90;
        }else
        {
            x= WIDTH/2+10;
        }
        if(first)
        {
            traffic.add(new Rectangle(x,y-100-(traffic.size()*space),Width,Height));
        }
        else{
            //creating a rectangle above the previous rectangle 300 pixels above
            traffic.add(new Rectangle(x,traffic.get(traffic.size()-1).y-300,Width,Height));
        }
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);

        ImageIcon icon_left_side = new ImageIcon("righhht11.jpg");
        Image left = icon_left_side.getImage();
        g.drawImage(left ,0,0,150,Height,null);

        ImageIcon icon_right_side = new ImageIcon("righhht11.jpg");
        Image right = icon_right_side.getImage();
        g.drawImage(right ,350,0,150,Height,null);

        ImageIcon road = new ImageIcon("road1.jpg");
        Image main_road = road.getImage();
        g.drawImage(main_road ,WIDTH/2-100,0,200,Height,null);


        ImageIcon icon_bike = new ImageIcon("bike2.png");
        Image image = icon_bike.getImage();
        g.drawImage(image, bike.x, bike.y, bike.width, bike.height, null);


        g.drawLine(WIDTH/2,0,WIDTH/2,Height);
        g.setColor(Color.CYAN);
        //drawing an image of a car onto screen for each rectangle in traffic
        for(Rectangle rect:traffic)
        {
            if (rand.nextInt()%2 == 0){
                ImageIcon traffic_icon = new ImageIcon("car .png");
                Image image_traffic = traffic_icon.getImage();
                g.drawImage(image_traffic, rect.x,rect.y,rect.width,rect.height, null);
            }else {
                ImageIcon traffic_icon = new ImageIcon("car .png");
                Image image_traffic = traffic_icon.getImage();
                g.drawImage(image_traffic, rect.x,rect.y,rect.width,rect.height, null);
            }
        }
            if(gameOver)
            {
                g.setColor(Color.BLACK);
                g.fillRect(0,0,500,700);
                g.setFont(new Font("Arail",Font.BOLD,48));
                g.setColor(Color.RED);
                g.drawString("Game Over",WIDTH/2 - 150,Height/2);

            }
    }




    @Override
    public void keyTyped(KeyEvent e) {

    }



    @Override
    public void keyPressed(KeyEvent e) {
        int x = (int) bike.getX();
        int y = (int) bike.getY();
        int code = e.getKeyCode();
        System.out.println(code+"the x :"+x+"the y is"+y);
        if(code == 37)
        {
            if(bike.x<= 150)
            {
                System.out.println("\b");
            }else {
                bike.setLocation(x-move,y);
                repaint();
            }
        }
        else if(code == 39)
        {
            if(bike.x >= 300)
            {
                System.out.println("\b");

            }
            else {
                bike.setLocation(x+move,y);
                repaint();
            }
        }
        else if(code == 40)
        {
            if(bike.y >=570) {
                System.out.print("\b");
            }
            else{
                bike.setLocation(x,y+move);
            }
        }
        else if(code == 38)
        {
            if(bike.y <= 0)
            {
                System.out.println("\b");

            }
            else {
                bike.setLocation(x,y-move);
                repaint();
            }

            }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Rectangle rect;
        for(int i=0;i<traffic.size();i++)
        {
            rect = traffic.get(i);

            rect.y+=speed;
            if(rect.y > Height)
            {
                speed += 10;
                traffic.remove(i);
            }
        }
        //crashing
        for(Rectangle r:traffic)
        {
            if(r.intersects(bike))
            {
                bike.y = r.y+height;
                t.stop();
                gameOver = true;
            }
        }
        for(int i= 0;i<traffic.size();i++)
        {
            rect = traffic.get(i);
            if(rect.y+rect.height>Height)
            {
                traffic.remove(rect);
                Addtraffic(false);
            }
        }
        repaint();
    }
}
