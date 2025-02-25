package clock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;


public class View implements PropertyChangeListener {

    private AnalogClockPanel panel;
    private JFrame frame;

    public View(Model model) {
        // Create the main frame
        frame = new JFrame("Java Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Create the clock panel
        panel = new AnalogClockPanel(model);
        frame.add(panel, BorderLayout.CENTER);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        // Add "About" menu item
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About().setVisible(true);
            }
        });
        menu.add(aboutMenuItem);

        // Add other menu items (placeholder)
        menu.add(new JMenuItem("Settings"));
        menu.add(new JMenuItem("Help"));

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // Add a button for demonstration
        JButton aboutButton = new JButton("About");
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About().setVisible(true);
            }
        });
        frame.add(aboutButton, BorderLayout.SOUTH);

        // Register the view as a listener to the model
        model.addPropertyChangeListener(this);

        // Display the frame
        frame.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        panel.repaint(); // Refresh the clock panel
    }
}