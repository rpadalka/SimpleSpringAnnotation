package screensaver;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by rpadalka on 25.7.16.
 */

public abstract class ColorFrame extends JFrame {

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1024), random.nextInt(768));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor();
}
