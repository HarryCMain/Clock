package clock;

import javax.swing.*;
import java.awt.*;

public class About extends JDialog {

    public About() {
        setTitle("About");
        setSize(300, 200);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel("<html><center>Java Clock Application<br>Version 2.0<br>© Harry Booth-Main: 2025</center></html>", SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        panel.add(closeButton, BorderLayout.SOUTH);

        add(panel);
    }
}