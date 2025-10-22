import java.awt.*;
import javax.swing.*;

public class View extends JPanel{
    private Model m;

    /**
     * Constructs a View instance connected to Model
     * @param model
     */
    public View(Model model) {
        this.m = model;
    }

    /**
     * Draws a colored dot at the cursors position
     * @param g     provides the color
     * @param shape contains the position
     */
    public void drawDot(Graphics g, Shape shape){

        g.fillOval(shape.getX()  , shape.getY()  , 10, 10);
    }

    /**
     * Draws a colored oval at the cursor position
     * @param g     provides the color
     * @param shape contains the position
     */
    public void drawOval(Graphics g, Shape shape){
        g.fillOval(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
    }
    /**
     * Draws a colored rectangle at the cursor position
     * @param g     provides the color
     * @param shape contains the position
     */
    public void drawRect(Graphics g, Shape shape){
        g.fillRect(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Shape shape : m.getShapes()) {
            drawShape(g, shape);
        }
    }

    /**
     * Updates the color of the paintbrush and
     * chooses which shape to draw
     * @param g
     * @param shape provides the shape and color information
     */
    public void drawShape(Graphics g, Shape shape){
        String color = shape.getColor();
        changeColor(g, color);
        String form = shape.getShape();
        if (form.equals("dot")){
            drawDot(g, shape);
        } else if (form.equals("oval")) {
            drawOval(g, shape);
        } else {
            drawRect(g,shape);
        }
    }

    /**
     * Changes the color of the paintbrush
     * @param g
     * @param color
     */
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
