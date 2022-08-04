
package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import queuemanager.PriorityItem;
import queuemanager.QueueOverflowException;
import queuemanager.SortedArrayPriorityQueue;

class EditAlarmActionListener implements ActionListener {

    EditAlarm view;

    public EditAlarmActionListener(EditAlarm view) {

        this.view = view;
    }

    
    /** 
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        // save alarm
        if (ae.getActionCommand() == "SAVE") {

            // error reporting
            System.out.println(String.valueOf(new SimpleDateFormat("HH:mm dd/MM/yyyy").format(view.alarm.getAlarmdatetime())));
            System.out.println(String.valueOf(new SimpleDateFormat("HH:mm dd/MM/yyyy").format(view.date_spinner.getValue())));

            // create new Alarm object
            Alarm alarm = new Alarm((Date) view.date_spinner.getValue());

            long datetime = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmm").format(view.date_spinner.getValue()));

            // probably the worst way to edit items in a queue...
            // create an arraylist containing a copy of the queue. This is so that we can access items at specific
            // indexes.
            ArrayList<Object> copyAlarms = view.model.alarms.returnArrayList();
            SortedArrayPriorityQueue<Alarm> newQueue = new SortedArrayPriorityQueue<>(5);

            int numAlarms = view.model.alarms.count();

            // iterate through the items in the queue to look for the item that is being changed
            for (int i = 0; i < numAlarms; i++) {

                // annoying java casting as the items are stored in an arraylist of generic Objects
                PriorityItem item = PriorityItem.class.cast(copyAlarms.get(i));
                Alarm alarmOfItem = Alarm.class.cast(item.getItem());

                // if we find the item we need to edit, replace it with the new alarm
                if (view.alarm == alarmOfItem) {
                    copyAlarms.set(i, new PriorityItem<Alarm>(alarm, (int) datetime));
                    alarmOfItem.cancel();
                    view.model.alarmTimer.schedule(alarm, alarm.getAlarmdatetime());
                }

                // add alarms to the new queue and timer
                try {
                    newQueue.add(Alarm.class.cast(PriorityItem.class.cast(copyAlarms.get(i)).getItem()), (PriorityItem.class.cast(copyAlarms.get(i)).getPriority()));
                }
                catch (QueueOverflowException error) {

                }
            }
             // replace the old queue with the new modified one
             view.model.alarms = newQueue;

             // confirmation notification
             JOptionPane.showMessageDialog(view, "Alarm saved");
         }
 
         // delete alarm
         else if (ae.getActionCommand() == "DELETE") {
 
             // again with the dodgy queue editing. If I remember will make this a method in the queue or something
             // create an arraylist containing a copy of the queue. This is so that we can access items at specific
             // indexes.
             ArrayList<Object> copyAlarms = view.model.alarms.returnArrayList();
 
             System.out.println("copyAlarms: " + copyAlarms);
 
             // create a new queue. The idea being that we will perform the edit in the arraylist then add
             // all the items from the arraylist to this new queue and replace the old queue with the new
             // updated one.
             SortedArrayPriorityQueue<Alarm> newQueue = new SortedArrayPriorityQueue<>(5);
 
             int numAlarms = view.model.alarms.count();
 
             System.out.println("count: " + numAlarms);
             for (int i = 0; i < numAlarms; i++) {

                // annoying java casting as the items are stored in an arraylist of generic Objects
                PriorityItem item = PriorityItem.class.cast(copyAlarms.get(i));
                Alarm alarmOfItem = Alarm.class.cast(item.getItem());

                // if we find the item we need to edit, delete it
                if (view.alarm == alarmOfItem) {

                    alarmOfItem.cancel();
                    copyAlarms.remove(i);
                    numAlarms -= 1;
                }
            }

            System.out.println("num alarms: " + numAlarms);
            System.out.println(copyAlarms);

            // iterate through the items in the arraylist and add them to the new queue
            for (int i = 0; i < numAlarms; i++) {

                PriorityItem item = PriorityItem.class.cast(copyAlarms.get(i));
                Alarm alarmOfItem = Alarm.class.cast(item.getItem());

                // add alarms to the new queue
                try {
                    newQueue.add(Alarm.class.cast(alarmOfItem), item.getPriority());

                    System.out.println(newQueue);
                }
                catch (QueueOverflowException error) {

                }
            }

            // replace the old queue with the new modified one
            view.model.alarms = newQueue;

            // confirmation notification
            JOptionPane.showMessageDialog(view, "Alarm deleted");

            // close edit alarm window
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
        }
    }
}