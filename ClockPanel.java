package clock;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.font.*;
import javax.swing.*;

public abstract class ClockPanel extends JPanel {
    Model model;
    Graphics g;

    public ClockPanel(Model model) {
        this.model = model;
        setPreferredSize(new Dimension(200, 200));
        setBackground(Color.white);
    }
    
  //  public abstract void paintComponent(Graphics g);

}
