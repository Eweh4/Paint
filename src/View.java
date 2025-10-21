import java.awt.*;
import javax.swing.*;

public class View extends JFrame{
    private Model m;


    public View(Model m) {
        setTitle("View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,400);
        setLocation(50,50);
        setVisible(true);
    }

    public void drawDot(Graphics g, Shape shape){
        System.out.println("drawDot");
        g.fillOval(shape.getX() - 5, shape.getY() - 5, 5, 10);
    }

    public void paintComponents(Graphics g){
        super.paintComponents(g);
        for (Shape shape : m.getShapes()) {
            drawShape(g, shape);
        }
    }

    public void drawShape(Graphics g, Shape shape){
        String color = shape.getColor();
        changeColor(g, color);
        String form = shape.getShape();
        if (form.equals("dot")){
            drawDot(g, shape);
        }
    }

    public void changeColor(Graphics g, String color) {
        switch (color){
            case "black":
                g.setColor(Color.BLACK);
                break;
            case "red":
                g.setColor(Color.RED);
                break;
            case "green":
                g.setColor(Color.GREEN);
                break;
        }
    }

}
