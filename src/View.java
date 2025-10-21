import java.awt.*;
import javax.swing.*;

public class View extends JPanel{
    private Model m;


    public View(Model m) {
        this.m = m;
    }

    public void drawDot(Graphics g, Shape shape){
        System.out.println("drawDot");
        g.fillOval(shape.getX() - 5, shape.getY() - 5, 5, 10);
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Shape shape : m.getShapes()) {
            drawShape(g, shape);
        }
    }

    public void drawShape(Graphics g, Shape shape){
        System.out.println("drawShape");
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
