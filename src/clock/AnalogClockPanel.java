package clock;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class AnalogClockPanel extends JPanel {

    private Model model;

    public AnalogClockPanel(Model model) {
        this.model = model;
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        int radius = Math.min(centerX, centerY) - 10;

        // Draw the clock face
        g2d.setColor(Color.BLACK);
        g2d.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

        // Draw the tick marks and numbers
        for (int i = 1; i <= 12; i++) {
            double angle = Math.toRadians(90 - i * 30);
            int x = (int) (centerX + Math.cos(angle) * (radius - 20));
            int y = (int) (centerY - Math.sin(angle) * (radius - 20));
            g2d.drawString(Integer.toString(i), x, y);
        }

        // Draw the hour hand
        double hourAngle = Math.toRadians(90 - (model.hour + model.minute / 60.0) * 30);
        drawHand(g2d, centerX, centerY, hourAngle, (int) (radius * 0.5), 4, Color.BLACK);

        // Draw the minute hand
        double minuteAngle = Math.toRadians(90 - (model.minute + model.second / 60.0) * 6);
        drawHand(g2d, centerX, centerY, minuteAngle, (int) (radius * 0.75), 2, Color.BLUE);

        // Draw the second hand
        double secondAngle = Math.toRadians(90 - model.second * 6);
        drawHand(g2d, centerX, centerY, secondAngle, (int) (radius * 0.9), 1, Color.RED);
    }

    private void drawHand(Graphics2D g2d, int centerX, int centerY, double angle, int length, int thickness, Color color) {
        int x = (int) (centerX + Math.cos(angle) * length);
        int y = (int) (centerY - Math.sin(angle) * length);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawLine(centerX, centerY, x, y);
    }
}