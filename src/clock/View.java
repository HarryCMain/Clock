package clock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class View implements Observer {
    
    AnalogClockPanel panel;
    static JMenuBar mb;
 

    // JMenu
    static JMenu x;
    static JMenuItem m1, m2, m3,m4,m5;

    public void setAbout() {
        JLabel label=new JLabel("About......");
        JPanel p = new JPanel();
        p.add(label);
        JFrame frameabout = new JFrame();
        frameabout.add(p);
        frameabout.pack();
        frameabout.setVisible(true);
    }


    public View(Model model) {
        JFrame frame = new JFrame();
        panel = new AnalogClockPanel(model);
        //frame.setContentPane(panel);
        frame.setTitle("Java Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Start of border layout code
        
        // I've just put a single button in each of the border positions:
        // PAGE_START (i.e. top), PAGE_END (bottom), LINE_START (left) and
        // LINE_END (right). You can omit any of these, or replace the button
        // with something else like a label or a menu bar. Or maybe you can
        // figure out how to pack more than one thing into one of those
        // positions. This is the very simplest border layout possible, just
        // to help you get started.
        
        Container pane = frame.getContentPane();

        mb = new JMenuBar();
 
        // create a menu
        x = new JMenu("Menu");
        m1 = new JMenuItem("about");
        m2 = new JMenuItem("MenuItem2");
        m3 = new JMenuItem("MenuItem3");
        m4 = new JMenuItem("MenuItem4");
        m5 = new JMenuItem("MenuItem5");

        m1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("About");
                setAbout();
            }
        });

           // add menu items to menu
           x.add(m1);
           x.add(m2);
           x.add(m3);
           x.add(m4);
           x.add(m5);

        // add menu to menu bar
        mb.add(x);
 
        // add menubar to frame
        frame.setJMenuBar(mb);
 
        
        JButton button = new JButton("Button 1 (PAGE_START)");
        

        JButton about = new JButton("About");
        pane.add(about, BorderLayout.PAGE_START);
            about.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("About");
                    setAbout();
                }
            });




         
        panel.setPreferredSize(new Dimension(200, 200));
        pane.add(panel, BorderLayout.CENTER);
         
        button = new JButton("Button 3 (LINE_START)");
        pane.add(button, BorderLayout.LINE_START);
         
        button = new JButton("Long-Named Button 4 (PAGE_END)");
        pane.add(button, BorderLayout.PAGE_END);
         
        button = new JButton("5 (LINE_END)");
        pane.add(button, BorderLayout.LINE_END);
        
        // End of borderlayout code
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void update(Observable o, Object arg) {
        panel.repaint();
    }
}
