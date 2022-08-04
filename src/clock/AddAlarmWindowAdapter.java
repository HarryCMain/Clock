package clock;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class AddAlarmWindowAdapter extends WindowAdapter {

    AddAlarm view;
    Model model;

    public AddAlarmWindowAdapter(AddAlarm view, Model model) {

        this.view = view;
        this.model = model;
    }

    
    /** 
     * @param we
     */
    @Override
    public void windowActivated(WindowEvent we) {

        // for error checking
        System.out.println("Add Alarm model: " + model.toString());
        System.out.println("Add Alarm alarms: " + model.alarms.toString());
    }
}