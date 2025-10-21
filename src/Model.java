import java.awt.*;
import java.util.ArrayList;

public class Model {
    private String color;
    private String shape;
    private ArrayList<Shape> shapes;

    public Model() {
        this.color = "black";
        this.shape = "dot";
        shapes = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public String getShape(){
        return shape;
    }

    public ArrayList<Shape> getShapes(){
        return shapes;
    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }



}
