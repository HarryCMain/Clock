package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Timer;

import queuemanager.QueueUnderflowException;

class ViewWindowAdapter extends WindowAdapter {

        View view;
        Model model;
    
        public ViewWindowAdapter(View view, Model model) {
    
            this.view = view;
            this.model = model;
        }
    
        
        /** 
         * @param windowEvent
         */
        @Override
        public void windowActivated(WindowEvent windowEvent) {
    
            // timer for updating  time
            Timer clockTimer = new Timer(999, updateCurrentTime);
            clockTimer.start();
            System.out.println("View model: " + model.toString());
        System.out.println("View alarms: " + model.alarms.toString());

        // update next alarm
        try {
            view.nextButton.setText("Next alarm: " + String.valueOf(new SimpleDateFormat("HH:mm dd/MM/yyyy").format(model.alarms.head().getAlarmdatetime())));
        }
        catch (QueueUnderflowException e) {

        }
    }
    
    /** 
     * @param windowEvent
     */
    @Override
    public void windowClosing(WindowEvent windowEvent) {

        // saves alarms to file
        SaveAlarms saveAlarms = new SaveAlarms(model);
    }

    
    /** 
     * @param windowEvent
     */
    @Override
    public void windowOpened(WindowEvent windowEvent) {

        // loads next alarms from file
        LoadAlarms loadAlarms = new LoadAlarms(model);
    }

    ActionListener updateCurrentTime = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            // format current time
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm dd/MM/yyyy");
            Date cur_datetime = new Date(System.currentTimeMillis());
            String dateFormatted = formatter.format(cur_datetime);

            // set current time
            view.ctButton.setText(dateFormatted);

            // remove timer task from schedule and remove head of queue if popup has been displayed
            try {
                if (model.alarms.head().isActive()) {

                    model.alarms.head().cancel();
                    model.alarms.remove();
                }
            }
            catch (QueueUnderflowException e) {

            }
        }
    };
}