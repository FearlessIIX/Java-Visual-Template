import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Template extends JFrame {

    // This determines size of the window, carried to Screen as parameter.
    private static Dimension d = new Dimension(400, 400);

    // The Drawable Screen (Canvas) for this Window [Where all draw operations are executed].
    private Screen screen = new Screen(d.width, d.height);
    // The Keyboard listener for this Window, passed Screen as parameter.
    // This Object directly controls the Screen (Canvas)
    private Keyboard keyboard = new Keyboard(this.screen);

    // Run point for this Code
    public static void main(String[] args) {
        new Template();
    }
    public Template() {
        setPreferredSize(d);
        setMinimumSize(d);
        addKeyListener(this.keyboard);

        // Is window Re-sizable.
        setResizable(false);
        // Puts the window in the middle of the screen.
        setLocationRelativeTo(null);

        Container c = getContentPane();
        c.add(screen);

        pack();

        // The title of this Window
        setTitle("Template");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
class Screen extends JPanel {

    // Create any methods to do drawing in this class
    // Grab the Graphics object by using the 'getGraphics()' method
    // Call that method from wherever your control flow is, for example 'Keyboard'

    private int width;
    private int height;

    private char color = 'r';

    public Screen(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // This code runs when the Screen is initialized
        g.setColor(Color.red.darker());
        g.drawString("Press enter to change the color", 5, 25);
        this.color = 'g';
    }

    public void drawString() {
        // Getting the Graphics Object with 'getGraphics()'
        Graphics g = getGraphics();

        // Setting the correct color, then cycling to the next one
        if (this.color == 'r') {
            g.setColor(Color.red.darker());
            this.color = 'g';
        } else if (this.color == 'g') {
            g.setColor(Color.green.darker());
            this.color = 'b';
        } else {
            g.setColor(Color.blue.darker());
            this.color = 'r';
        }

        g.drawString("Press enter to change the color", 5, 25);
    }
}
class Keyboard implements KeyListener {

    private Screen screen;

    public Keyboard(Screen screen) {
        super();
        this.screen = screen;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Any specific sequence of events and logical evaluation goes here, and can directly connect to methods in the Screen
        if (e.getKeyChar() == '\n') {
            // Runs a dedicated method in the Screen
            screen.drawString();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) { }
    @Override
    public void keyReleased(KeyEvent e) { }
}
