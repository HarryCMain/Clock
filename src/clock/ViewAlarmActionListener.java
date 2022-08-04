package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

class ViewAlarmActionListener implements ActionListener {

    ViewAlarm view;
    Alarm alarm;

    public ViewAlarmActionListener(ViewAlarm view) {

        this.view = view;
    }

    public ViewAlarmActionListener(ViewAlarm view, Alarm alarm) {

        this.view = view;
        this.alarm = alarm;
    }

    
    /** 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        EditAlarm editAlarm = new EditAlarm(view.model, alarm);
        // close view alarms window
        // this is jumping direct to the edit menu with a null value
       // view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
       // dispatching somehow causes the null error to occur
    }
}