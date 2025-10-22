import java.io.Serializable;

public class Shape implements Serializable {
    private String color;
    private String shape;
    private int x;
    private int y;
    private int xMoved;
    private int yMoved;

    /**
     * Constructs a new Shape
     * @param color Color of shape
     * @param shape Shape of shape
     * @param x     X-coordinate of shape
     * @param y     Y-coordinate of shape
     */
    public Shape(String color, String shape, int x, int y){
        this.color = color;
        this.shape = shape;
        this.x = x;
        this.y = y;
        this.xMoved = x;
        this.yMoved = y;
    }

    /**
     * Returns shapes color
     * @return a color
     */
    public String getColor() {
        return color;
    }

    /**
     * Returns shape of Shape
     * @return a Shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * Returns X of Shape
     * @return an int
     */
    public int getX() {return x;}

    /**
     * Returns Y of Shape
     * @return an int
     */
    public int getY() {return y;}

    /**
     * Returns the smallest of the x values
      * @return an int
     */
    public int getMinX() {
        return Math.min(x , xMoved);
    }

    /**
     * Returns the smallest of the y values
     * @return an int
     */
    public int getMinY() {
        return Math.min(y , yMoved);
    }

    /**
     * Updates the cursors current x and y position
     * @param x position
     * @param y position
     */
    public void mouseMoved(int x, int y){
        xMoved = x;
        yMoved = y;
    }

    /**
     * Calculates the height
     * @return height
     */
    public int getHeight(){
        return Math.abs(y - yMoved);
    }

    /**
     * Calculates the width
     * @return width
     */
    public int getWidth(){
        return Math.abs(x - xMoved);
    }


}
