package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

class AddAlarmActionListener implements ActionListener {

    AddAlarm view;
    Model model;

    public AddAlarmActionListener(AddAlarm view, Model model) {

        this.view = view;
        this.model = model;
    }

    
    /** 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        model.addAlarm((Date) view.date_spinner.getValue());

    }
}