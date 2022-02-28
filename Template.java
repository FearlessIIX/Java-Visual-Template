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

    private Color c = null;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintComponent(Graphics g) {
        // Runs the Method once to initialize the Screen
        drawString();
    }

    public void drawString() {
        // Getting the Graphics Object with 'getGraphics()'
        Graphics g = getGraphics();

        // Shifting the Color to (r g or b)
        if (this.c == null)
            this.c = Color.red.darker();
        else if (this.c == Color.red.darker())
            this.c = Color.green.darker();
        else if (this.c == Color.green.darker())
            this.c = Color.blue.darker();
        else this.c = Color.red.darker();

        // Sets the Color and draws the String to the Screen
        g.setColor(c);
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
