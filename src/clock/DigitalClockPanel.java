package clock;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.font.*;
import java.awt.Font;
import javax.swing.*;

public class DigitalClockPanel extends ClockPanel {

    Model model;
    
    public DigitalClockPanel(Model m) {
        super(m);
            model = m;
    }

    
    
    /** 
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Rectangle bounds = getBounds();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("SansSerif", Font.PLAIN, bounds.width / 5));
        g2.drawString(model.hour + ":" + model.minute + ":" + model.second, 20, 50);
    }
}
    

