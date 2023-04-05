import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener extends Frame implements KeyListener {
    private Label l;
    private TextArea area;
    public KeyboardListener() {
        // creating the label
        l = new Label();
// setting the location of the label in frame
        l.setBounds (20, 50, 100, 20);
// creating the text area
        area = new TextArea();
// setting the location of text area
        area.setBounds (20, 80, 300, 300);
// adding the KeyListener to the text area
        area.addKeyListener(this);
// adding the label and text area to the frame
        add(l);
        add(area);
// setting the size, layout and visibility of frame
        setSize (400, 400);
        setLayout (null);
        setVisible (true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            System.out.println("right key pressed");
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            System.out.println("left key pressed");
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            System.out.println("up key pressed");
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            System.out.println("down key pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
