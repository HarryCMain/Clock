package clock;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.font.*;

Public class About extends JPanel {

    public About {
        JFrame frame = new JFrame();
        frame.setTitle("About");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(200, 200));
        setBackground(Color.white);
        l = new JLabel("About......");
        JPanel p = new JPanel();
        p.add(l);
        frame.add(p);
    }

}
