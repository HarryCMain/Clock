package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ViewActionListener implements ActionListener {

    View view;
    Model model;

    public ViewActionListener(View view, Model model) {

        this.view = view;
        this.model = model;
    }

    
    /** 
     * @param actionEvent
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getActionCommand() == "ADD") {
            AddAlarm addAlarm = new AddAlarm(model);
        }
        else if (actionEvent.getActionCommand() == "VIEW") {

            // open view alarm window
            ViewAlarm viewAlarm = new ViewAlarm(model);
        }
    }
}