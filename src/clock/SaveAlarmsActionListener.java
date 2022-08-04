package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import queuemanager.PriorityItem;

// ****** SAVE ALARMS LISTENERS
// action listeners
class SaveAlarmsActionListener implements ActionListener {

    SaveAlarms view;
    Model model;

    public SaveAlarmsActionListener(SaveAlarms view, Model model) {

        this.view = view;
        this.model = model;
    }

    public SaveAlarmsActionListener(SaveAlarms view) {

        this.view = view;
    }

    
    /** 
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        String filepath = view.fileName.getText();
        if (ae.getActionCommand() == "YES") {

            try {

                // create new writer object
                PrintWriter writer = new PrintWriter(filepath, "UTF-8");

                // create copy of queue as arraylist
                ArrayList<Object> copyAlarms = model.alarms.returnArrayList();

                int numAlarms = model.alarms.count();

                // loop over the queue and write alarms to file in iCal format
                for (int i = 0; i < numAlarms; i++) {

                    PriorityItem item = PriorityItem.class.cast(copyAlarms.get(i));
                    Alarm alarmOfItem = Alarm.class.cast(item.getItem());

                    writer.println("BEGIN:VCALENDAR");
                    writer.println("VERSION:2.0");
                    writer.println("PRODID:-//hacksw/handcal//NONSGML v1.0//EN");
                    writer.println("BEGIN:VEVENT");
                    writer.println("UID:@uid1@example.com");
                    writer.println("DTSTAMP:" + alarmOfItem.getAlarmical());
                    writer.println("DTSTART:" + alarmOfItem.getAlarmical());
                    writer.println("DTEND:" + alarmOfItem.getAlarmical());
                    writer.println("END:VEVENT");
                    writer.println("END:VCALENDAR");
                }

                writer.close();
            }
            catch (FileNotFoundException | UnsupportedEncodingException e) {

            }

            System.exit(0);
        }

        // no button
        else if (ae.getActionCommand() == "NO") {

            System.exit(0);
        }

        // file choose functionality
        else if (ae.getActionCommand() == "FILE") {

            // set text field to selected file
            view.fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = view.fileChooser.showOpenDialog(view);

            if (result == JFileChooser.APPROVE_OPTION) {

                File selectedFile = view.fileChooser.getSelectedFile();
                view.fileName.setText(String.valueOf(selectedFile));
            }
        }
    }
}