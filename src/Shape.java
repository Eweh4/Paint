public class Shape {
    private String color;
    private String shape;
    private int x;
    private int y;

    public Shape(String color, String shape, int x, int y){
        this.color = color;
        this.shape = shape;
        this.x = x;
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public String getShape() {
        return shape;
    }

    public int getX() {return x;}

    public int getY() {return y;}


}
