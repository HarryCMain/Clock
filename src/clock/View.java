package clock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class View implements Observer {
    
    AnalogClockPanel panela;
    DigitalClockPanel paneld;
    static JMenuBar mb;
    Boolean digitalmode = true;
 

    // JMenu
    static JMenu x;
    static JMenuItem m1,m3,m4,m5,m6;

    static JRadioButtonMenuItem m2;
    JButton ctButton = new JButton("Current Time");
    JButton viewButton = new JButton("View Alarms");
    JButton nextButton= new JButton("Next Alarm");
    JButton addButton = new JButton("Add Alarm");

    public void setAbout() {
        JLabel label=new JLabel("About......");
        JPanel p = new JPanel();
        p.add(label);
        JFrame frameabout = new JFrame();
        frameabout.add(p);
        frameabout.pack();
        frameabout.setVisible(true);
    }

    public void setChange() {
        if (digitalmode == false) {
            digitalmode = true;
            paneld.setVisible(true);
            panela.setVisible(false);
        } else {
            digitalmode = false;
            paneld.setVisible(false);
            panela.setVisible(true);
        }
    }


    public View(Model model) {
        JFrame frame = new JFrame();
        panela = new AnalogClockPanel(model);
        paneld = new DigitalClockPanel(model);
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
        m1 = new JMenuItem("About");
        m2 = new JRadioButtonMenuItem("Digital Mode");
        m3 = new JMenuItem("Add Alarm");
        m4 = new JMenuItem("Edit/Delete Alarm");
        m5 = new JMenuItem("Load Alarms");
        m6 = new JMenuItem("Save Alarms");

        m1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("About");
                setAbout();
            }
        });

        m2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setChange();
            }
        });

        m3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Add Alarm");
                AddAlarm a = new AddAlarm(model);
            }
        });

        m4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Edit/Delete Alarm");
                ViewAlarm ea = new ViewAlarm(model);
            }
        });

        m5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Load Alarms");
                LoadAlarms la = new LoadAlarms(model);
            }
        });

        m6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Save Alarms");
                SaveAlarms sa = new SaveAlarms(model);
            }
        });


           // add menu items to menu
           x.add(m1);
           x.add(m2);
           x.add(m3);
           x.add(m4);
           x.add(m5);
           x.add(m6);

        // add menu to menu bar
        mb.add(x);
 
        // add menubar to frame
        frame.setJMenuBar(mb);

        pane.add(ctButton, BorderLayout.PAGE_START);
        pane.add(viewButton, BorderLayout.LINE_START);
        pane.add(nextButton, BorderLayout.PAGE_END);
        pane.add(addButton, BorderLayout.LINE_END);

        ctButton.setText("");

        addButton.setActionCommand("ADD");
        viewButton.setActionCommand("VIEW");
        
        // End of borderlayout code

        // listeners
        addButton.addActionListener(new ViewActionListener(this, model));
        viewButton.addActionListener(new ViewActionListener(this, model));

 
        
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




         
        panela.setPreferredSize(new Dimension(200, 200));
        paneld.setPreferredSize(new Dimension(200, 200));

        JPanel cards = new JPanel(new CardLayout());
        cards.add(paneld, "Digital");
        cards.add(panela, "Analog");
        pane.add(cards, BorderLayout.CENTER);

        if (digitalmode == false) {
            digitalmode = true;
            paneld.setVisible(true);
            panela.setVisible(false);
        } else {
            digitalmode = false;
            paneld.setVisible(false);
            panela.setVisible(true);
        }



        

        

         
        button = new JButton("Button 3 (LINE_START)");
        pane.add(button, BorderLayout.LINE_START);
         
/* 
        JButton butchange = new JButton("Change Mode");
        pane.add(butchange, BorderLayout.PAGE_END);
            butchange.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Change Mode");
                    setChange();
                }
            });
*/
        JPanel datePanel = new JPanel();
        Font font = new Font("Futura", Font.PLAIN, 35);
        JLabel textLabel = new JLabel(model.DateFormatted);
        textLabel.setFont(font);
        datePanel.add(textLabel);
        pane.add(datePanel, BorderLayout.PAGE_END);
        datePanel.setVisible(true);

         
        button = new JButton("5 (LINE_END)");
        pane.add(button, BorderLayout.LINE_END);
        
        // End of borderlayout code
        
        frame.pack();
        frame.setVisible(true);
    }
    
    
    /** 
     * @param o
     * @param arg
     */
    public void update(Observable o, Object arg) {
        panela.repaint();
        paneld.repaint();
    }
}
