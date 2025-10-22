import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 */
public class Model {
    private String color;
    private String shape;
    private ArrayList<Shape> drawList;

    /**
     * Constructs a Model instance
     */
    public Model() {
        this.color = "black";
        this.shape = "dot";
        drawList = new ArrayList<>();
    }

    /**
     * Returns color of model
     * @return a color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets color of model
     * @param color the color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Returns Shape of model
     * @return a Shape
     */
    public String getShape(){
        return shape;
    }

    /**
     * Sets Shape of model
     * @param shape the shape
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * Returns list of Shapes
     * @return a list of Shape objects
     */
    public ArrayList<Shape> getShapes(){
        return drawList;
    }

    /**
     * Adds a shape to list
     * @param x -
     * @param y
     */
    public void addShape(int x, int y){
        Shape newShape = new Shape(this.color, this.shape, x, y);
        drawList.add(newShape);
    }

    /**
     * Removes the last Shape added
     */
    public void undo(){
        if(!getShapes().isEmpty()){
            drawList.removeLast();
        }
    }

    /**
     * Saves canvas as a txt file
     * @throws IOException
     */
    public void save() throws IOException {
        JFileChooser jFileChooser = new JFileChooser();
        if (jFileChooser.showSaveDialog(null)== JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(drawList);
            objectOutputStream.flush();
            objectOutputStream.close();
        }
    }

    /**
     * Loads a canvas from a txt file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void load() throws IOException, ClassNotFoundException {
        JFileChooser jFileChooser = new JFileChooser();
        if (jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            drawList = (ArrayList<Shape>) objectInputStream.readObject();
            objectInputStream.close();
        }
    }

    /**
     * Updates the x and y coordinates of the shape that is being drawn
     * @param x
     * @param y
     */
    public void mouseMoved(int x, int y) {
        if (!getShapes().isEmpty()){
            Shape shape =  drawList.getLast();
            shape.mouseMoved(x, y);
        }
    }

}
