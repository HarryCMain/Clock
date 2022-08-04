package clock;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class EditAlarmWindowAdapter extends WindowAdapter {

    EditAlarm view;
    Alarm alarm;

    public EditAlarmWindowAdapter(EditAlarm view, Alarm alarm) {

        this.view = view;
        this.alarm = alarm;
    }

    
    /** 
     * @param we
     */
    @Override
    public void windowOpened(WindowEvent we) {

        // for error checking
        System.out.println("Edit Alarm model: " + view.model.toString());
        System.out.println("Edit Alarm alarms: " + view.model.alarms.toString());

        // set spinner value
        view.date_spinner.setValue(alarm.getAlarmdatetime());
    }

}