package clock;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;

import queuemanager.PriorityItem;

class ViewAlarmWindowAdapter extends WindowAdapter {

    ViewAlarm view;

    public ViewAlarmWindowAdapter(ViewAlarm view) {

        this.view = view;
    }

    
    /** 
     * @param we
     */
    @Override
    public void windowActivated(WindowEvent we) {

        // error checking
        System.out.println("View Alarm model: " + view.model.toString());
        System.out.println("View Alarm alarms: " + view.model.alarms.toString());

        // create an array list of the alarms queue so that program can access specific elements
        ArrayList<Object> copyAlarms = view.model.alarms.returnArrayList();

        // get number of alarms in the queue
        int numAlarms = view.model.alarms.count();

        // y coordinate for the first button
        int baseHeight = 20;

        // create a button and listener for each alarm in the queue
        // buttons are slow to load, no idea why, guessing there's a better way to do this somehow
        for (int i = 0; i < numAlarms; i++) {


            System.out.println("View Alarm alarm: " + copyAlarms.get(i).toString());
            PriorityItem<Alarm> alarm = (PriorityItem<Alarm>) copyAlarms.get(i);
            System.out.println("View Alarm alarm: " + alarm.toString());

            

            JButton button = new JButton(String.valueOf(new SimpleDateFormat("HH:mm dd/MM/yyyy").format(alarm.getItem().getAlarmdatetime())));
            button.setFont(new Font("Serif", Font.BOLD, 24));
            button.setBounds(20, baseHeight + 50, 250, 50);
            view.pane.add(button);

            button.addActionListener(new ViewAlarmActionListener(view, alarm.getItem()));

            // update position for the next button
            baseHeight += 50;

            System.out.println("button created");

            button.setVisible(true);
        }

        // stops buttons lagging
        view.repaint();
    }
}