import java.awt.*;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.*;


public class Controller extends JFrame implements MouseListener, MouseMotionListener {
    private Model m;
    private View  v;
    JLabel mode;

    public Controller(Model m, View v){
        this.m = m;
        this.v = v;
        v.addMouseListener(this);
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

        mode = new JLabel("Mode: " + m.getShape() + ", Color: " + m.getColor());
        mode.setFont(new Font("Default", Font.BOLD, 16));
        bottomPanel.add(mode, BorderLayout.SOUTH);
        v.add(topPanel, BorderLayout.NORTH);
        v.add(bottomPanel,BorderLayout.SOUTH);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        System.out.println("mouseClicked");
    }

    @Override
    public void mouseDragged(MouseEvent e){
        System.out.println("mouseDragged");
    }

    @Override
    public void mousePressed(MouseEvent e){
        System.out.println("mousePressed");
        String color = m.getColor();
        String shape = m.getShape();
        int x = e.getX();
        int y = e.getY();
        Shape newShape = new Shape(color, shape, x, y);
        m.addShape(newShape);
        v.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e){
        System.out.println("mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e){
        System.out.println("mouseReleased");
    }

    @Override
    public void mouseExited(MouseEvent e){
        System.out.println("mouseExited");
    }

    @Override
    public void mouseMoved(MouseEvent e){
        System.out.println("mouseMoved");
    }

    public void blackPressed(){
        System.out.println("blackPressed");
    }

    public void redPressed(){
        System.out.println("redPressed");
    }

    public void greenPressed(){
        System.out.println("greenPressed");
    }

    public void dotPressed(){
        System.out.println("dotPressed");
    }

    public void ovalPressed(){
        System.out.println("ovalPressed");
    }

    public void rectPressed(){
        System.out.println("rectPressed");
    }

    public void undoPressed(){
        System.out.println("undoPressed");
    }

    public void savePressed(){
        System.out.println("savePressed");
    }

    public void loadPressed(){
        System.out.println("loadPressed");
    }


}
