import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * Handles User Interface
 */
public class DrawControl extends JFrame implements MouseListener, MouseMotionListener {
    private Model model;
    private View view;
    JLabel mode;

    /**
     * Constructs a DrawControl instance connected to Model and View
     *
     * @param model the connected model
     * @param view  the connected view
     */
    public DrawControl(Model model, View view){
        this.model = model;
        this.view = view;

        setTitle("View");
        setBackground(Color.GREEN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,400);
        setLocation(50,50);
        setVisible(true);

        addMouseListener(this);
        addMouseMotionListener(this);
        JPanel topPanel = new JPanel(new FlowLayout());
        JPanel bottomPanel = new JPanel(new BorderLayout());

        //Buttons
        JButton black = new JButton("black");
        topPanel.add(black);
        black.addActionListener(e -> blackPressed());

        JButton red = new JButton("red");
        topPanel.add(red);
        red.addActionListener(e -> redPressed());

        JButton green = new JButton("green");
        topPanel.add(green);
        green.addActionListener(e -> greenPressed());

        JButton dot = new JButton("dot");
        topPanel.add(dot);
        dot.addActionListener(e -> dotPressed());

        JButton oval = new JButton("oval");
        topPanel.add(oval);
        oval.addActionListener(e -> ovalPressed());

        JButton rect = new JButton("rect");
        topPanel.add(rect);
        rect.addActionListener(e -> rectPressed());

        JButton undo = new JButton("undo");
        topPanel.add(undo);
        undo.addActionListener(e -> undoPressed());

        JButton save = new JButton("save");
        topPanel.add(save);
        save.addActionListener(e -> savePressed());

        JButton load = new JButton("load");
        topPanel.add(load);
        load.addActionListener(e -> loadPressed());

        mode = new JLabel("Mode: " + model.getShape() + ", Color: " + model.getColor());
        mode.setFont(new Font("Default", Font.BOLD, 16));

        bottomPanel.add(mode, BorderLayout.SOUTH);

        add(view);
        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel,BorderLayout.SOUTH);
    }

    /**
     * Main that initializes the program
     * @param args
     */
    public static void main(String[] args) {
        Model model1 = new Model();
        View view1 = new View(model1);
        DrawControl controller1 = new DrawControl(model1,view1);
    }

    @Override
    public void mouseDragged(MouseEvent e){

        int x = e.getX() - 6;
        int y = e.getY() - 66;
        model.mouseMoved(x,y);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e){
        int x = e.getX() - 12;
        int y = e.getY() - 70;
        model.addShape(x, y);
        view.repaint();
    }

    /**
     * Sets color to black
     */
    public void blackPressed(){
        System.out.println("blackPressed");
        model.setColor("black");
        setMode();
    }

    /**
     * Sets color to red
     */
    public void redPressed(){
        model.setColor("red");
        setMode();
    }

    /**
     * Sets color to green
     */
    public void greenPressed(){
        model.setColor("green");
        setMode();

    }

    /**
     * Sets shape to dot
     */
    public void dotPressed(){
        model.setShape("dot");
        setMode();
    }

    /**
     * Sets shape to oval
     */
    public void ovalPressed(){
        model.setShape("oval");
        setMode();
    }

    /**
     * Sets shape to rect
     */
    public void rectPressed(){
        model.setShape("rect");
        setMode();
    }

    /**
     * Removes the last drawn shape
     */
    public void undoPressed(){
        model.undo();
        repaint();
    }

    /**
     * Saves your canvas to a txt file
     */
    public void savePressed(){
        try {
            model.save();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Loads a canvas from a txt file
     */
    public void loadPressed(){
        try {
            model.load();
            repaint();
            setMode();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Updates Mode label based on models state
     */
    public void setMode() {
        mode.setText("Mode: " + model.getShape() + ", Color: " + model.getColor());
    }

    @Override
    public void mouseClicked(MouseEvent e){

    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mouseExited(MouseEvent e){

    }

    @Override
    public void mouseMoved(MouseEvent e){

    }
}
