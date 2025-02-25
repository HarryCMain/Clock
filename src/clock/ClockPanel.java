package clock;

import java.awt.*;
import javax.swing.*;

public abstract class ClockPanel extends JPanel {

    protected Model model;

    public ClockPanel(Model model) {
        this.model = model;
        setPreferredSize(new Dimension(300, 300)); // Set a reasonable default size
        setBackground(Color.WHITE); // Set a default background color
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensure the panel is properly rendered
    }
}